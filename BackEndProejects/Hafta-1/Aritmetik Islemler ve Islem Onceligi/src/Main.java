import java.util.Scanner;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {

        // ihtiyac duyacagımız değişkenleri tanımlıyoruz
        int a,b,c,result;
        /*dışarıdan veri almak için scanner nesnemizi tanımlıyor, kullanıcıdan veri istiyor ve
        bunu bir degişkenlerimize atıyoruz.*/
        Scanner input = new Scanner(System.in);
        System.out.print("a sayısını giriniz : ");
        a = input.nextInt();
        System.out.print("b sayısını giriniz : ");
        b = input.nextInt();
        System.out.print("c sayısını giriniz : ");
        c = input.nextInt();
        // işlem adımlarına ayırıp, sonuc hesaplatıp bunu yazdırıyoruz.
        result = (a+b*c-b);
        System.out.println("Sonuc : " + result);
        System.out.println("islem onceligi: a+b*c-b dir");
    }

}