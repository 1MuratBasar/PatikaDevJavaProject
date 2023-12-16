import java.util.Scanner;
//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {

        int  heat, heat3;
        String choise;

        Scanner input = new Scanner(System.in);
        System.out.print("-20 ve 40 Derece arasında Hava sıcaklığı giriniz : ");
        heat = input.nextInt();

        if (!(heat >= -20 && heat <=40)) {
            System.out.println("Belirtilen değerler arasında giriş yapınız.");
            System.out.println("Tekrar giriş yapmak ister misiniz? ");
            System.out.println("Y/N");
            choise = input.nextLine();
            choise = input.nextLine();


            if (choise.equals("N")) {
                System.out.println("Çıkışa gittiniz");
                System.exit(2);
            }
            if (choise.equals("Y")) {
                System.out.print("-20 ve 40 Derece arasında Hava sıcaklığı giriniz : ");
                heat3 = input.nextInt();
                if (!(heat3 >= -20 && heat3 <= 40)) {
                    System.out.println("Çıkışa yönlendiriliyorsunuz");
                    System.exit(2);
                }else{
                        heat = heat3;

                    if (heat < 5){
                        System.out.println("Kayak yamaya gidebilirsiniz");
                    } else if (heat >5 && heat <=25) { // <5 dışında kalan durumu (yani 5 ve üstünü) sorguluyoruz
                        if (heat <=15) {
                            System.out.println("Sinemaya gidebilirsiniz");
                        }if (heat >=10) {
                            System.out.println("Pikniğe gidebilirsiniz");

                        }

                    }
                    else {
                        System.out.println("Yüzmeye gidebilirsiniz");
                    }
                    }
            } else {
                System.out.println("Y veya N değeri girmediniz çıkışa yönlendiriliyorusunuz");
                System.exit(2);

            }


        }  else {
        if (heat < 5){
            System.out.println("Kayak yamaya gidebilirsiniz");
            } else if (heat >5 && heat <=25) { // <5 dışında kalan durumu (yani 5 ve üstünü) sorguluyoruz
                if (heat <=15) {
                    System.out.println("Sinemaya gidebilirsiniz");
                }if (heat >=10) {
                System.out.println("Pikniğe gidebilirsiniz");

        }

        }
        else {
            System.out.println("Yüzmeye gidebilirsiniz");
        }



        }
    }
}