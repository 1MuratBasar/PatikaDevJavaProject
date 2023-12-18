import java.util.Scanner;
//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        //Harmonik Sayı Formülasyon 1 + (1/2) + (1/3) + (1/4) ..... + (1/n)
        //veri tipi nedeniyle double değişken tanımlıyoruz.
        int n;
        double i;
        double result=0;
        double result2=0;

        Scanner input = new Scanner(System.in);
        System.out.print("Bir N değeri giriniz : ");
         n = input.nextInt();
        //1 den başlayıp n e kadar 1 er artırarak döngüyü çalıştırıyoruz.
        //Her çalıştığında resulta, result + (1/n) hesaplaması yaptırıyor
         // For döngüsü ile
         for (i=1; i<=n; i++){

             result = result + (1/i);
         }
        //while döngüsü
        i=1;
        while (i<=n)
        {

           result2 = result2 + (1/i);
            i++;
        }


        System.out.println("For Döngüsü Sonucu   : " + result);
        System.out.println("While Döngüsü sonucu : " + result2);
    }
}