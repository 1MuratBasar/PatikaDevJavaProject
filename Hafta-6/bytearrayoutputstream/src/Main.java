
import java.io.ByteArrayOutputStream;
import java.io.IOException;

public class Main {
    public static void main(String[] args) {

        String data = "Java 102 dersleri";
        ByteArrayOutputStream output = new ByteArrayOutputStream();
        byte[] dataByteArray = data.getBytes();

        try {
            output.write(dataByteArray);
            String newdata = output.toString(); // bu satırda byte cevirdiğimiz stringi tekrar geri byte a ceviriyoruz
            System.out.println("çıkış" + newdata);//
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        // buraya kadar ben stringi array a cevrdim ve output stream içine attım.
        // burada string byte a cevrildi ve bu stream uzerinden yapıldı

    }
}