package deadwood;

import java.util.Scanner;

public class PlayerInput {
    private static final Scanner scanner = new Scanner(System.in);
    private int numberOfPlayers;

    /**
     * Gets command line input for the number of players.
     * <p>
     * Theoretically, we can have an infinite amount of people playing..
     * although we should probably say there's a hard max of 20.
     *
     * @return The number of players playing this game of Deadwood
     */
    public int getNumberOfPlayers(DeadwoodPrinter printer) {
        int numberOfPlayersPlaying = 20;
        printer.askPlayers();
        try {
            int numberOfPlayersEntered = scanner.nextInt();
            while (numberOfPlayersEntered > 20 || numberOfPlayersEntered < 0) {
                printer.invalidPlayers();
                numberOfPlayersEntered = scanner.nextInt();
            }
            numberOfPlayersPlaying = numberOfPlayersEntered;
        } catch (NumberFormatException e) {
            printer.invalid();
        }
        return numberOfPlayersPlaying;
    }

    /**
     * Setter for setNumberOfPlayers
     * <p>
     * Private, as the number of players doesn't need to be changed afterwards.
     * Only needs to be used by getNumberOfPlayers
     *
     * @param numberOfPlayers the number of players that are playing
     */
    private void setNumberOfPlayers(int numberOfPlayers) {
        this.numberOfPlayers = numberOfPlayers;
    }

}
