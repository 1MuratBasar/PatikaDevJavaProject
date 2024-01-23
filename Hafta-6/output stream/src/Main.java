import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.FileOutputStream;

public class Main {
    public static void main(String[] args) {
        String yazi = ("ogrendim patiko ogreniyorum. \npatiko");

        try {
            FileOutputStream out = new FileOutputStream("src/Patika.txt" , false) ;

            byte [] usttekiyaziburdabyteoluyor = yazi.getBytes(); // tum stringler burda byte şekilnde array oluyor
            out.write(usttekiyaziburdabyteoluyor);
            out.close();
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }

    }
}