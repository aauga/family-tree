package main.data;

import javafx.scene.layout.AnchorPane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Ellipse;
import javafx.scene.text.Text;

public class Canvas {
    private static AnchorPane canvas;
    private static double mousePosX, mousePosY;

    public static void addToCanvas(Person person) {
        Ellipse ellipse = new Ellipse();
        Text text = new Text();

        String firstName = person.getFirstName();
        String lastName = person.getLastName();

        text.setText(firstName + " " + lastName.charAt(0) + ".");

        double textWidth = text.getBoundsInLocal().getWidth();
        double textHeight = text.getBoundsInLocal().getHeight();

        text.setLayoutX(mousePosX - textWidth / 2.0);
        text.setLayoutY(mousePosY - textHeight / 4.0);
        text.setFill(Color.WHITE);

        ellipse.setLayoutX(mousePosX);
        ellipse.setLayoutY(mousePosY - textHeight / 2.0);
        ellipse.setRadiusX(textWidth * 0.8);
        ellipse.setRadiusY(textHeight);
        ellipse.setFill(Color.GREEN);

        canvas.getChildren().add(ellipse);
        canvas.getChildren().add(text);
    }

    public static double getMousePosX() {
        return mousePosX;
    }

    public static double getMousePosY() {
        return mousePosY;
    }

    public static void setCanvas(AnchorPane canvas) {
        Canvas.canvas = canvas;
    }

    public static void setMousePosX(double mousePosX) {
        Canvas.mousePosX = mousePosX;
    }

    public static void setMousePosY(double mousePosY) {
        Canvas.mousePosY = mousePosY;
    }
}
