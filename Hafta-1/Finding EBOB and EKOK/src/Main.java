import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        //ebob olma ihtimali max en kucuk sayıya kadar
        int n1;
        int n2;

        int ebob=0;
        int ekok=0;

        Scanner input = new Scanner(System.in);

        System.out.print("n1 Sayısını Giriniz : ");
        n1 = input.nextInt();
        System.out.print("n2 Sayısını Giriniz : ");
        n2 = input.nextInt();

        //EBOB BULMA
        //sayıların kendi arasında büyük/küçük olduğunu sorguluyoruz
        //döngüyle ilk küçük sayıya kadar dönüyoruz (max kucuk sayı ebob olabilecegi için)
        //2 sayınından bölümden kalanın sıfır oldugu en sonra rakamı alıyoruz.
        if (n1 < n2)
        {
            for (int i=1; i<=n1 ; i++){
                if (n1%i==0 && n2%i==0){
                    ebob = i;
                }
            }
            System.out.println("EBOB : " + ebob);

        } else if (n1 > n2) {
            for (int i=1; i<=n2 ; i++){
                if (n1%i==0 && n2%i==0){
                    System.out.println(i);

                }
                System.out.println("EBOB : " + ebob);

            }
        } else {
            System.out.println("Sayılar Birbirine Eşit");
        }

      // EKOK BULMA
        //sayıları kendi arasında büyüklük/küçüklük olarak kıyaslıyoruz
        //döngüyle sayının max ekoku ikisinin çarpımı olabileceği için oraya kadar döndürüyoruz.
        //döngüde ki i nin sıfıra tam olarak n1 ve n2 sayısına bölünebildiği sayıyı ekok olarak alıyoruz.

        if (n1 < n2)
        {
            for (int i=1; i<=(n1*n2) ; i++){
                if (i%n1==0 && i%n2==0){
                    ekok   = i;
                //    System.out.println(i);
                    ekok=i;
                    break;
                }
            }
            System.out.println("EKOK : " + ekok);
        } else if (n1 > n2) {
            for (int i=1; i<=(n1*n2) ; i++){
                if (i%n1==0 && i%n2==0){
                 //   System.out.println(i);
                    ekok=i;
                  break;

                }
            }
            System.out.println("EKOK : " + ekok);
        } else {
            System.out.println("Sayılar Birbirine Eşit");
        }




        

    }
}