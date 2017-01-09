package java_se._2_serialization.presentation.serialization_with_inheritance.non_serializable_person_super_constructor;

public class PersonWithConstructorWithParameters {

    protected String firstName;
    protected String lastName;

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public PersonWithConstructorWithParameters(String first, String last) {
        this.firstName = first;
        this.lastName = last;
        System.out.println("PersonWithDefaultConstructor");
    }
}
