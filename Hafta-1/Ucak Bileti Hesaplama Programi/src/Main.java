import java.sql.SQLOutput;
import java.util.Scanner;
//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {

        // ihtiyaç duyulan değişkenleri tanımlıyoruz.
        int distance, age, flightType;
        double distancePayment = 0.10;
        double rateofAgeDiscountunder12 = 0.50;
        double rateofAgeDiscountbetween12and24 = 0.10;
        double rateofAgeDiscountbeton65 = 0.30;
        double rateofRoundTripDiscount = 0.20;
        double  rateofAgeDiscountbetween24and65 = 0.0001;
        double rateofAgeDiscount = 1;
        double totalAmount, roundTripDiscount, discountedAmount, agediscount, normalAmount;
        //scanner nesnesi tanımlayak dışaraıdan veri alıyoruz.
        //dunyanın cevresi 12757km
        //min gidilebilecek mesafeyi 30 km alıyoruz.

        Scanner input = new Scanner(System.in);
        System.out.print("Mesafeyi KM türünden giriniz (min 30 - max 12756) : ");
        distance = input.nextInt();
        if (!(distance >=30 && distance < 12757 ))
        {
            System.out.println("Hatalı mesafe değeri girdiniz, tekrar deneyin");
            System.exit(2);
        }
        System.out.print("Yaşınızı giriniz : ");
        age = input.nextInt();
         if (!(age > 0 && age < 151 ))
        {
            System.out.println("Hatalı yaş değeri girdiniz, tekrar deneyin");
            System.exit(2);
        }

        System.out.print("Yolculuk tipini giriniz (1 => Tek Yön , 2 => Gidiş Dönüş ) : ");
        flightType = input.nextInt();

        if (!(flightType >= 1 && flightType <=2 ))
        {
            System.out.println("Hatalı yaş değeri girdiniz, tekrar deneyin");
            System.exit(2);
        }


        normalAmount = distance  * distancePayment; // normal tutar = Mesage * Mesafe başı ücret
        if (age<12){
            rateofAgeDiscount = rateofAgeDiscountunder12;
        }else if (age <= 24) {
            rateofAgeDiscount = rateofAgeDiscountbetween12and24;
        } else if (age>65) {
            rateofAgeDiscount = rateofAgeDiscountbeton65;
        }else if (age>24 && age <=65) {
            rateofAgeDiscount = 0;
        }
        if (flightType == 1)
        {
            rateofRoundTripDiscount = 0;
        }
        agediscount = normalAmount * rateofAgeDiscount; // Yaş indirimi = Normal Tutar * Yaş İndirim Oranı
        discountedAmount = normalAmount - agediscount; // İndirimli Tutar = Normal Tutar - Yaş İndirimi
        roundTripDiscount = discountedAmount * rateofRoundTripDiscount; // Gidiş Dönüş Bilet İndirimi = İndirimli Tutar * rateofRoundTripDiscount
        totalAmount = ( discountedAmount - roundTripDiscount )* flightType ; //
        //İndirimli Tutar - Gidiş Dönüş bile indirimi) * flightType



       System.out.println("Normal Tutar : " + normalAmount);
        System.out.println("Yaş İndirimi : " + agediscount);
        System.out.println("İndirimli Tutar : " + discountedAmount);
        System.out.println("Gidiş Dönüş Bilet İndirimi : " + roundTripDiscount);
        System.out.println("Toplam Tutar : " + totalAmount);




    }
}