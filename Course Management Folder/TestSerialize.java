import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.util.ArrayList;

public class TestSerialize {
    public TestSerialize(ArrayList<Lecturer> lec){
        try{
            FileOutputStream file = new FileOutputStream("DataOfLecturerFinal1.ser");
            ObjectOutputStream out = new ObjectOutputStream(file);


            out.writeObject(lec);


            out.close();
            file.close();

        }
        catch (IOException ex){
            System.out.println("Exception is caught");
        }
    }
}
