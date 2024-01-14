import java.util.Objects;
import java.util.Scanner;
import java.util.Random;

public class MineField {
    int rowNumber, colNumber, size;
    String[][] map;
    String[][] board;
    boolean isGame = true;
    Scanner input = new Scanner(System.in);
    Random rand = new Random();


    MineField(int rowNumber, int colNumber) {
        this.colNumber = colNumber;
        this.rowNumber = rowNumber;
        this.size = rowNumber - colNumber;
        this.map = new String[rowNumber][colNumber];
        this.board = new String[rowNumber][colNumber];

    }

    public void runGame() {
placingMines();
print(map);
print(board);
      //  print(board);
    }

    public void placingMines () {                    //mayınları rastgele yerleştirmek için
        int randomRow, randColumn;                      //rasgele oluşturacagım randrow ve randcol sayıları
        int count = 0;
        while (count !=(size/4)) {

            randomRow = rand.nextInt(rowNumber);  // random sayılar uretmek için bu ve altı
            randColumn=rand.nextInt(colNumber);
                map[randomRow][randColumn] = "*";
            System.out.println(map[randomRow][randColumn] );
                count++;


        }


    }

    public void print(String[][] arr) {

        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr[0].length; j++) {

                arr[i][j] = "-";
                System.out.print(arr[i][j] + " ");
            }
            System.out.println();
        }

    }
}