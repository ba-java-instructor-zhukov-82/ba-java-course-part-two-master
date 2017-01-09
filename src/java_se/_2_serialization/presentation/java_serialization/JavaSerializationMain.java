package java_se._2_serialization.presentation.java_serialization;

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
        Student s2 = null;
        try (FileInputStream fis = new FileInputStream(FILE_PATH);
             ObjectInputStream oin = new ObjectInputStream(fis)) {
            s2 = (Student) oin.readObject();
            System.out.println("FirstName: " + s2.getFirstName());
            System.out.println("LastName: " + s2.getLastName());
            System.out.println("Age: " + s2.getAge());
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }

        System.out.format("\nSerialized and deserialized objects are separated: %s%n",
                          hasCodeComparison(s, s2));

        testSerializedAndDeserializedObjects(s, s2);
    }

    private static boolean hasCodeComparison(Object o1, Object o2) {
        return o1.hashCode() != o2.hashCode();
    }

    private static void testSerializedAndDeserializedObjects(Student o1, Student o2) {
        System.out.println("\nFirstname of o1 is: " + o1.getFirstName());
        System.out.println("Firstname of o2 is: " + o2.getFirstName());
        System.out.println("o1 Fristname changed to \'Oleg\'");
        o1.setFirstName("Oleg");
        System.out.println("Firstname of o1 is: " + o1.getFirstName());
        System.out.println("Firstname of o2 is: " + o2.getFirstName());
    }
}
