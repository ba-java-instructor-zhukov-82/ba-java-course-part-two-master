package java_se._2_serialization.presentation.custom_serialization_in_java;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;

public class Student implements Serializable {

    private static final long serialVersionUID = 1L;

    private String firstName;
    private String lastName;
    private int age;

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public int getAge() {
        return age;
    }

    public Student(String fn, String ln, int a) {
        this.firstName = fn;
        this.lastName = ln;
        this.age = a;
    }

    private void writeObject(ObjectOutputStream o) throws IOException {
        o.writeObject(firstName);
        o.writeUTF(lastName);
        o.writeInt(age);
    }

    private void readObject(ObjectInputStream o) throws IOException, ClassNotFoundException {
        firstName= (String) o.readObject();
        lastName= o.readUTF();
        age = o.readInt();
    }
}
