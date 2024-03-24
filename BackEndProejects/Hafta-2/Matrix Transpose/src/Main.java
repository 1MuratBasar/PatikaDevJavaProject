import java.util.Scanner;
public class Main {


        static void print(int[][] matrix) {
            for (int[] row : matrix) {
                for (int col : row) {
                    System.out.print(col + " ");
                }
                System.out.println();
            }
        }



    public static void main(String[] args) {

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
        System.out.println("Matris transpozu : ");
        int row = matrix.length;  // 1- i yi matrixlength kadar yani ilk satır sayısı kadar tanımla
        int col = matrix[0].length; // 2- j yi matrisin 0. satırındaki sutun uzunlugu kadar tanımla

        int[][] tMatrix = new int[col][row];  // 3- yeni matrix = eski matrix in sola sutun/sağa satır. burada boyutlar değişiyor

        for (int k = 0; k < matrix.length; k++) {  // 4- donguleri kur
            for (int y = 0; y < matrix[k].length; y++) {
                tMatrix[y][k] = matrix[k][y];  // 5- yeni matrix sutun,satır = eski matris satır,sutun
                // burada  yer değiştiriyoruz

            }

        }
        print(tMatrix); // matrisi yazdırıyoruz

        }




    }








