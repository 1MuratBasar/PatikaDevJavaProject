
import java.io.FileNotFoundException;
import java.io.PrintStream;

public class Main {

    // çıktı verilerini byte yerine metin biçimine çevirir.

    public static void main(String[] args) {

        try {
            PrintStream output = new PrintStream("araba.txt");
            output.print (123 + "123");
            output.close();
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }
    }
}