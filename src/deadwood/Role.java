package deadwood;


public class Role {
    protected String roleName;
    protected int roleDifficulty;
    protected String x;
    protected String y;
    protected String w;
    protected String h;
    protected String roleDescription;
    protected boolean starring;

    public Role(){

    }

    private String getName(){
        return roleName;
    }

    private int getDifficulty(){
        return roleDifficulty;
    }
    //probably wanna change this
    private String getArea(){
        return x+y+w+h;
    }

    private String getDescription(){
        return roleDescription;
    }
}
