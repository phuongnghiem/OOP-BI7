import java.awt.*;
import java.awt.event.*;
import java.util.Arrays;
import javax.swing.*;


public class LoginFrame {
    private JFrame frame;
    /* components for Login windows */
    private JFrame admin;
    private JFrame lecturer;
    private JTextField adminID;
    private JPasswordField adminPW;
    private JTextField lecturerID;
    private JPasswordField lecturerPW;
    private JButton adminLogin;
    private JButton adminLoginBack;
    private JButton lecturerLoginBack;
    private JButton lectureLogin;
    private JLabel adminLoginNoti;
    private JLabel lecturerLoginNoti;

    private char[] correctPassword = {'d','o','i','x','a','n','h'};
    private String correctUsername = "doixanh";

    /* --- components for choosing admin or lecturer --- */
    private JPanel  choose;
    private JButton chooseAdmin;
    private JButton chooseLecturer;


    public LoginFrame(){

        /*--- create Login window for Admin--- */
        adminID    = new JTextField(10);
        adminPW    = new JPasswordField(10);
        adminLogin = new JButton("Login");
        adminLoginBack=new JButton("Back");
        adminLoginBack.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                admin.dispose();
                frame.setVisible(true);
            }
        });
        adminLoginNoti=new JLabel("");
        admin      = new JFrame("Admin Login");  /* frame admin */
        admin.setLocation(400,400);
        admin.setLayout(new GridLayout(5,2));
        admin.add(new JLabel("Login for Admin only"));
        admin.add(new JLabel(" "));
        admin.add(new JLabel("Username "));
        admin.add(adminID);
        admin.add(new JLabel("Password "));
        admin.add(adminPW);
        admin.add(adminLoginNoti);
        admin.add(new JLabel(""));
        admin.add(adminLogin);
        admin.add(adminLoginBack);
        /*-------------------------------------*/

        /*----SECURITY-------*/



        /*--------------------*/
        adminLogin.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                char[] input = adminPW.getPassword();
                String inputID = adminID.getText();
                if(!Arrays.equals (input, correctPassword) || !correctUsername.equals(inputID)){
                    adminLoginNoti.setText("Wrong, try again!");
                }else{
                    admin.dispose();
                    Content xong = new Content();
                }
            }
        });


        /*--- create Login window for Lecturer---*/
        lecturerID   = new JTextField(10);
        lecturerPW   = new JPasswordField(10);
        lectureLogin = new JButton("Login");
        lecturerLoginBack=new JButton("Back");
        lecturerLoginBack.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                lecturer.dispose();
                frame.setVisible(true);
            }
        });
        lecturerLoginNoti=new JLabel("");
        lecturer     = new JFrame("Lecturer Login");
        lecturer.setLocation(400,400);
        lecturer.setSize(400,150);
        lecturer.setResizable(false);
        lecturer.setLayout(new GridLayout(5,2));
        lecturer.add(new JLabel(" Just kidding, only Admin can use this program!!! "));
        lecturer.add(new JLabel(" Button BACK to continue login as ADMIN "));
        lecturer.add(lecturerLoginBack);

        lecturer.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        /*----------------------------------------*/

        choose  = new JPanel(new GridLayout(2,2));
        choose.setSize(300,200);
        choose.add(new JLabel(" If admin, click below  "));
        choose.add(new JLabel("  If lecturer, click below "));
        chooseAdmin     = new JButton("ADMIN");
        chooseAdmin.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                admin.setVisible(true);
                admin.pack();
                frame.dispose();
            }
        });
        chooseLecturer  = new JButton("LECTURER");
        chooseLecturer.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                lecturer.setVisible(true);
                lecturer.pack();
                frame.dispose();
            }
        });
        choose.add(chooseAdmin);
        choose.add(chooseLecturer);

        frame = new JFrame("Login");
        frame.setLocation(400,400);
        frame.add(choose);
        frame.setVisible(true);
        frame.setSize(250,180);
        frame.setResizable(false);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();

        }
    public void setPW(String s){
        char[] tempo = s.toCharArray();
        this.correctPassword=tempo;
    }

    public char[] getPW(){
        return this.correctPassword;
    }
}





