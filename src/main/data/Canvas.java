package main.data;

import javafx.scene.layout.AnchorPane;
import javafx.scene.shape.Ellipse;
import javafx.scene.text.Text;

public class Canvas {
    private static AnchorPane canvas;
    private static double mousePosX, mousePosY;

    public static void addNode(Person person) {
        Node node = person.getNode();

        canvas.getChildren().add(node.getEllipse());
        canvas.getChildren().add(node.getText());
    }

    public static void addLine(ConnectionLine connectionLine) {
        canvas.getChildren().add(0, connectionLine.getLine());
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
