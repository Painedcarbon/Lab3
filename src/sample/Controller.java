package sample;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class Controller implements Initializable{

    @FXML private Button loginButton;
    @FXML private AnchorPane anchorPane;

    @Override
    public void initialize(URL location, ResourceBundle resources) {

    }
    @FXML
    public void buttonTest(ActionEvent ae){
        System.out.println("IT WORKS!");
        try{
            AnchorPane pane = FXMLLoader.load(getClass().getResource("store.fxml"));
            anchorPane.getChildren().setAll(pane);
        }catch (Exception e){
            System.out.println(e);
        }
    }
    @FXML
    public void handleBackButton(ActionEvent ae) throws IOException {
        //Skapar en ny node och sätter den till actionEvents source
        Node node = (Node)ae.getSource();   //getSource returnerar var actioneventet hände
        //Skapar en stage som sätter scenen till den vi är på
        Stage stage = (Stage)node.getScene().getWindow();

        //skapar en loader som sätts till "samplescene2"
        FXMLLoader loader = new FXMLLoader(getClass().getResource("store.fxml"));
        //skapar en ny parent som sätts till loader
        Parent root = loader.load();

        //skapar en ny scene
        Scene scene = new Scene(root);
        //byter scene
        stage.setScene(scene);
    }
}
