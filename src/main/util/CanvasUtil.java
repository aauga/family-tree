package main.util;

import javafx.scene.layout.AnchorPane;
import javafx.scene.shape.Ellipse;
import javafx.scene.shape.Line;
import javafx.scene.text.Text;
import main.data.ConnectionLine;
import main.data.Node;
import main.data.Person;
import main.data.Storage;

import java.util.ArrayList;

public class CanvasUtil {
    private static AnchorPane canvas;
    private static double mousePosX, mousePosY;

    // Used for checking when an user clicks on a node or connection line
    private static boolean clickedOnElement;

    private static Person selectedPerson;
    private static ConnectionLine selectedLine;

    // Nodes

    public static void addNode(Node node) {
        Ellipse ellipse = node.getEllipse();
        Text text = node.getText();

        if(!canvas.getChildren().contains(ellipse) && !canvas.getChildren().contains(text)) {
            canvas.getChildren().add(node.getEllipse());
            canvas.getChildren().add(node.getText());
        }
    }

    public static void removeNode(Node node) {
        Ellipse ellipse = node.getEllipse();
        Text text = node.getText();

        if(canvas.getChildren().contains(ellipse)) {
            canvas.getChildren().remove(node.getEllipse());
        }

        if(canvas.getChildren().contains(text)) {
            canvas.getChildren().remove(node.getText());
        }
    }

    // Connection lines

    public static void addLine(ConnectionLine connectionLine) {
        Line line = connectionLine.getLine();

        if(!canvas.getChildren().contains(line)) {
            canvas.getChildren().add(0, connectionLine.getLine());
        }
    }

    public static void removeLine(Line line) {
        if(canvas.getChildren().contains(line)) {
            canvas.getChildren().remove(line);
        }
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

    // Filtering

    public static void updateWithFilteredData(ArrayList<Person> personList, ArrayList<ConnectionLine> connectionList) {
        canvas.getChildren().clear();

        for(Person person : personList) {
            addNode(person.getNode());
        }

        for(ConnectionLine connection : connectionList) {
            addLine(connection);
            addNode(connection.getFirstPerson().getNode());
            addNode(connection.getSecondPerson().getNode());
        }
    }

    // Getters

    public static AnchorPane getCanvas() {
        return canvas;
    }

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
        CanvasUtil.canvas = canvas;
    }

    public static void setMousePosX(double mousePosX) {
        CanvasUtil.mousePosX = mousePosX;
    }

    public static void setMousePosY(double mousePosY) {
        CanvasUtil.mousePosY = mousePosY;
    }

    public static void setClickedOnElement(boolean state) {
        clickedOnElement = state;
    }

    public static void setSelectedPerson(Person person) {
        selectedPerson = person;
    }

    public static void setSelectedLine(ConnectionLine line) {
        selectedLine = line;
    }
}
