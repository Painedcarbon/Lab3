package sample;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class ControllerStore implements Initializable{

    @FXML private Button buttonGoBack;
    @FXML private Button buttonBuy;

    @Override
    public void initialize(URL location, ResourceBundle resources) {

    }
    @FXML
    public void handleBuyButton(ActionEvent ae){
        System.out.println("You've bought 5 bananas");
    }
    @FXML
    public void handleBackButton(ActionEvent ae) throws IOException {
        Node node = (Node)ae.getSource();
        Stage stage = (Stage)node.getScene().getWindow();
        FXMLLoader loader = new FXMLLoader(getClass().getResource("sample.fxml"));
        Parent root = loader.load();
        Scene scene = new Scene(root);
        stage.setScene(scene);
    }
}