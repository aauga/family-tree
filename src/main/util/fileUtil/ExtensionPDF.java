package main.util.fileUtil;

import javafx.embed.swing.SwingFXUtils;
import javafx.scene.SnapshotParameters;
import javafx.scene.image.WritableImage;
import javafx.scene.layout.AnchorPane;
import main.util.CanvasUtil;
import main.util.TableUtil;
import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.pdmodel.PDPage;
import org.apache.pdfbox.pdmodel.PDPageContentStream;
import org.apache.pdfbox.pdmodel.common.PDRectangle;
import org.apache.pdfbox.pdmodel.graphics.image.PDImageXObject;

import javax.imageio.ImageIO;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.IOException;

public class ExtensionPDF extends FileExtension {
    @Override
    public void saveToFile(String location) {
        PDDocument doc = new PDDocument();
        File file = new File(location);

        AnchorPane canvas = CanvasUtil.getCanvas();
        AnchorPane peopleTable = TableUtil.getPeopleTable();
        AnchorPane connectionTable = TableUtil.getConnectionTable();

        drawToNewPage(doc, canvas);

        if(peopleTable != null) {
            drawToNewPage(doc, peopleTable);
        }

        if(connectionTable != null) {
            drawToNewPage(doc, connectionTable);
        }

        try {
            doc.save(file);
            doc.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void drawToNewPage(PDDocument doc, AnchorPane anchorPane) {
        WritableImage nodeshot = anchorPane.snapshot(new SnapshotParameters(), null);

        // Store image in memory
        ByteArrayOutputStream output = new ByteArrayOutputStream();

        try {
            ImageIO.write(SwingFXUtils.fromFXImage(nodeshot, null), "png", output);
            output.close();
        } catch (IOException e) {
            e.printStackTrace();
        }

        PDPage page = new PDPage();
        PDImageXObject pdImage;
        PDPageContentStream content;

        try {
            pdImage = PDImageXObject.createFromByteArray(doc, output.toByteArray(), "png");
            content = new PDPageContentStream(doc, page);

            // Fit image to media box of page
            PDRectangle box = page.getMediaBox();

            double factor = Math.min(box.getWidth() / nodeshot.getWidth(), box.getHeight() / nodeshot.getHeight());

            float nodeshotWidth = (float) (nodeshot.getWidth() * factor);
            float nodeshotHeight = (float) (nodeshot.getHeight() * factor);
            float yCoordinates = box.getHeight() - nodeshotHeight;

            content.drawImage(pdImage, 0, yCoordinates, nodeshotWidth, nodeshotHeight);
            content.close();

            doc.addPage(page);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
