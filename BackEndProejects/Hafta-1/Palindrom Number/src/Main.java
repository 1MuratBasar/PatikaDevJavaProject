

public class Main {

    static boolean isPalindrom (int number){
        // yeni oluşacak sayıyı girdğimiz sayı ile karşılatırmak için en başta tempNumber = number diyoruz
        int tempNumber, lastNumber, newNumber =0;
        tempNumber = number;
        while (tempNumber !=0) {

            lastNumber = tempNumber %10;

            newNumber = (newNumber*10) + lastNumber;

            tempNumber=tempNumber/10;
        }
                if (number == newNumber) {
                    return true;
                } else {
                    return false;
                }
    }

    public static void main(String[] args) {



        System.out.println(isPalindrom(1234321));
    }
}