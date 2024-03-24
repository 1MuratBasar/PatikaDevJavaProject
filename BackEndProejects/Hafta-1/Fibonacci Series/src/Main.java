import  java.util.Scanner;


public class Main {
    public static void main(String[] args) {

        int rowNum;
        int total=0;
        int a=0, b=1;

        Scanner input = new Scanner(System.in);
        System.out.println("Fibonacci Serisinin Kaçıncı Basamağı Olsun, Giriniz : ");
        rowNum = input.nextInt();

        for (int n=1 ; n<= rowNum; n++){

            //her dongu girilen basamak değeri kadar çalıştıgında a ve byi toplayacak
            //ardında sırayla a ve b nin değerlerini totalden aldıgı değerle birlikte
            // yer değiştirecek. ilk çalışmada  a değişkenine b nin 1  değerinin atayacak
            //akabinde total 1 di. b ye totaldeki 1 değerini atayacak yapacak ve sonra döngü
            // tekrar başa dönerek tekrarlacak aynı işlemleri ve ekrana yazdıracak.
             total =  a + b;
            System.out.println(total);
                a = b;
                b = total;

        }

    }
}