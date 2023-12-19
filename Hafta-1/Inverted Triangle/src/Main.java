import java.util.Scanner;
//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {

        int rowNumber;
        int i, j, k;

        Scanner input = new Scanner(System.in);
        System.out.print("Basamak Sayısı Giriniz : ");
        rowNumber = input.nextInt();

        //döngümüzü her basamakta hesap yapabilmesi için azalan şekilde çalıştırıd.
        //ilk döngü çalıştıgında 2 ve 3. dongu ilk dongunun eleman sayısını baz alarak boşluk ve yıldız basıyor

        for (i=rowNumber ;  i>=1 ; i--){

            for (j=1; j<=rowNumber-i ; j++) {
                System.out.print(" ");
            }
            for (k=1; k<=((2*i)-1) ; k++) {
                System.out.print("*");
            }

            System.out.println();
        }



    }
}