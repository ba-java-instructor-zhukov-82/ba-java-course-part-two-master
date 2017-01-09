package java_se._2_serialization.presentation.complex_object_serialization.serializable;

import java.io.Serializable;

public class StudentWithSerializableCourse implements Serializable {

    private static final long serialVersionUID = 1L;

    private String firstName;
    private String lastName;
    private int age;
    private CourseSerializable course;

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public int getAge() {
        return age;
    }

    public CourseSerializable getCourse() {
        return course;
    }

    public void setCourse(CourseSerializable course) {
        this.course = course;
    }

    public StudentWithSerializableCourse(String fn, String ln, int a) {
        this.firstName = fn;
        this.lastName = ln;
        this.age = a;
    }
}
