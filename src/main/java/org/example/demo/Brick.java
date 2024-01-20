package org.example.demo;

import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;

public class Brick {
    Rectangle a;
    Rectangle b;
    Rectangle c;
    Color color;
    boolean isVertical;
    int brickNumber;

    public Brick(Rectangle a, Rectangle b, Rectangle c, int brickNumber) {
        this.a = a;
        this.b = b;
        this.c = c;
        this.isVertical = true;
        this.brickNumber = brickNumber;

        switch (brickNumber) {
            case 1:
                color = Color.RED;
                break;
            case 2:
                color = Color.BLUE;
                break;
            case 3:
                color = Color.GREEN;
                break;
            case 4:
                color = Color.ORANGE;
                break;
            case 5:
                color = Color.PINK;
                break;
            case 6:
                color = Color.PURPLE;
                break;
            case 7:
                color = Color.BROWN;
                break;
            case 8:
                color = Color.BLACK;
                break;

        }
        this.a.setFill(color);
        this.b.setFill(color);
        this.c.setFill(color);
    }

}
