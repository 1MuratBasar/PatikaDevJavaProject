import java.util.Arrays;

public class Main {


    int x;
    public static void main(String[] args) {
        int[][] arr = new int[3][];

        arr[2] = new int[4];
        int sum = 0;
        arr[2][2] = 1;
        arr[2][3] = 2;
        System.out.println(arr[2][2]);
        System.out.println(arr[2][3]);


        int[] original = {1, 2, 3, 4, 5};
        int[] reverse = new int[original.length];

        for (int i = 0; i < original.length; i++) {
            reverse[i] = original[original.length - 1 - i];
            System.out.println(Arrays.toString(reverse));
        }

// reverse dizisi şimdi {5, 4, 3, 2, 1} şeklinde olacaktır.



        int a=5;

        Main m1 = new Main();
        m1.x = 10;

    }
}
