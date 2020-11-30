package Deadwood.Player;

import Deadwood.Board.BoardController;
import Deadwood.Rank;
import Deadwood.Role;
import Deadwood.Room.Room;
import Deadwood.SceneCard;

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
    private final ArrayList<Rank> rankOptions;
    public ArrayList<String> turnOptions;
    public ArrayList<String> currencyOptions;
    public Rank rank;
    // TODO: Reset back to ArrayList? K/V doesn't really fit, but it is quick.
    private ArrayList<String> roomOptions;
    private int rehearsalTokens;
    private Role role;
    private Room currentRoom;
    private SceneCard currentSceneCard;

    private boolean isTurn;
    private boolean hasUpgraded;
    private boolean hasMoved;
    private boolean hasTakenRole;
    private boolean forceEndTurn;
    private boolean hasRehearsed;
    private boolean hasWorked;

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
        this.turnOptions = new ArrayList<>();
        this.rankOptions = new ArrayList<>(5);
        this.roomOptions = new ArrayList<>(8);
        this.currencyOptions = new ArrayList<>(2);
        this.currentRoom = BoardController.getInstance().getRoom("Trailer");
    }

    /* Bool Setters and Getters */
    public boolean isHasUpgraded() {
        return hasUpgraded;
    }

    public void setHasUpgraded(boolean hasUpgraded) {
        this.hasUpgraded = hasUpgraded;
    }

    public boolean isHasMoved() {
        return hasMoved;
    }

    public void setHasMoved(boolean hasMoved) {
        this.hasMoved = hasMoved;
    }

    public boolean isHasTakenRole() {
        return hasTakenRole;
    }

    public void setHasTakenRole(boolean hasTakenRole) {
        this.hasTakenRole = hasTakenRole;
    }

    public boolean isForceEndTurn() {
        return forceEndTurn;
    }

    public void setForceEndTurn(boolean forceEndTurn) {
        this.forceEndTurn = forceEndTurn;
    }

    public boolean isHasRehearsed() {
        return hasRehearsed;
    }

    public void setHasRehearsed(boolean hasRehearsed) {
        this.hasRehearsed = hasRehearsed;
    }

    public boolean isHasWorked() {
        return hasWorked;
    }

    public void setHasWorked(boolean hasWorked) {
        this.hasWorked = hasWorked;
    }

    /* Bool Helper Functions */
    public void updateBools() {
        isTurn = !this.isTurn;
        hasUpgraded = false;
        hasMoved = false;
        hasTakenRole = false;
        forceEndTurn = false;
        hasRehearsed = false;
        hasWorked = false;
    }

    /* Regular Getters and Setters */

    public ArrayList<Rank> getRankOptions() {
        return rankOptions;
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



