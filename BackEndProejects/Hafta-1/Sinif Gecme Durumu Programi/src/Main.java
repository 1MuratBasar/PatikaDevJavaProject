import java.util.Scanner;
//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        //ihtiyacımız olan değişkenleri tanımlıyoruz.

        int math, physics, turkish, chemistry, music, ortsayisi= 5;
        int not1 = 0; // notun olmaması durumu için başlangıc degeri 0 setlendi
        int not2 = 0;
        int not3 = 0;
        int not4 = 0;
        int not5 = 0;
        double avg;

        // dışarıdan veri almak için scanner tanımlıyoruz.

        Scanner input = new Scanner(System.in);
        System.out.print("Matematik Notunu Giriniz : ");
         math = input.nextInt();

        System.out.print("Fizik Notunu Giriniz : ");
        physics = input.nextInt();
        System.out.print("Türkçe Notunu Giriniz : ");
        turkish = input.nextInt();
        System.out.print("Kimya Notunu Giriniz : ");
        chemistry = input.nextInt();
        System.out.print("Müzik Notunu Giriniz : ");
        music = input.nextInt();

        //ortalama alıyoruz. ancak girilen değerin 0 ve 100 arasında olması gerekiyor.
        /*not: farklı olarak eger girilen deger 0-100 aralıgından farklı ise o ders ortalama
        hesaplamaya da girmesin dedim*/

        if (math > 0 && math <=100){
             not1 = math;
        } else {
            ortsayisi = --ortsayisi;
        }
        if (physics > 0 && physics <=100){
             not2 = physics;
        }
        else {
            ortsayisi = --ortsayisi;
        }
        if (turkish > 0 && turkish <=100){
             not3 = turkish;
        }
        else {
            ortsayisi = --ortsayisi;
        }
        if (chemistry > 0 && chemistry <=100){
             not4 = chemistry;
        }
        else {
            ortsayisi = --ortsayisi;
        }
        if (music > 0 && music <=100){
             not5 = music;
        }
        // ekstradan notu girilmeyen ders hesaplamadan düşülsün istersek

        avg = (not1+not2+not3+not4+not5)/ortsayisi;

        // ortalamamızın geçme/kalma koşulunu ve hangi değerler arasında olması gerektiğini belirtiyoruz

        if (avg <= 55 && avg >= 0) {
            System.out.println("Sınıfta kaldınız, seneye tekrar görüşmek üzere");
        }if (avg >55 && avg <=100 ){
            System.out.println("Sınıfı geçtiniz, tebrikler");
        }
        System.out.println("Not ortalamanız "+ avg);



    }
}