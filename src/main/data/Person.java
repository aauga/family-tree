package main.data;

import main.util.CanvasUtil;

import java.util.ArrayList;

public class Person {
    private String firstName, lastName;
    private String personalCode;
    private String birthPlace;
    private int birthYear;

    private final Node node;
    private final ArrayList<Person> connections;

    public Person(String firstName, String lastName, String personalCode, int birthYear, String birthPlace) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.personalCode = personalCode;
        this.birthYear = birthYear;
        this.birthPlace = birthPlace;
        this.connections = new ArrayList<>();
        node = new Node(this, CanvasUtil.getMousePosX(), CanvasUtil.getMousePosY());
    }

    public Person(String firstName, String lastName, String personalCode, int birthYear, String birthPlace, double posX, double posY) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.personalCode = personalCode;
        this.birthYear = birthYear;
        this.birthPlace = birthPlace;
        this.connections = new ArrayList<>();
        node = new Node(this, posX, posY);
    }

    public void addConnection(Person person) {
        connections.add(person);
    }

    public void removeConnection(Person person) {
        connections.remove(person);
    }

    public void updateNode() {
        node.updateInformation(this);
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

    public int getBirthYear() {
        return birthYear;
    }

    public String getBirthPlace() {
        return birthPlace;
    }

    public Node getNode() {
        return node;
    }

    public ArrayList<Person> getConnections() {
        return connections;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public void setPersonalCode(String personalCode) {
        this.personalCode = personalCode;
    }

    public void setBirthYear(int birthYear) {
        this.birthYear = birthYear;
    }

    public void setBirthPlace(String birthPlace) {
        this.birthPlace = birthPlace;
    }

    @Override
    public String toString() {
        return firstName + " " + lastName + " (" + personalCode + ")";
    }
}
