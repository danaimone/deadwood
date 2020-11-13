package deadwood;

public class Scene extends Set{
    protected String sceneName;
    protected String sceneImage;
    protected int budget;
    protected String sceneNumber;
    protected String sceneDescription;
    protected int difficulty;
    protected Role[] rolesInScene;
    protected int totalRoles;
    protected boolean isVisible;

    public Scene(String name, String image, int budget, String number, String description){
        this.sceneName = name;
        this.sceneImage = image;
        this.budget = budget;
        this.sceneNumber = number;
        this.sceneDescription = description;
    }

    /*
        Getters and Setters
         */
    private Role[] getRoles() {
        return rolesInScene;
    }

    public int getBudget() {
        return budget;
    }

    public void setBudget(int budget) {
        this.budget = budget;
    }

    public int getDifficulty() {
        return difficulty;
    }

    public void setDifficulty(int difficulty) {
        this.difficulty = difficulty;
    }
}
