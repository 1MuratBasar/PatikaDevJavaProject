

// ÜÇGENDE ÇEVRE ve ALANI HESAPLAYAN PROGRAM
import  java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        //değişkenlerimizi tanımlıyoruz
        int k1, k2, k3, cevre;
        double alan;
        // scanner ile dıaşrıdan veri aldırıyoruz
        Scanner sca = new Scanner(System.in);
        System.out.print("1. kenarı giriniz : ");
        k1 = sca.nextInt();
        System.out.print("2. kenarı giriniz : ");
        k2 = sca.nextInt();
        System.out.print("3. kenarı giriniz : ");
        k3 = sca.nextInt();
        // üçgenin alanınoı hesaplattırıyoruz
        cevre = (k1+k2+k3);
        double s = cevre / 2;
        System.out.println("Üçgenin çevre uzunluğu : " + cevre);
        alan = Math.sqrt(( s * (s - k1)* (s - k2)* (s - k3)));
        System.out.println("Üçgenin alanı : " + alan);







    }
}