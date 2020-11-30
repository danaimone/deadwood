package Deadwood;

import java.util.ArrayList;

/**
 *
 */
public class SceneCard extends Card {
    /* TODO: scene controller:
        every time someone wants to start a scene (only one player does it at a time)
        that's when we do all the work
        rolling dice, pass/fail, checking the budget, removing the card from the room? (maybe?)
        takes player, card for data and will tell you if you passed blah blah blah
        player and player data coupled tightly, which is not good. Need model controller separation.
        SceneCard and cards is coupled tightly together right now as well.
     */

    private int difficulty;


    public SceneCard(String cardName, String sceneDescription, int budget, ArrayList<Role> roles) {
        this.name = cardName;
        this.description = sceneDescription;
        this.budget = budget;
        this.rolesOnCard = roles;
    }

    /*
        Getters and Setters
         */
    public int getDifficulty() {
        return difficulty;
    }

    public void setDifficulty(int difficulty) {
        this.difficulty = difficulty;
    }

//    public void printSceneInfo() {
//        System.out.printf("SceneCard name: %s, SceneCard Budget: %d, SceneCard Img: %s%n    SceneCard Number: %s, SceneCard Desc: %s%n    Total Roles: %d%n", sceneName, sceneBudget, sceneImage, sceneNumber, sceneDescription, totalRoles);
//    }

    /**
     * wrapScene
     * <p>
     * move to scene, sceneCardLeft--?
     */
    private void wrapScene() {
//        if day is over, run endDay. if last day,
//        run gamemaster.endGame()
    }
}
