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
    public void loginToStore(ActionEvent ae) throws IOException {

        Node node = (Node)ae.getSource();   //getSource returnerar var actioneventet hände
        Stage stage = (Stage)node.getScene().getWindow();
        FXMLLoader loader = new FXMLLoader(getClass().getResource("store.fxml"));
        Parent root = loader.load();
        Scene scene = new Scene(root);
        stage.setScene(scene);
    }
    public boolean correctUser(String name, String password){
        String dbName = "Marcus"; // Get this from DB
        String dbPassword = "secret";
        if(name == dbName && password == dbPassword) {
            System.out.println("User information correct");
            return true;
        }
        else {
            System.out.println("Wrong username or password");
            return false;
        }
    }
}
