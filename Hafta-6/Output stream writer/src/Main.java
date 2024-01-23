import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.OutputStreamWriter;

import static java.lang.System.*;

public class Main {
    public static void main(String[] args) {

        String data = "dsfghdfjklkş";

        try {
            FileOutputStream fileOutputStream = new FileOutputStream("patika.txt");
            OutputStreamWriter outyazici = new OutputStreamWriter(fileOutputStream);
       //     fileOutputStream.write(data.getBytes());
            //getbyte  varsayılan utf 8 donduruyor
         //   fileOutputStream.close();
         //   out.println( outyazici.getEncoding());
            // bir outputstream ile çalışması gerekir
            outyazici.write(data);
            outyazici.close();
        } catch (Exception e) {
            e.printStackTrace();
        }

    }
}