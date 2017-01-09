package java_se._2_serialization.laboratory_works.lab_1_2_4;

import java.io.Serializable;

public class User implements Serializable {
    private static final long serialVersionUID = 1L;
    private String firstName;
    private String lastName;
    private int age;

    public User() {    }

    public User(String fn, String ln, int a) {
        this.firstName = fn;
        this.lastName = ln;
        this.age = a;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public int getAge() {
        return age;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public void setAge(int age) {
        this.age = age;
    }

    @Override
    public String toString() {
        return firstName + "," + lastName + "," + age + "\n";
    }
}
