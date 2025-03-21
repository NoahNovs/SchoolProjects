#include <barelib.h>
#include <interrupts.h>
#include <syscall.h>
#include <thread.h>
#include <queue.h>


/*  Takes an index into the thread table of a thread to suspend.  If the thread is  *
 *  not in the  running or  ready state,  returns an error.   Otherwise, sets the  *
 *  thread's  state  to  suspended  and  raises a  RESCHED  syscall to schedule a  *
 *  different thread.  Returns the threadid to confirm suspension.                 */
int32 suspend_thread(uint32 threadid) {
  char mask;
  mask = disable_interrupts();
  restore_interrupts(mask);
  if(thread_table[threadid].state == TH_READY || thread_table[threadid].state == TH_RUNNING)
  {
    

    // uint32 prev = thread_queue[threadid].qprev;
    // uint32 next = thread_queue[threadid].qnext;

    // thread_queue[prev].qnext = next;
    // thread_queue[next].qprev = prev;

    // thread_queue[threadid].qprev = threadid;
    // thread_queue[threadid].qnext = threadid;
    thread_dequeue(ready_list);
    thread_table[threadid].state = TH_SUSPEND;
    raise_syscall(RESCHED);
  }
  else
    threadid = -1;
  
  return threadid;
}
