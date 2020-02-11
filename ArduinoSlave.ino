#include <SPI.h>
char buff [50];
volatile byte indx;
volatile boolean process;
volatile byte age;
volatile byte position; // 0 = center, 1 = left, 2 = right
volatile byte size;
volatile byte lastRead;
void setup (void) {
 Serial.begin (9600);
 pinMode(12, OUTPUT); // have to send on master in so it set as output
 SPCR |= _BV(SPE); // turn on SPI in slave mode
 indx = 0; // buffer empty
 age = 11;
 size = 21;
 position = 31;
 process = false;
 SPI.attachInterrupt(); // turn on interrupt
}
ISR (SPI_STC_vect) // SPI interrupt routine
{

 lastRead= SPDR; // read byte from SPI Data Register
 //Serial.println (lastRead); //print the array on serial monitor
 //Serial.println (SPDR);

char arr[5] = {'d', 'e', 'f', 'g'};
SPDR = arr[indx++];
if(indx > 4) indx = 0;

/*for (int i  = 0; i<4; i++)
{
   SPDR = arr[i];
}*/
/*
  switch(indx){
  case 0:
  SPDR = arr[indx];
  break;

  case 1: 
  SPDR = arr[indx];
  break;

  case 2: 
  SPDR = arr[indx];
  break;

  case 3: 
  SPDR = arr[indx];
  break;

  case 4: 
  SPDR = arr[indx];
  break;
  }
indx++;
*/
/*switch (indx)
{
  case 0:
    SPDR = age;
    Serial.println (SPDR);
   //age = SPDR;
    break;
  case 1:
  //size = SPDR;
    SPDR = size;
    Serial.println (SPDR);
    break;
  case 2:
  //position = SPDR;
    SPDR = position;
    Serial.println (SPDR);
    break;
}
  indx++;
 if (lastRead == '\b') //check for the end of the word
 {
   process = true;
 }
 */
}

void loop (void) {
 if (process) {
    process = false; //reset the process
    indx= 0; //reset button to zero
    age++;
    position++;
    size++; 
    Serial.println("Hey");
    
   //Serial.println (SPDR); //print the array on serial monitor
 }
 
 delay(10);
}
