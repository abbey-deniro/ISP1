package sample;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.net.URL;
import java.util.ResourceBundle;

public class AddEmployeeController extends Controller implements Initializable {
    @FXML private TextField empNameFX;
    @FXML private TextField jobTitleFX;
    @FXML private TextField mondayShiftFX;
    @FXML private TextField tuesdayShiftFX;
    @FXML private TextField wednesdayShiftFX;
    @FXML private Button btnAdd;
    @FXML private TextField thursdayShiftFX;
    @FXML private TextField fridayShiftFX;
    @FXML private TextField saturdayShiftFX;
    @FXML private TextField sundayShiftFX;

    @FXML void add(ActionEvent event) {
    s.read();
    try {
        super.s.AddEmployee(empNameFX.getText(), jobTitleFX.getText(), mondayShiftFX.getText(),
                tuesdayShiftFX.getText(), wednesdayShiftFX.getText(), thursdayShiftFX.getText(),
                fridayShiftFX.getText(), saturdayShiftFX.getText(), sundayShiftFX.getText());
    }catch (Exception e){
        System.out.println("Try again");
    }
    s.write();
    Stage stages = (Stage) btnAdd.getScene().getWindow();
    stages.close();
    }
    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        System.out.println(super.s.getSchedule());
    }
}
