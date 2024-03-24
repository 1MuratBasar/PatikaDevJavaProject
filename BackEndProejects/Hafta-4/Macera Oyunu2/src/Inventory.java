

// aldıgım silahın etkisini damage olarak da düşeceğim için bu sınıfı olustrudum. bu nedenle player için olusturuldu
// weapon name ve damage ye ihtiyacım olacak
public class Inventory {
    private Weapon weapon;
    private Armor armor; // armor class ı ve print metotundan sonra invetory e yazıldı

    //varsayılan olarak kendi ureticem
    //sonra bulnarı weapon üzerinden get ile alıyorum
    public Inventory(){
        this.weapon = new Weapon("Yumruk",-1,0,0);
        this.armor = new Armor(-1, "Paçavra",0,0); // bundan sonra satın alma işlemi var go to toolstore
    }

    public Weapon getWeapon() {
        return weapon;
    }

    public void setWeapon(Weapon weapon) {
        this.weapon = weapon;
    }

    public Armor getArmor() {
        return armor;
    }

    public void setArmor(Armor armor) {
        this.armor = armor;
    }
}
