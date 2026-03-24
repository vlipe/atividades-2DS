#include <Servo.h>
Servo servo;
int pos;
void setup (){
 servo.attach(6);
 servo.write(0);
 pinMode(4, OUTPUT);
 pinMode(2, OUTPUT);
 delay(1000);
}
void loop(){
 for(pos = 0; pos < 180; pos++){
 servo.write(pos);
 delay(15);
 digitalWrite(4, HIGH);
 digitalWrite(2, LOW);
 }

 delay(1000);

 for(pos = 180; pos >= 0; pos--){
 servo.write(pos);
 delay(15);
 digitalWrite(4, LOW);
 digitalWrite(2, HIGH);
 }
}