import java.util.Scanner;
//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {

        Scanner input = new Scanner(System.in);
        System.out.print("Faktoriyeli Hesaplanacak Değeri Girin : ");
        int n = input.nextInt();
        if (n <=0) {
            System.out.println("0 veya daha az değer girdiniz, tekrar deneyin.");
        } else {


        int total = 1;
        int i=1;
        while ( i <=n) {
            total = total*i;
            i++;
        }
        System.out.println("Girilen sayının faktoriyeli : " + total);
    }
    }
}