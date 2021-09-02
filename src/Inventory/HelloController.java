package Inventory;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.stage.Stage;

import java.io.IOException;

public class HelloController extends Application {
    @Override
    public void start(Stage stage) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("hello-view.fxml"));
        stage.setMaximized(true);
        stage.setTitle("Cool Bros MS");
        stage.getIcons().add(new Image("logo.png"));
        stage.setScene(new Scene(root, 1000, 900));
        stage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}
