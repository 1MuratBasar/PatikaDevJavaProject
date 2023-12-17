import java.util.Scanner;//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {//TIP Press <shortcut actionId="ShowIntentionActions"/> with your caret at the highlighted text
        // to see how IntelliJ IDEA suggests fixing it.

        int date, date2;

        Scanner input = new Scanner(System.in);
        System.out.print("Enter a date : ");
        date = input.nextInt();

        if ((date % 400 == 0) || ((date%100!=0) && (date % 4 ==0))) {

             System.out.println( date + " is a leap year!");
        }
        else {
            System.out.println(date + " is Not a leap year!");
        }

    }
}