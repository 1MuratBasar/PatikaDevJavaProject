import java.util.Scanner;

public class deneme2 {
    public static void main(String[] args) {

        // Kullanıcıdan Sayı isteme ve Yönlendirme;

        Scanner scanner = new Scanner(System.in);

        System.out.print("Lütfen Bir Sayı Giriniz : ");
        int number = scanner.nextInt();

        if (number < 0 ) {
            System.out.print("Hatalı Sayı Girdiniz!");
        }
        else {
            recursiveMetot(number, number, -1);
        }
    }

    // Recursive Metot Kısmı
    static void recursiveMetot(int number, int a, int side){

        //Burada önce a değeri girilen sayı ile eşitlenerek ilk olarak girilen sayı ekrana yazdırılıyor.
        //Döngü boyunca desen için ekrana yazılan a sayılarının arasında boşluk olması için " " ifadesi eklenir.

        System.out.print(a + " ");


        if (a == number && side == 1){

            // a sayısı ilk başta girilen sayıya eşitlenip girilen sayı korunduğu için
            // döngü boyunca a sayısı değişirken girilen sayı korunur ve
            // a sayısının yeniden girilen sayıya eşitlendiği durumda döngü durdurulur.

            return;
        }
        if (a <= 0){

            // a sayısının negatife dönmesi durumunda side değeri -1 den +1 e dönerek
            // a sayısının döngü içerisinde artmasını sağlar

            side = 1;
        }

        // Burada girilen sayının a ya eşitlenmesinin ardından a sayısının
        //side değerinin 1 veya -1 olmasına bağlı olarak
        // a sayısının +5 artması veya -5 azalması sağlanır ve döngü devam eder.

        recursiveMetot(number, a + (5 * side), side);
    }
}