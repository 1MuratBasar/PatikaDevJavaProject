import java.io.*;

public class Main {

    // buffered input stream, dah önce kullandıgımız stream leri daha hızlandırmak için arada tampon görevi görür
    // hafıza ile program arasında bellek görevi görür
    // bi file dosyası olusturcaz. sonra bunu buffered içine atıcaz

    public static void main(String[] args) {

    /*    try {
            FileInputStream fileinput = new FileInputStream("patika.txt");

            BufferedInputStream bufferedInputStream = new BufferedInputStream(fileinput);

            int i = bufferedInputStream.read();
            while (i != -1){
                System.out.print((char)i);
                i = bufferedInputStream.read();
            }

        } catch (Exception e) {
            e.printStackTrace();
        }

        System.out.println("Hello world!");
     */

        // buffered output stream

        String data = "java 103 patikası";


        try {
            FileOutputStream outputStream = new FileOutputStream("patika.txt");
            BufferedOutputStream bufferedOutputStream = new BufferedOutputStream(outputStream);

            byte [] array = data.getBytes();
            bufferedOutputStream.write(array);
            bufferedOutputStream.close();
            outputStream.close();
        } catch (Exception e) {
            e.printStackTrace();
        }


    }

}