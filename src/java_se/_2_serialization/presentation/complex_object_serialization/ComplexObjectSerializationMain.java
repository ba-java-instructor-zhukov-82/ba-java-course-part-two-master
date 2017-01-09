package java_se._2_serialization.presentation.complex_object_serialization;

import java_se._2_serialization.paths_util.PathsUtil;
import java_se._2_serialization.presentation.complex_object_serialization.non_serializable.CourseNotSerializable;
import java_se._2_serialization.presentation.complex_object_serialization.non_serializable.StudentWithNonSerializableCourse;
import java_se._2_serialization.presentation.complex_object_serialization.serializable.CourseSerializable;
import java_se._2_serialization.presentation.complex_object_serialization.serializable.StudentWithSerializableCourse;

import java.io.*;

public class ComplexObjectSerializationMain {

    private static final String FILE_PATH = PathsUtil.getPackageFileAccess(ComplexObjectSerializationMain.class,
            "files/student.ser");

    public static void main(String[] args) {

        complexObjectSerializationTest();
    }

    private static void complexObjectSerializationTest() {

        nonSerializableTest();
        serializableTest();
    }

    private static void nonSerializableTest() {

        CourseNotSerializable crs = new CourseNotSerializable(11, "Java Base");
        StudentWithNonSerializableCourse s = new StudentWithNonSerializableCourse("Sasha", "Petrov", 22);
        s.setCourse(crs);
        try (FileOutputStream fos = new FileOutputStream(FILE_PATH);
             ObjectOutputStream oos = new ObjectOutputStream(fos)) {
            oos.writeObject(s);
        } catch (IOException e) {
            System.out.println("EXCEPTION: NotSerializableException (class - CourseSerializable)");
        }
    }

    private static void serializableTest() {

        CourseSerializable crs = new CourseSerializable(11, "Java Base");
        StudentWithSerializableCourse s = new StudentWithSerializableCourse("Sasha", "Petrov", 22);
        s.setCourse(crs);
        try (FileOutputStream fos = new FileOutputStream(FILE_PATH);
             ObjectOutputStream oos = new ObjectOutputStream(fos);
             FileInputStream fis = new FileInputStream(FILE_PATH);
             ObjectInputStream oin = new ObjectInputStream(fis))
        {
            oos.writeObject(s);
            StudentWithSerializableCourse s2 = (StudentWithSerializableCourse) oin.readObject();
            System.out.println("FirstName:" + s2.getFirstName());
            System.out.println("LastName:" + s2.getLastName());
            System.out.println("Age:" + s2.getAge());
            CourseSerializable cur2 = s2.getCourse();
            System.out.println("Course:" + cur2.getName());
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
}
