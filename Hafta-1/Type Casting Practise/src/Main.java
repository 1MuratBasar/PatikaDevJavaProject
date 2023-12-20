import java.util.Scanner;
//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        int selection;
        selection=15;
        int x;
        double myDouble;
        int myInt;
        char myChar;
        float myFloat;
        String myString;
        long myLong;
        byte myByte;

        Scanner input = new Scanner(System.in);

        while (selection > 0) {

            do {

                System.out.println(

                        "1- Int to Double\n" +
                                "2- Double to Int\n" +
                                "3- Char to Int\n" +
                                "4- Int to char\n" +
                                "5- Long to byte\n" +
                                "6- Int to String\n" +
                                "7- Long to string\n" +
                                "8- Float to string\n" +
                                "9- Çıkış ");

                System.out.print("Lütfen Yapmak İstediğiniz İşlemi Seçiniz : ");
                selection = input.nextInt();

                switch (selection) {
                    case 1:
                        System.out.println("Bir int değer giriniz : ");
                        x = input.nextInt();
                        myDouble = x;
                        System.out.println("Int to double " + myDouble);
                        break;
                    case 2:
                        System.out.println("Bir double değer giriniz : ");
                        myDouble = input.nextDouble();
                        myInt = (int) myDouble;
                        System.out.println("double to int " + myInt);
                        break;
                    case 3:
                        System.out.println("Bir char karakter giriniz : ");
                        myChar = input.next().charAt(0);
                        myInt = (int) myChar;
                        System.out.println("char to int " + myInt);
                        break;
                    case 4:
                        System.out.println("Bir int karakter giriniz : ");
                        myInt = input.nextInt();
                        myChar = (char) myInt;
                        System.out.println("int to char " + myChar);
                        break;
                    case 5:
                        System.out.println("Bir long karakter giriniz : ");
                        myLong = input.nextLong();
                        myByte = (byte) myLong;
                        System.out.println("Long to byte " + myByte);
                        break;
                    case 6:
                        System.out.println("Bir Int karakter giriniz : ");
                        myInt = input.nextInt();
                        myString = Integer.toString(myInt);
                        System.out.println("Int to String" + myString);
                        break;
                    case 7:
                        System.out.println("Bir Long karakter giriniz : ");
                        myLong = input.nextLong();
                        myString = Long.toString(myLong);
                        System.out.println("Long to String " + myString);
                        break;
                    case 8:
                        System.out.println("Bir Float karakter giriniz : ");
                        myFloat = input.nextFloat();
                        myString = Float.toString(myFloat);
                        System.out.println("Float  to String " + myString);
                        break;
                    case 9:
                        break;
                }
                break;
            } while (selection != 9);
            break;
        }
    }
}