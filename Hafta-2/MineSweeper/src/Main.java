import javax.sound.midi.Soundbank;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Scanner scan = new Scanner(System.in);
        int row=0, column=0;
        int exit=0;
        System.out.println("Mayın Tarlasına Hoşgeldiniz...");

        while (row < 2 || column < 2) {
            System.out.println("Lütfen oynamak istediğiniz satır ve sütun boyutlarını giriniz...");
            System.out.print("Satır sayısı : ");
            row = scan.nextInt();
            System.out.print("Sütun sayısı giriniz : ");
            column = scan.nextInt();
            if (row < 2 || column < 2)
            {
                System.out.println("Boyutlar 2*2 den az olamaz. ");
                System.out.println ("Çıkış yapmak isterseniz 0 a basın.");
                System.out.println ("Devam etmek için 0 dan farklı bir rakama basın");
                exit = scan.nextInt();
                if (exit == 0) {
                    System.exit(2);
                }
            }

        }
        MineField MineSpeewer = new MineField(row,column);
        MineSpeewer.run();

    }
}



