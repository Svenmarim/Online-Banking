package Client;/**
 * InternetBankieren Created by Sven de Vries on 12-12-2017
 */

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.stage.Stage;

public class Main extends Application {

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) throws Exception {
        Parent root = FXMLLoader.load(getClass().getResource("Screens/login.fxml"));
        primaryStage.setTitle("Login");
        primaryStage.setResizable(false);
        primaryStage.getIcons().add(new Image("file:assets/ideal_logo.jpg"));
        primaryStage.setScene(new Scene(root));
        primaryStage.setOnCloseRequest(event -> System.exit(0));
        primaryStage.show();
    }
}