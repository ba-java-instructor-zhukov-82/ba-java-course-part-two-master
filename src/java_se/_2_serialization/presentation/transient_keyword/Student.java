package java_se._2_serialization.presentation.transient_keyword;

import java.io.Serializable;

public class Student implements Serializable {

    private static final long serialVersionUID = 1L;

    private String firstName;
    private String lastName;
    private transient int age; //transient keyword makes a field non-serializable

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
}
