

import java.util.Scanner;
//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        // değişkenlerimizi tanımlıyoruz
        int km;
        double total, startPrice=10, perKm=2.20;
        // dışarıdan veri aldırmak için scanner nesnesi tanımlıyor ve atama yapıyoruz
        Scanner input = new Scanner(System.in);
        System.out.print("Gidilen yolu km olarak giriniz : ");
        km = input.nextInt();
        //gidilen yolu, açılış ücreti dahil edielerek toplamı hesaplıyoruz
        total = startPrice + (km * perKm);
        total = (total<20) ?  20 : total;
       System.out.println("toplam ödenecek tutar : " + total);
}
}
