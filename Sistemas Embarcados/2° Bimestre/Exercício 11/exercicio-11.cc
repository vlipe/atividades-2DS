int pino10 = 10;
int batimentos = 1;
void setup() {
 
 pinMode(pino10, OUTPUT);
}
void loop() {
 if(batimentos <=5) {
 
 digitalWrite(pino10, HIGH);
 delay(500);
 
 digitalWrite(pino10, LOW);
 delay(500);
 batimentos++;
 }else {
 
 digitalWrite(pino10, HIGH);
 }
}