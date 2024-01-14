public class Cave extends BattleLoc{
    public Cave(Player player) { // player otomatik atancak diger degerler varsayılan olarak manuel girilecek
        super(player,"Mağara", new Zombie(), "Food  ",3);
    }
}
