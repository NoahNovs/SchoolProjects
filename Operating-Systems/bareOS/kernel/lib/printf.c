#include <bareio.h>
#include <barelib.h>

/*
 *  In this file, we will write a 'printf' function used for the rest of
 *  the semester.  In is recommended  you  try to make your  function as
 *  flexible as possible to allow you to implement  new features  in the
 *  future.
 *  Use "va_arg(ap, int)" to get the next argument in a variable length
 *  argument list.
 */

/* Write a printf function in lib/printf.c to print strings and integers to the console using the provided uart_putc
 Function MUST take a template and variable number of arguments (using va_arg)
 For each character in the template that is not in the following rules, output the character
 For each %d in the template, get the next argument and output it as a base 10 integer
 For each %x in the template, get the next argument and output it as 0x followed by the value as a base 16 integer
 */

void printf(const char* format, ...) {
  va_list ap;
  va_start(ap, format);
  
  while (*format != '\0') {
        if (*format == '%') {
            format++; // Move past '%'
            switch (*format) {
                //integer
                case 'd':
                    unsigned int value = va_arg(ap, int);
                    // Print the integer as a base 10 number

                    if (value == 0) {
                        uart_putc('0');
                        return;
                    }

                    int buffer[20]; // assuming a maximum of 20 digits for an int
                    int i = 0;

                    while (value > 0) {
                        buffer[i] = '0' + (value % 10);
                        value /= 10;
                        i++;
                    }

                    //Print digits in reverse order
                    for (int j = i - 1; j >= 0; j--) {
                        uart_putc(buffer[j]);
                    }
                    format++;
                    break;
                //hex
                case 'x': {
                    unsigned int value = va_arg(ap, int);
                    // Print the integer as 0x followed by base 16 number


                    uart_putc('0');
                    uart_putc('x');

                    char hex_digits[] = "0123456789abcdef";
                    char buffer[10]; // assuming a maximum of 10 digits for an int in hex
                    int i = 0;

                    while (value > 0) {
                        buffer[i] = hex_digits[value % 16];
                        value /= 16;
                        i++;
                    }

                    // Print digits in reverse order
                        for (int j = i - 1; j >= 0; j--) {
                        uart_putc(buffer[j]);
                    }

                    format++;
                    break;
                }
                //string
                case 's':
                    char* str = va_arg(ap, char*);
                    while(*str)
                    {
                        uart_putc(*str);
                        str++;
                    }
                    format++;
                    break;
                default:
                    // Output the character as is
                    //uart_putc('%');
                    uart_putc(*format);
                    format++;
                    break;
            }
        } else {
            // Output regular characters
            uart_putc(*format);
            format++;
        }
    }
  
  va_end(ap);
}