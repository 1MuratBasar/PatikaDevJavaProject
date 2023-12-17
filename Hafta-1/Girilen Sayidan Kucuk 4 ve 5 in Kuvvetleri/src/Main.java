import java.util.Scanner;
//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        //değişken tanımlamalarımız yaptık
        int i;
        int x;
        int j;
        int sayac=-1;
         Scanner input = new Scanner(System.in);
         System.out.print("Bir Sayı Giriniz : ");
         j = input.nextInt();
         if (j>0) {
             // for dongusu ile her sayaç artısında kendisi kadar çarptırıp üs aldık
             for (i = 1, x = 1; i <= j && x <= j; i *= 4, x *= 5) {
                 sayac = sayac + 1;
                 System.out.println("4 ve 5 in " + sayac + ". kuvveti : " + i + " ve " + x + " dir.");

             }

         } else {
             System.out.println("0 veya daha düşük değer giriniz tekrar deneyin.");
         }

    }
}