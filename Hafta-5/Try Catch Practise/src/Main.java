import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        System.out.println("program başladı");
        int a;

        Scanner scanner = new Scanner(System.in);
        System.out.println("istenilen index elemanını girin: ");


        try {
            a= scanner.nextInt();
            IndexCheckException(a);
            System.out.println("Selected index : " + a);
        } catch (Exception e) {
            System.out.println("Index exception");
            System.out.println(e.getMessage());

        }

        System.out.println("Program is over");
    }

    public static  void IndexCheckException (int a) throws Exception  {
        int[] array = {1,2,3,4,5,6,7,8,9,0};


            if (a > array.length ) {
                System.out.println("out of bounds exception");

            }

    }
    }





