package main.util.fileUtil;

import main.data.ConnectionLine;
import main.data.Node;
import main.data.Person;
import main.data.Storage;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;

public class ExtensionCSV extends FileExtension {
    @Override
    public void saveToFile(String location) {
        File file = new File(location);
        String content = generateContent();

        try {
            OutputStreamWriter writer = new OutputStreamWriter(new FileOutputStream(file), StandardCharsets.UTF_8);
            writer.write(content);
            writer.close();
        } catch(IOException e) {
            e.printStackTrace();
        }
    }

    private String generateContent() {
        StringBuilder text = new StringBuilder();
        ArrayList<Person> peopleList = Storage.getPeopleArray();
        ArrayList<ConnectionLine> connectionList = Storage.getConnectionLineArray();

        generatePeopleList(text, peopleList);
        generateConnectionList(text, connectionList);

        return String.valueOf(text);
    }

    private void generatePeopleList(StringBuilder text, ArrayList<Person> list) {
        text.append(String.format("%d\n", list.size()));

        for(Person person : list) {
            Node node = person.getNode();
            text.append(String.format("%s;%s;%s;%d;%s;%.1f;%.1f\n", person.getFirstName(), person.getLastName(), person.getPersonalCode(), person.getBirthYear(), person.getBirthPlace(), node.getPosX(), node.getPosY()));
        }
    }

    private void generateConnectionList(StringBuilder text, ArrayList<ConnectionLine> list) {
        text.append(String.format("%d\n", list.size()));

        for(ConnectionLine connection : list) {
            Person firstPerson = connection.getFirstPerson();
            Person secondPerson = connection.getSecondPerson();

            text.append(String.format("%s;%s;%s\n", firstPerson.getPersonalCode(), connection.getConnectionType(), secondPerson.getPersonalCode()));
        }
    }
}
