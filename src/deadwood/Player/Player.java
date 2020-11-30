package deadwood.Player;

import deadwood.Board.BoardController;
import deadwood.*;

import java.util.ArrayList;
import java.util.HashMap;

/**
 * PlayerData
 * <p>
 * PlayerData represents each individual Player in a game of Deadwood.
 * There exists multiple PlayerDatas for the set of Players in Deadwood.
 */
public class Player {
    private final int ID;
    public HashMap<String, Boolean> turnOptions;
    private ArrayList<Rank> rankOptions;
    public ArrayList<String> currencyOptions;
    // Stores information about currency
    public Rank rank;
    // TODO: Reset back to ArrayList? K/V doesn't really fit, but it is quick.
    private ArrayList<String> roomOptions;
    private int rehearsalTokens;
    private Role role;
    private Room currentRoom;
    private SceneCard currentSceneCard;
    /*
        Bools
     */
    private boolean canTakeARole; // can I move? can I act?
    private boolean canMove;
    private boolean canAct;
    private boolean canRehearse;
    private boolean wantsToEndTurn;
    private boolean isWorking;
    private boolean hasTakenRole;
    private boolean canUpgrade;
    private boolean canUpgradeWithDollars;
    private boolean canUpgradeWithCredits;

    /**
     * Player Constructor
     * Sets up name, dollars, credits, rehearsal tokens, and rank.
     * The only variable parameter for the first construction of a Player
     * is the name. A player's current room always starts out in a trailer
     * in the game of Deadwood. A Player always starts out in the Trailer room.
     * <p>
     * A player can have at most 5 rank options at any given time.
     *
     * @param numberOfPlayers the number of players playing
     */
    public Player(int playerID, int numberOfPlayers, HashMap<Integer, Rank> availableRanks) {
        this.ID = playerID;
        this.rehearsalTokens = 0;
        this.rank = setInitialRank(numberOfPlayers, availableRanks);
        this.rank.setCredits(setInitialCredits(numberOfPlayers));
        this.turnOptions = new HashMap<>();
        this.rankOptions = new ArrayList<>(5);
        this.roomOptions = new ArrayList<>(8);
        this.currencyOptions = new ArrayList<>(2);
        this.currentRoom = BoardController.getInstance().getRoom("Trailer");

        this.canMove = true;
        this.canAct = true;
        this.canTakeARole = true;
        this.canRehearse = false;
        this.canUpgrade = false;
    }

    public ArrayList<Rank> getRankOptions() {
        return rankOptions;
    }

    public void setRankOptions(ArrayList<Rank> rankOptions) {
        this.rankOptions = rankOptions;
    }

    public boolean isCanUpgrade() {
        return canUpgrade;
    }

    public void setCanUpgrade(boolean canUpgrade) {
        this.canUpgrade = canUpgrade;
    }

    public boolean canUpgradeWithDollars() {
        return canUpgradeWithDollars;
    }

    public void setCanUpgradeWithDollars(boolean canUpgradeWithDollars) {
        this.canUpgradeWithDollars = canUpgradeWithDollars;
    }

    public boolean canUpgradeWithCredits() {
        return canUpgradeWithCredits;
    }

    public void setCanUpgradeWithCredits(boolean canUpgradeWithCredits) {
        this.canUpgradeWithCredits = canUpgradeWithCredits;
    }

    /**
     * Set can upgrade
     * Determine whether the player can upgrade, given
     * their current room. Essentially, this is checking that
     * their currentRoom is CastingOffice.
     */
    public void setCanUpgrade() {
        this.canUpgrade = currentRoom instanceof CastingOffice;
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
    void setCanRehearse() {
        if (getRole() != null) {
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
    void setCanMove() {
        // doesn't have role
        this.canMove = !isWorking();
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
    void setCanAct() {
        this.canAct = this.getRole() != null;
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
    void setCanTakeRole() {
        canTakeARole = this.getRole() == null &&
                currentRoom.isActive;
    }

    public boolean wantsToEndTurn() {
        return wantsToEndTurn;
    }

    public boolean isWorking() {
        return isWorking;
    }

    public void setWorking(boolean working) {
        this.isWorking = working;
    }

    public void setWantsToEndTurn(boolean wantsToEndTurn) {
        this.wantsToEndTurn = wantsToEndTurn;
    }


    public boolean isCanTakeARole() {
        return canTakeARole;
    }

    public void setCanTakeARole(boolean canTakeARole) {
        this.canTakeARole = canTakeARole;
    }

    public boolean isCanMove() {
        return canMove;
    }

    public void setCanMove(boolean canMove) {
        this.canMove = canMove;
    }

    public boolean isCanAct() {
        return canAct;
    }

    public void setCanAct(boolean canAct) {
        this.canAct = canAct;
    }

    public boolean isCanRehearse() {
        return canRehearse;
    }

    public void setCanRehearse(boolean canRehearse) {
        this.canRehearse = canRehearse;
    }

    /**
     * Sets a player's initial rank
     * <p>
     * When a player is created, their rank is first assigned based on the number of players.
     * This sets their rank accordingly.
     */
    public Rank setInitialRank(int numberOfPlayers, HashMap<Integer, Rank> availableRanks) {
        Rank initialRank = new Rank(1, 0, 0);
        if (numberOfPlayers > 7) {
            initialRank = availableRanks.get(2);
        }
        return initialRank;
    }

    /**
     * getId
     * Retrieves this players ID
     *
     * @return int ID this player's ID
     */
    public int getID() {
        return this.ID;
    }

    /*
        Getters
     */

    /**
     * getDollars
     * Retrieves this players dollars
     *
     * @return int this players dollars
     */
    public int getDollars() {
        return this.rank.getDollars();
    }

    public void setDollars(int dollars) {
        this.rank.setDollars(dollars);
    }

    /**
     * getCredits
     * Retrieves this players credits
     *
     * @return int credits this players credits
     */
    public int getCredits() {
        return this.rank.getCredits();
    }

    public void setCredits(int credits) {
        this.rank.setCredits(credits);
    }

    /**
     * getRank
     * Retrieves this players current rank
     *
     * @return int rank this players current rank
     */
    public Rank getRank() {
        return this.rank;
    }

    public void setRank(Rank rank) {
        this.rank = rank;
    }

    /**
     * Can Get Rank
     * <p>
     * Checks to see if given Rank is identical in fields to this rank
     *
     * @param rankToCompare rank to compare
     * @return true if they are identical, false otherwise
     */
    public boolean canGetRank(Rank rankToCompare) {
        return this.rank.getRankID() == rankToCompare.getRankID() &&
                this.rank.getDollars() > rankToCompare.getDollars() &&
                this.rank.getCredits() > rankToCompare.getCredits();
    }

    /**
     * getRole
     * Retrieves this players current role
     *
     * @return Role currentRole or null if role not available
     */
    public Role getRole() {
        if (this.role != null) {
            return null;
        } else {
            return this.role;
        }
    }

    public void setRole(Role role) {
        this.role = role;
    }

    public boolean hasRole() {
        return this.role != null;
    }

    /**
     * getRehearsalTokens
     * Retrieves this players current rehearsal tokens.
     *
     * @return int rehearsalTokens current amount of rehearsal tokens
     */
    public int getRehearsalTokens() {
        return this.rehearsalTokens;
    }

    public void setRehearsalTokens(int rehearsalTokens) {
        this.rehearsalTokens = rehearsalTokens;
    }

    /**
     * getCurrentRoom
     * Retrieves the current Room that player is in
     *
     * @return Room currentRoom this players current room
     */
    public Room getCurrentRoom() {
        if (this.currentRoom == null) {
            setCurrentRoom("Trailer");
        }
        return this.currentRoom;
    }

    public void setCurrentRoom(String room) {
        this.currentRoom = BoardController.getInstance().getRoom(room);
    }

    /**
     * Set initial credits
     * <p>
     * Sets the initial credits based on the number of players playing the game.
     *
     * @param numberOfPlayers the number of players playing the game
     */
    public int setInitialCredits(int numberOfPlayers) {
        if (numberOfPlayers == 5) {
            return 2;
        } else if (numberOfPlayers == 6) {
            return 4;
        } else {
            return 0;
        }
    }

    public SceneCard getCurrentScene() {
        assert currentSceneCard != null;
        return currentSceneCard;
    }

    public void setCurrentScene(SceneCard currentSceneCard) {
        this.currentSceneCard = currentSceneCard;
    }

    public void updateRoomOptions() {
        ArrayList<String> adjacentRooms = currentRoom.getAdjacentRooms();
        getRoomOptions().addAll(adjacentRooms);
    }

    public ArrayList<String> getRoomOptions() {
        return this.roomOptions;
    }

    public void setRoomOptions(ArrayList<String> rooms) {
        this.roomOptions = rooms;
    }

}



