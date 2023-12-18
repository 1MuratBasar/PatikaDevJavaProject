import java.util.Scanner;
//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        //ihtiyac duyulan değişkenleri tanımladık.
        int n; // n kumesi
        int r; // r kumesi
        int i; // n kumesinin dongusune çalışıyor
        int j; // r kumesinin dongusune çalışıyor
        int x; // n-r dongusu için çalışıyor
        int nSayac =1; // N kumesi faktoriyel hesabı için
        int rSayac =1; // R kumesi faktoriyel hesabı için
        int rfarkSayac =1; // N-R  faktoriyel hesabı için
        int kombinasyon;
        Scanner input = new Scanner(System.in);
        System.out.print("N kümesi eleman sayısını giriniz : ");
        n = input.nextInt();
        // ekrana girilen değerlerin sıfır ve daha az değer olma durumunu sorduk
        if (n<=0){
            System.out.print("N 0 veya daha az bir değer olamaz");
            System.exit(2);
        }
        System.out.print("R eleman sayısını giriniz : ");
        r = input.nextInt();
        // N kumesini, R kümesini ve N-R faktoriyeli için ayrı ayrı hesaplamalar yaptırdık
        for (i=1 ; i<=n ; i++ ){
            nSayac *= i;
        }
        for (j=1 ; j<=r ; j++ ){
            rSayac *= j;
        }
        for (x= (n-r) ; x<=(n-r); x++ ){
            rfarkSayac *= x;
        }
        // kombinasyon formulümüzü yazdık
        kombinasyon = nSayac/(rSayac*rfarkSayac);
        System.out.println("N nin R kombinasyonu : " + kombinasyon);

    }
}