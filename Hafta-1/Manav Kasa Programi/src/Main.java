
/*kullanıcıların manavdan almış oldukları ürünlerin kilogram değerlerine göre toplam tutarını ekrana yazdıran program
Armut : 2,14 TL
Elma : 3,67 TL
Domates : 1,11 TL
Muz: 0,95 TL
Patlıcan : 5,00 TL
 */

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Scanner scan = new Scanner(System.in);

        double pear = 2.14, pearKg,
                apple = 3.67, appleKg,
                tomato = 1.11, tomatoKg,
                banana = 0.95, bananaKg,
                eggplant = 5, eggplantKg,
                total;


        System.out.print("Armut kilo: ");
        pearKg = scan.nextDouble() * pear;  //kullanıcıdan aldığım değeri tek kod satırında ürün fiyatıyla çarptım

        System.out.print("Elma kilo: ");
        appleKg = scan.nextDouble() * apple;

        System.out.print("Domates kilo: ");
        tomatoKg = scan.nextDouble() * tomato;

        System.out.print("Muz kilo: ");
        bananaKg = scan.nextDouble() * banana;

        System.out.print("Patlıcan kilo: ");
        eggplantKg = scan.nextDouble() * eggplant;

        total= pearKg+appleKg+tomatoKg+bananaKg+eggplantKg;

        System.out.println("Toplam tutar: "+total+" TL");


    }

}