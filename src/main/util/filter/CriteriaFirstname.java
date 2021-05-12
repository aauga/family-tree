package main.util.filter;

import main.data.Person;

import java.util.ArrayList;

public class CriteriaFirstname implements FilterCriteria {
    @Override
    public ArrayList<Person> filterList(ArrayList<Person> list, String criteria) {
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
