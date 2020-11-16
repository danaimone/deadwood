package deadwood;

import java.util.ArrayList;

/**
 *
 */
public class Scene extends Room {
    /* TODO: scene controller:
        every time someone wants to start a scene (only one player does it at a time)
        that's when we do all the work
        rolling dice, pass/fail, checking the budget, removing the card from the room? (maybe?)
        takes player, card for data and will tell you if you passed blah blah blah
        player and player data coupled tightly, which is not good. Need model controller separation.
        Scene and cards is coupled tightly together right now as well.
     */

    private final String sceneName;
    private final String sceneImage;
    private final String sceneNumber;
    private final String sceneDescription;
    private final ArrayList<Role> roles = new ArrayList<Role>();
    private final int totalRoles;
    private int sceneBudget;
    private int difficulty;
    private boolean isVisible;

    public Scene(String name, String image, int budget, String number, String description, int roleTotal, ArrayList<Role> roleList) {
        sceneName = name;
        sceneImage = image;
        sceneBudget = budget;
        sceneNumber = number;
        sceneDescription = description;
        totalRoles = roleTotal;
    }

    /*
        Getters and Setters
         */
    private ArrayList<Role> getRoles() {
        return roles;
    }

    public int getBudget() {
        return sceneBudget;
    }

    public void setBudget(int budget) {
        this.sceneBudget = budget;
    }

    public int getDifficulty() {
        return difficulty;
    }

    public void setDifficulty(int difficulty) {
        this.difficulty = difficulty;
    }

    public void printSceneInfo() {
        System.out.printf("Scene name: %s, Scene Budget: %d, Scene Img: %s%n    Scene Number: %s, Scene Desc: %s%n    Total Roles: %d%n", sceneName, sceneBudget, sceneImage, sceneNumber, sceneDescription, totalRoles);
    }

    /**
     * wrapScene
     * <p>
     * move to scene
     */
    private void wrapScene() {
        sceneCardsLeft--;
        /*
        if day is over, run endDay. if last day,
        run gamemaster.endGame()
        */
    }
}
