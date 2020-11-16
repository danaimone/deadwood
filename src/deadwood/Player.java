package deadwood;

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
    public ArrayList<String> turnOptions;
    public ArrayList<Rank> rankOptions;
    public ArrayList<String> currencyOptions;

    // Stores information about currency
    private Rank rank;

    private int rehearsalTokens;
    private Decision playerDecision;
    private Role role;
    private Room currentRoom;
    private Scene currentScene;

    /**
     * Player Constructor
     * Sets up name, dollars, credits, rehearsal tokens, and rank.
     * The only variable parameter for the first construction of a Player
     * is the name. A player's current room always starts out in a trailer
     * in the game of Deadwood.
     *
     * A player can have at most 5 rank options at any given time.
     *
     * @param room            The trailer to set them in (this should always be a Room of type Trailer)
     * @param numberOfPlayers the number of players playing
     */
    public Player(int playerID, Room room, int numberOfPlayers, HashMap<Integer, Rank> availableRanks) {
        this.ID = playerID;
        this.rank = new Rank(0, 0, 0);
        this.rehearsalTokens = 0;
        setInitialRank(numberOfPlayers, availableRanks);
        setInitialCredits(numberOfPlayers);
        this.turnOptions = new ArrayList<>();
        this.rankOptions = new ArrayList<>(5);
        this.currencyOptions = new ArrayList<>(2);
        this.currentRoom = room;
    }

    public void setRank(Rank rank) {
        this.rank = rank;
    }

    /**
     * Sets a player's initial rank
     * <p>
     * When a player is created, their rank is first assigned based on the number of players.
     * This sets their rank accordingly.
     */
    public void setInitialRank(int numberOfPlayers, HashMap<Integer, Rank> availableRanks) {
        if (numberOfPlayers > 7) {
            Rank rank = availableRanks.get(2);
            setRank(rank);
        } else {
            Rank rank = availableRanks.get(1);
            setRank(rank);
        }
    }

    public Decision getPlayerDecision() {
        return playerDecision;
    }

    public void setPlayerDecision(Decision playerDecision) {
        this.playerDecision = playerDecision;
    }

    /*
        Getters
     */

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

    /**
     * Can Get Rank
     *
     * Checks to see if given Rank is identical in fields to this rank
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
        return this.currentRoom;
    }

    public void setCurrentRoom(Room currentRoom) {
        this.currentRoom = currentRoom;
    }

    /**
     * Set initial credits
     * <p>
     * Sets the initial credits based on the number of players playing the game.
     *
     * @param numberOfPlayers the number of players playing the game
     */
    public void setInitialCredits(int numberOfPlayers) {
        if (numberOfPlayers == 5) {
            setCredits(2);
        } else if (numberOfPlayers == 6) {
            setCredits(4);
        } else {
            setCredits(0);
        }
    }

    public Scene getCurrentScene() {
        assert currentScene != null;
        return currentScene;
    }

    public void setCurrentScene(Scene currentScene) {
        this.currentScene = currentScene;
    }


    /*
        Helper Functions for Player Data
     */
}



