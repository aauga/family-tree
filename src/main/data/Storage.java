package main.data;

import java.util.ArrayList;

public class Storage {
    private static final ArrayList<Node> nodes = new ArrayList<>();
    private static final ArrayList<Person> people = new ArrayList<>();

    public static void addPerson(Person person) {
        people.add(person);
    }

    public static void addNode(Node node) {
        nodes.add(node);
    }

    // Getters
    public static ArrayList<Node> getNodeArray() {
        return nodes;
    }

    public static ArrayList<Person> getPeopleArray() {
        return people;
    }
}
