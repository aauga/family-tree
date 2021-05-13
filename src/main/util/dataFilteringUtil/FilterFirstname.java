package main.util.dataFilteringUtil;

import main.data.Person;

import java.util.ArrayList;

public class FilterFirstname implements PersonFilter {
    @Override
    public ArrayList<Person> filterPeople(ArrayList<Person> list, String criteria) {
        ArrayList<Person> filteredList = new ArrayList<>();

        for (Person person : list) {
            String firstName = person.getFirstName();

            if (firstName.contains(criteria)) {
                filteredList.add(person);
            }
        }

        return filteredList;
    }
}
