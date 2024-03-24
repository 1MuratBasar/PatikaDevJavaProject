import java.util.Arrays;
public class Main {
    public static void main(String[] args) {
        // döngüde i sayisi indisteki değerden küçük ama 5 ten de büyük olmalı
        // döngde i sayisi indisteki değerden büyük ama 5 ten kucuk olmalı
        int[] list = {15, 12, 788, 1, -1, -778, 2, 0};
        int sayi=5;
        int newMin = list[0];
        int newMax = list[0];



        for (int i : list) {

            // 6 < 15 && 5 < 6 yani i sayım indisteki sayıdan küçük olacak aynı zamanda 5 ten buyuk olacak

            if (i < newMax && sayi<i ) {
                newMax = i;
            }

            if (i < -1*newMin && sayi>i) {
                newMin = i;
            }
        }

        System.out.println("Minimum Değer " + newMin);
        System.out.println("Maximum Değer " + newMax);

    }

}
