package Inventory;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Popup;
import javafx.stage.Stage;
import javafx.stage.Window;

import java.net.URL;
import java.util.ResourceBundle;

public class HelloApplication implements Initializable {
    protected Inventory i = new Inventory();
    @FXML
    private Label welcomeText;

    @FXML protected TableView<Item> table;
    @FXML TableColumn<Item, String> categoryCol;
    @FXML TableColumn<Item, String> itemCol;
    @FXML TableColumn<Item, String> quantityCol;
    @FXML TableColumn<Item, String> priceCol;
    @FXML Button btnAdd;

    @FXML
    protected void onHelloButtonClick() {
        welcomeText.setText("Welcome to JavaFX Application!");
    }

    @FXML private void btnAddItem(ActionEvent event){
        System.out.println(i.getItems());
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