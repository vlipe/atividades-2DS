int pino10 = 10;
void setup() {
 
 pinMode(pino10, OUTPUT);
}
void loop() {
 
 digitalWrite(pino10, HIGH);
 delay(1000);

 digitalWrite(pino10, LOW);
 delay(1000);
}