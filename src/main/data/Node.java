package main.data;

import main.data.Person;

public class Node {

    private Person person, connection;
    private double posX, posY;

    public Node(Person person, double posX, double posY) {
        this.person = person;
        this.posX = posX;
        this.posY = posY;
    }

    public void setConnection(Person connection) {
        this.connection = connection;
    }
}
