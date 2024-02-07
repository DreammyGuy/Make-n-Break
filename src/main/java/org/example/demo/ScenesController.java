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
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.stage.Modality;

public class ScenesController extends Application {

    private Stage stage;

    @Override
    public void start(Stage primaryStage) throws Exception {
        stage = primaryStage;

        // Load background image
        Image backgroundImage = new Image("file:C:\\Users\\ADMIN\\Documents\\GitHub\\Make-n-Break\\src\\image\\output-onlinepngtools (1).png");

        // Create an ImageView with the background image
        ImageView backgroundImageView = new ImageView(backgroundImage);

        // Main menu layout
        VBox menuLayout = new VBox();
        menuLayout.setAlignment(Pos.CENTER); // Align VBox contents to the center
        menuLayout.setSpacing(20); // Set spacing between buttons
        menuLayout.setPadding(new Insets(50, 0, 50, 0)); // Add padding at the top and bottom

        // Set the background image as the root node of the scene
        StackPane root = new StackPane();
        root.getChildren().addAll(backgroundImageView, menuLayout);

        Scene menuScene = new Scene(root, 1000, 729); // Set scene size according to image size

        // Buttons
        Button playButton = new Button("Play");
        playButton.setOnAction(e -> startGame());
        playButton.setStyle("-fx-background-color: orange; -fx-background-radius: 40px; -fx-text-fill: black; -fx-font-size: 30px; -fx-padding: 10px 100px;");

        Button creditButton = new Button("Credits");
        creditButton.setOnAction(e -> showCredits());
        creditButton.setStyle("-fx-background-color: orange; -fx-background-radius: 40px; -fx-text-fill: black; -fx-font-size: 30px; -fx-padding: 10px 50px;");

        // Add buttons to menu layout
        menuLayout.getChildren().addAll(playButton, creditButton);

        // Quit button
        Button quitButton = new Button("Quit");
        quitButton.setOnAction(e -> quitGame());
        quitButton.setStyle("-fx-background-color: orange; -fx-background-radius: 40px; -fx-text-fill: black; -fx-font-size: 30px; -fx-padding: 10px 30px;");
        StackPane.setAlignment(quitButton, Pos.BOTTOM_CENTER); // Align the button to the bottom center of the StackPane
        StackPane.setMargin(quitButton, new Insets(0, 0, 30, 0));

        root.getChildren().add(quitButton); // Add the quit button to the StackPane

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
        Stage creditsStage = new Stage();
        creditsStage.initModality(Modality.APPLICATION_MODAL);
        creditsStage.setTitle("Credits");

        VBox creditsLayout = new VBox();
        creditsLayout.setAlignment(Pos.CENTER);
        creditsLayout.setSpacing(20);
        creditsLayout.setPadding(new Insets(20));

        Label titleLabel = new Label("Credits");
        titleLabel.setStyle("-fx-font-size: 24px; -fx-font-weight: bold;");

        TextArea creditsTextArea = new TextArea();
        creditsTextArea.setEditable(false);
        creditsTextArea.setWrapText(true);
        creditsTextArea.setText("This game was created by Vo Cong Minh, Doan Phuoc Thong, Nguyen Dang Khanh");

        Button closeButton = new Button("Close");
        closeButton.setOnAction(e -> creditsStage.close());

        creditsLayout.getChildren().addAll(titleLabel, creditsTextArea, closeButton);

        Scene creditsScene = new Scene(creditsLayout, 400, 300);
        creditsStage.setScene(creditsScene);
        creditsStage.showAndWait();
    }

    // Method to quit the application
    private void quitGame() {
        stage.close();
    }

    public static void main(String[] args) {
        launch(args);
    }
}
