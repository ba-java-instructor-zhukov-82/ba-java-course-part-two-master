package java_se._2_serialization.laboratory_works.lab_1_2_4;

import java_se._2_serialization.paths_util.PathsUtil;

import java.io.RandomAccessFile;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Scanner;
import java.io.IOException;

public class DemoObjectFile {

    private static final String FILE_PATH = PathsUtil.getPackageFileAccess(DemoObjectFile.class, "files/test.ser");

    public static void main(String[] args) {
        User student = create();

        serialization(student, FILE_PATH);

        List<User> listTest = deserialization(FILE_PATH);

        System.out.println("\nList of users:");
        Iterator<User> iter = listTest.iterator();
        while (iter.hasNext()) {
            System.out.print(iter.next());
        }
    }

    public static User create() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter first name: ");
        String firstName = scanner.next();
        System.out.print("Enter last name: ");
        String lastName = scanner.next();
        System.out.print("Enter age: ");
        int age = scanner.nextInt();
        return new User(firstName, lastName, age);
     }

    public static void serialization(User object, String nameFile) {
        try (RandomAccessFile raf = new RandomAccessFile(nameFile, "rw")) {
            long size = raf.length();
            raf.seek(size);
            raf.writeBytes(object.toString());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static List<User> deserialization(String nameFile) {
        List<User> listTest = new ArrayList<>();
        String line;

        try (RandomAccessFile raf = new RandomAccessFile(nameFile, "r")) {
            while ((line = raf.readLine()) != null) {
                String[] fields = line.split(",");
                User object = new User();
                object.setFirstName(fields[0]);
                object.setLastName(fields[1]);
                object.setAge(Integer.parseInt(fields[2]));
                listTest.add(object);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return listTest;
    }
}
