import java.util.Arrays;

public class Main {
    public static void main(String[] args) {


      for (Yazar author : YazarIslemleri.getYazarlar()){

          System.out.println((author.getAd() + " " + author.getSoyad()));
      }


    }
}