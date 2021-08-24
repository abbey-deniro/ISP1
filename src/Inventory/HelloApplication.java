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

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class HelloApplication implements Initializable {
    protected Inventory i = new Inventory();
    protected int index;
    @FXML
    private Label welcomeText;

    @FXML private TableView<Item> table;
    @FXML private TableColumn<Item, String> categoryCol;
    @FXML private TableColumn<Item, String> itemCol;
    @FXML private TableColumn<Item, String> quantityCol;
    @FXML private TableColumn<Item, String> priceCol;
    @FXML private Button btnEdit;
    @FXML private Button btnAdd;

    @FXML
    protected void onHelloButtonClick() {
        welcomeText.setText("Welcome to JavaFX Application!");
    }

    @FXML private void btnAddItem(ActionEvent event){
        Stage popup = new Stage();
        try {
            Scene scene = new Scene(FXMLLoader.load(getClass().getResource("addItem.fxml")), 1000, 800);
            popup.setTitle("Add an item");
            popup.setScene(scene);
            popup.setWidth(300);
            popup.setHeight(400);

        }catch(Exception e){e.printStackTrace();}
        popup.showAndWait();

        loadTable();
    }

    @FXML private void btnRemoveItem(ActionEvent event){
        Item item = table.getSelectionModel().getSelectedItem();
        table.getItems().remove(item);

        int index = i.getItems().indexOf(item);
        i.getItems().remove(index);

        i.write();
    }

    @FXML private void btnEditItem(ActionEvent event) throws IOException {
        Item item = table.getSelectionModel().getSelectedItem();
        int index = i.getItems().indexOf(item);

        Stage popup = new Stage();
        Scene scene = new Scene(FXMLLoader.load(getClass().getResource("addItem.fxml")), 1000, 800);
        Button b = (Button) scene.lookup("#btnAdd");
        b.setText("Save");

        TextField category = (TextField) scene.lookup("#txtCategory");
        TextField name = (TextField) scene.lookup("#txtName");
        TextField quantity = (TextField) scene.lookup("#txtQuantity");
        TextField minQuantity = (TextField) scene.lookup("#txtMinQuantity");
        TextField price = (TextField) scene.lookup("#txtPrice");

        try {
            category.setText(item.getCategory());
            name.setText(item.getName());
            quantity.setText(Integer.toString(item.getQuantity()));
            minQuantity.setText(Integer.toString(item.getMinNumber()));
            price.setText(Float.toString(item.getPrice()));
        }catch(Exception e){e.printStackTrace();}

        popup.setTitle("Edit an item");
        popup.setUserData(index);
        popup.setScene(scene);
        popup.setWidth(300);
        popup.setHeight(400);
        popup.showAndWait();

        loadTable();
    }

    public void loadTable(){
        i.read();
        if(i.getItems().size() == 0)
            return;

        ObservableList<Item> list = FXCollections.observableArrayList(i.getItems());
        table.setItems(list);
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        categoryCol.setCellValueFactory(new PropertyValueFactory<Item, String>("category"));
        itemCol.setCellValueFactory(new PropertyValueFactory<Item, String>("name"));
        quantityCol.setCellValueFactory(new PropertyValueFactory<Item, String>("quantity"));
        priceCol.setCellValueFactory(new PropertyValueFactory<Item, String>("price"));

        loadTable();
    }
}