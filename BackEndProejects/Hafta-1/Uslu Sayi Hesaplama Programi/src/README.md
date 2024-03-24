Üslü Sayı Hesaplama Programı

     While döngüsü ile

import java.util.Scanner;
public class main2 {
public static void main(String[] args) {
int us;
int taban;
int i=1;
int total=1;

        Scanner input = new Scanner(System.in);

        System.out.print("Üssü alınacak sayı (taban) giriniz : ");
        taban = input.nextInt();
        System.out.print("Üs olacak sayıyı giriniz : ");
        us = input.nextInt();
        while (i<=us)
        {
            total *= taban;
            i++;
        }
        System.out.println("Sonuc : " + total);
    }
}
