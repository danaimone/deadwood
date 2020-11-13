package deadwood;


public class Role {
    protected String roleName;
    protected int roleDifficulty;
    protected String roleArea;
    protected String roleDescription;
    protected boolean starring;

    public Role(String name, int difficulty, String area, String description,
    Boolean starring){
        this.roleName = name;
        this.roleDifficulty = difficulty;
        this.roleArea = area;
        this.roleDescription = description;
        this.starring = starring;
    }

    private String getName(){
        return roleName;
    }

    private int getDifficulty(){
        return roleDifficulty;
    }

    private String getArea(){
        return roleArea;
    }

    private String getDescription(){
        return roleDescription;
    }
}
