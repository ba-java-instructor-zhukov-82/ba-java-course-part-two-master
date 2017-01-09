package java_se._2_serialization.laboratory_works.lab_1_2_3;

import java.io.Serializable;

public class Employee implements Serializable {
    private String name;
    private String address;
    private int number;
    // lab 1_2_3
    transient private int SSN;

    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public String getAddress() {
        return address;
    }
    public void setAddress(String address) {
        this.address = address;
    }
    public int getNumber() {
        return number;
    }
    public void setNumber(int number) {
        this.number = number;
    }
    public int getSSN() {
        return SSN;
    }
    public void setSSN(int SSN) {
        this.SSN = SSN;
    }
    @Override
    public String toString() {
        return  "name=" + name + "; address=" + address +
                "; number=" + number + "; SSN=" + SSN;
    }
}
