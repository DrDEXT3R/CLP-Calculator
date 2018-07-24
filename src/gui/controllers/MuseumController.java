package gui.controllers;

import gui.MainWindow;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.stage.Stage;

/**
 * FXML Controller class for museum time schedule.
 *
 * @author Tomasz Strzoda
 */
public class MuseumController implements Initializable {
    
    @FXML
    private Button home;

    @Override
    public void initialize(URL url, ResourceBundle rb) {
    }    
    
    @FXML
    public void homeAction(ActionEvent e) throws IOException {
        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(getClass().getResource("/gui/FXML/homePage.fxml"));
        Scene scene = new Scene(loader.load());
        MainWindow mainWindow = new MainWindow();
        Stage newWindow = mainWindow.getInstance();
        newWindow.setScene(scene);
        newWindow.show();
    }
    
}