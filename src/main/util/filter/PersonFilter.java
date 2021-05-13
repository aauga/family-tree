package main.util.filter;

import main.data.ConnectionLine;
import main.data.Person;
import main.data.Storage;

import java.util.ArrayList;

public interface PersonFilter {
    ArrayList<Person> filterPeople(ArrayList<Person> list, String criteria);

    default ArrayList<ConnectionLine> filterConnections(ArrayList<Person> list) {
        ArrayList<ConnectionLine> filteredList = new ArrayList<>();
        ArrayList<ConnectionLine> storage = Storage.getConnectionLineArray();

        for(ConnectionLine line : storage) {
            for(Person person : list) {
                if(line.getFirstPerson() == person || line.getSecondPerson() == person) {
                    filteredList.add(line);
                }
            }
        }

        return filteredList;
    }
}