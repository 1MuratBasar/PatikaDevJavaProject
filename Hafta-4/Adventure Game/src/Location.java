import java.util.Scanner;

public abstract class Location {

    private  Player player; // location ıma player ı atmalıyım
    private String name;
    public static Scanner input = new Scanner(System.in);
    public Location(Player player, String name) {
        this.player = player;
        this.name = name;

    }

    public abstract boolean onLOcation (); // tüm alt lokasyonlar bu metodu kullanacak

    public Player getPlayer() {
        return player;
    }

    public void setPlayer(Player player) {
        this.player = player;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
