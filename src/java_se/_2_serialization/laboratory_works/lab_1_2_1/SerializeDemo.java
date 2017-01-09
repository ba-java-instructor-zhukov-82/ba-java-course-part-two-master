package java_se._2_serialization.laboratory_works.lab_1_2_1;

import java_se._2_serialization.paths_util.PathsUtil;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;

public class SerializeDemo {

    private static final String FILE_PATH = PathsUtil.getPackageFileAccess(SerializeDemo.class, "files/employee.ser");

    public static void main(String[] args) {
	        // lab 1_2_1
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


    }
}
