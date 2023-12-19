
import java.util.Scanner;


//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {

        // FINDING PRIME NUMBERS

        int i, j;
        int count;

        for (i=1 ; i<=100; i++ ) {
            count    = 0; //her yeni değer için sayacı sıfırlıyoruz.
            for (j = 2; j <= i/2; j++) { // i sayısının yarısına kadar döndürücek cunku yarıdan fazlası bolunmez

                if (i%j==0){ // i mod j 0 ise sayacı arttır.
                    count ++; //sayacı arttırma nedenimiz i nin j değerine bölünebildiğini saptamak
                }
            }
            if (count==0 && i!=1){ //eger sayacı hiç arttırmayan bir değer varsa sorgulanacak
                System.out.print(i + " ");
            }
    }
    }
}