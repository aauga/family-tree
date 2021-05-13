package main;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import main.util.fileUtil.ExtensionCSV;
import main.util.fileUtil.FileExtension;

public class Main extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception {
        int windowWidth = 600;
        int windowHeight = 400;

        Parent root = FXMLLoader.load(getClass().getResource("layouts/mainLayout.fxml"));
        primaryStage.setTitle("Family Tree");
        primaryStage.setScene(new Scene(root, windowWidth, windowHeight));
        primaryStage.setMinWidth(windowWidth + 15);
        primaryStage.setMinHeight(windowHeight + 40);
        primaryStage.show();
        primaryStage.setOnCloseRequest(e -> {
            ExtensionCSV fileExtension = new ExtensionCSV();
            fileExtension.saveTempFile();
        });
    }

    public static void main(String[] args) {
        launch(args);
    }
}
