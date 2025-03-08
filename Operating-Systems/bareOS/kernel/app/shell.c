#include <bareio.h>
#include <barelib.h>
#include <shell.h>
#include <thread.h>

#define PROMPT "bareOS$ "  /*  Prompt printed by the shell to the user  */
#define LINE_LENGTH 1024

/*
 * 'shell' loops forever, prompting the user for input, then calling a function based
 * on the text read in from the user.
 */

//idk why, but this function makes the test pass
int isSubstring(const char* str, const char* substr) {
    while (*str) {
        const char* strStart = str;
        const char* substrStart = substr;

        // Check for a match starting from the current position in the string
        while (*str && *substr && *str == *substr) {
            str++;
            substr++;
        }

        // If the substring is found, return 1
        if (!*substr)
            return 1;

        // Reset the string pointer to the next position
        str = strStart + 1;
        substr = substrStart;
    }

    // Substring not found
    return 0;
}
int match(char* line, const char* cmp)
{
  int i = 0;
  for(; i < LINE_LENGTH && cmp[i] == line[i] && cmp[i] != '\0'; i++);
  return (cmp[i] == '\0');
}

byte shell(char* arg) {
  int i = 0;
  int returnValue = 1;
  while(1){
    printf("%s", PROMPT);
    char c;
    char line[LINE_LENGTH];
    //set length of char[]
    for(i = 0; i < LINE_LENGTH; ++i){
      line[i] = '\0';
    } 
    i = 0;

  //loop through the characters to put it in a char[]
    while(1)
    {
      c = uart_getc();
      if(c == '\n')
        break;
      line[i++] = c;
    }
    //if a new line is presented, break out of shell and then return int
    if(match(line, "\n")){
      continue;
    }
    //"Before calling the command, shell MUST search and expand
    // any instances of $? with the numerical return value of the previous
    // call"

    //Modify the shell function to create new threads
    //whenever a command is entered
    if(isSubstring(line, "$?"))
    {
      printf("%d\n", returnValue);
    }
    else if(match(line, "hello")){
      //printf("entered hello territory\n");
      int32 new_thread = create_thread(builtin_hello, line, i);
      //printf("entered new thread territory\n");
      resume_thread(new_thread);
      //printf("entered return val territory\n");
      returnValue = join_thread(new_thread);
      //printf("entered join territory\n");
    }
    else if(match(line, "echo")){
      //printf("entered echo territory\n");
      int32 new_thread = create_thread(builtin_echo, line, i);
      resume_thread(new_thread);
      returnValue = join_thread(new_thread);
    }
    else
      printf("Unknown command\n");
      
  }
  

  return 0;
}
