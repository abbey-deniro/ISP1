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

    @FXML private void addItem(ActionEvent event){
        i.read();
        super.i.addItems(txtName.getText(), Integer.parseInt(txtQuantity.getText()), Float.parseFloat(txtPrice.getText()), Integer.parseInt(txtMinQuantity.getText()), txtCategory.getText());
        i.write();
        Stage s = (Stage) btnAdd.getScene().getWindow();
        s.close();

//        ObservableList<Item> list = FXCollections.observableArrayList(i.getItems());
//        super.table.setItems(list);
    }
    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        System.out.println(super.i.getItems());
    }
}
