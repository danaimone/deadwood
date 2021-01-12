package deadwood;

import java.util.Random;

/**
 * Die
 * <p>
 * Represents a single Die
 */
public class Die {
    private Random random = new Random();
    private int currentFaceValue = 1;


    /**
     * Constructor
     */
    public Die() {
    }

    /**
     * Alternate constructor
     *
     * @param value the value of the die to be set
     */
    public Die(int value) {
        this.currentFaceValue = value;
    }

    public int getCurrentFaceValue() {
        return this.currentFaceValue;
    }

    /**
     * Roll
     * <p>
     * Rolls a Die
     *
     * @return the current face value of the die/the resulting roll value
     */
    public int roll(){
        return 1 + this.random.nextInt(6);
    }

    /**
     * to String
     * <p>
     * Returns a string representation of the die value.
     *
     * @return the die value in a String
     */
    public String toString() {
        return Integer.toString(this.currentFaceValue);
    }

}