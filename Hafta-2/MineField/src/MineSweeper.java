import java.lang.NullPointerException;
import java.util.Objects;
import java.util.Scanner;
import java.util.Random;

public class MineSweeper {
    // buraya sadece tüm class ta kullanacağım değişkenleri tanımlıyorum.
    int rowNumber, colNumber, size;
    String[][] map;
    String[][] board;
    boolean game = true;

    Random random = new Random();
    Scanner input = new Scanner(System.in);

    //kurucu metotun alacağı parametre olarak tanımlayacağım şey dışarıdan alacağım değerler olabilir.
    // bu noktada sürekli alacağım değerler satır ve sütun değerleri.
    MineSweeper(int rowNumber, int colNumber) {
        this.rowNumber = rowNumber;
        this.colNumber = colNumber;
        this.map = new String[colNumber][rowNumber];
        this.board = new String[colNumber][rowNumber];
        this.size = rowNumber * colNumber;

    }

    public void run() {
        int r, c, success = 0;

        prepareGame();
        print(map);
        //    print(board);

        System.out.println("Oyun Başladı");
        while (game) {

            System.out.print("satır");
            r = input.nextInt();
            System.out.print("sutun");
            c = input.nextInt();
            if (!Objects.equals(map[r][c], "*")) {
                break;
            } else {
                game = false;
                System.out.println("game over");
            }
        }
    }

    public void prepareGame() {
        int count = 0;


        int randomRow, randomCol;
        while (count != (size / 4)) {
            randomRow = random.nextInt(rowNumber);
            randomCol = random.nextInt(colNumber);
            if (!Objects.equals(map[randomRow][randomCol], "*")){
               map[randomRow][randomCol] = "*";
                count++;
            }

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















