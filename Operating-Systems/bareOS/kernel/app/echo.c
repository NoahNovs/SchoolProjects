#include <bareio.h>
#include <barelib.h>

#define LINE_LENGTH 1024

/*
 * 'builtin_echo' reads in a line of text from the UART
 * and prints it.  It will continue to do this until the
 * line read from the UART is empty (indicated with a \n
 * followed immediately by another \n).
 */
byte builtin_echo(char* arg) {
  while(1){
    char c;
    char line[LINE_LENGTH];
    //set length of char[]
    // for(int i = 0; i < LINE_LENGTH; ++i){
    //   line[i] = '\0';
    // } 
    

  //loop through the characters to put it in a char[]
  //if input is given
  if(arg[6] != '\0')
  {
    int i = 0;
    while(1)
    {
      line[i] = arg[i+5];
      if(arg[i+5+1] == '\n' || arg[i+6] == '\0')
        break;
      i++;
    }
    printf("%s\n", line);
    return 0;
  }
  //doing line by line
  else
  {
    int j = 0;
    int returnInt = 0;
    char temp = '\0';
    while(1)
    {
      if(j > 0)
      {
        temp = line[j];
      }
      //printf("we are here");
      c = uart_getc();
      line[j] = c;
      
      if(temp == '\n' && line[j] == '\n')
        break;
      //if we are at the end of a line, reset the "line" and print it out
        if(line[j] == '\n')
        {
          // line[j] = '\0';
          // break;
          printf("%s", line);
          //reset the line[]
          for(int i = 0; i < LINE_LENGTH; ++i){
            line[i] = '\0';
          }
          temp = '\n';
          j = 0;
          continue;
        }
        
        returnInt++;
        j++;
    }
    //printf("%d\n", returnInt);
    return returnInt;
  }
    return 0;
  }
}
