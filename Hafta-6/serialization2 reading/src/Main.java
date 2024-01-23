
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.ObjectInputStream;
public class Main {
    public static void main(String[] args) {
        Car c1 = new Car("Audi" , "A7");

        try {

            FileInputStream inputfile = new FileInputStream("araba.txt");
                ObjectInputStream inputObject = new ObjectInputStream(inputfile);
Car newcar = (Car) inputObject.readObject();
            System.out.println(newcar.getBrand());
        } catch (Exception e) {
            e.printStackTrace();
        }


    }
}
