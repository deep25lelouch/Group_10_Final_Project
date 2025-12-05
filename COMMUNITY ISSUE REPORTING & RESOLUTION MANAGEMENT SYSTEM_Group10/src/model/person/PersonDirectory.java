/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model.person;
//Rijurik_Saha_002525961
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author RIO
 */
public class PersonDirectory {
//Rijurik_Saha_002525961
    private List<Person> personList;

    public PersonDirectory() {
        this.personList = new ArrayList<>();
    }

    public Person createAndAddPerson(String firstName, String lastName, String email, String phone) {
        Person person = new Person(firstName, lastName, email, phone);
        personList.add(person);
        return person;
    }

    public void removePerson(Person person) {
        personList.remove(person);
    }

    public Person findPersonByEmail(String email) {
        return personList.stream()
                .filter(p -> p.getEmail().equalsIgnoreCase(email))
                .findFirst()
                .orElse(null);
    }

    public List<Person> getPersonList() {
        return personList;
    }
}
