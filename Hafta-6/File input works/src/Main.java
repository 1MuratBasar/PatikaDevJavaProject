import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

public class Main {
    public static void main(String[] args) {



            File dosya = new File("src/Patika.txt");
            try {
                dosya.createNewFile();
            } catch (IOException e) {
                System.out.println(e.getMessage());
            }


        }
    }
