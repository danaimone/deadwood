package deadwood;

public class Scene {
    private int shotsRemaining;
    private int difficulty;
    private Role[] rolesInScene;

    private Role[] getRoles() {
        return rolesInScene;
    }

    private int getShotsRemaining() {
        return shotsRemaining;
    }

    private void performShot() {
        return;
    }

    private int getDifficulty() {
        return difficulty;
    }
}
