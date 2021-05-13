package main.util.fileUtil;

import javafx.stage.FileChooser;
import javafx.stage.Stage;

import java.io.File;

public class FileUtil {

    public String selectLocation() {
        FileChooser fileChooser = new FileChooser();

        FileChooser.ExtensionFilter csvExtension = new FileChooser.ExtensionFilter("CSV files (*.csv)", "*.csv");
        fileChooser.getExtensionFilters().add(csvExtension);

        FileChooser.ExtensionFilter pdfExtension = new FileChooser.ExtensionFilter("PDF files (*.pdf)", "*.pdf");
        fileChooser.getExtensionFilters().add(pdfExtension);

        File file = fileChooser.showSaveDialog(new Stage());

        return file.getAbsolutePath();
    }

    public String getFileExtension(String path) {
        int lastIndex = path.lastIndexOf('.');

        return path.substring(lastIndex + 1);
    }

    public void saveFile(String path) {
        FileExtension fileExtension = new ExtensionCSV();

        if(getFileExtension(path).equals("pdf")) {
            fileExtension = new ExtensionPDF();
        }

        fileExtension.saveToFile(path);
    }
}
