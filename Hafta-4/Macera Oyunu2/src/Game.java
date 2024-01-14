import  java.util.Scanner;

public class Game {
private Scanner input = new Scanner(System.in);


    public void statrt () {
        System.out.println("Welcome to the adventure game !");
        System.out.println("Please enter a name : ");
        //  String playerName = input.nextLine();
        // kullanıcıdan isim aldıktan sonra bir player nesnesi üretmem lazım

        Player player = new Player("murat");
        System.out.println(player.getName() + " Welcome to the dark and foggy island. No turning back! ");
        //artık player ı olusturduktan sonra kullancıya karakter seçicem. çagırmak için metot yazıyorum. player altında

        System.out.println("Please select a charackter to start the game !");
        player.selectChar();
        // karakter olusturuna kadar herşey sırayla gidiyor.
        // karakterden sonra surekli dinami olacagı için while dongusu ile dinamik bir süreç yarayırouz
        Location location = null;
        while (true) {
            player.printInfo();
            System.out.println();
            System.out.println("------------------------------------------------------------------");
            System.out.println();
            System.out.println("The Locations : ");
            System.out.println("1- The Safe House   ---> No enemy here.");
            System.out.println("2- The Tool Store   ---> Silah veya zırh alabilirsiniz.");
            System.out.println("3- Mağaraya gir     ---> Ödül: Yemek ---> Dikkatli ol zombie var.");
            System.out.println("4- Ormana Gir       ---> Ödül: Odun ---> Dikkatli ol vampir var.");
            System.out.println("5- Nehire gir       ---> Ödül: Su ----> Dikkatli ol ayı var.");
            System.out.println("0- Çıkış Yap        ---> oyunu sonlandır.");
            System.out.println("------------------------------------------------------------------");
            System.out.print("Please select the location you want to go : ");
            int selecLoc = input.nextInt();

            switch (selecLoc) {
                case 0:
                    location = null;
                    break;
                case 1:
                    location = new SafeHouse(player); // Player player nesnesinden geliyor. safehouse da parametre olarak player tanımlanmıstı
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
                    System.out.println("Lütfen gecerli bölge giriniz");
                   // location = new SafeHouse(player);
                    // açıklama location safehouse gibi davrandı. location nun da onlocation u çagrıldıgında işlemleri yaptırıyor
            }

            if (location == null){
                System.out.println("Oyun bitti görüşmek üzere");
                break;
            }


          if(!location.onLocation()) {
              System.out.println("You are death. Game over");
              break;
          }
        }

    }


        }

