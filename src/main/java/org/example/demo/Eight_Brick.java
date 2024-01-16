package org.example.demo;

import javafx.scene.shape.Rectangle;

import java.util.ArrayList;
import java.util.List;

public class Eight_Brick {
    List<Brick> bricks = new ArrayList<>();
    public static int MOVE = Make_Break.MOVE;
    public static int SIZE = Make_Break.SIZE;
    public static int XMAX = Make_Break.XMAX;
    public static int YMAX = Make_Break.YMAX;
    int brickIndex = 0;

    public Eight_Brick() {
        //Add 8 Bricks
        bricks.add(MakeBrick(0, 0, 1));
        bricks.add(MakeBrick(SIZE, 0, 2));
        bricks.add(MakeBrick(SIZE * 2, 0, 3));
        bricks.add(MakeBrick(SIZE * 3, 0, 4));
        bricks.add(MakeBrick(SIZE * 4, 0, 5));
        bricks.add(MakeBrick(SIZE * 5, 0, 6));
        bricks.add(MakeBrick(SIZE * 6, 0, 7));
        bricks.add(MakeBrick(SIZE * 7, 0, 8));


    }
    public void MoveUp() {
        if (GetControlledBrick().a.getY() - MOVE >= 0 && GetControlledBrick().b.getY() - MOVE >= 0
                && GetControlledBrick().c.getX() - MOVE >= 0) {
            GetControlledBrick().a.setY(GetControlledBrick().a.getY() - MOVE);
            GetControlledBrick().b.setY(GetControlledBrick().b.getY() - MOVE);
            GetControlledBrick().c.setY(GetControlledBrick().c.getY() - MOVE);
        }
    }
    public void MoveDown() {
        if (GetControlledBrick().a.getY() + MOVE <= XMAX - SIZE && GetControlledBrick().b.getY() + MOVE <= XMAX - SIZE
                && GetControlledBrick().c.getY() + MOVE <= XMAX - SIZE) {
            GetControlledBrick().a.setY(GetControlledBrick().a.getY() + MOVE);
            GetControlledBrick().b.setY(GetControlledBrick().b.getY() + MOVE);
            GetControlledBrick().c.setY(GetControlledBrick().c.getY() + MOVE);
        }
    }
    public void MoveLeft() {
        if (GetControlledBrick().a.getX() - MOVE >= 0 && GetControlledBrick().b.getX() - MOVE >= 0
                && GetControlledBrick().c.getX() - MOVE >= 0) {
            GetControlledBrick().a.setX(GetControlledBrick().a.getX() - MOVE);
            GetControlledBrick().b.setX(GetControlledBrick().b.getX() - MOVE);
            GetControlledBrick().c.setX(GetControlledBrick().c.getX() - MOVE);
        }

    }
    public void MoveRight() {
        if (GetControlledBrick().a.getX() + MOVE <= XMAX - SIZE && GetControlledBrick().b.getX() + MOVE <= XMAX - SIZE
                && GetControlledBrick().c.getX() + MOVE <= XMAX - SIZE) {
            GetControlledBrick().a.setX(GetControlledBrick().a.getX() + MOVE);
            GetControlledBrick().b.setX(GetControlledBrick().b.getX() + MOVE);
            GetControlledBrick().c.setX(GetControlledBrick().c.getX() + MOVE);
        }
    }


    private Brick MakeBrick(int xPos, int yPos, int brickNumber) {
        Rectangle a = new Rectangle(SIZE-1, SIZE-1), b = new Rectangle(SIZE-1, SIZE-1),
                c = new Rectangle(SIZE-1, SIZE-1);

        //Set up Position
        a.setX(xPos);
        a.setY(yPos);
        b.setX(xPos);
        b.setY(SIZE + yPos);
        c.setX(xPos);
        c.setY(2 * SIZE + yPos);

        return new Brick(a, b, c, brickNumber);
    }
    public void SwitchBrick() {
        if (brickIndex != 7) {
            brickIndex++;
        } else {
            brickIndex = 0;
        }
    }
    private Brick GetControlledBrick() {
        return bricks.get(brickIndex);
    }

}
