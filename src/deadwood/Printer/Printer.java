package deadwood.Printer;

import deadwood.Player.PlayerController;

public abstract class Printer {
    PlayerController playerController;

    public Printer() {

    }

    public Printer(PlayerController playerController) {
        this.playerController = playerController;
    }

    public void setPlayerController(PlayerController playerController) {
        this.playerController = playerController;
    }
}
