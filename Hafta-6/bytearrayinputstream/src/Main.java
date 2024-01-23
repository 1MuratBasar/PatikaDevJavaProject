
import java.io.ByteArrayInputStream;
import java.io.IOException;

public class Main {
    public static void main(String[] args) {

       byte[] dizi = {1,2,3,54,66,127, 10, 12, 14};

       ByteArrayInputStream input = new ByteArrayInputStream(dizi , 2 ,4);
        System.out.println("kullanılabilir" + input.available());
      //  input.skip(2);

        int i = input.read();

        while (i != -1){
            System.out.println(i);
            i = input.read();
        }
        try {
            input.close();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

    }
}