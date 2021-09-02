package sample;



import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.image.Image;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;

import javafx.scene.control.Button;

import java.text.Format;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Main extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception{
        Parent root = FXMLLoader.load(getClass().getResource("sample.fxml"));
        primaryStage.setTitle("Cool Bros MS");
        //primaryStage.setMaximized(true);
        primaryStage.getIcons().add(new Image("logo.png"));
        primaryStage.setScene(new Scene(root, 770, 550));
        primaryStage.show();

    }


    public static void main(String[] args) {
        new Controller().run();
        launch(args);
    }


}
