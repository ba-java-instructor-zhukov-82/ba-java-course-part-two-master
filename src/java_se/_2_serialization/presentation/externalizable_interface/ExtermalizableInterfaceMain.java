package java_se._2_serialization.presentation.externalizable_interface;

import java_se._2_serialization.paths_util.PathsUtil;

import java.io.*;

public class ExtermalizableInterfaceMain {

    private static final String FILE_PATH = PathsUtil.getPackageFileAccess(ExtermalizableInterfaceMain.class,
                                                                           "files/userfile.ser");

    public static void main(String[] args) {
        externalizableInterfaceTest();
    }

    private static void externalizableInterfaceTest() {

        User userWrite = new User(1, "AlexUser", "name@mail.com");

        try (FileOutputStream fos = new FileOutputStream(FILE_PATH);
             ObjectOutputStream oos = new ObjectOutputStream(fos);
             FileInputStream fis= new FileInputStream(FILE_PATH);
             ObjectInputStream ois= new ObjectInputStream(fis);)
        {
            oos.writeObject(userWrite);
            oos.flush();

            User userRead = (User) ois.readObject();
            ois.close();
            System.out.println("username: " + userRead.getUsername());
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
}
