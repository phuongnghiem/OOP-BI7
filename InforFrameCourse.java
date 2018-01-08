import java.awt.*;
import javax.swing.*;


public class InforFrameCourse {
    public JFrame frame;
    private JLabel name;
    private JTextField nameField;
    private JLabel code;
    private JTextField codeField;
    private JLabel credit;
    private JTextField creditField;
    public JLabel avatar;
    public JButton update;
    public JButton  find;
    public JButton delete;
    public JButton back;

    /* some function to get or set information */
    public void setNameLabel(String s){
        this.name.setText(s);
    }
    public String getNameField(){
        return this.nameField.getText();
    }
    public void setNameField(String s){
        this.nameField.setText(s);
    }
    public void setCodeLabel(String s){
        this.code.setText(s);
    }
    public String getCodeField(){
        return this.codeField.getText();
    }
    public void setCodeField(String s){
        this.codeField.setText(s);
    }
    public void setCreditLabel(String s){
        this.credit.setText(s);
    }
    public int getCreditField(){
        String t = this.creditField.getText();
        int result = Integer.parseInt(t);
        return result;
    }
    public void setCreditField(int s){
        String t= new Integer(s).toString();
        this.creditField.setText(t);
    }


    public InforFrameCourse(){
        name = new JLabel("");
        nameField = new JTextField(10);
        code  = new JLabel("");
        codeField  = new JTextField(10);
        credit=new JLabel("");
        creditField=new JTextField(10);
        avatar =new JLabel("");

        /* set buttons */
        update = new JButton("Update");
        find   = new JButton("Find");
        delete = new JButton("Delete");
        delete.setBackground(Color.RED);
        back   = new JButton("Back");

        frame = new JFrame("Information");
        frame.setLayout(new GridLayout(6,2));
        frame.setSize(300,200);
        frame.setLocation(400,400);
        frame.setVisible(true);
        frame.add(name);
        frame.add(nameField);
        frame.add(code);
        frame.add(codeField);
        frame.add(credit);
        frame.add(creditField);

        frame.setResizable(false);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);


    }

}