import java.util.Scanner;

public class Player {

    private int damage;
    private int health;
    private int orjinalHealth;
    private int money;
    private String name; // Gamer's name
    private String charName; // karakteri ismi (archer, samurai etc)
    private Inventory inventory; // bu alan inventory class olusturulduktan sonra geldi secilen silahın hasarı hesaplanması istenildiği sırada
    private Scanner input = new Scanner(System.in);

    // playerdan nesne üretirken sadece oyuncunun ismini alıcam dışarıdan. Çünkü diger 4 ünü oyuncuya seçtircem
    //bu nedenle constructor a bunaları yazmama gerek yok

    public Player (String name){
        this.name = name;
        //boş inventory olusturdum ancak çalıştıgında inventory class ta varsayılan olacak yani yumruk
        this.inventory = new Inventory();

    }


    public  void selectChar (){

        GameChar[] charList = {new Samurai(), new Knight(), new Archer()};
        System.out.println("Characters");
        System.out.println("--------------------------------------------------------------");

        for (GameChar gameChar : charList) {
            System.out.println("ID : " + gameChar.getId() +
            "\tCharacter : " + gameChar.getName() +
            "\t Damage   : " + gameChar.getDamage() +
            "\t Health   : " + gameChar.getHealth() +
            "\t Money    : " + gameChar.getMoney());

        }
        System.out.println("--------------------------------------------------------------");
        System.out.print("Please select a character ID : ");
        int selectChar = input.nextInt();
        switch (selectChar){
            case 1:
            initPlayer(new Samurai());
            break;
            case 2:
                initPlayer(new Archer());
                break;
            case 3:
                initPlayer(new Knight());
                break;
            default:
                initPlayer(new Samurai());

        }
   //     System.out.println("The selected character : " + this.getCharName() + "." + " Damage : " + this.getDamage() + " Health : " + this.getHealth() + " Money : " + this.getMoney());

    }







// case 1 olunca intPlayer metotu ile dışarıdan oyun karakteri alıyorum
    public void initPlayer (GameChar gameChar){
this.setDamage(gameChar.getDamage());
this.setHealth(gameChar.getHealth());
this.setOrjinalHealth(gameChar.getHealth());
this.setMoney(gameChar.getMoney());
this.setCharName(gameChar.getName());
    }

    //player ın özelliklerini basmak için
    public void printInfo (){
        System.out.println(
                "Silahınız : " + this.getInventory().getWeapon().getName() +
                "Zırh      : " + this.getInventory().getArmor().getName() +
                "Bloklama  : " + this.getInventory().getArmor().getBlock() +
                "Hasarınız : " + this.getToltalDamage() +
                "Sağlık    : " + this.getHealth() +
                "Para      : " + this.getMoney());

    }
    // benim hasarımı yansıta nokta damage m + inventory den gelen weapon damage si

    public int getToltalDamage() {
       return damage + this.getInventory().getWeapon().getDamage();
    }

    public int getDamage() {
        return damage;
    }

    public void setDamage(int damage) {
        this.damage = damage;
    }

    public int getHealth() {
        return health;
    }

    public void setHealth(int health) {
        if (health < 0) {
            health=0;
        }

        this.health = health;
    }

    public int getMoney() {
        return money;
    }

    public void setMoney(int money) {
        this.money = money;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCharName() {
        return charName;
    }

    public void setCharName(String charName) {
        this.charName = charName;
    }

    public Inventory getInventory() {
        return inventory;
    }

    public void setInventory(Inventory inventory) {
        this.inventory = inventory;
    }
/*
    //böyle bir metot yazarak kısaltma yapabilrm cagırırken
public  Weapon getWeapon(){
        return this.getInventory().getWeapon();
}
 */


    public int getOrjinalHealth() {
        return orjinalHealth;
    }

    public void setOrjinalHealth(int orjinalHealth) {
        this.orjinalHealth = orjinalHealth;
    }

    public Scanner getInput() {
        return input;
    }

    public void setInput(Scanner input) {
        this.input = input;
    }
}

