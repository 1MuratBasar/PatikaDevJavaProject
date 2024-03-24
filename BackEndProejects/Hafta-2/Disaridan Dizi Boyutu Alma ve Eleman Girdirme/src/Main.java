import java.util.Arrays;
import java.util.Scanner;
public class Main {

    // scanner ile dışarıdan boyut aldık
    // kritik nokta benim için matrisin boyutunun dışarıdan girmek istediğini kadar input değerinde olması
    // ve boyutu dışarıdan gireceğin input kadar alıyorum.


    public static void main(String[] args) {
        int [] matrix;
        //int matrix[][] = new int[2][3];
        Scanner input = new Scanner(System.in);
        System.out.print("Matris boyutu giriniz : ");
        matrix  = new int[input.nextInt()];

      System.out.println("Dizinin boyutu : " + matrix.length);
       int count = 0;
        for (int i = 0; i < matrix.length; i++) {
          System.out.print(count + " . indisi giriniz : ");
                matrix[i] = input.nextInt();
                count++;
            }
            Arrays.sort(matrix);
        System.out.println(Arrays.toString(matrix));

    }

}







