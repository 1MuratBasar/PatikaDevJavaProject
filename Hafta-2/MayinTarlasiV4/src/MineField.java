import java.util.Objects;
import java.util.Random;
import  java.util.Scanner;
import  java.lang.String;
public class MineField {
    int row;
    int col;
    int rowNumber;
    int colNumber;
    int lengthOfArray;
    String [][] map;
    String [][] userInterface;
    boolean isGame = true;

    Scanner input = new Scanner(System.in);
    Random random = new Random();



    MineField(int colNumber, int rowNumber) {

        this.colNumber = colNumber;
        this.rowNumber = rowNumber;
        this.map = new String[rowNumber][colNumber];
        this.userInterface = new String[rowNumber][colNumber];
        this.lengthOfArray = rowNumber * colNumber;
        this.row = rowNumber;
        this.col= colNumber;
    }


    public void run1 () {

        int r1 , c1, control=0;

        placingMines ();
        print (map);
        System.out.println("Mayın Tarlası Oyuna Hoşgeldiniz !");  // 3-
       while (isGame) {
           print(userInterface);

           System.out.print("Satır giriniz : ");
           r1 = input.nextInt();
           System.out.print("Sütun giriniz : ");
           c1 = input.nextInt();
           System.out.println("===========================");


           if ((r1 > rowNumber - 1 || c1 > colNumber - 1) || (r1 < 0 || c1 < 0)) {
               System.out.println("Belirtilen matris değerler içinde değer girmelisiniz");
           } else {

              if ((!Objects.equals(map[r1][c1], "*")) && (!Objects.equals(map[r1][c1], "-"))) {
                   if (!(Objects.equals(map[r1][c1], userInterface[r1][c1]))){

                   control--;
                   System.out.println("Daha önce aynı değeri girdiniz. tekrar deneyin");

               }}


               if (!Objects.equals(map[r1][c1], "*")) {
                   checkMines(r1, c1);
                   control++;




                       if (control == (lengthOfArray - (lengthOfArray / 4))) {

                           System.out.println("Oyunu Kazandınız !");
                           print(userInterface);
                           break;
                       }
                } else {

                   isGame = false;
                   System.out.println("Game over !");
               }
           }

       }
    }




    public void placingMines () {                    //mayınları rastgele yerleştirmek için
        int randomRow, randColumn;                      //rasgele oluşturacagım randrow ve randcol sayıları
        int count = 0;
        while (count !=lengthOfArray/4) {

            randomRow = random.nextInt(rowNumber);  // random sayılar uretmek için bu ve altı
            randColumn=random.nextInt(colNumber);
            if (!Objects.equals(map[randomRow][randColumn], "*")){  // ürettiğim random sayıların aynı yere gelme ihtimalini sorgulamak için
                map[randomRow][randColumn] = "*";
                count++;

            }
        }

    }

    public void checkMines (int r, int c){
        int counter=0;
        if (map[r][c] == null){
            if ((c<colNumber-1) && (Objects.equals(map[r][c + 1], "*"))){
                counter ++;
                userInterface[r][c] = Integer.toString(counter);
            }
            if ((r < rowNumber-1) &&(Objects.equals(map[r + 1][c], "*"))){
                counter ++;
                userInterface[r][c] = Integer.toString(counter);
            }
            if ((r>0) && (Objects.equals(map[r - 1][c], "*"))){
                counter ++;
                userInterface[r][c] = Integer.toString(counter);
            }
            if ((c>0) && (Objects.equals(map[r][c - 1], "*"))){
                counter ++;
                userInterface[r][c] = Integer.toString(counter);
            }
            //burdan başla
            if ((c>0) && (r>0) && (Objects.equals(map[r-1][c - 1], "*"))){
                counter ++;
                userInterface[r][c] = Integer.toString(counter);
            }
            if ((c>0) && (r<rowNumber-1) && (Objects.equals(map[r+1][c - 1], "*"))){
                counter ++;
                userInterface[r][c] = Integer.toString(counter);
            }//sag ust capraz
            if ((r>0) && (c<colNumber-1) && (Objects.equals(map[r-1][c + 1], "*"))){
                counter ++;
                userInterface[r][c] = Integer.toString(counter);
            }//sag alt capraz
            if ((r<rowNumber-1) && (c<colNumber-1) && (Objects.equals(map[r+1][c + 1], "*"))){
                counter ++;
                userInterface[r][c] = Integer.toString(counter);
            }

            if (userInterface[r][c] == null){
                counter = 0;
                userInterface[r][c] = Integer.toString(counter);
            }



                }
            }




    public void print(String[][] arr) {
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr[0].length; j++) {
                if (arr[i][j] == null) {
                    System.out.print("- ");
                } else {
                    System.out.print(arr[i][j] + " ");
                }
            }
            System.out.println();
        }
    }






}
