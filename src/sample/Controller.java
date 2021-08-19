package sample;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;

//import javax.swing.table.TableColumn;
import java.net.URL;
import java.text.Format;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.ResourceBundle;

public class Controller implements Initializable {


    public void run() {
        DateFormatter();
    }

    @FXML private TableColumn<Schedule, String> employeeColumn;
    @FXML private TableColumn<Schedule, String> day1Column;
    @FXML private TableColumn<Schedule, String> day2Column;
    @FXML private TableColumn<Schedule, String> day3Column;
    @FXML private TableColumn<Schedule, String> day4Column;
    @FXML private TableColumn<Schedule, String> day5Column;
    @FXML private TableColumn<Schedule, String> day6Column;
    @FXML private TableColumn<Schedule, String> day7Column;
    @FXML private TableView<Schedule> table;

    @FXML
    private static Button add;

    @FXML
    private void handleButtonClick(ActionEvent event) {
        System.out.println("Button clicked");
        //add.setText("ADD");

    }

    public static String getWeekStartDate() {
        Calendar calendar = Calendar.getInstance();
        while (calendar.get(Calendar.DAY_OF_WEEK) != Calendar.MONDAY) {
            calendar.add(Calendar.DATE, -1);
        }
        Format dateFormat = new SimpleDateFormat("EEE MM-dd");
        String res = dateFormat.format(calendar.getTime());
        return res;
    }

    public static String getWeekEndDate() {
        Calendar calendar = Calendar.getInstance();
        while (calendar.get(Calendar.DAY_OF_WEEK) != Calendar.MONDAY) {
            calendar.add(Calendar.DATE, 1);
        }
        calendar.add(Calendar.DATE, -1);
        Format dateFormat = new SimpleDateFormat("EEE MM/dd");
        String res = dateFormat.format(calendar.getTime());
        return res;
    }
    public String DateFormatter(){
       String weekStartDate = getWeekStartDate();
       String weekEndDate = getWeekEndDate();
       String dateOf = weekStartDate + "- " + weekEndDate;
       return dateOf;
    }

    @FXML
    private Label weekOfLabel;


    private void init() {
        String weekDate = DateFormatter();
        weekOfLabel.setText(weekDate);
    }

    public static void Add(){
       // Parent root = FXMLLoader.load(getClass().getResource("\"sample.fxml\""))
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        init();
        employeeColumn.setCellValueFactory(new PropertyValueFactory<Schedule, String>("name"));
        day1Column.setCellValueFactory(new PropertyValueFactory<Schedule, String>("day1"));
        day2Column.setCellValueFactory(new PropertyValueFactory<Schedule, String>("day2"));
        day3Column.setCellValueFactory(new PropertyValueFactory<Schedule, String>("day3"));
        day4Column.setCellValueFactory(new PropertyValueFactory<Schedule, String>("day4"));
        day5Column.setCellValueFactory(new PropertyValueFactory<Schedule, String>("day5"));
        day6Column.setCellValueFactory(new PropertyValueFactory<Schedule, String>("day6"));
        day7Column.setCellValueFactory(new PropertyValueFactory<Schedule, String>("day7"));

        final ObservableList<Schedule> list = FXCollections.observableArrayList(
                new Schedule("Bob", "9-5", "4-6", "3-8", "2-10", "3-8", "5-6", "4-5")

        );
        this.table.setItems(list);
    }


}

