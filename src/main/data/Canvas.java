package main.data;

public class Canvas {
    private static double mousePosX, mousePosY;

    public static double getMousePosX() {
        return mousePosX;
    }

    public static double getMousePosY() {
        return mousePosY;
    }

    public static void setMousePosX(double mousePosX) {
        Canvas.mousePosX = mousePosX;
    }

    public static void setMousePosY(double mousePosY) {
        Canvas.mousePosY = mousePosY;
    }
}
