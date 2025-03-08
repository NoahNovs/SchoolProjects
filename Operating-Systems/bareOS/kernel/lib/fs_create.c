#include <barelib.h>
#include <fs.h>

extern fsystem_t* fsd;

/*  Search for 'filename' in the root directory.  If the  *
 *  file exists,  returns an error.  Otherwise, create a  *
 *  new file  entry in the  root directory,  allocate an  *
 *  unused  block in the block  device and  assign it to  *
 *  the new file.                                         */
int match(char* line, const char* cmp);

int32 fs_create(char* filename) {
  if(fsd -> root_dir.numentries >= DIR_SIZE)
    return -1;

  //check if file name exists
  for(uint32 i = 0; i < fsd -> root_dir.numentries; i++)
  {
    if(match(filename, fsd -> root_dir.entry[i].name))
      return -1;
  }

  //find unused directory entry (at end of array)
  uint32 inodeIdx = fsd -> root_dir.numentries;

  
  //find free block for file inode
  uint32 inodeBlockIdx = EMPTY;

  for (uint32 i = 0; i < fsd->device.nblocks; i++) {
    if (fs_getmaskbit(i) == 0) {
        inodeBlockIdx = i;
        fs_setmaskbit(i); // Mark inode block as used
        break;
    }
  }

  if(inodeBlockIdx == -1) return -1;

  // Fill directory entry with new file metadata
    int k = 0;
    while (filename[k] != '\0') {
        fsd->root_dir.entry[inodeIdx].name[k] = filename[k];
        k++;
    }
    fsd->root_dir.entry[inodeIdx].name[k] = '\0'; // Null-terminate string
    fsd->root_dir.numentries++;
    fsd->root_dir.entry[inodeIdx].inode_block = inodeBlockIdx;

  //write to ramdisk
  inode_t newInode;
  newInode.id = inodeBlockIdx;
  newInode.size = 0;
  for(int i = 0; i < INODE_BLOCKS; i++)
  {
    newInode.blocks[i] = -1;
  }
  bs_write(inodeBlockIdx, 0, &newInode, sizeof(inode_t));

  fs_setmaskbit(inodeBlockIdx);
  bs_write(1, 0, fsd->freemask, fsd->freemasksz);

  
  return 0;
}
