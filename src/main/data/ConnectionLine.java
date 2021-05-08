package main.data;

import javafx.scene.paint.Color;
import javafx.scene.paint.Paint;
import javafx.scene.shape.Line;
import java.util.Random;

public class ConnectionLine {
    private Line line;
    private final Person firstPerson, secondPerson;

    public ConnectionLine(Person firstPerson, Person secondPerson) {
        this.firstPerson = firstPerson;
        this.secondPerson = secondPerson;

        line = new Line();

        line.setOnMouseClicked(mouseEvent -> {
            removeLine();
        });

        createLine();
    }

    private void createLine() {
        line.setStartX(firstPerson.getNode().getPosX());
        line.setStartY(firstPerson.getNode().getPosY());
        line.setEndX(secondPerson.getNode().getPosX());
        line.setEndY(secondPerson.getNode().getPosY());
        line.setStroke(randomColor());
    }

    public void removeLine() {
        firstPerson.removeConnection(secondPerson);
        secondPerson.removeConnection(firstPerson);
        line = null;
    }

    /**
     * Function generates random colors
     *
     * @return Generated random color
     */
    private Paint randomColor() {
        Random random = new Random();

        double r = random.nextDouble();
        double g = random.nextDouble();
        double b = random.nextDouble();

        return Color.color(r, g, b);
    }

    public Line getLine() {
        return line;
    }
}
