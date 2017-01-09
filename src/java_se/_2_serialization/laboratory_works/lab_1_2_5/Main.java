package java_se._2_serialization.laboratory_works.lab_1_2_5;

import java_se._2_serialization.paths_util.PathsUtil;

import java.io.*;

public class Main {

    private static final String FILE_PATH = PathsUtil.getPackageFileAccess(Main.class, "files/userfile.ser");

    public static void main(String[] args) {
        User[] users = {new User("Alex", "Vetrov", 33), new User("Dasha", "Moroz", 23),
                             new User("Serg", "Dimitrov", 44), new User("Liubov", "Petrova", 39),
                             new User("Ivan", "Ivanov", 17)};

       try {
            ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(FILE_PATH));
            for (User user : users) {
                oos.writeObject(user);
            }
            oos.close();
       } catch (IOException exp) {
            exp.printStackTrace();
       }

        User userRead = null;
        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(FILE_PATH))) {
            System.out.println("Users stored in the file:");
            int count = 1;
            while (true) {
                userRead = (User) ois.readObject();
                System.out.println(count++ + ") " + userRead);
            }
        } catch (EOFException ee) {
            System.out.println("The list is completed!");
        } catch (IOException | ClassNotFoundException exp) {
            exp.printStackTrace();
        }
    }
}
