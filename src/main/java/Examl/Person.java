package Examl;

public class Person {

    String firstName;
    String lastName;
    String phoneNumber;
    private int id;

    public Person(int id, String firstName, String lastName, String phoneNumber) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.phoneNumber = phoneNumber;
    }

    public int getId() {
        return id;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    ;

    @Override
    public boolean equals(Object obj) {
        Person person = (Person) obj;
        return person.getId() == this.id;
    }

    @Override
    public int hashCode() {
        return super.hashCode();
    }
}
