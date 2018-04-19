package sample;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;

import java.net.URL;
import java.util.ResourceBundle;

public class Controller implements Initializable{

    @FXML private Button loginButton;

    @Override
    public void initialize(URL location, ResourceBundle resources) {

    }
    @FXML
    public void buttonTest(ActionEvent ae){
        System.out.println("IT WORKS!");
    }
}
