package main.data;

import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.paint.Color;
import javafx.scene.shape.Ellipse;
import javafx.scene.text.Text;
import javafx.stage.Modality;
import javafx.stage.Stage;

import java.io.IOException;

public class Node {

    private final Text text;
    private final Ellipse ellipse;

    private Person person;
    private final double posX, posY;

    public Node(Person person, double posX, double posY) {
        this.person = person;
        this.posX = posX;
        this.posY = posY;

        text = new Text();
        ellipse = new Ellipse();

        handleMousePressed();
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

    private void handleMousePressed() {
        ellipse.setOnMousePressed(mouseEvent -> {
            Canvas.handleClickOnElement();

            if(mouseEvent.getClickCount() == 2) {
                Canvas.removeNode(this);
                Canvas.removeLinesConnectedToNode(person);
                Storage.removePerson(person);
            }
            else {
                try {
                    Canvas.setSelectedPerson(person);
                    showEditPersonWindow();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        });
    }

    private void showEditPersonWindow() throws IOException {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("../layouts/editPerson.fxml"));
        Parent parent = loader.load();
        Stage stage = new Stage();

        stage.setTitle("Edit a Person");
        stage.setScene(new Scene(parent, 300, 350));
        stage.setResizable(false);

        stage.initModality(Modality.APPLICATION_MODAL);
        stage.show();
    }

    public void updateInformation(Person person) {
        this.person = person;
        createNodeLayout();
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
