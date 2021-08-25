package Inventory;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Popup;
import javafx.stage.Stage;
import javafx.stage.Window;
import sample.Main;

import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;

public class AddItemController extends HelloApplication implements Initializable{
    @FXML private Button btnAdd;
    @FXML private TextField txtCategory;
    @FXML private TextField txtName;
    @FXML private TextField txtQuantity;
    @FXML private TextField txtMinQuantity;
    @FXML private TextField txtPrice;

    @FXML private void addItem(ActionEvent event) {
        int index = -1;
        Stage stage = (Stage) btnAdd.getScene().getWindow();

        try {
            index = (int) stage.getUserData();
        } catch (Exception e) {
        }

        i.read();
        if (index == -1){
            try {
                super.i.addItems(txtName.getText(), Integer.parseInt(txtQuantity.getText()), Float.parseFloat(txtPrice.getText()), Integer.parseInt(txtMinQuantity.getText()), txtCategory.getText());
            } catch (Exception e) {
                System.out.println("Invalid input. Please try again.");
            }
        }
        else{
            try {
                Item item = super.i.getItems().get(index);
                item.setCategory(txtCategory.getText());
                item.setName(txtName.getText());
                item.setQuantity(Integer.parseInt(txtQuantity.getText()));
                item.setMinNumber(Integer.parseInt(txtMinQuantity.getText()));
                item.setPrice(Float.parseFloat(txtPrice.getText()));
            }catch (Exception e) {
                System.out.println("Invalid input. Please try again.");
            }
        }

        i.write();
        stage.close();
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

    }
}
