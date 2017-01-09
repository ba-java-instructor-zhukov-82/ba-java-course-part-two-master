package java_se._2_serialization.laboratory_works.lab_1_2_3;

import java_se._2_serialization.paths_util.PathsUtil;

import java.io.*;

public class Main {

    private static final String FILE_PATH = PathsUtil.getPackageFileAccess(Main.class, "files/employee.ser");

    public static void main(String[] args) {
        Employee employee = new Employee();
        employee.setName("Peter");
        employee.setAddress("av. Komarova, 1");
        employee.setNumber(101);
        employee.setSSN(204010050);

        System.out.println("Create object: " + employee);
        try (ObjectOutputStream objOutStream = new ObjectOutputStream(new FileOutputStream(FILE_PATH))) {
            objOutStream.writeObject(employee);
            System.out.println("Object write to file!");
        } catch (IOException expIO) {
            expIO.printStackTrace();
        }

        System.out.println("Deserializing an Object Transient");
        Employee otherEmployee;
        employee = null;
        try (ObjectInputStream objInStream = new ObjectInputStream(new FileInputStream(FILE_PATH))) {
            otherEmployee = (Employee) objInStream.readObject();
            System.out.println("Object read from file!");
            System.out.println(otherEmployee);
        } catch (IOException expIO) {
            System.out.println("Error reading file!");
        } catch (ClassNotFoundException ee) {
            ee.printStackTrace();
        }
    }
}
