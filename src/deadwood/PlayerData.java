package deadwood;

/**
 * PlayerData
 *
 * PlayerData represents multiple Players in a game of Deadwood.
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

    // Constructor
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
    public String getName() {
        return name;
    }

    public int getDollars() {
        return dollars;
    }

    public int getCredits() {
        return credits;
    }

    public int getRank() {
        return rank;
    }

    /**
     *
     * @return null if role not available
     */
    public Role getRole() {
        return role;
    }

    public int getRehearsalTokens() {
        return rehearsalTokens;
    }

    public Room getCurrentRoom() {
        return currentRoom;
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



