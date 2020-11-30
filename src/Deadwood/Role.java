package Deadwood;


public class Role {
    protected String roleName;


    protected int roleDifficulty;
    protected String x;
    protected String y;
    protected String w;
    protected String h;
    protected String roleDescription;
    protected boolean starring;

    public Role() {

    }

    public String getRoleName() {
        return roleName;
    }

    public void setRoleName(String roleName) {
        this.roleName = roleName;
    }

    public int getRoleDifficulty() {
        return roleDifficulty;
    }

    public void setRoleDifficulty(int roleDifficulty) {
        this.roleDifficulty = roleDifficulty;
    }

    public String getX() {
        return x;
    }

    public void setX(String x) {
        this.x = x;
    }

    public String getY() {
        return y;
    }

    public void setY(String y) {
        this.y = y;
    }

    public String getW() {
        return w;
    }

    public void setW(String w) {
        this.w = w;
    }

    public String getH() {
        return h;
    }

    public void setH(String h) {
        this.h = h;
    }

    public String getRoleDescription() {
        return roleDescription;
    }

    public void setRoleDescription(String roleDescription) {
        this.roleDescription = roleDescription;
    }

    public boolean isStarring() {
        return starring;
    }

    public void setStarring(boolean starring) {
        this.starring = starring;
    }


    private String getName() {
        return roleName;
    }

    private int getDifficulty() {
        return roleDifficulty;
    }

    //probably wanna change this
    private String getArea() {
        return x + y + w + h;
    }

    private String getDescription() {
        return roleDescription;
    }

    public void printRoleData() {
        System.out.printf("    Role name: %s, Difficulty: %d%n        Area(x, y, w, h): %s %s %s %s%n        Line: %s%n", roleName, roleDifficulty, x, y, w, h, roleDescription);
    }
}
