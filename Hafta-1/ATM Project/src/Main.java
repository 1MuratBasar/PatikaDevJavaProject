
import java.util.Scanner;

// NOT: Açıklama için Readme Dosyasını Okuyunuz.
//NOT : To explain what happes below, please read the readme file.

public class Main {
    public static void main(String[] args) {
        int right=3;
        String userName, password;
        String user= "Patika";
        String pass= "Java123";
        int balance=5000;
        int amount;
        int select;
        Scanner input = new Scanner(System.in);

        while (right > 0) {
            System.out.print("Kullanıcı adınız : ");
            userName = input.nextLine();
            System.out.print("Şifre Giriniz : ");
            password = input.nextLine();
            //kulllanıcı adı ve şifre dogrulama yapıyoruz.

            if ((userName.equals(user)) && (password.equals(pass))) {
                System.out.println("Şifreniz Doğru, X Bankasına Hoşgeldiniz.");
                do {

                    System.out.println(

                            "1- Para Yatırma\n" +
                                    "2- Para Çekme\n" +
                                    "3- Bakiye Görüntüleme\n" +
                                    "4- Çıkış");
                    System.out.println("Lütfen Yapmak İstediğiniz İşlemi Seçiniz : ");
                    select = input.nextInt();
                    switch (select) {
                        case 1:
                            System.out.println("Yatırılacak Para Miktarını Giriniz");
                            amount = input.nextInt();
                            balance += amount;
                            System.out.println("Bakiyeniz " + balance);
                            break;
                        case 2:
                            System.out.println("Çekilecek Para Miktarını Giriniz");
                            amount = input.nextInt();
                            if (amount > balance) {
                                System.out.println("Bakiye Yetersiz");
                            } else {
                                balance -= amount;
                                System.out.println("Bakiyeniz " + balance);
                            }
                            break;

                        case 3:
                            System.out.println("Bakiyeniz " + balance);
                            break;
                        case 4:
                            System.out.println("Çıkış yaptınız");
                            break;
                        default:
                            System.out.println("Lütfen Yapmak istediğiniz işlemi seçin");
                    }
                } while (select!=4);
                break;
            } else {
                right--;
                System.out.println("hatalı kullanıcı adı veya şifre girdiniz, tekrar deneyiniz.");
                if (right == 0) {
                    System.out.println("Hesabınız bloke olmuştur, lütfen banka ile iletişime geçiniz");
                } else {
                    System.out.println("Kalan Hakkınız " + right);
                }
            }
        }
    }
}