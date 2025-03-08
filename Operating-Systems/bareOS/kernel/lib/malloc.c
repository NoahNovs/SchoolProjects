#include <barelib.h>
#include <malloc.h>
#include <thread.h>

extern uint32* mem_start;
extern uint32* mem_end;
static alloc_t* freelist;

/*  Sets the 'freelist' to 'mem_start' and creates  *
 *  a free allocation at that location for the      *
 *  entire heap.                                    */
//--------- This function is complete --------------//
void heap_init(void) {
  freelist = (alloc_t*)mem_start;
  freelist->size = get_stack(NTHREADS) - mem_start - sizeof(alloc_t);
  freelist->state = M_FREE;
  freelist->next = NULL;
}

/*  Locates a free block large enough to contain a new    *
 *  allocation of size 'size'.  Once located, remove the  *
 *  block from the freelist and ensure the freelist       *
 *  contains the remaining free space on the heap.        *
 *  Returns a pointer to the newly created allocation     */
void* malloc(uint64 size) {
  if(size == 0) return NULL;
  alloc_t* curr = freelist;
  alloc_t* prev = NULL;

  //size += sizeof(alloc_t);

  //find the block
  while(curr != NULL){
    if(curr->state == M_FREE && curr->size >= size) break;
    prev = curr;
    curr = curr->next;
  }
    
//at the end of freelist, if none available, return null
if(curr == NULL){
  return 0;
}

//if block is too big, make it to the size/split it
uint64 total = sizeof(alloc_t) + size;
if(curr->size > total)
{
  alloc_t* temp = (alloc_t*)((char*)curr + total);
  temp->size = curr->size - total;
  temp->state = M_FREE;
  temp->next = curr->next;

  curr->size = size;
  curr->state = M_USED;
  curr->next = temp;
}
else
//remove allocation from free block
{
  if(prev == NULL)
    freelist = curr->next;
  else
    prev->next = curr->next;
  curr->state = M_USED;
}
  return (void*)(curr+1);
}

/*  Free the allocation at location 'addr'.  If the newly *
 *  freed allocation is adjacent to another free          *
 *  allocation, coallesce the adjacent free blocks into   *
 *  one larger free block.                                */

void free(void* addr) {
    if (addr == NULL) return;

    alloc_t* block = (alloc_t*)addr - 1;
    block->state = M_FREE;

    // Merge with the previous block in the freelist if applicable
    alloc_t* prev = NULL;
    alloc_t* current = freelist;
    while (current != NULL && (char*)current + sizeof(alloc_t) + current->size <= (char*)block) {
        prev = current;
        current = current->next;
    }

    if (prev != NULL && (char*)prev + sizeof(alloc_t) + prev->size == (char*)block) {
        // Merge with the previous block
        prev->size += sizeof(alloc_t) + block->size;
        block = prev; // Update block pointer to the merged block
    } else {
        // Insert into the freelist
        block->next = current;
        if (prev != NULL)
            prev->next = block;
        else
            freelist = block;
    }

    // Merge with the next block in the freelist if applicable
    if (block->next != NULL && (char*)block + sizeof(alloc_t) + block->size == (char*)block->next) {
        // Merge with the next block
        block->size += sizeof(alloc_t) + block->next->size;
        block->next = block->next->next;
    }
}
