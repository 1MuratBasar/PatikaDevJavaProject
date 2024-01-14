import java.util.Random;
import  java.util.Scanner;
import  java.lang.String;
public class MineField {
    //Nitelikler
    int rowNumber;                                      //satır sayısı için
    int colNumber;                                      //sütün sayısı için
    int lengthOfArray;
    int[][] map;                                       // mayın ve sayı haritam için
    int[][] userInterface;                             // kullanıcının oynadıgı oyun için
    boolean isGame = true;
    Scanner input = new Scanner(System.in);             // dışarıdan veri almak için
    Random random = new Random();                       // random mayın yerleştirmek için


//metotlar

    MineField(int colNumber, int rowNumber) {

        this.colNumber = colNumber;
        this.rowNumber = rowNumber;
        this.map = new int[rowNumber][colNumber];
        this.userInterface = new int[rowNumber][colNumber];
        this.lengthOfArray = rowNumber * colNumber;

    }

    public void run () {  // oyunu çalıştırdıgım alan
        int r1 , c1, control=0;
        placingMines ();                     // 1- mayınları yerleştir
        print (map);                      // 2-haritayı bas
        System.out.println("Oyun Başladı");  // 3-
        while (isGame) {
            print(userInterface);
            System.out.print("Satır giriniz...");
            r1 = input.nextInt();
            System.out.print("Sütun giriniz...");
            c1 = input.nextInt();
            if (map[r1][c1] != -1) {
                checkMines(r1, c1);
                control++;
                if (control == (lengthOfArray-(lengthOfArray/4))){
                    System.out.println("Oyunu başarılı bir şekilde bitirdiniz.");
                    break;
                }
            } else {
            isGame = false;
                System.out.println("Oyun bitti.");
            }
                // r1 ve c1 i checkMines methoduna parametre olarak gonderiyorum.
               // checjMines methodunda r ve c olarak işlem görecekler
            }

        }



    public void checkMines (int r, int c){
        if (userInterface[r][c] == 0){
        if ((c<colNumber-1) && (map[r][c+1 ] == -1)){
            userInterface[r][c] ++;
        }
        if ((r < rowNumber-1) &&(map[r+1][c ] == -1)){
            userInterface[r][c] ++;
        }
        if ((r>0) && (map[r-1][c ] == -1)){
            userInterface[r][c] ++;
        }
        if ((c>0) && (map[r][c-1 ] == -1)){
            userInterface[r][c] ++;
        }
      // eklenebilir
        if (userInterface[r][c]== 0){
            userInterface[r][c] = -2;
        }

    }
    }

    public void placingMines () {                    //mayınları rastgele yerleştirmek için
    int randomRow, randColumn;                      //rasgele oluşturacagım randrow ve randcol sayıları
        int count = 0;
    while (count !=lengthOfArray/4) {

        randomRow = random.nextInt(rowNumber);  // random sayılar uretmek için bu ve altı
        randColumn=random.nextInt(colNumber);
        if ((map[randomRow][randColumn]) != -1){  // ürettiğim random sayıların aynı yere gelme ihtimalini sorgulamak için
            map[randomRow][randColumn] = -1;
            count++;

        }
    }


    }

    public void print (int [][] arr) {        //dışarıdan arr alsın. bu methoda hangi metodu verirsem ekrana bassın
                                                //burası multidimensional arrayı ekrana bastırmak için
        for (int i=0; i<arr.length; i++){
            for (int j=0; j<arr[0].length; j++){
                if (arr[i][j] >=0) {
                    System.out.print(" ");
                }
                System.out.print(arr[i][j] + " ");
            }
            System.out.println();
        }

    }


}
