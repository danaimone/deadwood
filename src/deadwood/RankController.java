package deadwood;

import java.util.HashMap;

/**
 * Rank Controller controls
 * the base available ranks and how the ranking system is set up for upgrading.
 * Using a Cost for a Key value allows a smarter road map for setting up rank functionality,
 * or at least I hope.
 */
public class RankController {

    public HashMap<Integer, Rank> availableRanks = new HashMap<>();

    public RankController() {
        buildRankList();
    }

    private void buildRankList() {
        availableRanks.put(2, new Rank(2, 4, 5));
        availableRanks.put(3, new Rank(3, 10, 10));
        availableRanks.put(4, new Rank(4, 18, 15));
        availableRanks.put(5, new Rank(5, 28, 20));
        availableRanks.put(6, new Rank(6, 40, 25));
    }

    public HashMap<Integer, Rank> getAvailableRanks() {
        return availableRanks;
    }

    public void setAvailableRanks(HashMap<Integer, Rank> availableRanks) {
        this.availableRanks = availableRanks;
    }
}
