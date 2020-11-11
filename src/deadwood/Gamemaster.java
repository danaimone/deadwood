package deadwood;

import java.util.*;

public class Gamemaster {
    protected Board board;
    protected Player currentPlayer;
    protected boolean boardRandom; //false is default layout, true is randomized layout
    protected int maxGameDays; //how many days the game lasts
    protected int numberOfPlayers;
    protected ArrayList<Player> players = new ArrayList<Player>(); //stores all the players and their data

    /*
        main method that starts the game
    */
    public static void main(String[] args){
        Gamemaster game = new Gamemaster(); //create the game!
        DeadwoodPrinter printer = new DeadwoodPrinter(); //create the printer
        Scanner input = new Scanner(System.in); //global scanner for user inputed

        /*
        setup board
        make a while loop to cycle through players turns until 1 scene card is left
        */
        
        XMLParser test = new XMLParser();

        /*
        //read board data
        Document boardDoc = null;
        try{
            boardDoc = test.getDocFromFile("src/xml/board.xml");
            test.readBoardData(boardDoc);
        }
        catch (Exception e){
            System.out.println("Error = "+e);
        }
        */

        /*
        //read card data
        Document cardDoc = null;
        try{
            cardDoc = test.getDocFromFile("src/xml/cards.xml");
            test.readCardData(cardDoc);
        }
        catch (Exception e){
            System.out.println("Error"+e);
        }
        */

        
        //ask for amount of players (maybe more error tests?)
        game.numberOfPlayers = 0;
        while(game.numberOfPlayers < 2 || game.numberOfPlayers > 8){
            printer.askPlayers();
            game.numberOfPlayers = input.nextInt();
            if(game.numberOfPlayers < 2 || game.numberOfPlayers > 8){
                printer.invalidPlayers();
            }
        }
        
        game.createPlayers();
        input.nextLine(); //clear scanner
        //while board has more than one scene card
        while(true){
            Player current = game.currentPlayer;
            printer.whoseTurn(game.currentPlayer);
            String turnResult = current.playersTurn(input, printer);
            if(turnResult.equals("next")){
                int playerId = current.playerNumber;
                if(playerId == game.numberOfPlayers){
                    game.currentPlayer = game.players.get(0);
                    //printer.whoseTurn(game.currentPlayer);
                }
                else{
                    game.currentPlayer = game.players.get(playerId);
                    //printer.whoseTurn(game.currentPlayer);
                }
            }
        }
        
    }

    private int calculateScore(Player player) {
        // TODO: implement calculateScore
        return 0;
    }

    private void endGame() {
        // TODO: implement endGame
    }

    private Player calculateWinner() {
        // TODO: implement calculateWinner
        return null;
    }

    private void displayWinner(Player winner) {
        // TODO: implement displayWinner
    }

    private void setBoardLayout(){
        // TODO: implement setBoardLayout()
        //ask user if board should be default or randomized
        //create board layout, default or random
    }

    private void createPlayers(){
        
        //create players with stats accordingly
        int startingCredits = 0;
        int startingRank = 0;
        if(numberOfPlayers <= 3){
            maxGameDays = 3;
        } else if(numberOfPlayers == 4){
            maxGameDays = 4;
        } else if(numberOfPlayers == 5){
            maxGameDays = 4;
            startingCredits = 2;
        } else if(numberOfPlayers == 6){
            maxGameDays = 4;
            startingCredits = 4;
        } else{
            maxGameDays = 4;
            startingRank = 2;
        }
        for(int i = 1; i <= numberOfPlayers; i++){
            Player newPlayer = new Player(i, 0, startingCredits, startingRank);
            players.add(newPlayer);
        }
        for(int i = 0; i < numberOfPlayers; i++){
            Player current = players.get(i);
            String print = current.printPlayerData();
            System.out.println(print);
        }

        //player 1 goes first cause that's easiest
        currentPlayer = players.get(0);
    }
}
