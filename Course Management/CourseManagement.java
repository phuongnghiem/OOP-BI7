import javax.swing.*;

public class CourseManagement {
    public static void main(String args[]){
        try {
            for (UIManager.LookAndFeelInfo info : UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (Exception e) {
            // If Nimbus is not available, fall back to cross-platform
            try {
                UIManager.setLookAndFeel(UIManager.getCrossPlatformLookAndFeelClassName());
            } catch (Exception ex) {
                // not worth my time
            }
        }

        /* ArrayList<Lecturer> test1 = new ArrayList<Lecturer>();
        test1.add(new Lecturer("abcaplzzskasdashdasd","000abz109-72bfg","900099xxxx74"));
        TestSerialize TEST1 = new TestSerialize(test1);

        ArrayList<Course> test2 = new ArrayList<Course>();
        test2.add(new Course("ahihowthknhihi","xyz-1056998-cg",69,"asd"));
        TestSerializeCourse TEST2 = new TestSerializeCourse(test2); */



        LoginFrame TRIAL =new LoginFrame();

    }
}

