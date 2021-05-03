package main.data;

import javafx.scene.layout.AnchorPane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Ellipse;
import javafx.scene.text.Text;

public class Canvas {
    private static AnchorPane canvas;
    private static double mousePosX, mousePosY;

    public static void addToCanvas(Node node) {
        canvas.getChildren().add(node.getEllipse());
        canvas.getChildren().add(node.getText());
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
