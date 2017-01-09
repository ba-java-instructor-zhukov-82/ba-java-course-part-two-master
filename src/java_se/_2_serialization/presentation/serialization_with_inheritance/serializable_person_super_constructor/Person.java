package java_se._2_serialization.presentation.serialization_with_inheritance.serializable_person_super_constructor;

import java.io.Serializable;

public class Person  implements Serializable {

    protected String firstName;
    protected String lastName;

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public Person(String first, String last) {
        this.firstName = first;
        this.lastName = last;
        System.out.println("PersonWithDefaultConstructor");
    }
}

