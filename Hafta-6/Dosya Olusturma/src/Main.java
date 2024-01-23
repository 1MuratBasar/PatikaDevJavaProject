import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {

        // dosya olusturma ve kullanımı

        String str = "Java 101 Öğreniyorum, bunu dosyay yazdıralım, Let create a file and write this words on file.";
        String str2 = "Java 102 Öğreniyorum, bunu dosyay yazdıralım, Let create a file and write this words on file.";

        String path = "C:\\Users\\murat\\OneDrive\\Masaüstü\\JAVA UDEMY/dosya.txt";


        String ad = "Ahmet";
        String soyad = "Hasan";
        int yas = 24;


        File dosya = new File (path);

        if (!dosya.exists()) {

            dosya.createNewFile();
        }
           /*
        // buraya kadar dosyayı olusturduk. şimdi dosyayı yazdırıyoruz

        FileWriter fwriter = new FileWriter(dosya, true); // false diyorum yeni eklenecek ve her seferind euzerne yazacak, sonuna eklemeyecek
        //appnd true yaparsam varolanın devamın yazar. öncekiler kalır
        // bilgileri buffer bölgeler alır kendi yazma işini halleder performans sağlar
        BufferedWriter bufferedWriter = new BufferedWriter(fwriter);
        //  sıra yazmaya geldi
     //   bufferedWriter.write(str);
       // bufferedWriter.newLine(); // alt alta eklemek içic
      //  bufferedWriter.write(str2);
      //  bufferedWriter.newLine();

        String adF = String.format("%10s", ad);
        String soyadF = String.format("%10s", soyad);
        String yasF = String.format("%10d", yas);
        bufferedWriter.write(adF);
        bufferedWriter.write(soyadF);
        bufferedWriter.write(yasF); bufferedWriter.newLine();
        bufferedWriter.close();
*/

        //buraya kadar dosya yazdırdık. şimdi mevcut dosyadan okuma, cekme ypaıcaz

        FileReader fReader = new FileReader(dosya); //yine okrken de tampo bellege cekip okuyucaz
        BufferedReader bReader = new BufferedReader(fReader);
        //verilerib başından sonuna okuyalım
        String line;
            while ((line = bReader.readLine())!=null) {
               // System.out.println(line);

                // ben bunu bir database gibi alıp bir diziye verileri atmak istiyorum

                ad = line.substring(0,10);
                soyad = line.substring(10,20);
                ad = ad.replaceAll(" ","");
                soyad = soyad.replaceAll(" ","");
            String yass = line.substring(20,30);
                yass = yass.replaceAll(" ","" );
            yas = Integer.parseInt(yass);


                System.out.println(ad + " " + soyad + " " + yas);

            }

            // dosyayı silmek istiyorsak
        bReader.close();
        if (dosya.exists()){
            dosya.delete();
        }

    }
}