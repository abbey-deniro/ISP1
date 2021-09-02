package sample;

import Inventory.ChangeScene;
import Inventory.Item;
import javafx.application.Platform;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;

//import javax.swing.table.TableColumn;
import java.io.IOException;
import java.net.URL;
import java.text.Format;
import java.text.SimpleDateFormat;
import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Calendar;
import java.util.Locale;
import java.util.ResourceBundle;

public class Controller implements Initializable {
    protected Schedule s = new Schedule();

    public void run() {
        DateFormatter();
    }
    @FXML private TableColumn<Schedule, String> name;
    @FXML private TableColumn<Schedule, String> day1Column;
    @FXML private TableColumn<Schedule, String> day2Column;
    @FXML private TableColumn<Schedule, String> day3Column;
    @FXML private TableColumn<Schedule, String> day4Column;
    @FXML private TableColumn<Schedule, String> day5Column;
    @FXML private TableColumn<Schedule, String> day6Column;
    @FXML private TableColumn<Schedule, String> day7Column;
    @FXML private TableColumn<?, ?> totalHours;
    @FXML private TableView<Schedule> table;

    @FXML
    private void btnAddEmployee(ActionEvent event) {
        System.out.println("Button clicked");
        Stage popup = new Stage();
        try {
            Scene scene1 = new Scene(FXMLLoader.load(getClass().getResource("AddEmployee.fxml")), 1000,
                    800);
            popup.setTitle("Add an Employees Schedule");
            popup.setScene(scene1);
            popup.setWidth(433);
            popup.setHeight(438);

        }catch(Exception e){e.printStackTrace();}
        popup.showAndWait();

        loadTable();
        empTotalHours();

    }

    @FXML
    public void loadInventory(ActionEvent event){
        try {
            ChangeScene.changeScene(event, "Inventory/hello-view.fxml");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void loadTable(){
        s.read();
        if(s.getSchedule().size() == 0)
            return;

        ObservableList<Schedule> list = FXCollections.observableArrayList(s.getSchedule());
        table.setItems(list);
    }

    public void empTotalHours() {
        s.read();
        if(s.getSchedule().size() == 0)
            return;


        ObservableList<Schedule> list = FXCollections.observableArrayList(s.getSchedule());
        String nametoTH = name.getText();
        System.out.println(nametoTH);
    }

    @FXML private void btnRemoveItem(ActionEvent event){
        Schedule schedule = table.getSelectionModel().getSelectedItem();
        table.getItems().remove(schedule);

        int index = s.getSchedule().indexOf(schedule);
        s.getSchedule().remove(index);

        s.write();
    }


    @FXML public void btnEditSchedule(ActionEvent event) throws IOException {
        Schedule schedule = table.getSelectionModel().getSelectedItem();
        int index = s.getSchedule().indexOf(schedule);
        System.out.println(index);

        Stage popup = new Stage();
        Scene scene = new Scene(FXMLLoader.load(getClass().getResource("AddEmployee.fxml")));

        Button b = (Button) scene.lookup("#addToSave");
        b.setText("Save");

        TextField name = (TextField) scene.lookup("#empName");
        TextField day1 = (TextField) scene.lookup("#mondayShiftFX");
        TextField day2 = (TextField) scene.lookup("#tuesdayShiftFX");
        TextField day3 = (TextField) scene.lookup("#wednesdayShiftFX");
        TextField day4 = (TextField) scene.lookup("#thursdayShiftFX");
        TextField day5 = (TextField) scene.lookup("#fridayShiftFX");
        TextField day6 = (TextField) scene.lookup("#saturdayShiftFX");
        TextField day7 = (TextField) scene.lookup("#sundayShiftFX");

        try {
            name.setText(schedule.getEmpName());
            day1.setText(schedule.getDay1());
            day2.setText(schedule.getDay2());
            day3.setText(schedule.getDay3());
            day4.setText(schedule.getDay4());
            day5.setText(schedule.getDay5());
            day6.setText(schedule.getDay6());
            day7.setText(schedule.getDay7());
        }catch(Exception e){e.printStackTrace();}

        popup.setTitle("Edit an item");
        popup.setUserData(index);
        popup.setScene(scene);
        popup.setWidth(433);
        popup.setHeight(438);
        popup.showAndWait();

        loadTable();
    }

    public String DateFormatter(){
        LocalDate today = LocalDate.now();
        LocalDate monday = today;
        while (monday.getDayOfWeek() != DayOfWeek.MONDAY) {
            monday = monday.minusDays(1);
        }
        LocalDate sunday = today;
        while (sunday.getDayOfWeek() != DayOfWeek.SUNDAY) {
            sunday = sunday.plusDays(1);
        }
        String sundayDate = sunday.format(DateTimeFormatter.ofPattern("EEE MM-dd"));
        String mondayDate = monday.format(DateTimeFormatter.ofPattern("EEE MM-dd"));

       String weekStartDate = mondayDate;
       String weekEndDate = sundayDate;
       String dateOf = weekStartDate + " - " + weekEndDate;
       return dateOf;
    }
    @FXML private Label weekOfLabel;

    private void init() {
        String weekDate = DateFormatter();
        weekOfLabel.setText(weekDate);
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        init();
        name.setCellValueFactory(new PropertyValueFactory<Schedule, String>("empName"));
        day1Column.setCellValueFactory(new PropertyValueFactory<Schedule, String>("day1"));
        day2Column.setCellValueFactory(new PropertyValueFactory<Schedule, String>("day2"));
        day3Column.setCellValueFactory(new PropertyValueFactory<Schedule, String>("day3"));
        day4Column.setCellValueFactory(new PropertyValueFactory<Schedule, String>("day4"));
        day5Column.setCellValueFactory(new PropertyValueFactory<Schedule, String>("day5"));
        day6Column.setCellValueFactory(new PropertyValueFactory<Schedule, String>("day6"));
        day7Column.setCellValueFactory(new PropertyValueFactory<Schedule, String>("day7"));

        loadTable();
    }
}

