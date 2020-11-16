package deadwood;

/**
 * Player HAS-A RankData
 * <p>
 * Tidy way of storing financial information for a player
 * Rank exists for each rank
 */
public class Rank {
    public int getRankID() {
        return rankID;
    }

    public void setRankID(int rankID) {
        this.rankID = rankID;
    }

    private int rankID;
    private int dollars;
    private int credits;

    public Rank(int rankID, int dollars, int credits) {
        this.rankID = rankID;
        this.dollars = dollars;
        this.credits = credits;
    }

    public int getDollars() {
        return dollars;
    }

    public void setDollars(int dollars) {
        this.dollars = dollars;
    }

    public int getCredits() {
        return credits;
    }

    public void setCredits(int credits) {
        this.credits = credits;
    }

}
