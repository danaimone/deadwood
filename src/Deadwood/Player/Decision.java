package Deadwood.Player;

public class Decision {
    private static Decision instance;
    private String decision;

    public Decision() {
        this.decision = "";
    }

    public Decision(String decision) {
        this.decision = decision.toLowerCase();
    }

    public static Decision getInstance() {
        if (instance == null) {
            instance = new Decision();
        }
        return instance;
    }

    String getDecision() {
        return decision;
    }

    public void setDecisionString(String decision) {
        this.decision = decision;
    }

    public boolean decisionsMatch(String option) {
        return (decision.toLowerCase().contains(option.toLowerCase()));
    }
}

