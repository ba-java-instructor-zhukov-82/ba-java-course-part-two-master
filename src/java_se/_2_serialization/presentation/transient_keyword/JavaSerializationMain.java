package java_se._2_serialization.presentation.transient_keyword;

import java_se._2_serialization.paths_util.PathsUtil;

import java.io.*;

public class JavaSerializationMain {

    public static void main(String[] args) {
        javaSerializationTest();
    }

    private static void javaSerializationTest() {
        final String FILE_PATH = PathsUtil.getPackageFileAccess(JavaSerializationMain.class, "files/student.ser");

        //object serialization
        Student s = new Student("Sasha", "Petrov", 22);
        try (FileOutputStream fos = new FileOutputStream(FILE_PATH);
             ObjectOutputStream oos = new ObjectOutputStream(fos)) {
            oos.writeObject(s);
        } catch (IOException e) {
            e.printStackTrace();
        }

        //object de-serialization
        Student s2;
        try (FileInputStream fis = new FileInputStream(FILE_PATH);
             ObjectInputStream oin = new ObjectInputStream(fis)) {
            s2 = (Student) oin.readObject();
            System.out.println("FirstName: " + s2.getFirstName());
            System.out.println("LastName: " + s2.getLastName());
            System.out.println("Age: " + s2.getAge());
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
}
