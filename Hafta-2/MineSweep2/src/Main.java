import  java.util.Scanner;
import java.lang.NullPointerException;

public class Main {
    public static void main(String[] args) {
        int row, column;
        Scanner scan = new Scanner(System.in);
        System.out.println("Mayın Tarlasına Hoşgeldiniz");
        System.out.println("Lütfen satır ve sütun sayısı giriniz : ");
        do {
            System.out.println("Uyarı! En az 2*2 olmalı.");
            System.out.print("Satır : ");
            row = scan.nextInt();
            System.out.print("Sütun : ");
            column = scan.nextInt();
        } while  (row <2 || column <2);

        MineField MayinTarlasi = new MineField(row,column);
        MayinTarlasi.runGame();
    }
}