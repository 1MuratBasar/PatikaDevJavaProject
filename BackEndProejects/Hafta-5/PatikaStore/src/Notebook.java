import java.util.ArrayList;
import java.util.Scanner;

public class Notebook extends Product implements Operation {
    private static int id = 1;
    private static ArrayList<Notebook> notebookList = new ArrayList<>();


    public Notebook(String name, double price, double discounRate, int stock, String brandName, String screenSize, int ram, String memory) {
        super(id++, name, price, discounRate, stock, brandName, screenSize, ram, memory);
    }


    public Notebook() {
    }


    static {

        notebookList.add(new Notebook("Matebook 14", 7000.0, 5, 5, "Huawei", "14", 16, "512.0"));
        notebookList.add(new Notebook("v14 IGL", 3699.0, 5, 5, "Lenovo", "14", 8, "1024.0"));
        notebookList.add(new Notebook("TravelMate", 7199.0, 5, 5, "Acer", "15.6", 32, "512.0"));
        notebookList.add(new Notebook("Aspire", 9199.0, 5, 5, "Acer", "15.6", 32, "512.0"));
        notebookList.add(new Notebook("Nirvana", 18199.0, 5, 5, "Casper", "15.6", 32, "512.0"));
        notebookList.add(new Notebook("Gaming", 28199.0, 5, 5, "Monster", "15.6", 32, "512.0"));

    }

    Scanner scanner = new Scanner(System.in);

    boolean isRunning = true;


    @Override
    public void runMenu() {
        while (isRunning) {
            System.out.println("Notebook Store Yönetim Paneli");
            System.out.println("1- Notebook ekleme\n" +
                    "2- Notebook Silme  \n" +
                    "3- ID ye göre filtreleme      \n" +
                    "4- Markaya göre filtreleme    \n" +
                    "5- Notbook Listeleme \n" +
                    "0- Çıkış Yap");
            System.out.print("Yapmak istediğiniz işlemi seçin : ");
            int selection = scanner.nextInt();
            switch (selection) {
                case 1:
                    addProduct();
                    break;
                case 2:
                    deleteProduct();
                    break;
                case 3:
                    filterByProductId();
                    break;
                case 4:
                    filterByProducBrand();
                    break;
                case 5:
                    showProductList();
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


    @Override
    public void showProductList() {

        System.out.printf("%-8s %-22s %-12s %-16s %-15s %-16s %-15s %-15s %-16s%n",
                "ID", "Ürün Adı", "Fiyat", "İndirim", "Miktar", "Marka", "Ekran", "RAM", "HDD");
        for (Notebook notebook : notebookList) {
            System.out.printf("%-8s %-22s %-12s %-16s %-15s %-16s %-15s %-15s %-15s%n",
                    notebook.getId(), notebook.getName(), notebook.getPrice(), notebook.getDiscounRate(),
                    notebook.getStock(), notebook.getBrandName(), notebook.getScreenSize(), notebook.getRam(), notebook.getMemory());

        }
    }

    @Override
    public void addProduct() {


        System.out.print("Enter the name of the notebook: ");
        String name = scanner.nextLine();

        System.out.print("Enter the price of the notebook: ");
        double price = scanner.nextDouble();

        System.out.print("Enter the discount rate of the notebook: ");
        double discounRate = scanner.nextDouble();

        System.out.print("Enter the stock quantity of the notebook: ");
        int stock = scanner.nextInt();

        System.out.print("Enter the brand of the notebook: ");
        String brand = scanner.nextLine();
        scanner.nextLine();

        System.out.print("Enter the screen size of the notebook: ");
        String screenSize = scanner.nextLine();

        System.out.print("Enter the RAM size of the notebook: ");
        int ramSize = scanner.nextInt();

        System.out.print("Enter the memory of the notebook: ");
        String memory = scanner.nextLine();
        scanner.nextLine();

        notebookList.add(new Notebook(name, price, discounRate, stock, brand, screenSize, ramSize, memory));

        System.out.println("Yeni notebook eklendi.");
        System.out.println("----------------------");


    }

    @Override
    public void deleteProduct() {


        System.out.println("Silmek istediğiniz ürünün ID'sini giriniz:");
        int deleteSelection = scanner.nextInt();
        for (Notebook notebook : notebookList) {
            if (deleteSelection != notebook.getId()) {
                System.out.println("ID bulunamadı.");
            } else {
                notebookList.remove(deleteSelection);
                System.out.println("Ürün silindi.");

            }

        }

    }

    @Override
    public void filterByProductId() {
        System.out.println("Filtrelemek istediğiniz ID giriniz:");
        int filterID = scanner.nextInt();
        System.out.printf("%-8s %-22s %-12s %-16s %-15s %-16s %-15s %-15s %-16s%n",
                "ID", "Ürün Adı", "Fiyat", "İndirim", "Miktar", "Marka", "Ekran", "RAM", "HDD");
        for (Notebook notebook : notebookList) {
            if (notebook.getId() == filterID) {
                System.out.printf("%-8s %-22s %-12s %-16s %-15s %-16s %-15s %-15s %-15s%n",
                        notebook.getId(), notebook.getName(), notebook.getPrice(), notebook.getDiscounRate(),
                        notebook.getStock(), notebook.getBrandName(), notebook.getScreenSize(), notebook.getRam(), notebook.getMemory());

            }
        }
    }

    @Override
    public void filterByProducBrand() {
        System.out.println("Filtrelemek istediğiniz markayı giriniz:");
        String filterBrand = scanner.next();
        System.out.printf("%-8s %-22s %-12s %-16s %-15s %-16s %-15s %-15s %-16s%n",
                "ID", "Ürün Adı", "Fiyat", "İndirim", "Miktar", "Marka", "Ekran", "RAM", "HDD");
        for (Notebook notebook : notebookList) {
            if (notebook.getBrandName().equalsIgnoreCase(filterBrand)) {
                System.out.printf("%-8s %-22s %-12s %-16s %-15s %-16s %-15s %-15s %-15s%n",
                        notebook.getId(), notebook.getName(), notebook.getPrice(), notebook.getDiscounRate(),
                        notebook.getStock(), notebook.getBrandName(), notebook.getScreenSize(), notebook.getRam(), notebook.getMemory());

            }


        }
    }
}
