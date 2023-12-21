import java.util.Scanner;

// methodlar kulalnarak hesap makinesi yapma
public class Main {

static int sum (int a, int b){
    int result=0;

    result = a+b;
    System.out.println("Sonuc : " + result);
    return result;
}
    static int minus (int a, int b){
        int result=0;

        result = a-b;
        System.out.println("Sonuc : " + result);
        return result;
    }
    static int multiply (int a, int b){
        int result=0;

        result = a*b;
        System.out.println("Sonuc : " + result);
        return result;
    }

    static int divide (int a, int b){

    if (b==0){
        System.out.println("B değeri 0 olmamalıdır.");
        return 0;
    }
        int result=0;

        result = a/b;

        System.out.println("Sonuc : " + result);
        return result;
    }

    static int power (int a, int b){
        int result=1, i;
        for (i=1; i<=b; i++){
            result = result*a;
        }

        System.out.println("Sonuc : " + result);
        return result;
    }

    static int moding (int a, int b){
        int result=0;

        result = a%b;
        System.out.println("Sonuc : " + result);
        return result;
    }

    static int rectangle (int a, int b){
        int result=0;
        int result1=0;

        result= 2 * (a+b);
        System.out.println("Sonuc : " + result);

        result= a*b;
        System.out.println("Sonuc : " + result);

        return result;
    }


    public static void main(String[] args) {
        int a,b;

        Scanner input = new Scanner(System.in);
        int select;

        String Menu = "1- Toplama İşlemi\n" +
                      "2- Çıkarma İşlemi\n" +
                      "3- Çarpma İşlemi\n" +
                      "4- Bölme İşlemi\n" +
                      "5- Üs Sayi Hesaplama\n" +
                      "6- Mod Alm\n" +
                      "7- Diktörgen Çevre ve Alan Hesanı\n" +
                      "8- Çıkış";

                while (true){
                    System.out.println(Menu);
                    System.out.print("Bir işlem Seçiniz : ");
                    select = input.nextInt();

                    if (select ==0){
                        break;
                    }
                    System.out.print("İlk sayıyı giriniz : ");
                    a = input.nextInt();
                    System.out.print("İlk sayıyı giriniz : ");
                    b = input.nextInt();

                    switch (select) {

                        case 1:

                           sum(a,b);
                           break;

                        case 2:

                            minus(a,b);
                            break;


                        case 3:

                            multiply(a,b);
                            break;

                        case 4:

                            divide(a,b);
                            break;
                        case 5:

                            power(a,b);
                            break;
                        case 6:

                            moding(a,b);
                            break;

                        case 7:

                            rectangle(a,b);
                            break;

                    }

                   break;
                }

    }
}