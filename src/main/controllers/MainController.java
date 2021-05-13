package main.controllers;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.MenuItem;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Modality;
import javafx.stage.Stage;
import main.util.CanvasUtil;
import main.util.fileUtil.ExtensionCSV;
import main.util.fileUtil.FileUtil;
import main.util.fileUtil.LoadFileUtil;

import java.io.IOException;

public class MainController {

    @FXML
    private AnchorPane canvas;

    @FXML
    private Button showTableButton;

    public void initialize() {
        CanvasUtil.setCanvas(canvas);
        LoadFileUtil.loadTempFile();
    }

    @FXML
    public void showCreatePersonWindow() {
        canvas.setOnMouseClicked(mouseEvent -> {
            if(!CanvasUtil.getClickedOnElement()) {
                CanvasUtil.setMousePosX(mouseEvent.getX());
                CanvasUtil.setMousePosY(mouseEvent.getY());

                Parent parent = null;
                Stage stage = new Stage();
                FXMLLoader loader = new FXMLLoader(getClass().getResource("../layouts/createPerson.fxml"));

                try {
                    parent = loader.load();
                } catch (IOException e) {
                    e.printStackTrace();
                }

                stage.setTitle("Add a Person");
                stage.setScene(new Scene(parent, 300, 350));
                stage.setResizable(false);

                stage.initModality(Modality.APPLICATION_MODAL);
                stage.show();
            }
        });
    }

    @FXML
    public void showCreateConnectionWindow() throws IOException {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("../layouts/createConnection.fxml"));
        Parent parent = loader.load();
        Stage stage = new Stage();

        stage.setTitle("Create a Connection");
        stage.setScene(new Scene(parent, 300, 300));
        stage.setResizable(false);

        stage.initModality(Modality.APPLICATION_MODAL);
        stage.show();
    }

    @FXML
    public void showTableWindow() throws IOException {
        showTableButton.setDisable(true);

        FXMLLoader loader = new FXMLLoader(getClass().getResource("../layouts/tableLayout.fxml"));
        Parent parent = loader.load();
        Stage stage = new Stage();

        stage.setTitle("Table");
        stage.setScene(new Scene(parent, 800, 400));

        stage.show();
        stage.setOnCloseRequest(e -> showTableButton.setDisable(false));
    }

    @FXML
    public void enlargeCanvas() {
        canvas.setPrefHeight(canvas.getHeight() + 50.0);
        canvas.setPrefWidth(canvas.getWidth() + 50.0);
    }

    @FXML
    public void handleOpenFileMenuItem() {
        FileUtil fileUtil = new FileUtil();
        String path = fileUtil.selectLocation(true);

        LoadFileUtil.loadFile(path);
    }

    @FXML
    public void handleSaveToFileMenuItem() {
        FileUtil fileUtil = new FileUtil();
        String path = fileUtil.selectLocation(false);

        fileUtil.saveFile(path);
    }

    @FXML
    public void handleCloseMenuItem() {
        ExtensionCSV fileExtension = new ExtensionCSV();
        fileExtension.saveTempFile();

        System.exit(0);
    }
}
