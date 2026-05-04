package com.onur.simplecalculator;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.stage.Stage;

public class Main extends Application{

    @Override
    public void start(Stage primaryStage) {
        try{

            FXMLLoader loader = new FXMLLoader(getClass().getResource("/com/onur/simplecalculator/controller/Scene1.fxml"));
            Parent root = loader.load();

            Scene scene = new Scene(root);

            primaryStage.setTitle("Simple Calculator");
            primaryStage.setScene(scene);
            primaryStage.getIcons().add(new Image(getClass().getResourceAsStream("/view/calculator.jpg")));
            String css = this.getClass().getResource("/view/app.css").toExternalForm();
            scene.getStylesheets().add(css);
//            primaryStage.setMinWidth(100);
//            primaryStage.setMinHeight(100);
            primaryStage.setResizable(false);
            primaryStage.setWidth(350);
            primaryStage.setHeight(480);

            primaryStage.show();
        }catch(Exception e) {
            e.printStackTrace();
            System.out.println("Error!");
        }
    }

    public static void main(String[] args) {

        launch(args);
    }

}
