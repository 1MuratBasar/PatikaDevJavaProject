import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        //ebob olma ihtimali max en kucuk sayıya kadar
        int n1;
        int n2;
        int i = 1;
        int ebob=0;
        int ekok=0;

        Scanner input = new Scanner(System.in);

        System.out.print("n1 Sayısını Giriniz : ");
        n1 = input.nextInt();
        System.out.print("n2 Sayısını Giriniz : ");
        n2 = input.nextInt();

        // EBOB WITH WHILE LOOP

        if (n1 < n2)
        {
           while (i<=n1) {
                if (n1%i==0 && n2%i==0){
                    ebob = i;
                }
               i++;
            }
            System.out.println("EBOB : " + ebob);

        } else if (n1 > n2) {
            while (i<=n2) {
                if (n1%i==0 && n2%i==0){
                    ebob = i;

                }
                i++;
            }
                System.out.println("EBOB : " + ebob);

            }
         else {
            System.out.println("Sayılar Birbirine Eşit");
        }

        // EKOK WITH WHILE LOOP

        if (n1 < n2)
        {

            while ( i<=n1*n2){
                if (i%n1==0 && i%n2==0){

                    //    System.out.println(i);
                    ekok=i;
                    break;
                }
                i++;
            }
            System.out.println("EKOK : " + ekok);
        } else if (n1 > n2)
        {
            while ( i<=n1*n2){
                if (i%n1==0 && i%n2==0){

                    //    System.out.println(i);
                    ekok=i;
                    break;
                }
                i++;
            }
            System.out.println("EKOK : " + ekok);
        } else {
            System.out.println("Sayılar Birbirine Eşit");
        }





    }
}