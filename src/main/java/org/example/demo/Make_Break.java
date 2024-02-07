package org.example.demo;

import javafx.application.Application;
import javafx.event.EventHandler;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Line;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import javafx.scene.*;

import java.util.Arrays;
import java.util.Timer;
import java.util.TimerTask;

public class Make_Break extends Application {
    //Variables
    public static final int SIZE = 40;
    public static final int MOVE = 40;
    public static int XMAX = SIZE * 10;
    public static int YMAX = SIZE * 10;
    public static int [][] MESH = new int [XMAX/SIZE][YMAX/SIZE];
    private static Pane group = new Pane();
    private static Scene scene = new Scene(group, XMAX + 150, YMAX);
    public static int score = 0;
    public static float timer = 0;
    private static boolean game = true;
    private Eight_Brick eightBricks = new Eight_Brick();

    public static void main(String[] args)
    {
        launch(args);
    }

    @Override
    public void start(Stage stage) {

        //Set up scene and Start Game
        Line line = new Line(XMAX, 0, XMAX, YMAX);
        Text scoretext = new Text("Score: ");
        scoretext.setStyle("-fx-font: 20 arial;");
        scoretext.setY(50);
        scoretext.setX(XMAX + 5);
        Text level = new Text("Lines: ");
        level.setStyle("-fx-font: 20 arial;");
        level.setY(100);
        level.setX(XMAX + 5);
        level.setFill(Color.GREEN);
        group.getChildren().addAll(scoretext, line, level);

        //Set up Bricks Image

        for (Brick brick : eightBricks.bricks) {
            group.getChildren().addAll(brick.a, brick.b, brick.c);
        }
        MoveOnKeyPress();

        stage.setScene(scene);
        stage.setTitle("Make 'n' Break");
        stage.show();

        //Game Loop
        Timer fall = new Timer();
        TimerTask gameUpdate = new TimerTask() {
            @Override
            public void run() {
                if (game) {
                    //MoveOnKeyPress();
                    eightBricks.PrintMeshInConsole();
                    scoretext.setText("Score: " + Integer.toString(score));
                }
            }
        };

        fall.schedule(gameUpdate, 0, 300);
    }
    private void MoveOnKeyPress() {
        scene.setOnKeyPressed(new EventHandler<KeyEvent>() {
            @Override
            public void handle(KeyEvent event) {
                switch (event.getCode()) {
                    case RIGHT:
                        eightBricks.MoveRight();
                        break;
                    case DOWN:
                        eightBricks.MoveDown();
                        break;
                    case LEFT:
                        eightBricks.MoveLeft();
                        break;
                    case UP:
                        eightBricks.MoveUp();
                        break;
                    case Q:
                        eightBricks.SwitchBrick();
                        break;
                    case W:
                        eightBricks.Rotate();
                        break;
                    case E:
                        //checker.Check();
                        break;
                }
            }
        });
    }
}