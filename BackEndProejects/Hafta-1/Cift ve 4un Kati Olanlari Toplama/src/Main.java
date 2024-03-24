
import javax.security.sasl.SaslClient;
import java.util.Scanner;
//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        //ihtiyac duyulan değişkenleri tanımladık
        int n;
        int total = 0;

        Scanner scan = new Scanner(System.in);
        // pozitif tek sayı girine kadar çalışmaya devam edecek
        do {
            System.out.print("Bir Sayı Giriniz : ");
            n = scan.nextInt();

           if (n % 4 == 0) {
                total +=n;
            }

        }while ((n%2==0) || (n<=0)); // iki koşul birbirinin kümesine girmediği için veya diyebiliyoruz.

        System.out.println("Toplam : " + total  );
    }
}