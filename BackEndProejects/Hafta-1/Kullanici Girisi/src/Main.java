import java.util.Scanner;
public class Main {
    public static void main(String[] args) {

        String username, pass1, pass2, pass3, pass4, choise; // yeni kayıtlar
        String user = "Patika"; //veritabanında kayıtlı
        String pass = "Dev123"; // veritabanında kayıtlı
        boolean isLOgin= true;
        Scanner input = new Scanner(System.in);
        System.out.print("Kullanıcı Adı Giriniz : ");
        username = input.nextLine();

        System.out.print("Şifre Giriniz : ");
        pass1 = input.nextLine();


        // dışarıdan verileri aldık şimdi sıra sorgulama

        if (!(username.equals(user)) && (pass1.equals(pass))) {
            System.out.println("Kullanıcı Adı veya Şifre Yanlış.");

        } if ((username.equals(user)) && (pass1.equals(pass))) {
            System.out.println("Giriş yaptınız, yönlendiriliyorsunuz.");
          // System.exit(2); // şifre dogruysa aşağıdaki bloğu çalıştırmaya gerek duymuyoruz.
            isLOgin = false;
        }
        if (isLOgin == true) {

            System.out.println("Şifrenizi sıfırlamak ister misiniz?");
            System.out.println("Y/N");
            choise = input.nextLine();
            // Kullanıcıdan Y veya N değeri ile seçeneğe bağlı şifre ürettiyor , bunu sorguluyor ya da çıkıyoruz.
            switch (choise) {

                case "Y":

                    System.out.println("Yeni şifrenizi giriniz");
                    pass2 = input.nextLine();
                    System.out.println("Yeni şifreniz " + pass2);

                    if (pass2.equals(pass)) {
                        System.out.println("Şifreniz geçmiş şifreleriniz ile aynı olmamalıdır!");
                        System.out.println(" Tekrar deneyiniz");
                        pass3 = input.nextLine();
                        if (pass3.equals(pass)) {
                            System.out.println("Şifreniz geçmiş şifreleriniz ile aynı olmamalıdır!");
                            System.out.println(" Tekrar deneyiniz");
                            pass4 = input.nextLine();
                            if (pass4.equals(pass)) {
                                System.out.println("Şifreniz geçmiş şifreleriniz ile aynı olmamalıdır!");
                                System.out.println(" Çıkışa yönlendiriliyorsunuz");
                            } else {
                                System.out.println("Şifre Yanlış.");
                            }
                        }
                    }
                    break;

                case "N":
                    System.out.println("Çıkış yaptınız.");
                    break;

                default:
                    System.out.println("Y ya da N değeri giriniz");
                    break;
            }
        }

    }

}



