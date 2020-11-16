package deadwood;

/**
 * This is the main driving class for the entire game of Deadwood.
 */
public class Deadwood {
    /**
     * In driving the game of Deadwood, a Gamemaster is set up for base control.
     * Play is invoked on by the Gamemaster.
     *
     * @param args
     */
    public static void main(String[] args) {
        DeadwoodPrinter printer = new DeadwoodPrinter();
        Gamemaster game = new Gamemaster(printer);
        String gameWinner = game.playDeadwood();
        printer.printWinner(gameWinner);
    }
}
//    public static void alt_main(String[] args) {
//        Gamemaster game = new Gamemaster(); //create the game!
//        DeadwoodPrinter printer = new DeadwoodPrinter(); //create the printer
//        scanner = new Scanner(System.in); //global scanner for user inputted
//
//        /*
//        setup board
//        make a while loop to cycle through players turns until 1 scene card is left
//        */
//
//        BoardXMLParser parseXML = new BoardXMLParser();
//
//        /*
//        //read board data
//        Document boardDoc = null;
//        try{
//            boardDoc = test.getDocFromFile("src/xml/board.xml");
//            test.readBoardData(boardDoc);
//        }
//        catch (Exception e){
//            System.out.println("Error = "+e);
//        }
//        */
//
//        //read and store scene card data
//        Document cardDoc = null;
//        try {
//            cardDoc = parseXML.getDocFromFile("src/xml/cards.xml");
//            game.sceneCards = parseXML.readCardData(cardDoc);
//        } catch (Exception e) {
//            System.out.println("Error" + e);
//        }
//        Collections.shuffle(game.sceneCards); //shuffles the scene cards
//
//        /*
//        This reads data out from each scene card and its roles
//        for(int i = 0; i < game.sceneCards.size(); i++){
//            Scene sceneTest = game.sceneCards.get(i);
//            sceneTest.printSceneInfo();
//            for(int j = 0; j < sceneTest.roles.size(); j++){
//                Role roleTest = sceneTest.roles.get(j);
//                roleTest.printRoleData();
//            }
//        }
//        */
//
//
//        //actual game!
//        //ask for amount of players (maybe more error tests?)
//        game.numberOfPlayers = 0;
//        while (game.numberOfPlayers < 2 || game.numberOfPlayers > 8) {
//            printer.askPlayers();
//            game.numberOfPlayers = input.nextInt();
//            if (game.numberOfPlayers < 2 || game.numberOfPlayers > 8) {
//                printer.invalidPlayers();
//            }
//        }
//
//        game.createPlayers();
//        input.nextLine(); //clear scanner
//        //while board has more than one scene card
//        while (true) {
//            PlayerController current = game.currentPlayerController;
//            printer.whoseTurn(game.currentPlayerController);
//            String turnResult = current.performTurn(input, printer);
//            if (turnResult.equals("next")) {
//                int playerId = current.getPlayerNumber();
//                if (playerId == game.numberOfPlayers) {
//                    game.currentPlayerController = game.playerControllers.get(0);
//                } else {
//                    game.currentPlayerController = game.playerControllers.get(playerId);
//                }
//            }
//        }
//    }
