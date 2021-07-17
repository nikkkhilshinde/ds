package Examl;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class TelephoneDirectory {
    private List<Person> persons;

    public TelephoneDirectory(){
        persons = new ArrayList<>();
        List<Integer> list = new ArrayList<>();
        List<Integer> list1 = new ArrayList<>(list);
    }
    public TelephoneDirectory(List<Person> persons){
        this.persons = persons;
    }
    public List<Person> query(String firstName, String lastName, String phoneNumber){
        List<Person> queriedPersons = new ArrayList<>();
        this.persons.forEach(person -> {
            boolean firstNameCheck = false;
            boolean lastNameCheck = false;
            boolean phoneNumberCheck = false;
            if(person.getFirstName() == null || firstName.equals(person.getFirstName())){
                firstNameCheck = true;
            }
            if(person.getLastName() == null || lastName.equals(person.getLastName())){
                lastNameCheck = true;
            }
            if(person.getPhoneNumber() == null || phoneNumber.equals(person.getPhoneNumber())){
                phoneNumberCheck = true;
            }
            if(firstNameCheck && lastNameCheck && phoneNumberCheck){
                queriedPersons.add(person);
            }
        });
        return queriedPersons;
    }
    public boolean checkIfPersonExistsById(int id){
        for (Person person : this.persons) {
            if(person.getId()==id){
                return true;
            }
        }
        return false;
    }
    public void add(Person person){
        if(!checkIfPersonExistsById(person.getId())){
            this.persons.add(person);
        }else{
            throw new IllegalStateException();
        }
    }
    public void deletePerson(Person person){
        if(checkIfPersonExistsById(person.getId())){
            this.persons.remove(getPersonById(person.getId()));
        }else{
            throw new IllegalStateException();
        }
    }
    public Person getPersonById(int id){
        for (Person person : this.persons) {
            if(person.getId() == id) return person;
        }
        throw new IllegalStateException();
    }
    public void update(Person person){
        if(checkIfPersonExistsById(person.getId())){
            this.persons.remove(getPersonById(person.getId()));
            this.persons.add(person);
        }else{
            throw new IllegalStateException();
        }
    }
}
