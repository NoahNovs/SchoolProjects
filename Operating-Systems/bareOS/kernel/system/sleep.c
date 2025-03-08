#include <interrupts.h>
#include <queue.h>
#include <syscall.h>

/*  Places the thread into a sleep state and inserts it into the  *
 *  sleep delta list.                                             */
int32 sleep(uint32 threadid, uint32 delay) {
  char mask;
  mask = disable_interrupts();
  // if the delay is 0, function MUST raise a RESCHED and return immediately
  if(delay == 0)
  {
    raise_syscall(RESCHED);
    return NULL;
  }
  //Function MUST set the thread's state to the TH_SLEEP
  thread_table[threadid].state = TH_SLEEP;

  //Function MUST dequeue the thread from its existing queue (if any)
  int prev_id = thread_queue[threadid].qprev;
  if(thread_queue[threadid].qprev >= NTHREADS)
    thread_dequeue(prev_id);

  //Function MUST enqueue the thread into a sleep_list queue (see Modify)
  thread_table[threadid].priority = delay;
  //thread_queue[threadid].key = delay;
  thread_enqueue(sleep_list, threadid);

  //fix threadid key manually
  int sleep_prev_id = thread_queue[threadid].qprev;
  if(sleep_prev_id != sleep_list)
    thread_queue[threadid].key = delay - thread_table[sleep_prev_id].priority;

  //fix the qnext key when inserting
  int sleep_next_id = thread_queue[threadid].qnext;
  //if(sleep_next_id != sleep_list)
  thread_queue[sleep_next_id].key = thread_table[sleep_next_id].priority - thread_table[threadid].priority;

  //Function MUST raise a RESCHED syscall
  raise_syscall(RESCHED);

  //Function MUST correct the delay in the following thread in the sleep_list

  restore_interrupts(mask);
  return 0;
}

/*  If the thread is in the sleep state, remove the thread from the  *
 *  sleep queue and resumes it.                                      */
int32 unsleep(uint32 threadid) {
  char mask;
  mask = disable_interrupts();
  //if thread is not asleep
  if(thread_table[threadid].state != TH_SLEEP)
    return -1;

  //want to get the previous id in queue
  int temp_id = thread_queue[threadid].qprev;
  //and the next
  int next_tid = thread_queue[threadid].qnext;

  // Function MUST correct the delay in the following thread in the sleep_list
  if(next_tid != sleep_list)
    thread_queue[next_tid].key += thread_queue[threadid].key;
  
  //Function MUST remove the thread from the sleep_list
  thread_dequeue(temp_id);

  //Function MUST add the thread to the ready_list
  thread_enqueue(ready_list, threadid);

  raise_syscall(RESCHED);
  restore_interrupts(mask);
  return 0;
}
