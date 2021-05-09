package main.data;

import java.util.ArrayList;

public class Storage {
    private static final ArrayList<Person> people = new ArrayList<>();
    private static final ArrayList<ConnectionLine> lines = new ArrayList<>();

    public static void addPerson(Person person) {
        people.add(person);
    }

    public static void addLine(ConnectionLine line) {
        lines.add(line);
    }

    // Getters
    public static ArrayList<Person> getPeopleArray() {
        return people;
    }

    public static ArrayList<ConnectionLine> getConnectionLineArray() {
        return lines;
    }
}
