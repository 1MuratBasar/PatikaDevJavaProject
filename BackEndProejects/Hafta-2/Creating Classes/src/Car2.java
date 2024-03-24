public class Car2 {
// nitelikler

    String type;
    double enginePower;
    String model;
    String color;
    int speed;
    int speedLimit=180;


    Car2 (String type, String model, String color) {
this.type = type;
this.model = "Sportege";
this.color = color;
this.speed = 0;



    }


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



void printInfo() {
    System.out.println("================");
    System.out.println("Type  : " + this.type);
    System.out.println("Model  : " + this.model);
    System.out.println("Color  : " + this.color);

    System.out.println("Speed  : " + this.speed);
}

}