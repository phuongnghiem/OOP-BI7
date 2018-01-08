public class Course implements java.io.Serializable{

    public String code;
    public String name;
    public int credit;

    public Course(String NAME, String CODE, int CREDITS){
        this.name=NAME;
        this.code=CODE;
        this.credit=CREDITS;
    }
}
