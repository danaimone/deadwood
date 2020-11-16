package deadwood;

import java.util.ArrayList;
import java.util.Collection;

/**
 * TODO: define whether Card is an abstract class
 * We could consider SceneCards to be an extension of the abstract class Card
 * but is that necessary?
 */
public class Card {
    private final String name;
    private final String description;
    private final int budget;
    private Collection<Role> rolesOnCard = new ArrayList<Role>();

    private boolean flipped;

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
