package main.data;

import javafx.scene.layout.AnchorPane;
import javafx.scene.shape.Line;

import java.util.ArrayList;
import java.util.Timer;
import java.util.TimerTask;

public class Canvas {
    private static AnchorPane canvas;
    private static double mousePosX, mousePosY;

    // Used for checking when an user clicks on a node or connection line
    private static boolean clickedOnElement;

    private static Person selectedPerson;
    private static ConnectionLine selectedLine;

    // Nodes

    public static void addNode(Node node) {
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

    /**
     * Function removes all connection lines which were connected to a node
     *
     * @param person Reference to a person whose connections to remove
     */
    public static void removeLinesConnectedToNode(Person person) {
        ArrayList<ConnectionLine> lines = Storage.getConnectionLineArray();

        for(ConnectionLine line : lines) {
            if(line.isConnectedTo(person)) {
                removeLine(line.getLine());
            }
        }
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

    public static Person getSelectedPerson() {
        return selectedPerson;
    }

    public static ConnectionLine getSelectedLine() {
        return selectedLine;
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

    public static void setSelectedPerson(Person person) {
        selectedPerson = person;
    }

    public static void setSelectedLine(ConnectionLine line) {
        selectedLine = line;
    }
}
