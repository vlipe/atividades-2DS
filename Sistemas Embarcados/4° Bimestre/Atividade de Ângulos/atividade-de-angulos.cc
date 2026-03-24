#include <Servo.h>

const byte LED_VERMELHO = 9;
const byte LED_VERDE    = 8;

const byte TRIG_PIN     = 6;
const byte ECHO_PIN     = 13;

const byte SERVO_PIN    = 7;

const int ANGULO_FECHADO = 0;
const int ANGULO_ABERTO  = 90;
const int DISTANCIA_ACIONAMENTO_CM = 40;
const unsigned long TEMPO_ABERTA_MS = 3000;

Servo cancela;

long duracaoPulso;
float distanciaCm;

bool prontoParaNovaPassagem = true;

float medirDistanciaCm()
{
  digitalWrite(TRIG_PIN, LOW);
  delayMicroseconds(2);
  digitalWrite(TRIG_PIN, HIGH);
  delayMicroseconds(10);
  digitalWrite(TRIG_PIN, LOW);
  duracaoPulso = pulseIn(ECHO_PIN, HIGH);
  float distancia = (duracaoPulso * 0.0343) / 2.0;
  return distancia;
}

void setup()
{
  Serial.begin(9600);

  pinMode(LED_VERMELHO, OUTPUT);
  pinMode(LED_VERDE, OUTPUT);
  pinMode(TRIG_PIN, OUTPUT);
  pinMode(ECHO_PIN, INPUT);

  cancela.attach(SERVO_PIN);

  cancela.write(ANGULO_FECHADO);
  digitalWrite(LED_VERMELHO, HIGH);
  digitalWrite(LED_VERDE, LOW);
}

void loop()
{
  distanciaCm = medirDistanciaCm();

  bool objetoPresente = (distanciaCm > 0 && distanciaCm < DISTANCIA_ACIONAMENTO_CM);

  if (!objetoPresente) {
    cancela.write(ANGULO_FECHADO);
    digitalWrite(LED_VERMELHO, HIGH);
    digitalWrite(LED_VERDE, LOW);
    prontoParaNovaPassagem = true;
  } 
  else {
    if (prontoParaNovaPassagem) {
      prontoParaNovaPassagem = false;

      digitalWrite(LED_VERMELHO, LOW);
      digitalWrite(LED_VERDE, HIGH);

      cancela.write(ANGULO_ABERTO);
      delay(TEMPO_ABERTA_MS);

      cancela.write(ANGULO_FECHADO);

      digitalWrite(LED_VERDE, LOW);
      digitalWrite(LED_VERMELHO, HIGH);

      delay(300);
    }
  }

  delay(100);
}
