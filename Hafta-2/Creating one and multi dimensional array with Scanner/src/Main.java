import java.util.Scanner;
public class Main {



    public static void main(String[] args) {
      /*  int matrix[] = new int[5];

        Scanner input = new Scanner(System.in);

        for (int i = 0; i < matrix.length; i++) {
            System.out.print(i + ". değerini giriniz : ");
            matrix[i] = input.nextInt();

        }
        for (int i = 0; i < matrix.length; i++) {
            System.out.print(matrix[i] + " ");
        } */

        int matrix[][] = new int[2][3];
        Scanner input = new Scanner(System.in);
        int count = 0;
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                System.out.print(count + " . değeri giriniz : ");

                matrix[i][j] = input.nextInt();

                count ++;
            }


        }
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {

                System.out.print(matrix[i][j] + "  ");

            }
            System.out.println();

        }


    }

}







