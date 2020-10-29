package deadwood;

public class Scene {
    protected String name;
    protected int budget;
    protected int shotsRemaining;
    protected int difficulty;
    protected Role[] rolesInScene;


    public Scene(String name, int budget, int shotsRemaining, int difficulty, Role[] rolesInScene) {
        this.name = name;
        this.budget = budget;
        this.shotsRemaining = shotsRemaining;
        this.difficulty = difficulty;
        this.rolesInScene = rolesInScene;
    }

    private void performShot() {
        shotsRemaining--;
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
    private int getShotsRemaining() {
        return shotsRemaining;
    }



}
