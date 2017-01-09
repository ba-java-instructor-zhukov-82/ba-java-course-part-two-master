package java_se._2_serialization.presentation.serialization_with_inheritance.non_serializable_person_derived_constructor;

import java.io.Serializable;

public class StudentSuperNonSerializableDefault extends PersonWithDefaultConstructor implements Serializable {

    private static final long serialVersionUID = 1L;

    private int age;

    public int getAge() {
        return age;
    }

    public StudentSuperNonSerializableDefault(String fn, String ln, int a) {
        this.firstName = fn;
        this.lastName = ln;
        this.age = a;
        System.out.println("Constructor");
    }
}
