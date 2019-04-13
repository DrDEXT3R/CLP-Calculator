package gui.controllers;

import gui.MainWindow;
import javafx.beans.property.SimpleStringProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.Arrays;

/**
 * Abstract class template for controllers.
 *
 * @author Tomasz Strzoda
 */
public abstract class BasicOptions {

    // Variables used to make movable application.
    protected double xOffset = 0;
    protected double yOffset = 0;

    protected void makeMovable(Stage stage, Scene page) {
        page.setOnMousePressed(e -> {
            xOffset = e.getSceneX();
            yOffset = e.getSceneY();
        });

        page.setOnMouseDragged(e -> {
            stage.setX(e.getScreenX() - xOffset);
            stage.setY(e.getScreenY() - yOffset);
        });
    }

    protected void loadNewScene(String location) throws IOException {
        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(getClass().getResource(location));
        Scene scene = new Scene(loader.load());

        MainWindow mainWindow = new MainWindow();
        Stage newWindow = mainWindow.getStage();

        makeMovable(newWindow, scene);
        newWindow.setScene(scene);
        newWindow.show();
    }

    protected void fillTableView(String[][] solution, TableView tableView, TableColumn[] tableCols) {
        ObservableList<String[]> data = FXCollections.observableArrayList();
        data.addAll(Arrays.asList(solution));
        tableView.setItems(data);

        for (int i = 0; i < tableCols.length ; i++)
            this.setColumn(tableCols[i], i);
}

    protected void setColumn(TableColumn<String[], String> column, int colNo) {
        column.setCellValueFactory(cellData -> {
            String[] x = cellData.getValue();
            return new SimpleStringProperty(x != null && x.length>1 ? x[colNo] : "<no value>");
        });
    }

}