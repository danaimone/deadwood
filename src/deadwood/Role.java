package deadwood;

public class Role {
    public boolean onCard;
    public int level;
    public boolean taken;
    public boolean visible;

    private int getLevel() {
        return 0;
    }

    private boolean isVisible(){
        return visible;
    }

    private boolean isTaken() {
        return taken;
    }

    private boolean isOnCard() {
        return onCard;
    }

}
