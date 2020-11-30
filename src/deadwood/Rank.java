package deadwood;

/**
 * Player HAS-A RankData
 * <p>
 * Tidy way of storing financial information for a player
 * Rank exists for each rank
 */
public class Rank {
    private int rankID;
    private int dollars;
    private int credits;
    private int score;

    public Rank(int rankID, int dollars, int credits) {
        this.rankID = rankID;
        this.dollars = dollars;
        this.credits = credits;
    }

    public int getRankID() {
        return rankID;
    }

    public void setRankID(int rankID) {
        this.rankID = rankID;
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

    public int setScore() {
        int score = 0;
        score += this.getDollars();
        score += this.getCredits();
        score += this.getRankID() * 5;
        return score;
    }

    public int getScore() {
        return this.score;
    }

}

