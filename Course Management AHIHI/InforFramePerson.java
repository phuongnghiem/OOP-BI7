import java.awt.*;
import javax.swing.*;


public class InforFramePerson {
    public JFrame frame;
    private JLabel name;
    private JTextField nameField;
    private JLabel id;
    private JTextField idField;
    private JLabel mobile;
    private JTextField mobileField;
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
    public void setIdLabel(String s){
        this.id.setText(s);
    }
    public String getIdField(){
        return this.idField.getText();
    }
    public void setIdField(String s){
        this.idField.setText(s);
    }
    public void setMobileLabel(String s){
        this.mobile.setText(s);
    }
    public String getMobileField(){
        return this.mobileField.getText();
    }
    public void setMobileField(String s){
        this.mobileField.setText(s);
    }


    public InforFramePerson(){
        name = new JLabel("");
        nameField = new JTextField(10);
        id   = new JLabel("");
        idField   = new JTextField(10);
        mobile=new JLabel("");
        mobileField=new JTextField(10);
        avatar =new JLabel("");

        /* set buttons */
        update = new JButton("Update");
        find   = new JButton("Find");
        delete = new JButton("Delete");
        delete.setBackground(Color.BLACK);
        back   = new JButton("Back");

        frame = new JFrame("Information");
        frame.setLayout(new GridLayout(6,2));
        frame.setSize(300,200);
        frame.setLocation(400,400);
        frame.setVisible(true);
        frame.add(name);
        frame.add(nameField);
        frame.add(id);
        frame.add(idField);
        frame.add(mobile);
        frame.add(mobileField);

        frame.setResizable(false);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);


    }

}
