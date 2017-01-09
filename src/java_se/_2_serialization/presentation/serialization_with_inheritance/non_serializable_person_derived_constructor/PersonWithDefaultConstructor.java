package java_se._2_serialization.presentation.serialization_with_inheritance.non_serializable_person_derived_constructor;

public class PersonWithDefaultConstructor {

    protected String firstName;
    protected String lastName;

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public PersonWithDefaultConstructor() {
        System.out.println("PersonWithDefaultConstructor");
    }
}
