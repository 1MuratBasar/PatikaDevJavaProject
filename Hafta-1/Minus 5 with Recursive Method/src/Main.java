import java.util.Scanner;
public class Main {
    static int minusFive(int a, int b, boolean isDecreasing) {

        if (a > 0 && isDecreasing) {
           System.out.print(a + " ");
             minusFive(a - 5, b, true);
        } else {
            if (a <= b) {
               System.out.print(a + " ");
                    minusFive(a + 5, b, false);

            }
        }
            return a;
    }

public static void main (String [] args) {


    int a;
    int b;
    Scanner input = new Scanner(System.in);
    System.out.println("k sayısı gir");
    a = input.nextInt();
    b=a;
    boolean isDecreasing = true;
    int sonuc = minusFive(a,b,isDecreasing);
    System.out.println(sonuc );



}
    }

