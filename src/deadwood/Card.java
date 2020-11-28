package deadwood;

import java.util.ArrayList;
import java.util.Collection;

public abstract class Card {
    protected String name;
    protected int number;
    protected String img;
    protected String description;
    protected int budget;
    protected Collection<Role> rolesOnCard = new ArrayList<Role>();

    public Card () {
        this.name = null;
        this.description = null;
        this.budget = 0;
    }

    /**
     * Card
     *
     * @param name        Name of Card
     * @param description Card description
     * @param budget      Card budget
     * @param rolesOnCard Roles onCard
     */
    public Card(String name, String description, int budget, Collection<Role> rolesOnCard) {
        this.name = name;
        this.description = description;
        this.budget = budget;
        this.rolesOnCard = rolesOnCard;
        this.flipped = false;
    }

    public Card(String name, String description, int budget) {
        this.name = name;
        this.description = description;
        this.budget = budget;
    }

    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }

    public int getBudget() {
        return budget;
    }

    public Collection<Role> getRolesOnCard() {
        return rolesOnCard;
    }

    public void setRolesOnCard(Collection<Role> rolesOnCard) {
        this.rolesOnCard = rolesOnCard;
    }

    public int getTotalRoles() {
        return totalRoles;
    }

    public void setTotalRoles(int totalRoles) {
        this.totalRoles = totalRoles;
    }

    private int totalRoles;

    private boolean flipped;



    /**
     * Flip the card
     * <p>
     * Given the current state of the card, flip it other way.
     *
     * @return The current state of the card (flipped or not flipped)
     */
    public boolean flipCard() {
        this.flipped = !flipped;
        return this.isFlipped();
    }

    /**
     * Is Flipped
     * <p>
     * Checks if the card has been flipped over.
     *
     * @return True if card is flipped over, false otherwise
     */
    public boolean isFlipped() {
        return flipped;
    }

}
