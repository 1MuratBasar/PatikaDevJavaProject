import javax.swing.*;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.nio.charset.Charset;

public class Main {
    // byte ve karakter akısından türleriiz mevcut. biri char dab digeri byte dan veri aktarır
    //char stream lerde bir charset belirleyebiliyoruz
    //bu karakter set
    // reader sınıfı soyuttru. aynı inputstreamler gibi
    // byte cinsiznde verileri char lara donustutur
    // soyut reader sınıfını genişletiyor , miras alıyor
    // karakter setleri sağlıyor farklı diller vs.

    public static void main(String[] args) {

        try {
            FileInputStream fileInput = new FileInputStream("patika.txt");

            InputStreamReader inputStreamReader = new InputStreamReader(fileInput, Charset.forName("x-Big5-HKSCS-2001" +
                    "" +
                    ""));
            System.out.println(inputStreamReader.getEncoding());
            int i = inputStreamReader.read();
            while (i != -1) {
                System.out.print((char)i);
                i= inputStreamReader.read();
            }

        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        System.out.println("Hello world!");
    }
}