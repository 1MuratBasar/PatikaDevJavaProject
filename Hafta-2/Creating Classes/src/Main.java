//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {

        Car sahin = new Car();
        sahin.speed = 10;
        sahin.increaseSpeed(90);
        sahin.color = "Beyaz";
        sahin.model = "1994";
        sahin.enginePower = 1.6;
        sahin.printCarFeature();

    }
}