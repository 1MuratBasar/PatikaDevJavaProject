import java.util.Scanner;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        int number; // giriş değerimiz
        int result=0; // toplam değerimiz için
        int basValue; // basamak adeti tutmak için
        int numberCounter=0; // sayaç


        Scanner input = new Scanner(System.in);

        System.out.print("Bir sayi giriniz : ");
        number = input.nextInt();
        int tempNumber;
        //ilk girş değerimizi bi yedekledik aşağıda lazım olacak 2. dongude tekrar
        tempNumber = number;
        // dongu 0 a eşit olursa duracak. moddan kalan değeri basvalue ya basıcak.
        //resultta bu değerleri toplayacak ve sonra sayıyı 10 a bolup tekrar yeni sayıyı donguye alacak
        while (tempNumber != 0) {
            basValue = tempNumber%10;
            result += basValue;
            tempNumber /= 10;
        }
        //yedeklediğimiz giriş degerini tekrar alıyoruz
        tempNumber = number;
        // sayıyı 10 a böl ve bunu numberCounter la saydır. böylece kaç basamaklı onu öğreniyoruz.
        while (tempNumber != 0) {
            tempNumber /= 10;
            numberCounter++;
        }

        System.out.println(number + " Sayısını Basamak Sayısı " + numberCounter);
        System.out.println(number + " Sayısının Basamak Sayıları Toplamı : "  + result);
        }


    }
