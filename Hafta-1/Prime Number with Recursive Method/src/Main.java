import java.util.Scanner;
//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {

        static boolean isPrime (int number){

            boolean prime = true;

            if (number < 1 ) {
                prime = false;
            } else {
                for (int i = 2; i<number; i++){
                    if (number%i==0){
                        prime = false;
                        break;
                    }
                }

            }
            if (prime) {
                System.out.println(number + " bir asal sayıdır.");
            } else {
                System.out.println(number + " bir asal sayı değildir.");
            }

        return prime;
        }



    public static void main(String[] args) {
        int number;
        Scanner input = new Scanner(System.in);

                System.out.print("Bir Sayı giriniz : ");
                number = input.nextInt();
                System.out.println(isPrime(number));


        }


    }
