import java.util.Scanner;

public class Game {
private Scanner input = new Scanner(System.in);
    public void start (){

        System.out.println("Macera Oyununa Hoşgeldiniz !");
        System.out.print("Lütfen bir isim giriniz : ");
  //      String playerName = input.nextLine();
        Player player = new Player("test");
        System.out.println(" Sayın " + player.getName() + " bu karalık ve sisli adaya Hoşgeldiniz !");
        System.out.println("Lütfen bir karakter seçiniz : ");
        player.selectChar();
        System.out.println("------------------------------------------------------------------");

        Location location = null;

        while (true) {
            player.printInfo();
            System.out.println("Bölgeler : ");
            System.out.println("1- Güvenli Ev-----------> Burası güvenli yer düşman yok------");
            System.out.println("2- Mağaza --------------> Silah veya zırh satın alabilirsiniz");
            System.out.println("3- Mağara --------------> Mağaraya git-----------------------");
            System.out.println("4- Orman- --------------> Ormana git-------------------------");
            System.out.println("5- Nehir- --------------> Nehire git-------------------------");
            System.out.println("0- Çıkış yap------------> Oyunu sonlandır--------------------");
            System.out.print("Lütfen gitmek istediğiniz bölgeyi seçiniz : ");
            int selecLoc = input.nextInt();
            switch (selecLoc) {
                case 0:
                    location = null;
                    break;
                case 1 :
                    location = new SafeHouse(player);
                    break;
                case 2:
                    location = new ToolStore(player);
                    break;
                case 3:
                    location = new Cave(player);
                    break;
                case 4:
                    location = new Forest(player);
                    break;
                case 5:
                    location = new River(player);
                    break;
                default:
                    System.out.println("Lütfen gecerli bir bölge girin : ");
                    //location = new SafeHouse(player);

            }
            if (location == null){
                System.out.println("Oyundan çabuk çıkış yaptınız");
                break;
            }
            if (!location.onLOcation()) {
                System.out.println("Game Over");
                break;
            }

        }
    }
}
