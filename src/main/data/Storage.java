package main.data;

import java.util.ArrayList;

public class Storage {
    private static final ArrayList<Person> people = new ArrayList<>();

    public static void addPerson(Person person) {
        people.add(person);
    }

    // Getters
    public static ArrayList<Person> getPeopleArray() {
        return people;
    }
}
