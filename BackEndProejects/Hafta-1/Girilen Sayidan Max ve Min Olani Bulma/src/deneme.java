
import java.util.Scanner;

                public class deneme {
                    public static void main(String[] args) {
                        Scanner scan = new Scanner(System.in);
                        int n, max, min;
                        System.out.print("Kaç tane sayı gireceksiniz? ");
                        n = scan.nextInt();
                        int[] numbers = new int[n];
                        System.out.print("Sayıları girin: ");
                        for(int i = 0; i < n; i++) {
                            numbers[i] = scan.nextInt();
                        }
                        max = numbers[0];
                        min = numbers[0];
                        for(int i = 1; i < n; i++) {
                            if(numbers[i] > max) {
                                max = numbers[i];
                            }
                            if(numbers[i] < min) {
                                min = numbers[i];
                            }
                        }
                        System.out.println("En büyük sayı: " + max);
                        System.out.println("En küçük sayı: " + min);
                    }
                }