import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.ArrayList;

public class Database implements Serializable {
    private ArrayList<Account> list;

    @SuppressWarnings("unchecked")
    public Database() {
        try {
            if (fileAvailable()) {
                FileInputStream fileIn = new FileInputStream("tmp/database.ser");
                ObjectInputStream in = new ObjectInputStream(fileIn);
                list = (ArrayList<Account>) in.readObject();
                in.close();
                fileIn.close();
            } else {
                list = new ArrayList<Account>();
            }

        } catch (IOException i) {
            i.printStackTrace();
        } catch (ClassNotFoundException c) {
            System.out.println("Database class not found");
            c.printStackTrace();
        }
    }

    public boolean addEntry(Account newAccount) {
        list.add(newAccount);
        save();
        return true;
    }

    private boolean save() {
        try {
            FileOutputStream fileOut = new FileOutputStream("tmp/database.ser");
            ObjectOutputStream out = new ObjectOutputStream(fileOut);
            out.writeObject(list);
            out.close();
            fileOut.close();
            return true;
        } catch (IOException i) {
            i.printStackTrace();
            return false;
        }
    }

    private boolean fileAvailable() {
        File newFile = new File("tmp/database.ser");
        if (newFile.isFile()) {
            return true;
        } else {
            return false;
        }
    }
}
