package deadwood;

/**
 * PlayerData
 * <p>
 * PlayerData represents each individual Player in a game of Deadwood.
 * There exists multiple PlayerDatas for the set of Players in Deadwood.
 */
public class Player {
    private int ID;
    //    private int playerNumber;
    private int dollars;
    private int credits;
    private int rehearsalTokens;
    private int rank;


    private Role role;
    private Room currentRoom;


    /**
     * PlayerData Constructor
     * Sets up name, dollars, credits, rehearsal tokens, and rank.
     * The only variable parameter for the first construction of a Player
     * is the name. A player's current room always starts out in a trailer
     * in the game of Deadwood.
     *
     * @param name            The name of the new Player to create.
     * @param room            The trailer to set them in (this should always be a Room of type Trailer)
     * @param numberOfPlayers the number of players playing
     */
    public Player(int playerID, Room room, int numberOfPlayers) {
        this.ID = playerID;
        this.dollars = 0;
        this.rehearsalTokens = 0;
        setInitialRank(numberOfPlayers);
        setInitialCredits(numberOfPlayers);
        this.currentRoom = room;
    }

    /*
        Getters
     */

    /**
     * get
     * Retrieves this players name
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
        return this.dollars;
    }

    /**
     * getCredits
     * Retrieves this players credits
     *
     * @return int credits this players credits
     */
    public int getCredits() {
        return this.credits;
    }

    /**
     * getRank
     * Retrieves this players current rank
     *
     * @return int rank this players current rank
     */
    public int getRank() {
        return this.rank;
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

    /**
     * getRehearsalTokens
     * Retrieves this players current rehearsal tokens.
     *
     * @return int rehearsalTokens current amount of rehearsal tokens
     */
    public int getRehearsalTokens() {
        return this.rehearsalTokens;
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

    /*
        Setters
     */
    public void setName(String name) {
        this.name = name;
    }

    public void setDollars(int dollars) {
        this.dollars = dollars;
    }


    public void setCredits(int credits) {
        this.credits = credits;
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

    public void setRole(Role role) {
        this.role = role;
    }

    public void setRehearsalTokens(int rehearsalTokens) {
        this.rehearsalTokens = rehearsalTokens;
    }

    /**
     * Sets a player's initial rank
     * <p>
     * When a player is created, their rank is first assigned based on the number of players.
     * This sets their rank accordingly.
     */
    public void setInitialRank(int numberOfPlayers) {
        if (numberOfPlayers > 7) {
            setRank(2);
        } else {
            setRank(1);
        }
    }

    /**
     * Set Rank
     * <p>
     * Setter for rank
     *
     * @param rank rank to set to
     */
    private void setRank(int rank) {
        this.rank = rank;
    }

    public void setCurrentRoom(Room currentRoom) {
        this.currentRoom = currentRoom;
    }

    /*
        Helper Functions for Player Data
     */
}



