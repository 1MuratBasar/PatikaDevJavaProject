import java.util.Scanner;
//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        int us;
        int taban;
        int i; // saydırmak iin
        int total=1; // us sonucunu atamak için

        Scanner input = new Scanner(System.in);
        //Dışarıdan taban ve us degerleri aldık
        System.out.print("Üssü alınacak sayı (taban) giriniz : ");
        taban = input.nextInt();
        System.out.print("Üs olacak sayıyı giriniz : ");
        us = input.nextInt();
        // donguyu us kadar dondurdukce tabanı kendisiyle çarptık
        for (i=1; i<=us; i++ ){

            total *=taban;

        }
        System.out.println("Sonuç değeri : " + total);



    }
}