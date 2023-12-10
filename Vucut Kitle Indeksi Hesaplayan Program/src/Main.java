import java.util.Scanner;
//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        //ihtiyac duyulan değişkenleri tanımlıyoruz
        double kg, m, vkIndex;
        //Dışarıdan veri almak için scanner nesnesi tanımlayarak girilen değişkene atıyoruz.
        Scanner input = new Scanner(System.in);
        System.out.print("Lütfen boyunuzu (metre cinsinde) giriniz : ");
        m = input.nextDouble();
        System.out.print("Lütfen kilonuzu giriniz : ");
        kg = input.nextDouble();
        // Formül ile vucut kitle endeksini hesaplıyoruz
        vkIndex = (kg)/(m*m);
        System.out.println("Vücut Kitle İndeksiniz : " + vkIndex);



    }
}