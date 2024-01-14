import  java.util.Scanner;
import  java.util.Random;

public class Main {


    public static void main(String[] args) {
    double r = 0;
double random;

        Scanner input = new Scanner(System.in);
        System.out.println("alanı hesaplanıcak daire yarı çapını girin");
      //  r = input.nextDouble();


       Daire d = new Daire((int) input.nextDouble());
        System.out.println(d.calArea2());
        System.out.println(Daire.PI);
    }
}