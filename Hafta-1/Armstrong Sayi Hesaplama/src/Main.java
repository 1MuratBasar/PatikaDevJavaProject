import java.util.Scanner;
//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
Scanner input = new Scanner(System.in);
        System.out.println("Bir sayı giriniz");
        int number = input.nextInt();
        int basNumber;
        int tempNumber;
        int result = 0;
        int basPow;
        // ekrandan gelen sayı number da durmaya devam edecek. bu sayıyı tempNumber a atayıp işleme alıyorum
        // number değeri sonraki döngüde tekrar lazım olacak.
        tempNumber = number;
        basNumber = 0;
        int basValue ;
        while (tempNumber!=0){
            tempNumber /= 10;
            basNumber++;
        }
        // üstte tempNumber 0 a ulaştığı için alltaki döngüye giremyor.
        //bu nedenle en üstte hafıza duran giriş sayımızı temNumber a tekrar atayıp sayının
        //ilk halini tekrar döngüye sokuyorum.
        tempNumber = number;
        while (tempNumber!=0){
            basValue = tempNumber%10;
            basPow=1;
            for (int i=1; i<=basNumber; i++) {

                basPow *= basValue; //burada basValue değeri yani moddan kalan üs kadar kendiyle carpıldı
            }
            result += basPow;
             tempNumber /= 10;
        }

        System.out.println(result);
    }
}