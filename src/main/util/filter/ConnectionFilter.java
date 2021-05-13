package main.util.filter;

import main.data.ConnectionLine;
import main.data.Person;

import java.util.ArrayList;

public class ConnectionFilter {
    public static ArrayList<ConnectionLine> filterConnections(ArrayList<ConnectionLine> list, String criteria) {
        ArrayList<ConnectionLine> filteredList = new ArrayList<>();

        for(ConnectionLine line : list) {
            if(line.getConnectionType().equals(criteria)) {
                filteredList.add(line);
            }
        }

        return filteredList;
    }

    public static ArrayList<Person> filterPeople(ArrayList<ConnectionLine> connectionList) {
        ArrayList<Person> filteredList = new ArrayList<>();

        for(ConnectionLine connection : connectionList) {
            Person person = connection.getFirstPerson();

            if(!filteredList.contains(person)) {
                filteredList.add(connection.getFirstPerson());
            }
        }

        return filteredList;
    }
}
