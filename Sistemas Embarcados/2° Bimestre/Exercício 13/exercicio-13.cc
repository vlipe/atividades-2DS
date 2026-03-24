void setup() {
 
 pinMode(10, OUTPUT);
 pinMode(8, OUTPUT);
 pinMode(6, OUTPUT);
 pinMode(4, OUTPUT);
}
void loop() {
 digitalWrite(10,HIGH);
 digitalWrite(4,HIGH);
 led();
 delay(750);
 digitalWrite(8,HIGH);
 led();
 delay(750);
 digitalWrite(6,HIGH);
 led();
 delay(2000);
 
 digitalWrite(10,LOW);
 digitalWrite(8,LOW);
 digitalWrite(6,LOW);
 
 delay(1000);
}
void led(){
 digitalWrite(4,HIGH);
 delay(200);
 digitalWrite(4,LOW);
 }