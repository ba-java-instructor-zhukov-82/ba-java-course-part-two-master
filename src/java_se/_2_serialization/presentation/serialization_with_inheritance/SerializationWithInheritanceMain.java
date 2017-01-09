package java_se._2_serialization.presentation.serialization_with_inheritance;

import java_se._2_serialization.paths_util.PathsUtil;
import java_se._2_serialization.presentation.serialization_with_inheritance.non_serializable_person_derived_constructor
                                                                           .StudentSuperNonSerializableDefault;
import java_se._2_serialization.presentation.serialization_with_inheritance.non_serializable_person_super_constructor
                                                                           .StudentSuperNonSerializableWithParameters;
import java_se._2_serialization.presentation.serialization_with_inheritance.serializable_person_super_constructor
                                                                           .Student;

import java.io.*;

public class SerializationWithInheritanceMain {

    private static final String FILE_PATH = PathsUtil.getPackageFileAccess(SerializationWithInheritanceMain.class,
                                            "files/student.ser");


    public static void main(String[] args) {
        serializationWithInheritanceTest();
    }

    private static void serializationWithInheritanceTest() {
        nonSerializableSuperClassDefaultConstructor();
        nonSerializableSuperClassConstructorWithParameters();
        serializableSuperClassConstructorWithParameters();
    }

    private static void nonSerializableSuperClassDefaultConstructor() {

        System.out.println("\n\tSuper class Person with default constructor and NOT serializable\n");

        StudentSuperNonSerializableDefault s = new StudentSuperNonSerializableDefault("Sasha", "Petrov", 22);
        try(FileOutputStream fos = new FileOutputStream(FILE_PATH);
            ObjectOutputStream oos = new ObjectOutputStream(fos);
            FileInputStream fis = new FileInputStream(FILE_PATH);
            ObjectInputStream oin = new ObjectInputStream(fis))
        {
            oos.writeObject(s);
            StudentSuperNonSerializableDefault s2 = (StudentSuperNonSerializableDefault)oin.readObject();
            System.out.println("FirstName:" + s2.getFirstName());
            System.out.println("LastName:" + s2.getLastName());
            System.out.println("Age:" + s2.getAge());
        } catch(IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    private static void nonSerializableSuperClassConstructorWithParameters() {

        System.out.println("\n\tSuper class Person with constructor with parameters and NOT serializable\n");

        StudentSuperNonSerializableWithParameters s = new StudentSuperNonSerializableWithParameters("Sasha", "Petrov", 22);
        try(FileOutputStream fos = new FileOutputStream(FILE_PATH);
            ObjectOutputStream oos = new ObjectOutputStream(fos);
            FileInputStream fis = new FileInputStream(FILE_PATH);
            ObjectInputStream oin = new ObjectInputStream(fis))
        {
            oos.writeObject(s);
            StudentSuperNonSerializableWithParameters s2 = (StudentSuperNonSerializableWithParameters)oin.readObject();
            System.out.println("FirstName:" + s2.getFirstName());
            System.out.println("LastName:" + s2.getLastName());
            System.out.println("Age:" + s2.getAge());
        } catch(IOException | ClassNotFoundException e) {
            System.out.println("EXCEPTION: InvalidClassException");
        }
    }

    private static void serializableSuperClassConstructorWithParameters() {

        System.out.println("\n\tSuper class Person with constructor with parameters and serializable\n");

        Student s = new Student("Sasha", "Petrov", 22);
        try(FileOutputStream fos = new FileOutputStream(FILE_PATH);
            ObjectOutputStream oos = new ObjectOutputStream(fos);
            FileInputStream fis = new FileInputStream(FILE_PATH);
            ObjectInputStream oin = new ObjectInputStream(fis))
        {
            oos.writeObject(s);
            Student s2 = (Student)oin.readObject();
            System.out.println("FirstName:" + s2.getFirstName());
            System.out.println("LastName:" + s2.getLastName());
            System.out.println("Age:" + s2.getAge());
        } catch(IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
}
