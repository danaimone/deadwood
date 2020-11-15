package deadwood;

import java.util.Scanner;

public class CastingOffice extends Room {
    public CastingOffice(String name) {
        super(name);
    }

    private boolean upgradeRank(Scanner playerInput, DeadwoodPrinter printer) {
        //THIS NEEDS TO CHECK IF PLAYER IS IN UPGRADE ROOM STILL
        //REPLACE IF STATEMENT
        if (true) {
            while (true) {
                printer.ranksList();
                printer.askRank();
                String input = playerInput.nextLine();
                switch (input) {
                    case "back":
                        return false;
                    case "2":
                        if (Integer.parseInt(input) <= rank) {
                            printer.invalidRank(input);
                            continue;
                        }
                        return upgradeP2(playerInput, printer, input, 4, 5);
                    case "3":
                        if (Integer.parseInt(input) <= rank) {
                            printer.invalidRank(input);
                            continue;
                        }
                        return upgradeP2(playerInput, printer, input, 10, 10);
                    case "4":
                        if (Integer.parseInt(input) <= rank) {
                            printer.invalidRank(input);
                            continue;
                        }
                        return upgradeP2(playerInput, printer, input, 18, 15);

                    case "5":
                        if (Integer.parseInt(input) <= rank) {
                            printer.invalidRank(input);
                            continue;
                        }
                        return upgradeP2(playerInput, printer, input, 28, 20);
                    case "6":
                        if (Integer.parseInt(input) <= rank) {
                            printer.invalidRank(input);
                            continue;
                        }
                        return upgradeP2(playerInput, printer, input, 40, 25);
                    default:
                        printer.invalid();
                        continue;
                }
            }
        }
        return false; //base case???
    }

    private boolean upgradeP2(Scanner playerInput, DeadwoodPrinter printer, String input, int dolPrice, int credPrice) {
        while (true) {
            printer.payment();
            String payment = playerInput.nextLine();
            switch (payment) {
                case "credits":
                    if (playerData.credits >= Integer.valueOf(input)) {
                        credits -= credPrice;
                        rank = Integer.valueOf(input);
                        printer.rankSuccess(input);
                        return true;
                    } else {
                        printer.rankFail(payment);
                        return false;
                    }
                case "dollars":
                    if (dollars >= Integer.valueOf(input)) {
                        dollars -= dolPrice;
                        rank = Integer.valueOf(input);
                        printer.rankSuccess(input);
                        return true;
                    } else {
                        printer.rankFail(payment);
                        return false;
                    }
                default:
                    printer.invalid();
                    continue;
            }
        }
        //remove this
    }
}
