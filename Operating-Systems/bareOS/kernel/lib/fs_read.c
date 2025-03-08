#include <barelib.h>
#include <fs.h>
#define MIN(a, b) (((a) < (b)) ? (a) : (b))

/* fs_read - Takes a file descriptor index into the 'oft', a  pointer to a  *
 *           buffer that the function writes data to and a number of bytes  *
 *           to read.                                                       *
 *                                                                          *
 *           'fs_read' reads data starting at the open file's 'head' until  *
 *           it has  copied either 'len' bytes  from the file's  blocks or  *
 *           the 'head' reaches the end of the file.                        *
 *                                                                          *
 * returns - 'fs_read' should return the number of bytes read (either 'len' *
 *           or the  number of bytes  remaining in the file,  whichever is  *
 *           smaller).                                                      */
uint32 fs_read(uint32 fd, char* buff, uint32 len) {
  // Check if file descriptor is valid
  if (fd < 0 || fd >= NUM_FD) return -1; // Invalid file descriptor

  // Check if file is open
  if (oft[fd].state != FSTATE_OPEN) return -1; // File not open

  // Get block size (512)
  uint32 blockSize = fsd->device.blocksz;

  // Calculate remaining bytes to read
  uint32 remBytes = oft[fd].inode.size - oft[fd].head;
  uint32 toRead = MIN(len, remBytes);
  if(len < 512) toRead = len;

  // Calculate number of blocks to read and offset within the first block
  uint32 blockIdx = oft[fd].head / blockSize;
  uint32 offset = oft[fd].head % blockSize;
  uint32 numBlocks = (toRead) / blockSize;

  // Read data from blocks
  uint32 bytesRead = 0;
  for (uint32 i = 0; i <= numBlocks; i++) {
    uint32 curBlock = oft[fd].inode.blocks[blockIdx + i];
    uint32 toCopy = MIN(toRead - bytesRead, blockSize - offset);

    //means we are at the first partial block (Read file from start partial block)
    if(i == 0 && numBlocks == 0 && oft[fd].head == 0){
      toCopy = toRead;
      bs_read(curBlock, 0, buff, toCopy);
      bytesRead += toCopy;
      break;
    }
    // Read from the current block
    bs_read(curBlock, offset, buff + bytesRead, toCopy);
    bytesRead += toCopy;

    // Update offset for subsequent blocks
    offset = 0;
  }

  // Update file's head position
  oft[fd].head += bytesRead;

  return bytesRead; // Return number of bytes read
}