package java_se._2_serialization.laboratory_works.lab_1_2_2;

import java_se._2_serialization.laboratory_works.lab_1_2_1.Employee;
import java_se._2_serialization.paths_util.PathsUtil;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;

public class DeserializeDemo {

    private static final String FILE_PATH = PathsUtil.getPackageFileAccess(DeserializeDemo.class, "files/employee.ser");

    public static void main(String[] args) {
        Employee employee;

        System.out.println("Opening a file for reading...");
        try (ObjectInputStream objInStream = new ObjectInputStream(new FileInputStream(FILE_PATH))) {
            employee = (Employee) objInStream.readObject();
            System.out.println("Object read from file!");
            System.out.println(employee);
        } catch (ClassNotFoundException ee) {
            ee.printStackTrace();
        } catch (IOException expIO) {
            System.out.println("Error reading file!");
        }
    }
}
