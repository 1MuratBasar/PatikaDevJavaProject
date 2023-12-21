
import java.util.Scanner;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    static int power(int base, int exp) {


        int result = 0;

        if (exp == 0) {
            return 1;
        }


        result = base * power(base, exp - 1);
        return result;


    }

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        while (true) {
            System.out.print("Taban sayısı giriniz : ");
            int base = input.nextInt();
            System.out.print("Üs sayısı giriniz : ");
            int exp = input.nextInt();

            System.out.println("sonuc : " + power(base, exp));


        }
    }

    }

