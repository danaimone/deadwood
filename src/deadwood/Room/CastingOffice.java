package deadwood.Room;

import deadwood.Printer.DeadwoodPrinter;
import deadwood.Room.Room;

import java.util.Scanner;

public class CastingOffice extends Room {
    public CastingOffice() {

    }

    /**
     * Upgrade Rank
     * <p>
     * Given a player, upgrade their rank.
     *
     * @param playerInput
     * @param printer
     * @return
     */
    private boolean upgradeRank(Scanner playerInput, DeadwoodPrinter printer) {
        //THIS NEEDS TO CHECK IF PLAYER IS IN UPGRADE ROOM STILL
        //REPLACE IF STATEMENT
        // TODO: some of this input stuff can be moved to the input controller
//        if (true) {
//            while (true) {
//                printer.ranksList();
//                printer.askRank();
//                String input = playerInput.nextLine();
//                switch (input) {
//                    case "back":
//                        return false;
//                    case "2":
//                        if (Integer.parseInt(input) <= rank) {
//                            printer.invalidRank(input);
//                            continue;
//                        }
//                        return upgradeP2(playerInput, printer, input, 4, 5);
//                    case "3":
//                        if (Integer.parseInt(input) <= rank) {
//                            printer.invalidRank(input);
//                            continue;
//                        }
//                        return upgradeP2(playerInput, printer, input, 10, 10);
//                    case "4":
//                        if (Integer.parseInt(input) <= rank) {
//                            printer.invalidRank(input);
//                            continue;
//                        }
//                        return upgradeP2(playerInput, printer, input, 18, 15);
//
//                    case "5":
//                        if (Integer.parseInt(input) <= rank) {
//                            printer.invalidRank(input);
//                            continue;
//                        }
//                        return upgradeP2(playerInput, printer, input, 28, 20);
//                    case "6":
//                        if (Integer.parseInt(input) <= rank) {
//                            printer.invalidRank(input);
//                            continue;
//                        }
//                        return upgradeP2(playerInput, printer, input, 40, 25);
//                    default:
//                        printer.invalid();
//                        continue;
//                }
//            }
//        }
        return false; //base case???
    }

    /**
     * upgrade P2
     * <p>
     * TODO: redefine this function. This is essentially the Player rank information
     * This function current needs to be fixed.
     * setter that is specific to a rank being upgraded.
     *
     * @param playerInput
     * @param printer
     * @param input
     * @param dolPrice
     * @param credPrice
     * @return
     */
    private boolean upgradeP2(Scanner playerInput, DeadwoodPrinter printer, String input, int dolPrice, int credPrice) {
//        while (true) {
//            printer.payment();
//            String payment = playerInput.nextLine();
//            switch (payment) {
//                case "credits":
//                    if (playerController.playerDatacredits >= Integer.valueOf(input)) {
//                        credits -= credPrice;
//                        rank = Integer.valueOf(input);
//                        printer.rankSuccess(input);
//                        return true;
//                    } else {
//                        printer.rankFail(payment);
//                        return false;
//                    }
//                case "dollars":
//                    if (dollars >= Integer.valueOf(input)) {
//                        dollars -= dolPrice;
//                        rank = Integer.valueOf(input);
//                        printer.rankSuccess(input);
//                        return true;
//                    } else {
//                        printer.rankFail(payment);
//                        return false;
//                    }
//                default:
//                    printer.invalid();
//                    continue;
//            }
//        }
        return false;
    }
}
