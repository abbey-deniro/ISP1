package Inventory;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.stage.Stage;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.scene.control.TextField;

public class AddItemController extends HelloApplication implements Initializable {
    @FXML
    private Button btnAdd;
    @FXML
    private TextField txtCategory;
    @FXML
    private TextField txtName;
    @FXML
    private TextField txtQuantity;
    @FXML
    private TextField txtMinQuantity;
    @FXML
    private TextField txtPrice;

    @FXML
    private void addItem(ActionEvent event) {
        i.read();
        try {
            super.i.addItems(txtName.getText(), Integer.parseInt(txtQuantity.getText()), Float.parseFloat(txtPrice.getText()), Integer.parseInt(txtMinQuantity.getText()), txtCategory.getText());
        } catch (Exception e) {
            System.out.println("Invalid input. Please try again.");
        }
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
