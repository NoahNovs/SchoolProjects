#include <barelib.h>
#include <fs.h>

uint32 fs_get_free_block() {
    // Iterate through the bitmask to find a free block
    for (uint32 i = 0; i < fsd->device.nblocks; i++) {
        if (fs_getmaskbit(i) == 0) {
            fs_setmaskbit(i); // Mark inode block as used
            return i;
        }
    }
    return EMPTY; // No free blocks available
}

/* fs_write - Takes a file descriptor index into the 'oft', a  pointer to a  *
 *            buffer  that the  function reads data  from and the number of  *
 *            bytes to copy from the buffer to the file.                     *
 *                                                                           *
 *            'fs_write' reads data from the 'buff' and copies it into the   *
 *            file  'blocks' starting  at the 'head'.  The  function  will   *
 *            allocate new blocks from the block device as needed to write   *
 *            data to the file and assign them to the file's inode.          *
 *                                                                           *
 *  returns - 'fs_write' should return the number of bytes written to the    *
 *            file.                                                          */
uint32 fs_write(uint32 fd, char* buff, uint32 len) {
    // Check if file descriptor is valid
    if (fd < 0 || fd >= NUM_FD) return 0; // Invalid file descriptor

    // Check if file is open
    if (oft[fd].state != FSTATE_OPEN) return 0; // File not open

    inode_t* inode = &oft[fd].inode;
    uint32 blockSize = fsd->device.blocksz;
    uint32 remainingSize = len;
    uint32 dataOffset = 0;
    uint32 blockIndex = oft[fd].head / blockSize;
    uint32 blockOffset = oft[fd].head % blockSize;

    // Check if there are enough free blocks to write the data
    uint32 requiredBlocks = (len + blockOffset + blockSize - 1) / blockSize;
    if (blockIndex + requiredBlocks > INODE_BLOCKS) {
        // Cannot fit data into inode blocks
        return -1;
    }

    // Reserve necessary blocks
    for (uint32 i = 0; i < requiredBlocks; ++i) {
        if (inode->blocks[blockIndex + i] == 600) {
            // Allocate a new block
            uint32 newBlock = fs_get_free_block();
            if (newBlock == EMPTY) {
                // Failed to allocate block
                return -1;
            }
            // Update inode with the new block
            inode->blocks[blockIndex + i] = newBlock;
        }
    }

    // Write data to blocks
    //int i = 0;
    while (remainingSize > 0) {
        // Determine write size for current block
        uint32 writeSize = remainingSize > blockSize - blockOffset ? blockSize - blockOffset : remainingSize;

        // Write data to the block
        if (bs_write(inode->blocks[blockIndex], blockOffset, buff + dataOffset, writeSize) != 0) {
            // Error writing to block
            return -1;
        }

        // Update offsets and sizes
        remainingSize -= writeSize;
        dataOffset += writeSize;
        blockOffset = 0; // Move to beginning of next block
        blockIndex++;

        // Update inode size if necessary
        if (oft[fd].head + writeSize > inode->size) {
            inode->size = oft[fd].head + writeSize;
        }
    }

    // Update file head position
    oft[fd].head += len;
    
    // Update inode size if necessary
    if(oft[fd].inode.size < oft[fd].head) oft[fd].inode.size = oft[fd].head;
    
    // Update inode on disk
    if(bs_write(inode->id, 0, inode, sizeof(inode_t))) return -1;

    return len;
}