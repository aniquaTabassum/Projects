const int triggerL = 2;
const int echoL = 3;
const int triggerR = 4;
const int echoR = 5;

long timeTaken;
int distL, distR;

void setup() {
  Serial.begin(9600);
  pinMode(triggerL, OUTPUT);
  pinMode(triggerR, OUTPUT);
  pinMode(echoL, INPUT);
  pinMode(echoR, INPUT);
}

/***** FUNCTION TO CALCULATE DISTANCE *****/
int getDistance(int triggerPin, int echoPin)
{
  digitalWrite(triggerPin, LOW);
  delayMicroseconds(2);
  digitalWrite(triggerPin, HIGH);
  delayMicroseconds(10);
  digitalWrite(triggerPin, LOW);

  timeTaken = pulseIn(echoPin, HIGH);
  return timeTaken * 0.034 / 2;
}

void loop() {
  // put your main code here, to run repeatedly:
  distL = getDistance(triggerL, echoL);
  distR = getDistance(triggerR, echoR);
  
  ///// operation 1
  if((distL>=40 && distR>=40) && (distL<=60 && distR<=60))
  {
    Serial.println("Play/Pause");
    delay(500);
  }
  
  ///// operation 2
  else if(distL>=13 && distL<=17)
  {
    delay(100);
    distL = getDistance(triggerL, echoL);
    if(distL<=13 && distL<=17)
    {
      Serial.println("Left Locked");
      while(distL<=40)
      {
        distL = getDistance(triggerL, echoL);
        if(distL <= 10) // hand pushed in
        {
          Serial.println("Volume Incresaed");
          delay(300);
        }
        else if(distL>=20) // hand pulled out
        {
          Serial.println("Volume Decreased");
          delay(300);
        }
      }
    }
  }
  
  ///// operation 3
  else if(distR>=13 && distR<=17)
  {
    delay(100);
    distR = getDistance(triggerR, echoR);
    if(distR>=13 && distR<=17)
    {
      Serial.println("Right Locked");
      while(distR<=40)
      {
        distR = getDistance(triggerR, echoR);
        if(distR <= 10) // hand pushed in
        {
          Serial.println("Rewind");
          delay(300);
        }
        else if(distR>=20) // hand pulled out
        {
          Serial.println("Forward");
          delay(300);
        }
      }
    }
  }
  delay(200);
}
