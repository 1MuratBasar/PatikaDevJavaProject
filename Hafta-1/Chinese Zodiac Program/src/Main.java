import java.sql.SQLOutput;
import java.util.Scanner;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Calendar;
// ÇİN ZODYAK INA GÖRE BURÇ BULAN PROGRAM
//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        // ihtiyaç olan değişkenleri tanımlıyoruz
        int birthdate;
        Calendar calendar = Calendar.getInstance();
        int today = calendar.get(Calendar.YEAR); // yıl
        Scanner input = new Scanner(System.in);
        System.out.print("Enter your birthdate (It must max last 150 years) : ");
        birthdate = input.nextInt();
        // bugun ve son 150 yıl (max 150 yaşında olunabileceği varsayılarak) arasına bakmasını istiyoruz
            if (birthdate < (today - 150) || birthdate > today) {
                System.out.println("You entered wrong value, try again");
                System.exit(2);
            } else {
            // son 150 yıl içinde bir tarih girildiyse sorgulamasını yapıyoruz.
                if (birthdate % 12 == 0) {
                    System.out.print("Your Chines Zodic Horoscope is : Monkey");
                } else if (birthdate % 12 == 1) {
                    System.out.print("Your Chines Zodic Horoscope is : Rooster");
                } else if (birthdate % 12 == 2) {
                    System.out.print("Your Chines Zodic Horoscope is : Dog");
                } else if (birthdate % 12 == 3) {
                    System.out.print("Your Chines Zodic Horoscope is : Pig");
                } else if (birthdate % 12 == 4) {
                    System.out.print("Your Chines Zodic Horoscope is : Mouse");
                } else if (birthdate % 12 == 5) {
                    System.out.print("Your Chines Zodic Horoscope is : Ox");
                } else if (birthdate % 12 == 6) {
                    System.out.print("Your Chines Zodic Horoscope is : Tiger");
                } else if (birthdate % 12 == 7) {
                    System.out.print("Your Chines Zodic Horoscope is : Rabbit");
                } else if (birthdate % 12 == 8) {
                    System.out.print("Your Chines Zodic Horoscope is : Dragon");
                } else if (birthdate % 12 == 9) {
                    System.out.print("Your Chines Zodic Horoscope is : Snake");
                } else if (birthdate % 12 == 10) {
                    System.out.print("Your Chines Zodic Horoscope is : Horse");
                } else if (birthdate % 12 == 11) {
                    System.out.print("Your Chines Zodic Horoscope is : Sheep");
                }
            }


    }
}