import java.util.Scanner;
public class Main {

        public static void main(String[] args) {
            int k;
            int y;
            Scanner input = new Scanner(System.in);
            System.out.println("k sayısı gir");
            k = input.nextInt();
            y=k;
            boolean isDecreasing = true;

            int sonuc = toplam(k,y,isDecreasing);
            System.out.println(sonuc );
        }
        public static int toplam(int k, int y, boolean isDecreasing) {
            if (k > 0) {

                return k + toplam(k - 1, y-1, isDecreasing);

            } else {
                return 0;
            }
        }
    }



