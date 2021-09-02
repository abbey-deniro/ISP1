package sample;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.control.TextFormatter;
import javafx.stage.Stage;
import javafx.stage.Window;

import java.net.URL;
import java.util.ResourceBundle;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

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

    private static void showAlert(Alert.AlertType alertType, String title, String message) {
        Alert alert = new Alert(alertType);
        alert.setTitle(title);
        alert.setHeaderText(null);
        alert.setContentText(message);
        alert.show();
    }

    Alert a = new Alert(Alert.AlertType.NONE);

    private boolean isInputValid(TextField textField) {
        Boolean isValid = false;
    Pattern p = Pattern.compile("^(\\d{1,2})(:)(\\d{2})(-)(\\d{1,2})(:)(\\d{2})");
    Matcher m = p.matcher(textField.getText());

    while (m.find() || m.equals(null)) {
        System.out.println("full match: " + m.group(0));
        isValid = true;
    }
    return isValid;
    }

    @FXML
    void addEmployeeToSchedule(ActionEvent event) {
        System.out.println("employee add button clicked");
        int index = -1;
        Stage stage = (Stage) addToSave.getScene().getWindow();

        try {
            System.out.println("Getting index");
            index = (int) stage.getUserData();

        }catch(Exception e){}

        s.read();
        if(index == -1){
            try {
                //boolean nameisInputValide = empName.getText()
                boolean mondayisInputValid = isInputValid(mondayShiftFX);
                boolean tuesdayisInputValid = isInputValid(tuesdayShiftFX);
                boolean wednesdayisInputValid = isInputValid(wednesdayShiftFX);
                boolean thursdayisInputValid = isInputValid(thursdayShiftFX);
                boolean fridayisInputValid = isInputValid(fridayShiftFX);
                boolean saturdayisInputValid = isInputValid(saturdayShiftFX);
                boolean sundayisInputValid = isInputValid(sundayShiftFX);

                if(mondayisInputValid || tuesdayisInputValid || wednesdayisInputValid || thursdayisInputValid ||
                        fridayisInputValid || saturdayisInputValid || sundayisInputValid == true) {
                    System.out.println("line 40 " + empName.getText() + " " + mondayShiftFX.getText() + " " +
                                tuesdayShiftFX.getText() + " " +
                                wednesdayShiftFX.getText() + " " +  thursdayShiftFX.getText() + " " +  fridayShiftFX.getText() + " " +
                        saturdayShiftFX.getText() + " " +  sundayShiftFX.getText());
                super.s.AddEmployee(empName.getText(), mondayShiftFX.getText(), tuesdayShiftFX.getText(),
                        wednesdayShiftFX.getText(), thursdayShiftFX.getText(), fridayShiftFX.getText(),
                        saturdayShiftFX.getText(), sundayShiftFX.getText());
                }else {
                    showAlert(Alert.AlertType.ERROR, "Form Error!", "Please enter fields in correct form.");
                }
                System.out.println();
                s.write();
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


//    @FXML void add(ActionEvent event) {
//    s.read();
//    try {
//        super.s.AddEmployee(empNameFX.getText(), mondayShiftFX.getText(),
//                tuesdayShiftFX.getText(), wednesdayShiftFX.getText(), thursdayShiftFX.getText(),
//                fridayShiftFX.getText(), saturdayShiftFX.getText(), sundayShiftFX.getText());
//    }catch (Exception e){
//        System.out.println("Try again");
//    }
//    s.write();
//    Stage stages = (Stage) btnAdd.getScene().getWindow();
//    stages.close();
//    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        System.out.println(super.s.getSchedule());
    }
}
