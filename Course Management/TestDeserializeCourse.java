import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.util.ArrayList;

public class TestDeserializeCourse {
    public ArrayList<Course> DeserializeCourse(){
        ArrayList<Course> course =new ArrayList<Course>();
        String filename ="dulieuCourse1.ser";
        try
        {
            // Reading the object from a file
            FileInputStream file = new FileInputStream(filename);
            ObjectInputStream in = new ObjectInputStream(file);

            // Method for deserialization of object

            course = (ArrayList<Course>) in.readObject();

            in.close();
            file.close();

        }
        catch(IOException ex)
        {
            System.out.println("IOException is caught");
        }
        catch(ClassNotFoundException ex)
        {
            System.out.println("ClassNotFoundException is caught");
        }
        return course;



    }
}
