
import java.util.Scanner;
//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        // ihtiyacımız olan değişkenleri ve scanner nesnemisi tanımlıyoruz.
        int a = 0;
        int b = 0;
        int c = 0;


        Scanner input = new Scanner(System.in);
        //dışarıdan sayı isteyip değişkenlere atamasını yapıyoruz
        System.out.print("a sayısını giriniz : ");
        if (input.hasNextInt()) {
            a = input.nextInt();
        } else {
            System.out.println("Sayı girmelisiniz");
            System.exit(2);
        }

        System.out.print("b sayısını giriniz : ");
        if (input.hasNextInt()) {
            b = input.nextInt();
        } else {
            System.out.println("Sayı girmelisiniz");
            System.exit(2);
        }
        System.out.print("c sayısını giriniz : ");
        if (input.hasNextInt()) {
            c = input.nextInt();
        } else {
            System.out.println("Sayı girmelisiniz");
            System.exit(2);
        }
        if ((a == b) || (b == c) || (a == c)) {
            System.out.println("Sayılar birbirine eşittir farklı değerler girin");
            System.exit(2);
        } else {

            // dışarıdan sayı aldıktan sonra koşulları uyguluyoruz
            if ((a > b) && (a > c)) {
                if (b > c) {
                    System.out.println("a>b>c");
                } else {
                    System.out.println("a>c>b");
                }
            } else if ((b > a) && (b > c)) {
                if (a > c) {
                    System.out.println("b>a>c");
                } else {
                    System.out.println("b>c>a");
                }
            } else {
                if (a > b) {
                    System.out.println("c>a>b");
                } else {
                    System.out.println("c>b>a");
                }

            }
        }
    }
}


