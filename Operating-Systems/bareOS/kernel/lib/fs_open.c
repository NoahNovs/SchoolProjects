#include <barelib.h>
#include <fs.h>

extern fsystem_t* fsd;
extern filetable_t oft[NUM_FD];
int match(char* line, const char* cmp);
/*  Search for a filename  in the directory, if the file doesn't exist  *
 *  or it is  already  open, return  an error.   Otherwise find a free  *
 *  slot in the open file table and initialize it to the corresponding  *
 *  inode in the root directory.                                        *
 *  'head' is initialized to the start of the file.                     */
int32 fs_open(char* filename) {
  int32 dirEntryIdx = -1;
  //find index in directory
    for (uint32 i = 0; i < fsd->root_dir.numentries; ++i) {
        if (match(fsd->root_dir.entry[i].name, filename)) {
            dirEntryIdx = i;
            break;
        }
    }
    if (dirEntryIdx == -1) {
        return -1; // Directory entry with filename does not exist
    }

    //if file exists and is open, return -1
    for (uint32 i = 0; i < NUM_FD; ++i) {
        if (oft[i].state == FSTATE_OPEN && oft[i].direntry == dirEntryIdx) {
            return -1; // File exists in the oft
        }
    }
    inode_t fileInode;
    bs_read(fsd->root_dir.entry[dirEntryIdx].inode_block, 0, &fileInode, sizeof(inode_t));

    // Fill a FSTATE_CLOSED entry in the oft with the file's metadata
    int32 oft_idx = -1;
    for (uint32 i = 0; i < NUM_FD; ++i) {
        if (oft[i].state == FSTATE_CLOSED) {
            oft[i].state = FSTATE_OPEN;
            oft[i].head = 0;
            oft[i].direntry = dirEntryIdx;
            oft[i].inode.id = fileInode.id;
            oft[i].inode.size = fileInode.size;
            for (int j = 0; j < INODE_BLOCKS; j++) {
                oft[i].inode.blocks[j] = fileInode.blocks[j];
            }
            oft_idx = i;
            break;
        }
    }
    if (oft_idx == -1) {
        return -1; // No FSTATE_CLOSED entry available in the oft
    }

    return oft_idx;
}
