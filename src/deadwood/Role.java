package deadwood;

public class Role {
    protected boolean onCard;
    protected int level;
    protected boolean taken;
    protected boolean visible;

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
