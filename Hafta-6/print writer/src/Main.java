import java.io.FileNotFoundException;
import java.io.PrintWriter;

public class Main {


    public static void main(String[] args) {
        // her şeyi stringe cevirir
        String data = "java öğreniyorum";
        try {
            PrintWriter writer = new PrintWriter("output.txt");
        writer.print(1234555);
        writer.close();

        } catch (Exception e) {
            System.out.println(e.getMessage());

        }

    }
}