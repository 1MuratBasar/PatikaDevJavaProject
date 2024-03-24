import java.util.Scanner;
//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        //ihtiyaç duyulan değişkenleri tanımlıyoruz
        double radius, angle, circleField, pi=3.14;
        //scanner nesnesi ile dışarıdan veri alıp değikene atıyoruz.
        Scanner input = new Scanner(System.in);
        System.out.print("Yarıcap giriniz : ");
        radius = input.nextDouble();
        System.out.print("Açı giriniz : ");
        angle = input.nextDouble();
        // alanı hesaplıyoruz
        circleField = ((pi*(radius*radius)*angle)/360);
        System.out.println("Dairenin alanı : " + circleField);

    }
}