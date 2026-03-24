int led;
int botao;
boolean estado_botao;
  
void setup()
{
  pinMode(led, OUTPUT);
  pinMode(botao, INPUT);
  digitalWrite(botao, HIGH);
}

void loop()
{
  estado_botao = digitalRead(botao);
  
  if(estado_botao == LOW){
    digitalWrite(led, HIGH);
  }
  
  else {
    digitalWrite(led, LOW);
}
}