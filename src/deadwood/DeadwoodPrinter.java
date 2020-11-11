package deadwood;

public class DeadwoodPrinter extends Gamemaster{
    protected void askPlayers(){
        System.out.println("How many players? (2-8)");
    }
    protected void invalidPlayers(){
        System.out.println("Please enter a valid number of players");
    }
    protected void whoseTurn(Player player){
        System.out.println("It is Player "+player.playerNumber+"'s turn");
    }
    protected void working(){
        System.out.println("Would you like to [act] or [rehearse]? Or player [info]");
    }
    protected void notMoveNotUpgrade(){
        System.out.println("Would you like to [move], [upgrade], [work]? Or player [info]");
    }
    protected void moveNotUpgrade(){
        System.out.println("Would you like to [upgrade], [work]? Or player [info]");
    }
    protected void notMoveUpgrade(){
        System.out.println("Would you like to [move], [work]? Or player [info]");
    }
    protected void moveUpgrade(){
        System.out.println("Would you like to [work]? Or player [info]");
    }
}
