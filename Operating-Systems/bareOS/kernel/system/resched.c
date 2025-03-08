#include <barelib.h>
#include <bareio.h>
#include <syscall.h>
#include <thread.h>
#include <queue.h>
#include <interrupts.h>
/*  'resched' places the current running thread into the ready state  *
 *  and  places it onto  the tail of the  ready queue.  Then it gets  *
 *  the head  of the ready  queue  and sets this  new thread  as the  *
 *  'current_thread'.  Finally,  'resched' uses 'ctxsw' to swap from  *
 *  the old thread to the new thread.                                 */
int32 resched(void) {
  char mask = disable_interrupts();

  int old = current_thread;
  int new = thread_dequeue(ready_list);
  if(new == NTHREADS) 
    return -1;

  if(thread_table[old].state == TH_RUNNING || thread_table[old].state == TH_READY)
  {
    thread_enqueue(ready_list, old);
    thread_table[old].state = TH_READY;
  }

  thread_table[new].state = TH_RUNNING;
  current_thread = new;
  ctxsw(&(thread_table[new].stackptr), &(thread_table[old].stackptr));
  restore_interrupts(mask);
  return 0;
}