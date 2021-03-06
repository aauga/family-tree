package main.util.fileUtil;

import main.data.ConnectionLine;
import main.data.Node;
import main.data.Person;
import main.data.Storage;
import main.util.CanvasUtil;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class LoadFileUtil {

    private static String line;

    public static void loadFile(String path) {
        CanvasUtil.clearCanvas();
        Storage.clearData();

        File file = new File(path);

        try {
            Scanner scanner = new Scanner(file);
            scanPeopleList(scanner);
            scanConnectionList(scanner);
            scanner.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }

    public static void loadTempFile() {
        String path = System.getProperty("java.io.tmpdir") + "\\familyTreeTemp.csv";
        File file = new File(path);

        if(file.exists()) {
            loadFile(path);
        }
    }

    private static void scanPeopleList(Scanner scanner) {
        int num = scanner.nextInt();

        double maxHeight = 0, maxWidth = 0;

        scanner.nextLine();

        for(int i = 0; i < num; i++) {
            line = scanner.nextLine();

            String firstName = getField();
            String lastName = getField();
            String personalCode = getField();
            int birthYear = Integer.parseInt(getField());
            String birthPlace = getField();
            double posX = Double.parseDouble(getField());
            double posY = Double.parseDouble(line);

            if(posX > maxWidth) {
                maxWidth = posX;
            }

            if(posY > maxHeight) {
                maxHeight = posY;
            }

            Person person = new Person(firstName, lastName, personalCode, birthYear, birthPlace, posX, posY);

            Storage.addPerson(person);
            CanvasUtil.addNode(person.getNode());
        }

        CanvasUtil.setCanvasHeight(maxHeight + 50.0);
        CanvasUtil.setCanvasWidth(maxWidth + 50.0);
    }

    private static void scanConnectionList(Scanner scanner) {
        int num = scanner.nextInt();

        scanner.nextLine();

        for(int i = 0; i < num; i++) {
            line = scanner.nextLine();

            String firstPersonalCode = getField();
            String connectionType = getField();
            String secondPersonalCode = line;

            Person firstPerson = Storage.getPersonByPersonalCode(firstPersonalCode);
            Person secondPerson = Storage.getPersonByPersonalCode(secondPersonalCode);

            if(firstPerson != null && secondPerson != null) {
                firstPerson.addConnection(secondPerson);
                secondPerson.addConnection(firstPerson);

                ConnectionLine connectionLine = new ConnectionLine(firstPerson, secondPerson, connectionType);
                Storage.addLine(connectionLine);
                CanvasUtil.addLine(connectionLine);
            }
        }
    }

    private static String getField() {
        int index = line.indexOf(';');
        String field = line.substring(0, index);

        line = line.substring(index + 1);

        return field;
    }
}
