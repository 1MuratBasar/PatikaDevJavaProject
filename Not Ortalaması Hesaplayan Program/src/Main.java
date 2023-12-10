import java.util.Scanner;

public class Main
{

    public static void main(String[] args) {

        int matematik, fizik, kimya, turkce, tarih, muzik;
        Scanner sca = new Scanner(System.in);

        System.out.print("Matematik notunu giriniz : ");
        matematik = sca.nextInt();

        System.out.print("Fizik notunu giriniz : ");
        fizik = sca.nextInt();

        System.out.print("Kimya notunu giriniz : ");
        kimya = sca.nextInt();

        System.out.print("Türkçe notunu giriniz : ");
        turkce = sca.nextInt();

        System.out.print("Tarih notunu giriniz : ");
        tarih = sca.nextInt();

        System.out.print("Müzik notunu giriniiz : ");
        muzik = sca.nextInt();
        int toplam = (matematik + fizik + kimya + turkce + tarih + muzik);
        double ortalama = (toplam / 6.0) ;
        System.out.println("Ortalamanız : " + ortalama); // Bir string in yanına '+' koyarsak +'dan sonrası
        // farklı bir değer de olsa sonuç string döner.

        boolean kosul1 = ortalama >= 60;
        boolean kosul2 = ortalama < 60;
          boolean sonuc = kosul1 || kosul2;
      String str = sonuc ? "Sınıfı Geçti" : "Sınıfta Kaldı";
        System.out.println(str);


    }
}