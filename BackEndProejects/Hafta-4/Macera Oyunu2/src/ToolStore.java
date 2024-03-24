public class ToolStore extends NormalLoc {

    public ToolStore(Player player) {
        super(player, "The Tool Store");


    }

    @Override
    public boolean onLocation() {
        System.out.println("-----Welcome to the Tool Store-----");
        boolean showMenu = true;
        while (showMenu) {
            System.out.println("1- Weapons ");
            System.out.println("2- Armors ");
            System.out.println("3- Go exit ");
            System.out.print("Please select a number : ");
            int selectCase = input.nextInt();
            while (selectCase < 1 || selectCase > 3) {
                System.out.print("Invalid value try again : ");
                selectCase = input.nextInt();
            }
            switch (selectCase) {
                case 1:
                    printWeapon();
                    buyWeapon();
                    break;

                case 2:
                    printArmor();
                    buyArmor(); // inventory de olusturuldukan sonra burda ism verildi sonrası metotun yazılması altta
                    break;

                case 3:
                    System.out.println("See you next time");
                    showMenu = false;
                    break;
            }
        }
        return true;
    }

    public void printWeapon() {
        System.out.println("----- Weapons -----");
        // Weapon w adında nesne üretip Weapon.weaposn metonu cagırdım (array listeyi)
        for (Weapon w : Weapon.weapons()) {
            System.out.println(w.getId() + " - " + w.getName() + " Price : " + w.getPrice() + " Damage : " + w.getDamage());
        }
        System.out.println("0 - Çıkış Yap");

    }

    public void buyWeapon() {
        System.out.println("Select a weapon : ");
        int selectWeaponID = input.nextInt();
        while (selectWeaponID < 0 || selectWeaponID > Weapon.weapons().length) {
            System.out.print("Invalid value try again : ");
            selectWeaponID = input.nextInt();
        }
        if (selectWeaponID != 0) {
            Weapon selectedWeapon = Weapon.getWeaponObjByID(selectWeaponID);
            if (selectedWeapon != null) {
                if (selectedWeapon.getPrice() > this.getPlayer().getMoney()) {
                    System.out.println("The Balance is not enough !");
                } else {
                    // satın alma burada gerçekleşiyor
                    System.out.println(selectedWeapon.getName() + " you purchased.");
                    int balance = this.getPlayer().getMoney() - selectedWeapon.getPrice();
                    this.getPlayer().setMoney(balance);
                    System.out.println("Kalan paranız : " + this.getPlayer().getMoney());
                    //   System.out.println("Önceki silahınız : " + this.getPlayer().getInventory().getWeapon().getName()); // örnek amaclı
                    //getplayer locationdan geliyor player alıyor.
                    //location a player game de toolstore nesnesine değer olarak atıyorum
                    //player tool store a geldi
                    //tool store da inventory var. inventory de ise ilk silah yumruk. cunku oraya nesne olarak weapon atıldı
                    //inventory den weapon u getir dedim
                    // ordan da adını getir dedim. yani nesneler üzerinden birbirileine erişim sağlattırdım
                    this.getPlayer().getInventory().setWeapon(selectedWeapon);
                    //  System.out.println("Yeni silahınız : " + this.getPlayer().getInventory().getWeapon().getName()); // örnek amaclı

                }
            }
        }
    }

    //armor sınıfı içerisinde gerie armor array donduren değer yazdırmak istiyorum go to armor class
    public void printArmor() {
        System.out.println("----- Zırhlar -----");
        for (Armor a : Armor.armors()) {
            System.out.println(a.getId() + " - " + a.getName() + " Fiyat : " + a.getPrice() + " Zırh : " + a.getBlock());
        }
        System.out.println("0 - Çıkış Yap");

    }

    // satın alma işlemi sonrası (seçilen sonrası) seçileni obje olarak geri getiren metot yazdık weaponda
    public void buyArmor() {
        System.out.println("Zırh seçiniz :");
        int selectArmorID = input.nextInt();
        while (selectArmorID < 0 || selectArmorID > Armor.armors().length) {
            System.out.print("Invalid value try again : ");
            selectArmorID = input.nextInt();
        }

       if (selectArmorID != 0) {
           Armor selectedArmor = Armor.getArmorByID(selectArmorID);
           if (selectedArmor.getPrice() > this.getPlayer().getMoney()) {
               System.out.println("Yeterli paranız bulunmamaktadır");
           } else {
               // satın alma burada gerçekleşiyor
               System.out.println(selectedArmor.getName() + " you purchased.");
               int balance = this.getPlayer().getMoney() - selectedArmor.getPrice();
               this.getPlayer().setMoney(balance);
               System.out.println("Kalan bakiye : " + this.getPlayer().getMoney());
               //   System.out.println("Önceki silahınız : " + this.getPlayer().getInventory().getWeapon().getName()); // örnek amaclı
               //getplayer locationdan geliyor player alıyor.
               //location a player game de toolstore nesnesine değer olarak atıyorum
               //player tool store a geldi
               //tool store da inventory var. inventory de ise ilk silah yumruk. cunku oraya nesne olarak weapon atıldı
               //inventory den weapon u getir dedim
               // ordan da adını getir dedim. yani nesneler üzerinden birbirileine erişim sağlattırdım
               this.getPlayer().getInventory().setArmor(selectedArmor);
               //  System.out.println("Yeni silahınız : " + this.getPlayer().getInventory().getWeapon().getName()); // örnek amaclı

           }

       }
    }
}






