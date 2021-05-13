package main.util;

import javafx.scene.layout.AnchorPane;

public class TableUtil {
    private static AnchorPane peopleTable;
    private static AnchorPane connectionTable;

    public static AnchorPane getPeopleTable() {
        return peopleTable;
    }

    public static AnchorPane getConnectionTable() {
        return connectionTable;
    }

    public static void setPeopleTable(AnchorPane peopleTable) {
        TableUtil.peopleTable = peopleTable;
    }

    public static void setConnectionTable(AnchorPane connectionTable) {
        TableUtil.connectionTable = connectionTable;
    }
}
