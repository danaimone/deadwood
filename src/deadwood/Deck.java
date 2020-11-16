package deadwood;

import java.util.ArrayList;

/**
 * Deck just represents an object that "holds" multiple Cards.
 * A deck can be put in a room for instance, so it helps abstract
 * that idea out for programming purposes.
 * This is represented by a stack for now, since we don't necessarily
 * care about any of the middle elements
 */
public class Deck<Card> {
    private final ArrayList<Card> deck;
    private int currentCard; // deal THIS card in the deck!

    public Deck() {
        this.deck = new ArrayList<>();
        this.currentCard = 0;
    }

    /**
     * Draw Card
     * <p>
     * Draws a card from the deck.
     * <p>
     * Pre-condition:
     * - currentCard does not exceed the deck size.
     * <p>
     * Post-condition:
     * - The currentCard value index card is returned, and currentCard is incremented.
     * - Note that the use of post-incrementation allows us to evaluate deck.get() at the correct position
     * as well as increment in the same line.
     *
     * @return The card drawn from the deck.
     */
    public Card drawCard() {
        assert (currentCard < deck.size());
        return deck.get(currentCard++);
    }

    /**
     * Fill Deck
     * <p>
     * Fills deck with given cards
     *
     * @param cardsToInsert An Array filled with the Cards to be inserted.
     */
    public void fillDeck(ArrayList<Card> cardsToInsert) {
        deck.addAll(cardsToInsert);
    }
}
