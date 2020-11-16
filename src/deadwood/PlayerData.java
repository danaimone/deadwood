package deadwood;

/**
 * PlayerData
 * <p>
 * PlayerData represents each individual Player in a game of Deadwood.
 * There exists multiple PlayerDatas for the set of Players in Deadwood.
 */
public class PlayerData {
    private String name;
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
     * @param name The name of the new Player to create.
     */
    public PlayerData(String name) {
        this.name = name;
        this.dollars = 0;
        this.credits = 0;
        this.rehearsalTokens = 0;
        this.rank = 1;
        // aiming to have this currentRoom be a Trailer object
        // this.currentRoom = new Room();
    }

    /*
        Getters
     */

    /**
     * getName
     * Retrieves this players name
     *
     * @return String name this player's name
     */
    public String getName() {
        return this.name;
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

    public void setRole(Role role) {
        this.role = role;
    }

    public void setRehearsalTokens(int rehearsalTokens) {
        this.rehearsalTokens = rehearsalTokens;
    }

    public void setRank(int rank) {
        this.rank = rank;
    }

    public void setCurrentRoom(Room currentRoom) {
        this.currentRoom = currentRoom;
    }

    /*
        Helper Functions for Player Data
     */
}



