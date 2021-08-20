package sample;



import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;

import javafx.scene.control.Button;

import java.text.Format;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Main extends Application {

    private TableView table = new TableView();

    @Override
    public void start(Stage primaryStage) throws Exception{
        Parent root = FXMLLoader.load(getClass().getResource("sample.fxml"));
        primaryStage.setTitle("Cool Bros MS");
        primaryStage.setScene(new Scene(root, 800, 800));
        primaryStage.show();

        //TableView<> table = new TableView<>();
        TableColumn fileNameCol = new TableColumn("File Name");
        table.getColumns().add(fileNameCol);

    }


    public static void main(String[] args) {
        new Controller().run();
        launch(args);
    }


}
