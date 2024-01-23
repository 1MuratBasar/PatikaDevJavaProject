
import java.io.*;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Bir metin girin: ");
        String metin = scanner.nextLine();
        scanner.close();
        FileWriter fileWriter = null;
        try {
            fileWriter = new FileWriter("notlar.txt", false);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        PrintWriter printWriter = new PrintWriter(fileWriter);
        printWriter.print(metin);

        printWriter.close();

        FileReader fileReader = null;
        try {
            fileReader = new FileReader("notlar.txt");
            BufferedReader bufferedReader = new BufferedReader(fileReader);
            String okunanMetin = bufferedReader.readLine();
            System.out.println(okunanMetin);
            bufferedReader.close();

        } catch (Exception e) {
            System.out.println(e.getMessage());
        }




    }
}