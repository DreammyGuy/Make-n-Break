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


import java.util.Scanner;
import java.io.BufferedReader;
import java.io.FileReader;

//for image adding:
import java.io.File;
import java.io.FileInputStream; 
import java.io.FileNotFoundException; 
import javafx.application.Application; 
import javafx.scene.Group; 
import javafx.scene.Scene; 
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;  
import javafx.stage.Stage;  


public class Make_Break extends Application {
    //Variables
    public static final int SIZE = 40;
    public static final int MOVE = 40;
    public static int XMAX = SIZE * 10;
    public static int YMAX = SIZE * 10;
    public static int [][] MESH = new int [XMAX/SIZE][YMAX/SIZE];
    private static Pane group = new Pane();
    private static Scene scene = new Scene(group, XMAX + 170, YMAX);
    public static int score = 0;
    public static float timer = 0;
    public static int Picture = 0;
    private static boolean game = true;
    private Eight_Brick eightBricks = new Eight_Brick();
    private Checker checker = new Checker();
    
    //for image:
    ImageView imageView;
    

    public static void main(String[] args)
    {
        launch(args);
    }

    //image:
    @Override
        public void start(Stage stage) {
            // Set up game scene
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
    
            // Set up bricks image
            for (Brick brick : eightBricks.bricks) {
                group.getChildren().addAll(brick.a, brick.b, brick.c);
            }
    
            MoveOnKeyPress();
    
            // Set up image view
            try {
                String imagePath = "solution/solution0/sol0_image.png";
                Image image = new Image(new FileInputStream(imagePath));
                imageView = new ImageView(image);
                imageView.setX(XMAX + 4);
                imageView.setY(200);
                imageView.setFitHeight(160);
                imageView.setFitWidth(150);
                imageView.setPreserveRatio(true);
    
                // Add image view to the group
                group.getChildren().add(imageView);
            } catch (FileNotFoundException e) {
                e.printStackTrace();
                System.out.println("Error loading the image: File not found.");
            }
    
            // Set up and show stage
            stage.setScene(scene);
            stage.setTitle("Make 'n' Break");
            stage.show();
    
            // Game Loop
            Timer fall = new Timer();
            TimerTask gameUpdate = new TimerTask() {
                @Override
                public void run() {
                    if (game) {
                        scoretext.setText("Score: " + Integer.toString(score));
                    }
                }
            };
    
            fall.schedule(gameUpdate, 0, 300);
        }
    
        //Setting the image view 
        
        //Setting the position of the image 
        
        //Setting title to the Stage 



        //Set up scene and Start Game
        /*Line line = new Line(XMAX, 0, XMAX, YMAX);
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
                    //eightBricks.PrintMeshInConsole();
                    scoretext.setText("Score: " + Integer.toString(score));
                }
            }
        };

        fall.schedule(gameUpdate, 0, 300);
    }*/
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
                        if(checker.CheckSolution(eightBricks.MESH, Picture)){
                            score += checker.GetScore(Picture);
                            Picture+= 1; 
                            Picture %= checker.listOfCards.size();
                            eightBricks.PrintMeshInConsole();
                            System.out.println("Success!");
                            changeImage_OriSetUp(Picture);
                        }
                        else{
                            eightBricks.PrintMeshInConsole();
                            System.out.println("Failed!");
                        }
                        break;
                }
            }
        });
    }
    private void changeImage_OriSetUp(int Picture) {
        try {
            String newImagePath = String.format("solution/solution%d/sol%d_image.png", Picture, Picture);
            File newImageFile = new File(newImagePath);

            if (newImageFile.exists()) {
                System.out.printf("%s Successfully changed image\n", newImagePath);


                /// REMOVE current Image and current brick:
                Image newImage = new Image(new FileInputStream(newImagePath));
                group.getChildren().removeIf(node -> node instanceof ImageView);
                for (Brick brick : eightBricks.bricks) {
                    group.getChildren().removeAll(brick.a, brick.b, brick.c);
                }

                /// ADD new eightbrick + image:
                eightBricks = new Eight_Brick();
                imageView.setImage(newImage);
                group.getChildren().add(imageView);
                for (Brick brick : eightBricks.bricks) {
                    group.getChildren().addAll(brick.a, brick.b, brick.c);
                }

            // Set the updated Group to the Scene
                scene.setRoot(group);

            // Show the updated Stage
                Stage stage = (Stage) imageView.getScene().getWindow();
                stage.show();
            } else {
                System.out.println("Error: New image file not found.");
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
            System.out.println("Error loading the new image: File not found.");
        }
    }
}