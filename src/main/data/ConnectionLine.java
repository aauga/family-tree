package main.data;

import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.paint.Color;
import javafx.scene.paint.Paint;
import javafx.scene.shape.Line;
import javafx.stage.Modality;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.Random;

public class ConnectionLine {
    private final Line line;
    private final Person firstPerson, secondPerson;
    private String connectionType;

    public ConnectionLine(Person firstPerson, Person secondPerson, String connectionType) {
        this.firstPerson = firstPerson;
        this.secondPerson = secondPerson;
        this.connectionType = connectionType;

        line = new Line();

        handleMousePressed();
        createLine();
    }

    private void handleMousePressed() {
        line.setOnMouseClicked(mouseEvent -> {
            Canvas.setSelectedLine(this);

            try {
                showEditConnectionWindow();
            } catch (IOException e) {
                e.printStackTrace();
            }
        });
    }

    private void showEditConnectionWindow() throws IOException {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("../layouts/editConnection.fxml"));
        Parent parent = loader.load();
        Stage stage = new Stage();

        stage.setTitle("Edit a Connection");
        stage.setScene(new Scene(parent, 300, 300));
        stage.setResizable(false);

        stage.initModality(Modality.APPLICATION_MODAL);
        stage.show();
        stage.setOnCloseRequest(windowEvent -> Canvas.setClickedOnElement(false));
    }

    private void createLine() {
        line.setStartX(firstPerson.getNode().getPosX());
        line.setStartY(firstPerson.getNode().getPosY());
        line.setEndX(secondPerson.getNode().getPosX());
        line.setEndY(secondPerson.getNode().getPosY());
        line.setStroke(randomColor());
        line.setStrokeWidth(3.0);
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

    /**
     * Function checks whether a line is connected to a person or not
     *
     * @param person Person which will be compared to the people connected by the line
     * @return True if this line is connected to a person and false otherwise
     */
    public boolean isConnectedTo(Person person) {
        return person == firstPerson || person == secondPerson;
    }

    public Line getLine() {
        return line;
    }

    public Person getFirstPerson() {
        return firstPerson;
    }

    public Person getSecondPerson() {
        return secondPerson;
    }

    public String getConnectionType() {
        return connectionType;
    }

    public void setConnectionType(String connectionType) {
        this.connectionType = connectionType;
    }
}
