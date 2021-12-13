#include<Wire.h>

const int triggerPin = 2;
const int echoPin = 4;
const int vcc = 8;

double duration, distance;

void setup() {
  // put your setup code here, to run once:
  pinMode(triggerPin, OUTPUT);
  pinMode(echoPin, INPUT);
  pinMode(vcc, OUTPUT);
  Serial.begin(9600);
}

void loop() {
  // put your main code here, to run repeatedly:

  delay(1000);
  digitalWrite(vcc, HIGH);
  
  digitalWrite(triggerPin, LOW);
  delayMicroseconds(2);

  digitalWrite(triggerPin, HIGH);
  delayMicroseconds(10);

  digitalWrite(triggerPin, LOW);
  duration = pulseIn(echoPin, HIGH);

  distance = duration * 0.0340 / 2;

  Serial.println(distance);
}
