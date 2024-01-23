import java.io.*;

public class Main {
    public static void main(String[] args) {
       File file = new File ("kod.txt");
       if (!file.exists()){
           try {
               file.createNewFile();
           } catch (Exception e) {
               System.out.println(e.getMessage());

           }
       }


    }
}