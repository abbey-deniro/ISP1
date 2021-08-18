package Inventory;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.stage.Stage;

import java.io.IOException;

public class HelloController extends Application {
    @Override
    public void start(Stage stage) throws IOException {

        Parent root = FXMLLoader.load(getClass().getResource("hello-view.fxml"));
        Scene scene = new Scene(root, 1000, 800);
        stage.setMaximized(true);
        stage.setTitle("CoolBrosMS");
        stage.setScene(scene);
        stage.show();
        //stage.getIcons().add(new Image("C:\\Users\\nsharma\\OneDrive - Neumont College of Computer Science\\Desktop\\Neumont\\Year 2\\Sprint 7\\Sprint 8\\CoolBroISS\\Images\\icon.png"));
        //age.getIcons().add(new Image("file:icon.png")); change image to coolBrosPizza
    }

    public static void main(String[] args) {
        launch();
    }


    public class ButtonExperiments extends Application {

        @Override
        public void start(Stage primaryStage) throws Exception {
            primaryStage.setTitle("COOL");

            Button button = new Button("My Button");

            Scene scene = new Scene(button, 200, 100);
            primaryStage.setScene(scene);
            primaryStage.show();

            //Creating a Button
            Button test = new Button();
            test.setText("Sample Button");
            //Setting the location of the button
            test.setTranslateX(200);
            test.setTranslateY(2000);
            //Setting the stage
            primaryStage.setScene(scene);
            primaryStage.show();
        }


    }
}
