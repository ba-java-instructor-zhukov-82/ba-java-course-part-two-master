package java_se._2_serialization.presentation.serialization_with_inheritance.non_serializable_person_super_constructor;

import java.io.Serializable;

public class StudentSuperNonSerializableWithParameters extends PersonWithConstructorWithParameters implements Serializable {

    private static final long serialVersionUID = 1L;

    private int age;

    public int getAge() {
        return age;
    }

    public StudentSuperNonSerializableWithParameters(String fn, String ln, int a) {
        super(fn, ln);
        this.age = a;
        System.out.println("Constructor");
    }
}
