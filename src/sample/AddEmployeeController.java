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
    @FXML private TextField empName;
    //@FXML private TextField jobTitleFX;
    @FXML private TextField mondayShiftFX;
    @FXML private TextField tuesdayShiftFX;
    @FXML private TextField wednesdayShiftFX;
    @FXML private Button addToSave;
    @FXML private TextField thursdayShiftFX;
    @FXML private TextField fridayShiftFX;
    @FXML private TextField saturdayShiftFX;
    @FXML private TextField sundayShiftFX;

    @FXML
    void addEmployeeToSchedule(ActionEvent event) {
        int index = -1;
        Stage stage = (Stage) addToSave.getScene().getWindow();

        try {
            index = (int) stage.getUserData();

        }catch(Exception e){}

        s.read();
        if(index == -1){
            try {
                super.s.AddEmployee(empName.getText(), mondayShiftFX.getText(), tuesdayShiftFX.getText(),
                        wednesdayShiftFX.getText(), thursdayShiftFX.getText(), fridayShiftFX.getText(),
                        saturdayShiftFX.getText(), sundayShiftFX.getText());
               // s.write();
            }catch (Exception e) {
                System.out.println("Invalid input. Please try again.");
            }
        }
        else{
            try {
                Schedule empSchedule = super.s.getSchedule().get(index);
                empSchedule.setEmpName(empName.getText());
                empSchedule.setDay1(mondayShiftFX.getText());
                empSchedule.setDay2(tuesdayShiftFX.getText());
                empSchedule.setDay3(wednesdayShiftFX.getText());
                empSchedule.setDay4(thursdayShiftFX.getText());
                empSchedule.setDay5(fridayShiftFX.getText());
                empSchedule.setDay6(saturdayShiftFX.getText());
                empSchedule.setDay7(sundayShiftFX.getText());
            }catch (Exception e) {
                System.out.println("Invalid input. Please try again.");
            }
        }

        s.write();
        stage.close();
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        System.out.println(super.s.getSchedule());
    }
}
