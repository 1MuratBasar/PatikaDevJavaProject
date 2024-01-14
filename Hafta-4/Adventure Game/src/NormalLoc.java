public abstract class NormalLoc extends Location{
    public NormalLoc(Player player, String name) {
        super(player, name);
    }

    @Override
  public   boolean onLOcation() {
        return true;
    }
}
