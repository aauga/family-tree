package main.data.nodes;

import main.data.Person;

public class Node {

    private Person person, connection;

    public Node(Person person) {
        this.person = person;
    }

    public void setConnection(Person connection) {
        this.connection = connection;
    }
}
