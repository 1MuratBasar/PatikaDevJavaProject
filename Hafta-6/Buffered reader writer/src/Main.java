import java.io.*;
import java.nio.charset.Charset;

public class Main {

    public static void main(String[] args) {
/* // buffered reader
        try {
            FileReader okuyucu = new FileReader("patika.txt");
            BufferedReader readBuff = new BufferedReader(okuyucu);
       /*     String line = readBuff.readLine();

            while (line != null){
                System.out.println(line);
                line = readBuff.readLine();
            }


            String line;
while ((line = readBuff.readLine()) != null) {
    System.out.print(line + "#######");
}
        } catch (Exception e) {
            e.printStackTrace();

        }
*/

        // Bufferede Writer

        // dosya yazmak için kullanılır. tek başına kullanılmaz

        String data = "Java Full Stack Developer öğreniyörüm";
        File dosya = new File("patika.txt");
        try {
            FileWriter yazici = new FileWriter(dosya, Charset.forName("Big5"));

            BufferedWriter buffyaz = new BufferedWriter(yazici);

            buffyaz.write(data);
            buffyaz.close();

        } catch (Exception e) {
            System.out.println(e.getMessage());


        }
    }
}