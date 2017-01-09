package java_se._2_serialization.presentation.complex_object_serialization.non_serializable;

import java_se._2_serialization.presentation.complex_object_serialization.non_serializable.CourseNotSerializable;

import java.io.Serializable;

public class StudentWithNonSerializableCourse implements Serializable {

    private static final long serialVersionUID = 1L;

    private String firstName;
    private String lastName;
    private int age;
    private CourseNotSerializable course;

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public int getAge() {
        return age;
    }

    public void setCourse(CourseNotSerializable course) {
        this.course = course;
    }

    public StudentWithNonSerializableCourse(String fn, String ln, int a) {
        this.firstName = fn;
        this.lastName = ln;
        this.age = a;
    }
}
