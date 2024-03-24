import java.util.Scanner;

public class PatikaStore {


    Scanner input = new Scanner(System.in);

    boolean isRunning = true;

    public void run (){

        while (isRunning) {

            System.out.println("Patika Store Yönetim Paneli");
            System.out.println("1- Notebook İşlemleri \n" +
                               "2- Telefon İşlemleri  \n" +
                               "3- Marka Listele      \n" +
                               "0- Çıkış Yap" );
            System.out.print("Yapmak istediğiniz işlemi seçin : ");

            int selection = input.nextInt();
            switch (selection) {
                case 1:
                    Notebook notebook = new Notebook();
                    notebook.runMenu();
                    break;
                case 2:
                    Phone phone = new Phone();
                    phone.runMenu();
                    break;
                case 3:
                    Brand brand = new Brand("");
                    brand.printBrand();
                    break;
                case 0:
                    System.out.println("Çıkış yapıldı");
                    isRunning = false;
                    break;
                default:
                    System.out.println("Hatalı değer girdiniz.");
            }
        }
    }

}
