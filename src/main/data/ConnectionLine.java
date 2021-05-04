package main.data;

import javafx.scene.shape.Line;

public class ConnectionLine {
    private final Line line;
    private final Person firstPerson, secondPerson;

    public ConnectionLine(Person firstPerson, Person secondPerson) {
        line = new Line();

        this.firstPerson = firstPerson;
        this.secondPerson = secondPerson;

        createLine();
    }

    private void createLine() {
        line.setStartX(firstPerson.getNode().getPosX());
        line.setStartY(firstPerson.getNode().getPosY());
        line.setEndX(secondPerson.getNode().getPosX());
        line.setEndY(secondPerson.getNode().getPosY());
    }

    public Line getLine() {
        return line;
    }
}
