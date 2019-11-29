int laserPin = 10;

void setup ()
{
   Serial.begin(9600);
   pinMode (laserPin, OUTPUT); // define the digital output interface 13 feet
}
void loop () {
   digitalWrite (laserPin, HIGH); // Turn Laser On
   delay (1000); // On For Half a Second
   digitalWrite (laserPin, LOW); // Turn Laser Off
   delay (500); // Off for half a second
}
