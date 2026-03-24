const int led1 = 4;   
const int led2 = 3;
const int led3 = 2;   

const int botao1 = 13; 
const int botao2 = 8; 

const int potenciometro = A0;

const int buzzer = 7;

void setup() {
  
  pinMode(led1, OUTPUT);
  pinMode(led2, OUTPUT);
  pinMode(led3, OUTPUT);
  pinMode(botao1, INPUT);
  pinMode(botao2, INPUT);
  pinMode(buzzer, OUTPUT);
  digitalWrite(led1, HIGH);
  digitalWrite(led2, HIGH);
}

void loop() {
  
  int valorPot = analogRead(potenciometro);
  int brilho = map(valorPot, 0, 1023, 0, 255);
  analogWrite(led3, brilho);

  if (digitalRead(botao1) == HIGH) {
    digitalWrite(led1, LOW);
    delay(10000);
    digitalWrite(led1, HIGH);
    tone(buzzer, 1000, 500);
  }

  if (digitalRead(botao2) == HIGH) {
    digitalWrite(led2, LOW);
    delay(15000);
    digitalWrite(led2, HIGH);
    tone(buzzer, 1000, 500);
  }
  
}
