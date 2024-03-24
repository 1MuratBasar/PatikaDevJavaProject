
import java.util.Scanner;
public class dede {
public static void main(String[] args) {

       // MAKING TRIGANGLE WITH STARS
        //YILDIZLAR İLE ÜÇGEN YAPIMI

                int i,k,j,n;
                Scanner input = new Scanner(System.in);
                System.out.print("Enter a number that shows how many rows will be stars : ");
                n = input.nextInt();
                for (i=1; i<=n; i++){ //loop a
                    for (k=1; k<=n-i; k++) { // loop b
                        System.out.print(" ");
                    }
                    for (j=1; j<= (2*i)-1 ; j++ ) { // loop c
                        System.out.print("*");
                    }
                    System.out.println(); // to move bottom row
                }
            }
        }


