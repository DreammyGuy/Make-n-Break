package org.example.demo;

import javafx.application.Application;
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
    public static final int SIZE = 25;
    public static int XMAX = SIZE * 20;
    public static int YMAX = SIZE * 24;
    public static int [][] MESH = new int [XMAX/SIZE][YMAX/SIZE];
    private static Pane group = new Pane();
    private static Scene scene = new Scene(group, XMAX + 150, YMAX);
    public static int score = 0;
    public static float timer = 0;
    private static boolean game = true;


    @Override
    public void start(Stage stage) {
        //Init arrays
        for (int[] a : MESH) {
            Arrays.fill(a, 0);
        }

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

        stage.setScene(scene);
        stage.setTitle("Make 'n' Break");
        stage.show();

        //Game Loop
        Timer fall = new Timer();
        TimerTask gameUpdate = new TimerTask() {
            @Override
            public void run() {
                if (game) {
                    //Bricks.Update();
                    scoretext.setText("Score: " + Integer.toString(score));
                }
            }
        };

        fall.schedule(gameUpdate, 0, 300);
    }

    public static void main(String[] args)
    {
        launch(args);
    }
}