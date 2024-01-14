public class SafeHouse extends NormalLoc {
    public SafeHouse(Player player) {
        super(player, "The Safe House");
    }

    @Override
    public boolean onLocation() {
        System.out.println("You are in the Safe House.");
        System.out.println("Your health is refulled.");
        this.getPlayer().setHealth(this.getPlayer().getOrjinalHealth());
return true;
    }
}
