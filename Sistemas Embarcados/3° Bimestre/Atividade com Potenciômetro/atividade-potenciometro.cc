const int leds[] = {4, 5, 6, 7, 8, 9, 10, 11, 12, 13};
const int numLeds = sizeof(leds) / sizeof(leds[0]);
const int potPin = A2;

void setup() {
  for (int i = 0; i < numLeds; i++) {
    pinMode(leds[i], OUTPUT);
  }
}

void loop() {
  int potValue = analogRead(potPin);

  if (potValue < 50) {
    for (int i = 0; i < numLeds; i++) {
      digitalWrite(leds[i], LOW);
    }
    delay(100); 
    return;
  }


  int delayTime = map(potValue, 50, 1023, 150, 100); 

  for (int i = 0; i < numLeds; i++) {
    digitalWrite(leds[i], HIGH);
    delay(delayTime);
    digitalWrite(leds[i], LOW);
  }

  for (int i = numLeds - 1; i >= 0; i--) {
    digitalWrite(leds[i], HIGH);
    delay(delayTime);
    digitalWrite(leds[i], LOW);
  }
}