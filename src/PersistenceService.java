import java.io.*;

public class PersistenceService {

    public void saveData(Object data, String fileName) {

        try {

            FileOutputStream file = new FileOutputStream(fileName);
            ObjectOutputStream out = new ObjectOutputStream(file);

            out.writeObject(data);

            out.close();
            file.close();

            System.out.println("Data saved successfully");

        } catch (Exception e) {

            System.out.println("Error saving data: " + e.getMessage());
        }
    }

    public Object loadData(String fileName) {

        try {

            FileInputStream file = new FileInputStream(fileName);
            ObjectInputStream in = new ObjectInputStream(file);

            Object data = in.readObject();

            in.close();
            file.close();

            return data;

        } catch (Exception e) {

            System.out.println("Error loading data: " + e.getMessage());
            return null;
        }
    }
}