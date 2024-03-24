import  java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        int number;
        int i;
        int result=0;

        Scanner input = new Scanner(System.in);
        System.out.print("Bir Sayi Giriniz : ");
        number = input.nextInt();
        // sayının pozitif çarpanı için girilen değerin 0 üzeri olmasını kontrol ettik.
        if (number >0) {

            //girilen sayı sıfırdan büyükse sayının 1 eksiğine kadar dönecek.
            for (i = 1; i < number; i++) {

                if (number % i == 0) {

                    result += i;
                }
            }
              if (number == result) {
                System.out.println(result + " Bir Mükemmel Sayıdır");

            } else {
                System.out.println(number + " Bir Mükemmel Sayı Değildir");

            }
        } else {
            System.out.println("0 veya daha az bir değer giriniz tekrar deneyiniz.");
            System.exit(2);
        }

    }
}