/*

OSEPP Touch Sensor Module Example

Serial monitor prints values output from touch sensor
when body conductivity applied. 


 */

int sensorPin = A0;    // select the input pin for the potentiometer
int sensorValue = 0;  // variable to store the value coming from the sensor

void setup() {
  Serial.begin(9600);
  // declare the ledPin as an OUTPUT:
}

void loop() {
  // read the value from the sensor:
  sensorValue = analogRead(sensorPin);
  Serial.println("Touch Sensor Value = " + sensorValue);

}