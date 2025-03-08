#include <bareio.h>
#include <barelib.h>
#define LINE_LENGTH 1024

/*
 * 'builtin_hello' prints "Hello, <text>!\n" where <text> is the contents 
 * following "builtin_hello " in the argument and returns 0.  
 * If no text exists, print and error and return 1 instead.
 */


byte builtin_hello(char* arg) {
  while(1){
    //char c;
    char line[LINE_LENGTH];
    //set length of char[]
    // for(int i = 0; i < LINE_LENGTH; ++i){
    //   line[i] = '\0';
    // } 
    

  //loop through the characters to put it in a char[]
  if(arg[6] != '\n' && arg[6] != '\0')
  {
    int i = 0;
    while(1)
    {
      if(arg[i+6] == '\n' || arg[i+6] == '\0')
        break;
      line[i] = arg[i+6];
      i++;
    }
    printf("Hello, %s!\n", line);
    return 0;
  }
  else
  {
    printf("Error - bad argument\n");
    return 1;
  }
  
}
}
