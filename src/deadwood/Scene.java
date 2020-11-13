package deadwood;

import java.util.*;

public class Scene extends Gamemaster{
    protected String sceneName;
    protected String sceneImage;
    protected int sceneBudget;
    protected String sceneNumber;
    protected String sceneDescription;
    protected int difficulty;
    protected ArrayList<Role> roles = new ArrayList<Role>();
    protected int totalRoles;
    protected boolean isVisible;

    public Scene(String name, String image, int budget, String number, String description, int roleTotal, ArrayList<Role> roleList){
        sceneName = name;
        sceneImage = image;
        sceneBudget = budget;
        sceneNumber = number;
        sceneDescription = description;
        totalRoles = roleTotal;
        roles = roleList;
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
    
    public void printSceneInfo(){
        System.out.printf("Scene name: %s, Scene Budget: %d, Scene Img: %s%n    Scene Number: %s, Scene Desc: %s%n    Total Roles: %d%n", sceneName, sceneBudget, sceneImage, sceneNumber, sceneDescription, totalRoles);
    }
}
