import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
public class Main {
    static void cumleBol(String cumle) {
        String a;
        Scanner scan = new Scanner(System.in);
        System.out.println("Cümle girin:");
        a = scan.nextLine();
        String[] parted = a.split(" ");
        HashMap<String , Integer> hashMap = new HashMap<>();
//parted = {"murat" , "murat", "basar"}

        for(int i=0;i<parted.length;i++) {
        String key= parted[i];
         hashMap.put(key , hashMap.getOrDefault(key,0)+1);
        }


        String mostFrequent = null;
        int count=0;

        for (Map.Entry<String, Integer> entry : hashMap.entrySet()) {

            if (entry.getValue() > count){
                count = entry.getValue();
                mostFrequent = entry.getKey();
            }
        }

        System.out.println(count + " " + mostFrequent);



    }
    public static void main(String[] args) {
        String cumle = null;
        cumleBol(cumle);

    }
}