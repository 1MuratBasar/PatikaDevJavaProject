import java.util.Scanner;
//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        //ihtiyac duyulan değişkenleri tanımlıyoruz
        double pear=2.14, apple= 3.67, tomato=1.11, banana=0.95, eggplant=5.00, total, kg1, kg2,kg3,kg4,kg5;

        //dışarıdan veri almak için scanner nesnesi türetip ilgili değişkene atıyoruz
        Scanner input = new Scanner(System.in);
        System.out.print("Armut Kaç Kilo ? : ");
        kg1 = input.nextDouble();
        System.out.print("Elma Kaç Kilo ? : ");
        kg2 = input.nextDouble();
        System.out.print("Domates Kaç Kilo ? : ");
        kg3 = input.nextDouble();
        System.out.print("Muz Kaç Kilo ? : ");
        kg4 = input.nextDouble();
        System.out.print("Patlıcan Kaç Kilo ? : ");
        kg5 = input.nextDouble();

        // dışarıdan veri alma bitti. toplam tutarı hesaplıyoruz
        total = (kg1*pear) + (kg2*apple) + (kg3*tomato) + (kg4*banana) + (kg5*eggplant);
        System.out.println("Toplam Tutar : " + total);
    }
}