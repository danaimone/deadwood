package deadwood;

/**
 * Player
 * <p>
 * Player describes the actions available to an individual player in
 * their given turn of Deadwood.
 * <p>
 * This class makes all manipulation relating to a Player's turn
 */
public class PlayerController {
    Player player;
    PlayerInput playerInput;
    /* Actions (while my turn has not ended)*/
    private boolean canTakeARole; // can I move? can I act?
    private boolean canMove;
    private boolean canAct;
    private boolean canRehearse;
    private boolean canUpgrade;

    /* Constructor 'singleton'
     * TODO: might want to updatePlayer when the constructor is called, just to get everything set up
     * */
    PlayerController() {
        playerInput = new PlayerInput();
        setCanMove();
        setCanAct();
        setCanRehearse();
        setCanTakeRole();
        player.setWantsToEndTurn(false);
    }

    /**
     * Set can upgrade
     * Determine whether the player can upgrade, given
     * their current room. Essentially, this is checking that
     * their currentRoom is CastingOffice.
     *
     * @param canUpgrade
     */
    public void setCanUpgrade(boolean canUpgrade) {
        this.canUpgrade = (player.getCurrentRoom() instanceof CastingOffice);
    }

    /**
     * Update Player
     * <p>
     * Update a new Player for Player Controller
     * setCurrentPlayer is called after every person has a turn
     * consider whether you want to reset player wanting to end turn
     * This is essentially also ensuring that our Player Controller
     * has the current player at any given time.
     *
     * @param player PlayerData object to setup
     */
    void updatePlayerOptions(Player player) {
        this.player = player;
        setCanMove();
        setCanAct();
        setCanRehearse();
        setCanTakeRole();
    }

    /**
     * Set Can Rehearse
     * <p>
     * This function makes the determination of whether a given player can
     * rehearse in their turn.
     * <p>
     * Pre-conditions:
     * - player has a role, can't rehearse over maximum budget - 1
     * <p>
     * Post-conditions:
     * - player is able to rehearse
     * - player cannot act
     */
    private void setCanRehearse() {
        if (this.player.getRole() != null) {
            this.canRehearse = true;
            this.canAct = false;
        } else {
            this.canRehearse = false;
            this.canAct = true;
        }
    }

    /**
     * Set Can Move
     * <p>
     * This function makes the determination of whether a given player
     * can move in their turn.
     * <p>
     * Pre-conditions: player does not have a role
     * <p>
     * Invariant condition: player doesn't have role during turn
     * <p>
     * Post-condition: player can no longer move?
     */
    private void setCanMove() {
        // doesn't have role
        this.canMove = !player.isWorking();
    }

    /**
     * Set Can Act
     * <p>
     * This function makes the determination of whether a given player
     * can act in their turn.
     * <p>
     * Pre-condition:
     * - player has a role
     * <p>
     * Post-condition:
     * - player can either act or not act
     */
    private void setCanAct() {
        this.canAct = this.player.getRole() != null;
    }

    /**
     * Setter for canTakeRole
     * <p>
     * This function makes the determination of whether a given Player
     * can take a role, as well as whether a player can work on the role
     * if they take it.
     * <p>
     * Pre-condition:
     * - player does not have a role
     * - room that they are in is active/roles available
     * <p>
     * Post-condition:
     * - player can either take a role or not take a role
     */
    private void setCanTakeRole() {
        canTakeARole = this.player.getRole() == null &&
                player.getCurrentRoom().isActive;
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
    public void determinePlayerTurnOptions(Player player) {
        player.turnOptions.add("End Turn");
        Scene playersCurrentScene = player.getCurrentScene();
        if (player.getCurrentRoom() instanceof CastingOffice) {
            player.turnOptions.add("Upgrade Rank");
        }

        if (!player.isWorking()) {
            player.turnOptions.add("Move (opt.)");
            player.turnOptions.add("Take a role (opt.)");
        } else {
            player.turnOptions.add("Act");
            if (player.getRehearsalTokens() < playersCurrentScene.getBudget()) {
                player.turnOptions.add("Rehearse");
            }
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
     *
     * @param player the given player to take care of
     */
    void handleDecision(Player player) {
        Decision playerDecision = player.getPlayerDecision();
        String decision = playerDecision.getDecision();
        while (!player.wantsToEndTurn() || decision.contains("End")) {
            if (!player.isWorking()) {
                if (decision.contains("Upgrade") && canUpgrade) {
                    // upgrade();
                    // TODO: how do we make the consideration of upgrading before
                    //       or after a move?
                    //
                }

                if (decision.contains("Move") && canMove) {
                    canAct = false;
                    canTakeARole = false;
                    canRehearse = false;
                    // move();
                }

                if (decision.contains("Role") && canTakeARole) {
                    // takeARole();
                }
            } else if (player.isWorking()) {
                if (decision.contains("Act") && canAct) {
                    // act();
                } else if (decision.contains("Rehearse") && canRehearse) {
                    // rehearse();
                }
            }
        }
        player.setWantsToEndTurn(true);
    }


    /**
     * Perform Turn
     */
//    void performTurn() {
//        // here's the deal:
//        // if you choose you want to move  you're going to be updating other variables
//        // if you choose to move you can't do acting
//        // what do we display? can they move? can they act? can they rehearse?
//        // show player what they can do
//        // get there input
//        // do whatever they chose
//        // prompt again (or end turn!)
//        // figure out moves they can make
//
//        // How do we prompt these choices?
//        boolean chooseMove = false;
//        boolean chooseAct = false;
//        boolean chooseRehearse = false;
//        boolean chooseTakeARole = false;
//
//        getUserInput(); // set all the booleans above, they select an option
//
//        while (!player.wantsToEndTurn()) {
//            if (canMove && chooseMove) {
//                canTakeARole = true;
//                canAct = false;
//                canRehearse = false;
//                move();
//            } else if (canAct && chooseAct) {
//                canAct = true;
//                canTakeARole = false;
//
//            } else if (canRehearse) { // they rehease
//
//            } else if (canTakeARole && chooseTakeARole) { // they take a role
//                this.canTakeARole = false;
//            } else { // they choose to end turn
//
//            }
//        }
//    }
    private void moveTo(Room destRoom) {
        /*
        this will need to check for valid rooms user can move into
        will also probably trigger stuff for undiscovered scenes
        */
    }


}
