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
import javafx.scene.image.Image;
import javafx.stage.Stage;
import javafx.util.Callback;

import java.io.IOException;
import java.net.URL;
import java.text.NumberFormat;
import java.util.ArrayList;
import java.util.ResourceBundle;

public class HelloApplication implements Initializable {
    protected Inventory i = new Inventory();
    @FXML
    private Label welcomeText;

    @FXML private TableView<Item> table;
    @FXML private TableColumn<Item, String> categoryCol;
    @FXML private TableColumn<Item, String> itemCol;
    @FXML private TableColumn<Item, Integer> quantityCol;
    @FXML private TableColumn<Item, Float> priceCol;
    @FXML private TableColumn<Item, Integer> minQuantityCol;
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
            popup.getIcons().add(new Image("logo.png"));
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
        popup.getIcons().add(new Image("logo.png"));
        popup.setUserData(index);
        popup.setScene(scene);
        popup.setWidth(300);
        popup.setHeight(400);
        popup.showAndWait();

        loadTable();
    }


    @FXML private void addQuantity(ActionEvent event){
        Item item = table.getSelectionModel().getSelectedItem();
        item.setQuantity(item.getQuantity()+1);
        i.write();
        table.refresh();
        table.getSelectionModel().getSelectedItem();

    }

    @FXML private void removeQuantity(ActionEvent event){
        Item item = table.getSelectionModel().getSelectedItem();

        if(item.getQuantity() > 0) {
            item.setQuantity(item.getQuantity() - 1);
        }
        
        i.write();
        table.refresh();
        table.getSelectionModel().getSelectedItem();

    }

    public void loadTable(){
        i.read();
        if(i.getItems().size() == 0)
            return;

        ObservableList<Item> list = FXCollections.observableArrayList(i.getItems());
        table.setItems(list);
    }

    @FXML public void loadSchedule(ActionEvent event){
        try {
            ChangeScene.changeScene(event, "sample/sample.fxml");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        categoryCol.setCellValueFactory(new PropertyValueFactory<Item, String>("category"));
        itemCol.setCellValueFactory(new PropertyValueFactory<Item, String>("name"));
        quantityCol.setCellValueFactory(new PropertyValueFactory<Item, Integer>("quantity"));
        priceCol.setCellValueFactory(new PropertyValueFactory<Item, Float>("price"));
        minQuantityCol.setCellValueFactory(new PropertyValueFactory<Item, Integer>("minNumber"));

        table.setRowFactory(new Callback<TableView<Item>, TableRow<Item>>() {
            @Override
            public TableRow<Item> call(TableView<Item> itemTableView) {
                final TableRow<Item> row = new TableRow<Item>(){
                    @Override
                    protected void updateItem(Item item, boolean empty){
                        super.updateItem(item, empty);
                        //System.out.println(item);

                        if(!empty) {
                            try {
                                if (item.getQuantity() < item.getMinNumber()) {
                                    setStyle("-fx-background-color:lightcoral;");
                                }
                            }catch(Exception e){}
                        }
                    }
                };
                return row;
            }
        });

        priceCol.setCellFactory(new Callback<TableColumn<Item, Float>, TableCell<Item, Float>>() {
            @Override
            public TableCell<Item, Float> call(TableColumn<Item, Float> itemStringTableColumn) {
                final TableCell<Item, Float> cell = new TableCell<Item, Float>(){
                    @Override
                    protected void updateItem(Float price, boolean empty){
                        super.updateItem(price, empty);

                        if(empty)
                            setText("");
                        else{
                            setText(NumberFormat.getCurrencyInstance().format(price));
                        }
                    }
                };
            return cell;
            }
        });

        loadTable();
    }
}