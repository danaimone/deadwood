package deadwood;

public class Player {
    protected String name;
    protected int dollars;
    protected int credits;
    protected int rehearsalTokens;
    protected int rank;
    protected boolean onRole;

    private Set getCurrentRoom() {
        //find where player currently is
        //do we want to store this as its own variable?
        //or is it easier for Room class to store players in room?
        return null;
    }

    private void playersTurn(){
        /*
        moveTo()
        upgradeRank()
        rehearse()
        chooseRole()
        act()
        
        make it so player can continue turn if applicable
        ex. player moves, they can upgrade OR take role then work
        */
    }

    private void moveTo(Set destRoom) {
        /*
        this will need to check for valid rooms user can move into
        will also probably trigger stuff for undiscovered scenes
        */
        return;
    }

    private void upgradeRank() {
        /*
        needs to store ranks and their prices
        ask player how they want to pay, what rank they want
        change rank
        */
        return;
    }

    private void rehearse() {
        //give player rehearse counter
        //force to act if rehearse counters are max
        return;
    }

    private void act() {
        /*
        this will need to check if scene is wrapped after acting
        since Board class seems to contain board/scene info,
        wrapScene method is in there
        */
        return;
    }

    private void chooseRole() {
        //will need to make sure player can take role
        //will also let player work on role if they take it
        return;
    }

    public boolean isOnRole() {
        return onRole;
    }

    private void setDollars(int amount) {
        return;
    }

    private void setCredits(int amount) {
        return;
    }

    public int getDollars() {
        return dollars;
    }

    public int getCredits() {
        return credits;
    }
}
