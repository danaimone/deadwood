package deadwood;

public class DeadwoodPrinter {
    protected void askPlayers(){
        System.out.println("How many players? (2-8)");
    }
    protected void invalidPlayers(){
        System.out.println("Please enter a valid number of players");
    }
    protected void whoseTurn(PlayerController playerController){
        System.out.println("It is Player "+ playerController.getPlayerNumber() +"'s turn");
    }
    protected void working(){
        System.out.println("Would you like to [act] or [rehearse]? Or player [info]");
    }
    protected void notMoveNotUpgrade(){
        System.out.println("Would you like to [move], [upgrade], [work], [skip]? Or player [info]");
    }
    protected void moveNotUpgrade(){
        System.out.println("Would you like to [upgrade], [work], [skip]? Or player [info]");
    }
    protected void notMoveUpgrade(){
        System.out.println("Would you like to [move], [work], [skip]? Or player [info]");
    }
    protected void moveUpgrade(){
        System.out.println("Would you like to [work], [skip]? Or player [info]");
    }
    protected void ranksList(){
        System.out.printf("%nRank 2: 4 Dollars OR 5 Credits%nRank 3: 10 Dollars OR 10 Credits%nRank 4: 18 Dollars OR 15 Credits%nRank 5: 28 Dollars OR 20 Credits%nRank 6: 40 Dollars OR 25 Credits%n");
    }
    protected void askRank(){
        System.out.printf("%nWhich rank would you like to upgrade to? [2], [3]...[6]. Or go [back]%n");
    }
    protected void invalidRank(String input){
        System.out.println("You cannot go to rank "+input+", try again");
    }
    protected void invalid(){
        System.out.println("Invalid entry, try again");
    }
    protected void payment(){
        System.out.println("Would you like to pay with [credits] or [dollars]?");
    }
    protected void rankSuccess(String input){
        System.out.println("You are now rank " + input);
        System.out.println();
    }
    protected void rankFail(String type){
        System.out.println("Rank not upgraded, not enough " + type);
        System.out.println();
    }
}
