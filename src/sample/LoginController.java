package sample;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class LoginController implements Initializable {

    @FXML
    private ComboBox<String> storeCombo;
    @FXML
    private TextField textName;
    @FXML
    private PasswordField textPassword;
    @FXML
    private Label errorMessage;

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        storeCombo.setValue("YATT");
        storeCombo.getItems().addAll("YATT", "SQS");

        textName.focusedProperty().addListener((ChangeListener -> errorMessage.setText("")));
        textPassword.focusedProperty().addListener((ChangeListener -> errorMessage.setText("")));
    }

    @FXML
    public void loginToStore(ActionEvent ae) throws IOException {

        //add user in db: INSERT  INTO user(id,name,password) values (0,'danfeng','123')
        //danfeng,123
        //tobb,123
        //ragmunk,123
        //tröttpappa,123
        String store = storeCombo.getValue();
        String name = textName.getText();
        String password = textPassword.getText();
        System.out.println(store + name + password);

        if (Main.connection.login(store, name, password)) {
            Node node = (Node) ae.getSource();
            Stage stage = (Stage) node.getScene().getWindow();

            Parent root = FXMLLoader.load(getClass().getResource("store.fxml"));
            stage.setScene(new Scene(root));
            stage.setTitle(store);
            stage.show();
        } else {
            errorMessage.setText("The username or password id is incorrect");
        }
    }
}
