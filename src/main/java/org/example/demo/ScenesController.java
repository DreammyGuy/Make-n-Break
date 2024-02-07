package org.example.demo;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class ScenesController extends Application {

    private Stage stage;

    @Override
    public void start(Stage primaryStage) throws Exception {
        stage = primaryStage;

        // Load background image
        Image backgroundImage = new Image("file:C:\\Users\\ADMIN\\Documents\\GitHub\\Make-n-Break\\src\\image\\output-onlinepngtools.png");

        // Create an ImageView with the background image
        ImageView backgroundImageView = new ImageView(backgroundImage);

        // Main menu layout
        VBox menuLayout = new VBox();
        Scene menuScene = new Scene(menuLayout, 800, 583); // Set scene size according to image size

        // Set the background image as the root node of the scene
        StackPane root = new StackPane();
        root.getChildren().add(backgroundImageView);
        menuScene.setRoot(root);

        // Buttons
        Button playButton = new Button("Play");
        playButton.setOnAction(e -> startGame());

        Button creditButton = new Button("Credits");
        creditButton.setOnAction(e -> showCredits());

        Button quitButton = new Button("Quit");
        quitButton.setOnAction(e -> quitGame());

        // Add buttons to menu layout
        menuLayout.getChildren().addAll(playButton, creditButton, quitButton);

        stage.setScene(menuScene);
        stage.setTitle("Main Menu");
        stage.show();
    }

    // Method to start the game
    private void startGame() {
        Make_Break game = new Make_Break();
        try {
            game.start(stage);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    // Method to show credits
    private void showCredits() {
        // Implement your credits display here
        System.out.println("Credits:");
        System.out.println("This game was created by [Your Name]");
    }

    // Method to quit the application
    private void quitGame() {
        stage.close();
    }

    public static void main(String[] args) {
        launch(args);
    }
}
