package deadwood.Player;

import deadwood.DeadwoodLogger;
import deadwood.Printer.DeadwoodPrinter;
import deadwood.Rank;
import deadwood.RankController;
import deadwood.Room.CastingOffice;
import deadwood.Room.Room;
import deadwood.SceneCard;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

/**
 * Player
 * <p>
 * Player describes the actions available to an individual player in
 * their given turn of Deadwood.
 * <p>
 * This class makes all manipulation relating to a Player's turn
 */
public class PlayerController {
    private static PlayerController playerController = null;
    private final PlayerInput playerInput = PlayerInput.getInstance();
    RankController rankController = new RankController();
    HashMap<Integer, Rank> availableRanks = rankController.getAvailableRanks();
    private Player currentPlayer;


    /*
     * Constructor 'singleton'
     *
     * A Player Controller should really only be made at the beginning of program
     * operation, thus these should be the assumed rules given that a player
     * starts out at the Trailers.
     *
     */
    public PlayerController() {
    }

    public static PlayerController getInstance() {
        if (playerController == null) {
            playerController = new PlayerController();
        }
        return playerController;
    }

    public Player getCurrentPlayer() {
        return currentPlayer;
    }

    public void setCurrentPlayer(Player currentPlayer) {
        this.currentPlayer = currentPlayer;
    }

    public PlayerInput getPlayerInput() {
        return playerInput;
    }

    /**
     * Determine Player Turn Options
     * <p>
     * Determines the available options for a player to make for the printer to handle and display.
     * and is stored within the Players data.
     * <p>
     * No matter what, the player can upgrade rank before or after they move.
     * Otherwise, a player can either move and/or take a role if they are not working.
     * If they are working, they can only Act or Rehearse, and they can only Rehearse if
     * they have less Rehearsal Tokens than the budget.
     */
    public void determinePlayerTurnOptions() {
        currentPlayer.turnOptions.clear();
        currentPlayer.turnOptions.add("End Turn");
        Room currentRoom = currentPlayer.getCurrentRoom();
        SceneCard playersCurrentSceneCard = currentPlayer.getCurrentScene();
        if (!currentPlayer.isWantsToEndTurn()) {
            if (currentRoom instanceof CastingOffice) {
                currentPlayer.turnOptions.add("Upgrade Rank");
            }
            if (!currentPlayer.isHasWorked()) {
                if (!currentPlayer.isHasMoved())
                    currentPlayer.turnOptions.add("Move");
                if (!currentPlayer.isHasTakenRole())
                    currentPlayer.turnOptions.add("Take a role");
            } else {
                currentPlayer.turnOptions.add("Act");
                if (currentPlayer.getRehearsalTokens() < playersCurrentSceneCard.getBudget()) {
                    currentPlayer.turnOptions.add("Rehearse");
                }
            }
        }
    }

    /**
     * Update rank options
     * <p>
     * This function determines a players rank options at any given point in the game.
     * <p>
     * For each available rank in the Hashmap, get the Rank.
     * If it is the same rank (they have the exact same attributes), the player's rank options
     * has that Rank added.
     */
    public void updateRankOptions() {
        Rank currentRank = currentPlayer.getRank();
        for (Map.Entry<Integer, Rank> entry : availableRanks.entrySet()) {
            Rank rank = entry.getValue();
            if (currentPlayer.canGetRank(currentRank)) {
                currentPlayer.getRankOptions().add(rank);
            }
        }
    }


    void determineCurrencyOptions(Player player) {
        if (player.getRankOptions().contains(2)) {

        }
    }

    /**
     * Handle Decision
     * <p>
     * Handle decision handles a given players decision, given
     * the state of whether they are able to make that decision in the first place.
     * <p>
     * If the player is not working, they can move or take a role.
     * A player may also upgrade before or after their move if they are in the casting
     * office.
     * <p>
     * If a player is working, they must either act or rehearse.
     * <p>
     * The boolean can checks act as safe guards to make sure a player isn't able
     * to do any move they are not allowed to.
     */
    public void handleDecision(String decision) {
        switch (decision) {
            case "Upgrade":
                boolean hasUpgraded = false;
                while (!hasUpgraded) {
                    // GUI upgrade rank
                    upgrade();
                }
                break;
            case "Move":
                move();
                break;
            case "Take Role":
                 takeRole();
                 break;
            case "Act":
                // act();
                break;
            case "Rehearse":
                //rehearse();
                break;
            case "End Turn":
                endTurn();
                break;
        }
    }

    private void takeRole() {
    }

    private void move() {
        currentPlayer.updateRoomOptions();
        DeadwoodPrinter printer = DeadwoodPrinter.getInstance();
        ArrayList<String> roomOptions = currentPlayer.getRoomOptions();

        printer.printRoomOptions();
        printer.printMovePrompt();

        Decision decision = playerInput.getMoveInput();
        while (!containsIgnoreCase(decision.getDecision(), roomOptions)) {
            if (!containsIgnoreCase(playerInput.inputDecision.getDecision(), roomOptions)) {
                System.out.println("You entered an invalid choice. Please try again.");
                System.out.print("> ");
                DeadwoodLogger.logInfo(decision.getDecision());
                printer.printRoomOptions();
            }
            playerInput.getMoveInput();
        }

        moveTo(decision.getDecision());
        System.out.println("You've been moved to the " + decision.getDecision() + ".");
        currentPlayer.setHasMoved(true);
    }

    public void endTurn() {
        currentPlayer.setEndTurn(true);
    }

    public boolean containsIgnoreCase(String str, ArrayList<String> list) {
        for (String i : list) {
            if (i.equalsIgnoreCase(str))
                return true;
        }
        return false;
    }

    /**
     * Perform upgrade
     * <p>
     * TODO: are we just..deciding for the player whether they would like to use
     * their credits or cash?
     * Rank Chart:
     * Rank 2: 4 dollars or 5 credits
     * Rank 3: 10 dollars or 10 credits
     * Rank 4: 18 dollars or 15 credits
     * Rank 5: 28 dollars or 20 credits
     * Rank 6: 40 dollars 25 credits
     * <p>
     * For each possible Rank option in the players given options,
     * if the player
     */
    private void upgrade() {
        DeadwoodPrinter printer = new DeadwoodPrinter();
        int rankChoice = playerInput.getPlayerUpgradeInput(this);
        Rank chosenRank = availableRanks.get(rankChoice);
//        String currencyChoice = playerInput.getCurrencyChoice(player);
        int currentDollars = currentPlayer.getDollars();
        int currentCredits = currentPlayer.getCredits();

        printer.printUpgradeCase();
        int enteredDollars = playerInput.getDollarInput(this, printer);
        int enteredCredits = playerInput.getCreditInput(this, printer);

        int dollarDifference = currentDollars - enteredDollars;
        int creditDifference = enteredCredits - currentCredits;

        if (!(dollarDifference < 0 || creditDifference < 0)) { // ensuring no overflow
            setRank(chosenRank, enteredDollars, enteredCredits);
            // TODO: we could maybe make some edge case considerations if a user
            // provides too much, but this is easier for now
        }

        currentPlayer.setHasUpgraded(true);
    }

    public void setRank(Rank rank, int dollar, int credit) {
        currentPlayer.setDollars(currentPlayer.getDollars() - dollar);
        currentPlayer.setCredits(currentPlayer.getCredits() - credit);
        currentPlayer.setRank(rank);
    }

    private void moveTo(String destRoom) {
        currentPlayer.setCurrentRoom(destRoom);
        /*
        this will need to check for valid rooms user can move into
        will also probably trigger stuff for undiscovered scenes
        */
    }
}
