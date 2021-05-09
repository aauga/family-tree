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
            Canvas.handleClickOnElement();
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
        line.setStrokeWidth(2.0);
    }

    public void removeLine() {
        firstPerson.removeConnection(secondPerson);
        secondPerson.removeConnection(firstPerson);
        Canvas.removeLine(line);
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

    /**
     * Function checks whether a line is connected to a person or not
     *
     * @param person Person which will be compared to the people connected by the line
     * @return True if this line is connected to a person and false otherwise
     */
    public boolean isConnectedTo(Person person) {
        return person == firstPerson || person == secondPerson;
    }
}
