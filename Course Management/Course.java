public class Course implements java.io.Serializable{

    public String code;
    public String name;
    public int credit;
    public String lecturer;

    public Course(String NAME, String CODE, int CREDITS,String LECTURER){
        this.name=NAME;
        this.code=CODE;
        this.credit=CREDITS;
        this.lecturer=LECTURER;
    }
}
