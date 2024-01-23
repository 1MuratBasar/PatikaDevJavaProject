
import java.io.FileInputStream;
import java.io.ObjectInputStream;

public class Main {

    // bir proje içerisinde olsutrdugumuz nesnenin değerleriyle birlikte dosyaya atıp daha sonradan
    // dosyadan değerleri ile birlikte okuyabilme olayını göretiyor.
    //geri okurken o dosyanın hangi sınfa ait oldugu/türü bilinmiyor. tam bu noktada
    // java serialization yardımcı oluyor (Serialization api ile depoloma yapıyoruz)
    public static void main(String[] args) {

       /* Car c1 = new Car("Audi" , "A7");

        try {
            FileOutputStream outputfile = new FileOutputStream("src/araba.txt");
            ObjectOutputStream outputObject = new ObjectOutputStream(outputfile);
            outputObject.writeObject(c1);
            outputObject.close();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        */

        Car c1 = new Car("Audi" , "A7");

        try {
            FileInputStream inputFile = new FileInputStream("araba.txt");

            ObjectInputStream inputStream = new ObjectInputStream(inputFile);

            Car newCar = (Car) inputStream.readObject();
            System.out.println(newCar.getBrand());
            System.out.println(newCar.getModel());
            inputFile.close();
            inputStream.close();

        } catch (Exception e) {
            e.printStackTrace();
        }

    }
}