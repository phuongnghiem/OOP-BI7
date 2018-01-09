import javax.swing.*;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.util.ArrayList;

public class TestDeserialize {
    public ArrayList<Lecturer> Deserialize(){
        ArrayList<Lecturer> prof =new ArrayList<Lecturer>();
        String filename ="DataOfLecturerFinal1.ser";
        try
        {
            // Reading the object from a file
            FileInputStream file = new FileInputStream(filename);
            ObjectInputStream in = new ObjectInputStream(file);

            // Method for deserialization of object

            prof = (ArrayList<Lecturer>) in.readObject();

            in.close();
            file.close();

        }
        catch(IOException ex)
        {
            JOptionPane.showMessageDialog(null,"Data is empty, add a new lecturer!");
        }
        catch(ClassNotFoundException ex)
        {
            System.out.println("ClassNotFoundException is caught");
        }
        return prof;



    }
}
