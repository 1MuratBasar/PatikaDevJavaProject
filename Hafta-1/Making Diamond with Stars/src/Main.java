import java.util.Scanner;

public class Main
{ public static void main(String[] args) {

    // MAKING TRIGANGLE WITH STARS
    //YILDIZLAR İLE ÜÇGEN YAPIMI

    int i,k,j,n;

    Scanner input = new Scanner(System.in);
    System.out.print("Enter a number that shows how many rows will be stars : ");
    n = input.nextInt();
    for (i=1; i<=n; i++){ //loop a
        for (k=1; k<=n-i; k++) { // loop b
            System.out.print(" ");
        }
        for (j=1; j<= (2*i)-1 ; j++ ) { // loop c
            System.out.print("*");
        }
        System.out.println(); // to move bottom row
    } // üst kısım ok altı açıklayalım
    // son yıldız serisinden sonra aşağıya n-1 kadar inmeli
    //yani n değeri 6 girdiysem azalan yıldızlara geçtiğiginde artık 5 defa dönerek bitmeli
    // o nedenle ilk dongunun başlangıc degerinin n-1 aldık ki 5 defa donsun
    //ve hesaplamalara i yerine artık hep 5 ve azalan değerleri girecek

    for (i=n-1; i>=1; i--){ //loop a


        //örnegin ilk dönüşte k<=n-i ifadesinde i hep azaldığı için boşuklar az çoğa artıcak
        for (k=1; k<=n-i; k++) { // loop b
            System.out.print(" ");
        }

        //i değeri çoktan aza azaldıgı için yıldız sayısı da paralelde azalacak
        for (j=1; j<= (2*i)-1 ; j++ ) { // loop c
            System.out.print("*");
        }


        System.out.println(); // to move bottom row
    }



}
}