package main.util.filter;

import main.data.Person;

import java.util.ArrayList;

public class FilterLastname implements PersonFilter {
    @Override
    public ArrayList<Person> filterPeople(ArrayList<Person> list, String criteria) {
        ArrayList<Person> filteredList = new ArrayList<>();

        for (Person person : list) {
            String lastName = person.getLastName();

            if (lastName.contains(criteria)) {
                filteredList.add(person);
            }
        }

        return filteredList;
    }
}
