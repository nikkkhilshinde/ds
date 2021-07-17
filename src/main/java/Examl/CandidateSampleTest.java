package Examl;

import org.junit.Test;

import java.util.List;

import static org.junit.Assert.*;

public class CandidateSampleTest {


    @Test
    public void addAndGetOneEntry(){
        Person testPerson = new Person(1, "firstName1", "lastName1", "9988776655");
        TelephoneDirectory directory = new TelephoneDirectory();
        directory.add(testPerson);
        List<Person> queriedPersons = directory.query("firstName1", "lastName1","9988776655");
        assertEquals(queriedPersons.size(), 1);
    }
    @Test
    public void checkUpdate(){
        Person testPerson = new Person(1, "firstName1", "lastName1", "9988776655");
        TelephoneDirectory directory = new TelephoneDirectory();
        directory.add(testPerson);
        testPerson.firstName = "updatedFirstName";
        directory.update(testPerson);
        assertEquals(directory.getPersonById(1).firstName, "updatedFirstName");
    }
    @Test(expected = IllegalStateException.class)
    public void checkDelete(){
        Person testPerson = new Person(1, "firstName1", "lastName1", "9988776655");
        TelephoneDirectory directory = new TelephoneDirectory();
        directory.add(testPerson);
        directory.deletePerson(testPerson);
        directory.getPersonById(1);
    }
    @Test(expected = IllegalStateException.class)
    public void noPersonPresent(){
        Person testPerson = new Person(1, "firstName1", "lastName1", "9988776655");
        TelephoneDirectory directory = new TelephoneDirectory();
        directory.update(testPerson);
    }
    @Test(expected = IllegalStateException.class)
    public void deletePerson(){
        Person testPerson = new Person(1, "firstName1", "lastName1", "9988776655");
        TelephoneDirectory directory = new TelephoneDirectory();
        directory.deletePerson(testPerson);
    }
}
