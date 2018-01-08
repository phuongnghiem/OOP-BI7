import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.util.ArrayList;

public class TestSerializeCourse {
    public   TestSerializeCourse(ArrayList<Course> course){

        try{
            FileOutputStream file = new FileOutputStream("dulieuCourse1.ser");
            ObjectOutputStream out = new ObjectOutputStream(file);


            out.writeObject(course);


            out.close();
            file.close();

        }
        catch (IOException ex){
            System.out.println("Exception is caught");
        }
    }
}
