public abstract class NormalLoc extends Location{


    public NormalLoc(Player player, String name) {
        super(player, name);
    }

    @Override
    public boolean onLocation() {
        return true; // true yaptım cunku normal loc olme ihtimali yok
    }
}
