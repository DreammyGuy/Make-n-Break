package org.example.demo;

import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;

public class Bricks {

    private int SIZE = Make_Break.SIZE;
    Rectangle[] rectangles = new Rectangle[8];
    public Bricks() {
        //Init all rectangles
        for (Rectangle rect : rectangles) {
            rect = new Rectangle(SIZE, 3 * SIZE);
        }
        //Set up color
        this.rectangles[0].setFill(Color.RED);

    }
    public static void Update() {

    }
}
