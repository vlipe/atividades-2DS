int trig = 4;

int echo = 5;
int led = 8;
int led2 = 9;
int led3 = 10;

void setup()
{
 Serial.begin(9600);
  
  pinMode(trig, OUTPUT);
  pinMode(echo, INPUT);
  pinMode(led, OUTPUT);
  pinMode(led2, OUTPUT);
  pinMode(led3, OUTPUT);
}

void loop()
{
  digitalWrite(trig, LOW);
  delayMicroseconds(2);
  digitalWrite(trig, HIGH);
  delayMicroseconds(10);
  digitalWrite(trig, LOW);
  
  int duracao = pulseIn(echo, HIGH);
  
  int distancia = (duracao/2) / 29.1;
  
  Serial.println(distancia);
  
  if (distancia >= 10 and distancia <= 20) {
  digitalWrite(led,HIGH);
  } else {
      digitalWrite(led, LOW);
      delay(100);
    }
  
   if (distancia >= 21 and distancia <= 30) {
  digitalWrite(led2,HIGH);
  } else {
      digitalWrite(led2, LOW);
      delay(100);
    }
  
  if (distancia >= 31 and distancia <= 40) {
  digitalWrite(led3,HIGH);
  } else {
      digitalWrite(led3, LOW);
      delay(100);
    }
  }