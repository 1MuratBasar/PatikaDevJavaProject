import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.charset.Charset;

public class Main {


    public static void main(String[] args) {

/*  // File Reader
        try {
            FileReader readFile = new FileReader("patika.txt" , Charset.forName("Big5"));
            readFile.skip(1);
            readFile.getEncoding();

            int i = readFile.read();
            while (i != -1){
                System.out.print((char)i);
                i = readFile.read();
            }
            readFile.close();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

*/

        // File Writer
        String data = "JAVA ÖĞRENİYORUM";

        try {
            FileWriter yazici = new FileWriter("output.txt");
            yazici.write(data);
            yazici.close();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }


    }
}