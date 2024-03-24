import java.util.Scanner;
public class HesapMakinesiProgrami {
    public static void main(String[] args) {
        //ihtiyaç duyacagımız değişkenleri tanımlıyoruz.
        float  a, b, result;
        char operator;

        /*dışarıdan veri almak için scanner tanımlayıp kullanıcıdan deger
        istiyoruz ve bunu değişkenlere atıyoruz.*/
        Scanner input = new Scanner(System.in);

        System.out.print("İlk sayıyı giriniz : ");
        //girilen değerimiz sadece sayı olmasını istiyorum, diğer karakterler olmasın
        a = input.nextFloat();

        System.out.print("İkinci sayıyı giriniz : ");
        b = input.nextFloat();

            System.out.println("Yapmak istediğiniz işlemi seçiniz. Seçenekler");
            System.out.println("Toplama için + işaretine basın : \nÇıkarma için - işaretine basın : \nÇarpma için  * işaretine basın : \nBölme için   / iaretine basın : ");
            operator = input.next().charAt(0); // klavyeden sembol ile işlem yapılmasınız istyoruz

            // switchcase yapımızla koşullarımızı belirtiyoruz.

            switch (operator) {

                case '+':
                    result = (a + b);
                    System.out.println("Sonuc : " + (result));
                    break;
                case '-':
                    result = (a - b);
                    System.out.println("Sonuc : " + (result));
                    break;
                case '*':
                    result = (a * b);
                    System.out.println("Sonuc : " + (result));
                    break;
                case '/':
                    if (b != 0) {
                        result = (a / b);
                        System.out.println("Sonuc : " + (result));
                        break;
                    } else {
                        System.out.println("Sayı 0 a bölünemez");
                    }
                    break;
                default:
                    System.out.println("Yanlış deger girdiniz");
                    break;

            }

        }
    }
