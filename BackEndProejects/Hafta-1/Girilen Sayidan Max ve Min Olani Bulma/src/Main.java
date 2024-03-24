import java.util.Scanner;


public class Main {
    public static void main(String[] args) {
        int sayi, i, n, s1;
        int kucuk=2147483647, buyuk = -2147483648;

        Scanner input = new Scanner(System.in);
        System.out.print("Kaç tane sayı gireceksiniz : ");
        sayi = input.nextInt();


        for (i = 1; i <= sayi; i++) {

            System.out.print(i + " . sayıyı giriniz : ");
            s1 = input.nextInt();

            if (s1 > buyuk) {// girilen sayının “buyuk”le karşılaştırılması. girelen sayı diyelim 1 olsun.
                buyuk = s1; // s1 > buyuk (varsayılan değer yukarıda 0) den mi diye bakacak.
                // dogruysa buyuk = s1 olacak. yani yeni en buyuk s1 artık.
            } if (s1 < kucuk)  {
               kucuk = s1;
           }


        }
        System.out.println("En Buyuk sayi= "+ buyuk);
        System.out.println("En Küçük sayi= "+ kucuk);
}
    }
