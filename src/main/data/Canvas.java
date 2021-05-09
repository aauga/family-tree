package main.data;

import javafx.scene.layout.AnchorPane;
import javafx.scene.shape.Line;

import java.util.Timer;
import java.util.TimerTask;

public class Canvas {
    private static AnchorPane canvas;
    private static double mousePosX, mousePosY;

    // Used for checking when an user clicks on a node or connection line
    private static boolean clickedOnElement;

    // Nodes

    public static void addNode(Person person) {
        Node node = person.getNode();

        canvas.getChildren().add(node.getEllipse());
        canvas.getChildren().add(node.getText());
    }

    public static void removeNode(Node node) {
        canvas.getChildren().remove(node.getEllipse());
        canvas.getChildren().remove(node.getText());
    }

    // Connection lines

    public static void addLine(ConnectionLine connectionLine) {
        canvas.getChildren().add(0, connectionLine.getLine());
    }

    public static void removeLine(Line line) {
        canvas.getChildren().remove(line);
    }

    public static void removeLinesConnectedToNode(Person person) {

    }

    // Element click

    public static void handleClickOnElement() {
        clickedOnElement = true;

        // Reset variable to false after 0.1s
        Timer timer = new Timer();

        timer.schedule(new TimerTask() {
            @Override
            public void run() {
                clickedOnElement = false;
            }
        }, 100);
    }

    // Getters

    public static double getMousePosX() {
        return mousePosX;
    }

    public static double getMousePosY() {
        return mousePosY;
    }

    public static boolean getClickedOnElement() {
        return clickedOnElement;
    }

    // Setters

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
