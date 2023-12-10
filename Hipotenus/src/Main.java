
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        //Değişkenleri tanımlıyoruz. kenar1, kenar2 ve hipotenüsün atanacağı değişken
        int k1, k2;
        double hipotenus;
        //Dışarıdan kenar uzunluğu almak için scanner tanımlıyoruz.(sca)
        Scanner sca = new Scanner(System.in);
        System.out.print("1. Kenarı Giriniz : ");
        k1 = sca.nextInt();
        System.out.print("2. Kenarı Giriniz : ");
        k2 = sca.nextInt();
        //mathsqrt ile kenarların kareleri toplamının karekökünü alıyoruz ve hipotneüsü elde ediyoruz.
        hipotenus = Math.sqrt((k1*k1)+ (k2*k2)) ;
        System.out.println("Hipotenus : " + hipotenus);


    }
}