
import  java.util.Scanner;
//KODUN TEMİZ HALİ README dosyasında
// READ readme file just for code
public class Main {
    public static void main(String[] args) {
        int i,k,j,n;

        Scanner input = new Scanner(System.in);
        System.out.print("Enter a number that shows how many rows will be stars : ");
        n = input.nextInt();

        //with foor loop
        // first we will make rows that are indicated with n
        for (i=1; i<=n; i++){ //loop a

            //loop b runs in loop a, to make empty fields
            //ilk yıldıza gelen kadar kaç boşluk basmalıyım (n-i adet) ilk döngü ilk çalıştıgında i 1 iken n-1=5 boşluk basacak
            for (k=1; k<=n-i; k++) { // loop b
                System.out.print(" ");
            }
            // loop c runs in loop a, after loop b, to make stars
            for (j=1; j<= (2*i)-1 ; j++ ) { // loop c
                //in first run, it shows how many stars will be placed. to first run: it will be one star.
                //ilk çalıştıgında n tepeye n-1 boşluktan sonra 1 yıldız koymamız gerekiyor.
                // bunu yapmak için de formülasyon olarak 2*i-1 (yani i nin ilk dönüş değeri 1 hesaplanıyor.
                //sonraki adımda i=2 olunca 2*i-1 formülünden 3 sonucu cıkacak. yani 2. satırda 3 yıldız basacak.
                System.out.print("*");

            }
            System.out.println(); // to move bottom row
        }





    }
}