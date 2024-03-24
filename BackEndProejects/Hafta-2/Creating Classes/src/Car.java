public class Car {
// nitelikler

String type;
double enginePower;
String model;
String color;
int speed;
int speedLimit=180;

int increaseSpeed (int increment) {

    if (speed + increment < speedLimit) {
        speed += increment;
    }
    return increment;
}
int descreaseSpeed (int desrease) {

if (speed - desrease >0 ) {
         speed -= desrease;

}
return desrease;

}

void printCarFeature () {

    System.out.println("Aracın rengi : " + color + "\nAracı Hızı : " + speed + "\nAracın motoru : " + enginePower) ;
}


}
