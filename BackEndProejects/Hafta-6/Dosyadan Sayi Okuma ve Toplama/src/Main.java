import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
// Pratik - Dosyadan syı okuma ve bu sayıları toplama. önemli noktalar kod satırlarında belirtilmiştir.

public class Main {
    public static void main(String[] args) {
        String path = "Numbers.txt";
        try {
            //1-dosyadan okuma için FileReader gerekli
            FileReader fileReader = new FileReader(path);
            //2-performans için tampon buffreader gerekli
            BufferedReader bufferedReader = new BufferedReader(fileReader);
            //3- her okuyacagım satıra line değişkeni dedim
            String line;
            //4-toplama yapacagım için önceden bir toplam değişkeni alıyorum
            int sum=0;
            //5- satır değişkenime her satır okundugunda ata ve satır boş olmadıgı surece kontrol et
            while ((line = bufferedReader.readLine()) != null){
                //6-dosyadaki sayıları integer a dönüştr ve topla
                sum += Integer.parseInt(line);

            }
            //7- sonucu yazdır
            System.out.println(sum);
            //Not: filereader işlemleri exception fırlatabileceği için try-catch e aldık
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

    }
}