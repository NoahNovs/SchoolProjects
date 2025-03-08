#include <interrupts.h>
#include <queue.h>
#include <semaphore.h>
#include <syscall.h>

semaphore_t sem_table[NSEM];

/*  Finds an unusued semaphore in the sem_table and returns it after  *
 *  resetting its values and marking it as used.                      */
int32 sem_create(int32 count) {
  char mask = disable_interrupts();
  for(int i = 0; i < NSEM; i++)
  {
    if(sem_table[i].state == S_FREE)
    {
      sem_table[i].state = S_USED;
      sem_table[i].count = count;
      restore_interrupts(mask);
      return i;
    }
  }

  restore_interrupts(mask);
  return -1;
}

/*  Marks a semaphore as free  */
int32 sem_free(uint32 sid) {
  if(sem_table[sid].state == S_FREE)
    return -1;

  //Function MUST signal all remaining waiting threads on the semaphore

  //Function MUST set semaphore to S_FREE
  sem_table[sid].state = S_FREE;
  return 0;
}

/*  Decrements the given semaphore if it is in use.  If the semaphore  *
 *  is less than 0, marks the thread as waiting and switches to        *
 *  another thread.                                                    */
int32 sem_wait(uint32 sid) {
  char mask;
  mask = disable_interrupts();
  //If semaphore is invalid or free, function MUST return -1
  if(sem_table[sid].state == S_FREE)
    return -1;


  sem_table[sid].count--;
  if(sem_table[sid].count < 0)
  {
    
  }
  restore_interrupts(mask);
  return 0;
}

/*  Increments the given semaphore if it is in use.  Resume the next  *
 *  waiting thread (if any).                                          */
int32 sem_post(uint32 sid) {
  char mask;
  mask = disable_interrupts();
  if(sem_table[sid].state == S_FREE)
    return -1;

  sem_table[sid].count++;
  if(sem_table[sid].count <= 0)
  {
    // Return the first thread from the semaphore queue to the ready queue
    int tid = thread_dequeue(sem_table[sid].qprev);
    sem_table[sid].state = TH_READY;
    thread_enqueue(ready_list, tid);
    // Raise a RESCHED syscall
    raise_syscall(RESCHED);
  }
  restore_interrupts(mask);
  return 0;
}
