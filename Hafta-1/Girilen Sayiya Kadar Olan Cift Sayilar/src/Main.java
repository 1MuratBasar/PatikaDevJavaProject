import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        //ihtiyacımız olan değişkenleri tanımlıyoruz.
        // i ve j dışarıdan alınan sayı ve döngü için
        //sayac,toplam ve avg = tam bölünebilenleri saydırmak, toplamak ve ortalama almak için tanımlandılar
        int i;
        int j;
        int sayac=0;
        int toplam=0;
        int avg=0;


            Scanner input = new Scanner(System.in);
             System.out.print("Bir Sayı Giriniz : ");
             i = input.nextInt();
            // ekrana girilen sayı 0 ve 0 dan az ise tekrar denememizi isteyecek
            if (i <= 0) {

                System.out.println("Girdiğiniz değer 0 veya 0'dan azdır, farklı değer deneyiniz");
            } else {
                //döngüye alıp 3 e 4 e ve 0 a modun 0 olmama durumu. 0 ı çıkarma nedenimiz sayaçta fark arttırması
                for (j = 0; j < i; j++) {

                    if ((j % 3 == 0) && (j % 4 == 0) && (j != 0)) {

                        sayac += 1;
                        toplam = toplam + j;
                        avg = toplam / sayac;

                    }
                }
                System.out.println("3 ve 4 e bölünen tam sayıların ortalaması " + avg);
            }


    }
}
