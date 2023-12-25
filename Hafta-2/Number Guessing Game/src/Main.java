import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Random rand = new Random ();

        int number = rand.nextInt(100);
      // int number = (int) (Math.random()*100);

        Scanner input = new Scanner(System.in);
        int right =0;
        int selected;
        boolean isWin = false;
        boolean isWrong = false;
        int [] wrong = new int[5];
        while (right<5) {
            System.out.println("Tahmininizi giriniz : ");
            selected = input.nextInt();
            if (selected <0 || selected >99) {
                System.out.println("Lüten 0-100 arasında bir değer giriniz");
                if (!isWrong){
                    right++;
                    System.out.println("Fazla sayıda giriş hatası. Kalan hak : "+ (5-right));
                } else {
                    isWrong = true;
                    System.out.println("Sonraki yanlış girişinizde hakkınızdan düşülecektir");

                }
                continue; // yanlış bir seçim yaptıysa dongunun başına donsun aşağı gitmesn tekrar
            }
            if (selected == number) {
                System.out.println("Tebrikler, doğru tahmin. tahmin ettiğiniz sayı " +    number);
                isWin = true;
                break;
            } else {

                System.out.println("Hatalı bir sayı girdiniz.");
                if (selected > number){
                    System.out.println(selected + " sayısı, gizli sayıda büyüktür.");
                } else {
                    System.out.println(selected + " sayısı, gizli sayıdan küçüktür.");
                }
                wrong[right++] = selected;
                System.out.println("Kalan hakkı : " + (5-right));
            }
        }
            if (!isWin) {
                System.out.println("Kaybettiniz.");
                if (!isWrong) {
                    System.out.println("Tahminleriniz : " + Arrays.toString(wrong));

                }

            }
    }
}