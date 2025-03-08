/*
 *  This file contains functions for initializing and handling interrupts
 *  from the hardware timer.
 */

#include <barelib.h>
#include <interrupts.h>
#include <queue.h>

#define TRAP_TIMER_ENABLE 0x80

volatile uint32* clint_timer_addr  = (uint32*)0x2004000;
const uint32 timer_interval = 100000;
int64 resched(void);

/*
 * This function is called as part of the bootstrapping sequence
 * to enable the timer. (see bootstrap.s)
 */
void clk_init(void) {
  *clint_timer_addr = timer_interval;
  set_interrupt(TRAP_TIMER_ENABLE);
}

/* 
 * This function is triggered every 'timer_interval' microseconds 
 * automatically.  (see '__traps' in bootstrap.s)
 */
interrupt handle_clk(void) {
  *clint_timer_addr += timer_interval;
  
  //milestone 5 implementation
  int id = thread_queue[sleep_list].qnext;
  thread_queue[id].key--;
  while(thread_queue[id].key == 0)
  {
    int temp = thread_dequeue(sleep_list);
    id = thread_queue[sleep_list].qnext;
    thread_table[temp].state = TH_READY;
    thread_enqueue(ready_list, temp);
  }

  if (boot_complete && is_interrupting()) {
    char mask = disable_interrupts();

    resched();
    restore_interrupts(mask);
  }
}
