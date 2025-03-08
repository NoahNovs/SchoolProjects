#include <queue.h>

/*  Queues in bareOS are all contained in the 'thread_queue' array.  Each queue has a "root"
 *  that contains the index of the first and last elements in that respective queue.  These
 *  roots are  found at the end  of the 'thread_queue'  array.  Following the 'qnext' index 
 *  of each element, starting at the "root" should always eventually lead back to the "root".
 *  The same should be true in reverse using 'qprev'.                                          */

queue_t thread_queue[NTHREADS+2];   /*  Array of queue elements, one per thread plus one for the read_queue root  */
uint32 ready_list = NTHREADS + 0;   /*  Index of the read_list root  */
uint32 sleep_list = NTHREADS + 1;

/*  'thread_enqueue' takes an index into the thread_queue  associated with a queue "root"  *
 *  and a threadid of a thread to add to the queue.  The thread will be added to the tail  *
 *  of the queue,  ensuring that the  previous tail of the queue is correctly threaded to  *
 *  maintain the queue.                                                                    */
void thread_enqueue(uint32 queue, uint32 threadid) {
  if(thread_queue[threadid].qnext != threadid)
    return;
  
  thread_queue[threadid].key = thread_table[threadid].priority;
  int after = thread_queue[queue].qprev;

  while(thread_table[threadid].priority < thread_table[after].priority)
  {
    after = thread_queue[after].qprev;
  }

  //perform insert
  int before = thread_queue[after].qnext;
  thread_queue[before].qprev = threadid;
  thread_queue[threadid].qnext = before;
  thread_queue[threadid].qprev = after;
  thread_queue[after].qnext = threadid;
  return;
}


/*  'thread_dequeue' takes a queue index associated with a queue "root" and removes the  *
 *  thread at the head of the queue and returns the index of that thread, ensuring that  *
 *  the queue  maintains its structure and the head correctly points to the next thread  *
 *  (if any).                                                                            */
uint32 thread_dequeue(uint32 queue) {

  //uint32 id = thread_queue[queue].qprev;

  if(thread_queue[queue].qprev == queue)
  {
    return NTHREADS;
  }
  uint32 delete = thread_queue[queue].qnext;
  uint32 before = thread_queue[delete].qnext;


  thread_queue[before].qprev = queue;
  thread_queue[queue].qnext = before;
  thread_queue[delete].qprev = delete;
  thread_queue[delete].qnext = delete;
  
  return delete;
}
