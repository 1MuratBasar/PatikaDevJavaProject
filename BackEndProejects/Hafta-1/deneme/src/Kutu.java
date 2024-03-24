import  java.util.Scanner;
public class Kutu {


    public static void main(String[] args) {
        String x;
        String y;
        Scanner input = new Scanner(System.in);
        System.out.println("isim gir");
        x = input.nextLine();
        System.out.println("soyad gir");
        y = input.nextLine();


       // String komple = tumIsım("John", "Dere");
        System.out.println("Full Name is: " + tumIsım(x,y));
    }

    public static String tumIsım(String ad, String soyad) {
        return ad + " " + soyad;
    }
}