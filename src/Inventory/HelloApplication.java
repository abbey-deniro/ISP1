package Inventory;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;

import java.net.URL;
import java.util.ResourceBundle;

public class HelloApplication implements Initializable {
    @FXML
    private Label welcomeText;

    @FXML TableView<Item> table;
    @FXML TableColumn<Item, String> categoryCol;
    @FXML TableColumn<Item, String> itemCol;
    @FXML TableColumn<Item, String> quantityCol;
    @FXML TableColumn<Item, String> priceCol;

    @FXML
    protected void onHelloButtonClick() {
        welcomeText.setText("Welcome to JavaFX Application!");
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        categoryCol.setCellValueFactory(new PropertyValueFactory<Item, String>("category"));
        itemCol.setCellValueFactory(new PropertyValueFactory<Item, String>("name"));
        quantityCol.setCellValueFactory(new PropertyValueFactory<Item, String>("quantity"));
        priceCol.setCellValueFactory(new PropertyValueFactory<Item, String>("price"));

        Inventory i = new Inventory();
        i.addItems("Cheese", 12, 1.40f, 1, 2, "Ingredient");
        i.write();
        //i.read();

        ObservableList<Item> list = FXCollections.observableArrayList(i.getItems());
        table.setItems(list);
    }
}