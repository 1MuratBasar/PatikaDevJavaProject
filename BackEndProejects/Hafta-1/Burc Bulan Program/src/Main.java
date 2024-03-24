import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        // ihitacımız olan değikenleri tanımlıyoruz.
        int day, month;
        boolean isError = false;
        String horoscope = "";

        //dışarıdan veri almak için scanner nesnemizi tanımlıyoruz ve alınan değerleri değişkene atama yapıyoruz
        Scanner input = new Scanner(System.in);
        System.out.print("Sayı olarak ay giriniz : ");
        month = input.nextInt();
        System.out.print("Sayı olarak gün giriniz  : ");
        day = input.nextInt();
        //Ocak ayı için koşul soruyoruz.

        if (month == 1) {

            if (day >=1 && day <=31) {


                if (day < 22) {

                    horoscope = "Oğlak";
                } else {
                    horoscope = "Kova";
                }
            } else {
                System.out.println("Hatalı gün girdiniz");
                System.exit(2);
                }
            // Şubat için sorguluyoruz
        }  else if (month == 2) {

            if (day >= 1 && day <= 28) {


                if (day < 20) {

                    horoscope = "Kova";
                } else {
                    horoscope = "Balık";
                }
            } else {
                System.out.println("Hatalı gün girdiniz");
                System.exit(2);
            }
        }
        // Mart için sorguluyoruz
        else if (month == 3) {

            if (day >= 1 && day <= 31) {


                if (day < 21) {

                    horoscope = "Balık";
                } else {
                    horoscope = "Koç";
                }
            } else {
                System.out.println("Hatalı gün girdiniz");
                System.exit(2);
            }
        }
        // Nisan için sorguluyoruz
        else if (month == 4) {

            if (day >= 1 && day <= 30) {


                if (day < 21) {

                    horoscope = "Koç";
                } else {
                    horoscope = "Boğa";
                }
            } else {
                System.out.println("Hatalı gün girdiniz");
                System.exit(2);
            }
        }
        // Mayıs için sorguluyoruz
        else if (month == 5) {

            if (day >= 1 && day <= 31) {


                if (day < 22) {

                    horoscope = "Boğa";
                } else {
                    horoscope = "İkizler";
                }
            } else {
                System.out.println("Hatalı gün girdiniz");
                System.exit(2);
            }
        }
        // Haziran için sorguluyoruz
        else if (month == 6) {

            if (day >= 1 && day <= 30) {


                if (day < 23) {

                    horoscope = "İkizler";
                } else {
                    horoscope = "Yengeç";
                }
            } else {
                System.out.println("Hatalı gün girdiniz");
                System.exit(2);
            }
        }
        // Temmuz için sorguluyoruz
        else if (month == 7) {

            if (day >= 1 && day <= 31) {


                if (day < 23) {

                    horoscope = "Yengeç";
                } else {
                    horoscope = "Aslan";
                }
            } else {
                System.out.println("Hatalı gün girdiniz");
                System.exit(2);
            }
        }
        // Ağustos için sorguluyoruz
        else if (month == 8) {

            if (day >= 1 && day <= 31) {


                if (day < 23) {

                    horoscope = "Aslan";
                } else {
                    horoscope = "Başak";
                }
            } else {
                System.out.println("Hatalı gün girdiniz");
                System.exit(2);
            }
        }
        // Eylül için sorguluyoruz
        else if (month == 9) {

            if (day >= 1 && day <= 30) {


                if (day < 23) {

                    horoscope = "Başak";
                } else {
                    horoscope = "Terazi";
                }
            } else {
                System.out.println("Hatalı gün girdiniz");
                System.exit(2);
            }
        }
        // Ekim için sorguluyoruz
        else if (month == 10) {

            if (day >= 1 && day <= 31) {


                if (day < 23) {

                    horoscope = "Terazi";
                } else {
                    horoscope = "Akrep";
                }
            } else {
                System.out.println("Hatalı gün girdiniz");
                System.exit(2);
            }
        }
        // Kasım için sorguluyoruz
        else if (month == 11) {

            if (day >= 1 && day <= 30) {


                if (day < 22) {

                    horoscope = "Akrep";
                } else {
                    horoscope = "Yay";
                }
            } else {
                System.out.println("Hatalı gün girdiniz");
                System.exit(2);
            }
        }
        // Aralık için sorguluyoruz
        else if (month == 12) {

            if (day >= 1 && day <= 31) {


                if (day < 22) {

                    horoscope = "Yay";
                } else {
                    horoscope = "Oğlak";
                }
            } else {
                System.out.println("Hatalı gün girdiniz");
                System.exit(2);
            }
        }

        else

        {
            System.out.println("Hatalı ay girdinzz");
            System.exit(2);
        }

        System.out.println("Sizin burcunuz : " + horoscope);

    }
}
