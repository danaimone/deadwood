package deadwood;

/**
 * Represents a Players decision in an instance
 */
public class Decision {
    private static Decision decisionInstance;
    private String decision;

    public Decision() {
        this.decision = "";
    }

    public Decision(String decision) {
        this.decision = decision;
    }

    public static Decision getDecisionInstance() {
        if (decisionInstance == null) {
            decisionInstance = new Decision();
        }
        return decisionInstance;
    }

    public String getDecision() {
        return decision;
    }

    public void setDecision(String playerDecision) {
        this.decision = playerDecision;
    }

    public String getPlayerDecision() {
        return this.decision;
    }
}
