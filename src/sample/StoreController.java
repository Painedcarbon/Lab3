package sample;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class StoreController implements Initializable {

    @FXML
    private TableView tableView;
    @FXML
    private TableColumn product, quantity;
    @FXML
    private TextField textAmount;

    @Override
    public void initialize(URL location, ResourceBundle resources) {

        DB_Connection connection = new DB_Connection();

        product.setCellValueFactory(new PropertyValueFactory<Product, String>("name"));
        quantity.setCellValueFactory(new PropertyValueFactory<Product, String>("quantity"));
    }

    @FXML
    public void handleBuyButton(ActionEvent ae) {


    }

    @FXML
    public void handleBackButton(ActionEvent ae) throws IOException {
        Node node = (Node) ae.getSource();
        Stage stage = (Stage) node.getScene().getWindow();
        FXMLLoader loader = new FXMLLoader(getClass().getResource("login.fxml"));
        Parent root = loader.load();
        Scene scene = new Scene(root);
        stage.setScene(scene);
    }
}