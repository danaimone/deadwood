package deadwood.Printer;

import deadwood.Player.PlayerController;

public abstract class Printer {
    Printer printer = null;
    public Printer() {

    }

    public Printer(Printer printer) {
        this.printer = printer;
    }

    public void setPrinter(Printer printer) {
        this.printer = printer;
    }
}
