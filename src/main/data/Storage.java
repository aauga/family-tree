package main.data;

import main.data.nodes.Node;

import java.util.ArrayList;

public class Storage {
    private static final ArrayList<Node> nodes = new ArrayList<>();
    private static final ArrayList<Person> people = new ArrayList<>();

    public static void addPerson(Person person) {
        people.add(person);
    }
}
