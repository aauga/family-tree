package main.data;

import javafx.scene.paint.Color;
import javafx.scene.shape.Ellipse;
import javafx.scene.text.Text;

public class Node {

    private final Text text;
    private final Ellipse ellipse;

    private final Person person;
    private final double posX, posY;

    public Node(Person person, double posX, double posY) {
        this.person = person;
        this.posX = posX;
        this.posY = posY;

        text = new Text();
        ellipse = new Ellipse();

        createNodeLayout();
    }

    private void createNodeLayout() {
        text.setText(person.getFirstName() + " " + person.getLastName().charAt(0) + ".");

        double textWidth = text.getBoundsInLocal().getWidth();
        double textHeight = text.getBoundsInLocal().getHeight();

        // Make text in center of ellipse
        text.setLayoutX(posX - textWidth / 2.0);
        text.setLayoutY(posY - textHeight / 4.0);
        text.setFill(Color.WHITE);

        ellipse.setLayoutX(posX);
        ellipse.setLayoutY(posY - textHeight / 2.0);
        ellipse.setRadiusX(textWidth * 0.8);
        ellipse.setRadiusY(textHeight);
        ellipse.setFill(Color.GREEN);
    }

    public Ellipse getEllipse() {
        return ellipse;
    }

    public Text getText() {
        return text;
    }

    public double getPosX() {
        return posX;
    }

    public double getPosY() {
        return posY;
    }
}
