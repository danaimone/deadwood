package deadwood;

import java.util.*;

public class Player {
    protected int playerNumber;
    protected int dollars;
    protected int credits;
    protected int rehearsalTokens;
    protected int rank;
    protected boolean onRole = false; //false by default

    //player constructor
    public Player(int playerNum, int dol, int cred, int ran){
        playerNumber = playerNum;
        dollars = dol;
        credits = cred;
        rank = ran;
    }

    private Set getCurrentRoom() {
        //find where player currently is
        //do we want to store this as its own variable?
        //or is it easier for Room class to store players in room?
        return null;
    }

    public void playersTurn(Scanner playerInput){
        /*
        moveTo()
        upgradeRank()
        rehearse()
        chooseRole()
        act()
        
        make it so player can continue turn if applicable
        ex. player moves, they can upgrade OR take role then work
        */
        boolean continueTurn = true;
        while(continueTurn){
            if(onRole){
                playerInput.nextLine(); //clear scanner
                while(true){
                    System.out.println("Would you like to [act] or [rehearse]?");
                    String input = playerInput.nextLine();
                    if(input.equals("act")){
                        System.out.println("ACT ROLE");
                        break;
                    } else if(input.equals("rehearse")){
                        System.out.println("REHEARSE ROLE");
                        break;
                    } else{
                        System.out.println("Invalid input, try again");
                    }
                }
            }
            else{
                playerInput.nextLine(); //clear scanner
                System.out.println("Would you like to [move], [upgrade], [work]");
            }
        }
    }

    private void moveTo(Set destRoom) {
        /*
        this will need to check for valid rooms user can move into
        will also probably trigger stuff for undiscovered scenes
        */
    }

    private void upgradeRank() {
        /*
        needs to store ranks and their prices
        ask player how they want to pay, what rank they want
        change rank
        */
    }

    private void rehearse() {
        //give player rehearse counter
        //force to act if rehearse counters are max
    }

    private void act() {
        /*
        this will need to check if scene is wrapped after acting
        since Board class seems to contain board/scene info,
        wrapScene method is in there
        */
    }

    private void chooseRole() {
        //will need to make sure player can take role
        //will also let player work on role if they take it
    }

    public boolean isOnRole() {
        return onRole;
    }

    private void setDollars(int amount) {
        this.dollars = amount;
    }

    private void setCredits(int amount) {
        this.credits = amount;
    }

    private void setRank(int amount){
        this.rank = amount;
    }

    public int getDollars() {
        return dollars;
    }

    public int getCredits() {
        return credits;
    }

    public int getRank(){
        return rank;
    }

    public String printPlayerData(){
        return "Player "+playerNumber+
                " - Credits: "+credits+
                ", Dollars: "+dollars+
                ", Rank: "+rank;
                //print player location too
    }
}
