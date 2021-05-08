package main.data;

import java.util.ArrayList;

public class Person {
    private final String firstName, lastName;
    private final String personalCode;
    private final String birthPlace;
    private final int birthYear;

    private final Node node;
    private final ArrayList<Person> connections;

    public Person(String firstName, String lastName, String personalCode, int birthYear, String birthPlace) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.personalCode = personalCode;
        this.birthYear = birthYear;
        this.birthPlace = birthPlace;
        this.connections = new ArrayList<>();
        node = new Node(this, Canvas.getMousePosX(), Canvas.getMousePosY());
    }

    public void addConnection(Person person) {
        connections.add(person);
    }

    public void removeConnection(Person person) {
        connections.remove(person);
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public String getPersonalCode() {
        return personalCode;
    }

    public Node getNode() {
        return node;
    }

    public ArrayList<Person> getConnections() {
        return connections;
    }

    @Override
    public String toString() {
        return firstName + " " + lastName.charAt(0) + ". (" + personalCode + ")";
    }
}
