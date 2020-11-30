package Deadwood;

/**
 * Die
 * <p>
 * Represents a single Die
 */
public class Die {
    private final int MAX_FACE_VALUE = 6;
    private int currentFaceValue;


    /**
     * Constructor
     */
    public Die() {
        currentFaceValue = 1;
    }

    /**
     * Alternate constructor
     *
     * @param value the value of the die to be set
     */
    public Die(int value) {
        currentFaceValue = value;
    }

    public int getCurrentFaceValue() {
        return currentFaceValue;
    }

    public void setCurrentFaceValue(int currentFaceValue) {
        this.currentFaceValue = currentFaceValue;
    }

    /**
     * Roll
     * <p>
     * Rolls a Die
     *
     * @return the current face value of the die/the resulting roll value
     */
    public int roll() {
        currentFaceValue = (int) (Math.random() * MAX_FACE_VALUE) + 1;
        return currentFaceValue;
    }

    /**
     * to String
     * <p>
     * Returns a string representation of the die value.
     *
     * @return the die value in a String
     */
    public String toString() {
        return Integer.toString(currentFaceValue);
    }

}
