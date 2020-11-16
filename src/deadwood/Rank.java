package deadwood;

/**
 * Rank represents a given Rank in among us
 * There exists such ranks as Rank 1, Rank 2, etc.
 * Abstracted out a bit so things become more readable
 */
public class Rank {
    private int rankID;
    private int dollarCost;
    private int creditCost;

    public Rank() {

    }

    public Rank(int rankID, int dollarCost, int creditCost) {
        this.rankID = rankID;
        this.dollarCost = dollarCost;
        this.creditCost = creditCost;
    }

    public int getRankID() {
        return rankID;
    }

    public void setRankID(int rankID) {
        this.rankID = rankID;
    }

    public int getDollarCost() {
        return dollarCost;
    }

    public void setDollarCost(int dollarCost) {
        this.dollarCost = dollarCost;
    }

    public int getCreditCost() {
        return creditCost;
    }

    public void setCreditCost(int creditCost) {
        this.creditCost = creditCost;
    }


}
