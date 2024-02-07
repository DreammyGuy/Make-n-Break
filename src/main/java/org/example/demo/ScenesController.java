package org.example.demo;
import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
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
        menuLayout.setAlignment(Pos.CENTER); // Align VBox contents to the center
        menuLayout.setSpacing(20); // Set spacing between buttons
        menuLayout.setPadding(new Insets(150, 0, 0, 0)); // Add padding at the top and bottom

        // Set the background image as the root node of the scene
        StackPane root = new StackPane();
        root.getChildren().addAll(backgroundImageView, menuLayout);

        Scene menuScene = new Scene(root, 800, 583); // Set scene size according to image size

        // Buttons
        Button playButton = new Button("Play");
        playButton.setOnAction(e -> startGame());
        playButton.setStyle("-fx-background-color: orange; -fx-background-radius: 40px; -fx-text-fill: black; -fx-font-size: 30px; -fx-padding: 5px 70px;");

        Button creditButton = new Button("Credits");
        creditButton.setOnAction(e -> showCredits());
        creditButton.setStyle("-fx-background-color: orange; -fx-background-radius: 40px; -fx-text-fill: black; -fx-font-size: 30px; -fx-padding: 5px 30px;");

        Button quitButton = new Button("Quit");
        quitButton.setOnAction(e -> quitGame());
        quitButton.setStyle("-fx-background-color: orange; -fx-background-radius: 40px; -fx-text-fill: black; -fx-font-size: 30px; -fx-padding: 5px 20px;");

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

