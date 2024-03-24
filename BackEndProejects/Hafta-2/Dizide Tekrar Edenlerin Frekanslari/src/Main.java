import java.util.Arrays;
public class Main {

    public static void main(String[] args) {
        int count = 0;
        int[] Dizi = {10, 20, 20, 10, 10, 20, 5, 20};

        Arrays.sort(Dizi); // dizi elemanlarının öncesi ve sonrasına bakıcaz
        // öncesi ya da sonrasıyla aynı olup olmama durumlarıı saydırıyorruz
        for (int i = 0; i < Dizi.length; i++) {
            count=0; // her sayı için sayacı sıfırladık
            for (int j = 0; j < Dizi.length; j++) {
              if (Dizi[i]==Dizi[j]){
                 count++;
              }
                }
            if(i==0 && Dizi[i+1]==Dizi[i])
            {
                System.out.println(count + " tane " +  Dizi[i] + " var." );
           }

            if(i==0 && Dizi[i+1]!=Dizi[i])
            {
                System.out.println(count + " tane " +  Dizi[i] + " var." );
            }
            if(i!=0 && Dizi[i-1]!=Dizi[i])
            {
                System.out.println(count + " tane " +  Dizi[i] + " var." );
            }

        }
            }


        }





