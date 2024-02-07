package org.example.demo;

import javafx.application.Application;
import javafx.event.EventHandler;
import javafx.scene.control.Button;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.shape.Line;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import javafx.scene.*;

import java.util.Timer;
import java.util.TimerTask;

public class Make_Break extends Application {
    //Variables
    public static final int SIZE = 70;
    public static final int MOVE = 40;
    public static int XMAX = SIZE * 10;
    public static int YMAX = SIZE * 10;
    public static int [][] MESH = new int [XMAX/SIZE][YMAX/SIZE];
    private static Pane gameLayout = new Pane();
    private static Scene gameScene = new Scene(gameLayout, XMAX + 150, YMAX);
    private static VBox menuLayout = new VBox();
    private static Scene menuScene = new Scene(menuLayout, XMAX + 150, YMAX);
    public static int score = 0;
    public static float timer = 0;
    private static boolean game = true;
    private BricksController bricksController = new BricksController();
    private Checker checker = new Checker();

    public static void main(String[] args)
    {
        launch(args);
    }

    @Override
    public void start(Stage stage) {

        //Set up gameScene and Start Game
        Line line1 = new Line(XMAX, 0, XMAX, YMAX);
        Text scoretext = new Text("Score: ");
        scoretext.setStyle("-fx-font: 20 arial;");
        scoretext.setY(50);
        scoretext.setX(XMAX + 5);
        Text level = new Text("Lines: ");
        level.setStyle("-fx-font: 20 arial;");
        level.setY(100);
        level.setX(XMAX + 5);
        level.setFill(Color.GREEN);
        gameLayout.getChildren().addAll(scoretext, line1, level);


        //Set up Bricks Image
        for (Brick brick : bricksController.bricks) {
            gameLayout.getChildren().addAll(brick.a, brick.b, brick.c);
        }
        gameLayout.getChildren().add(bricksController.highlightBrick);
        MoveOnKeyPress();


        //Set up Card Image
        gameLayout.getChildren().add(checker.imageView);


        //Set up menuScene
        Button startButton = new Button("Game Start");
        startButton.setOnAction(e -> stage.setScene(gameScene));



        stage.setScene(gameScene);
        stage.setTitle("Make 'n' Break");
        stage.show();

        //Game Loop
        Timer fall = new Timer();
        TimerTask gameUpdate = new TimerTask() {
            @Override
            public void run() {
                if (game) {
                    //MoveOnKeyPress();
                    //bricksController.PrintMeshInConsole();
                    scoretext.setText("Score: " + Integer.toString(score));
                }
            }
        };

        fall.schedule(gameUpdate, 0, 300);
    }
    private void MoveOnKeyPress() {
        gameScene.setOnKeyPressed(new EventHandler<KeyEvent>() {
            @Override
            public void handle(KeyEvent event) {
                switch (event.getCode()) {
                    case RIGHT:
                        bricksController.MoveRight();
                        break;
                    case DOWN:
                        bricksController.MoveDown();
                        break;
                    case LEFT:
                        bricksController.MoveLeft();
                        break;
                    case UP:
                        bricksController.MoveUp();
                        break;
                    case Q:
                        bricksController.SwitchBrick();
                        break;
                    case W:
                        bricksController.Rotate();
                        break;
                    case E:
                   //checker.Check();
                        if (checker.Check(bricksController))
                            score += 3;

                        break;
                }
            }
        });
    }
}