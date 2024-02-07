package org.example.demo;

import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class BricksController {
    List<Brick> bricks = new ArrayList<>();
    Rectangle highlightBrick;
    public static int MOVE = Make_Break.MOVE;
    public static int SIZE = Make_Break.SIZE;
    public static int XMAX = Make_Break.XMAX;
    public static int YMAX = Make_Break.YMAX;
    public int [][] MESH = Make_Break.MESH;
    int brickIndex = 0;

    public BricksController() {
        //Add 8 Bricks
        bricks.add(MakeBrick(0, 0, 1));
        bricks.add(MakeBrick(SIZE, 0, 2));
        bricks.add(MakeBrick(SIZE * 2, 0, 3));
        bricks.add(MakeBrick(SIZE * 3, 0, 4));
        bricks.add(MakeBrick(SIZE * 4, 0, 5));
        bricks.add(MakeBrick(SIZE * 5, 0, 6));
        bricks.add(MakeBrick(SIZE * 6, 0, 7));
        bricks.add(MakeBrick(SIZE * 7, 0, 8));

        //Init position in MESH
        for (int[] a : MESH) {
            Arrays.fill(a, 0);
        }
        for (Brick brick : bricks) {
            MESH[(int) brick.a.getX() / SIZE][(int) brick.a.getY() / SIZE] = brick.brickNumber;
            MESH[(int) brick.b.getX() / SIZE][(int) brick.b.getY() / SIZE] = brick.brickNumber;
            MESH[(int) brick.c.getX() / SIZE][(int) brick.c.getY() / SIZE] = brick.brickNumber;
        }

        //Init highlight Brick
        highlightBrick = new Rectangle(SIZE-30, SIZE-30);
        highlightBrick.setFill(Color.WHITE);
        highlightBrick.setX(GetControlledBrick().b.getX() + 15);
        highlightBrick.setY(GetControlledBrick().b.getY() + 15);


    }
    private void UpdateHighlightBrickPosition() {
        highlightBrick.setX(GetControlledBrick().b.getX() + 15);
        highlightBrick.setY(GetControlledBrick().b.getY() + 15);
    }
    private boolean CanMoveUp() {
        boolean isNotGonnaOutOfUpBoundary = GetControlledBrick().a.getY() - MOVE >= 0 && GetControlledBrick().b.getY() - MOVE >= 0
                && GetControlledBrick().c.getY() - MOVE >= 0;
        if (isNotGonnaOutOfUpBoundary) {
            int movea = MESH[((int) GetControlledBrick().a.getX() / SIZE)][((int) GetControlledBrick().a.getY() / SIZE) - 1];
            int moveb = MESH[((int) GetControlledBrick().b.getX() / SIZE)][((int) GetControlledBrick().b.getY() / SIZE) - 1];
            int movec = MESH[((int) GetControlledBrick().c.getX() / SIZE)][((int) GetControlledBrick().c.getY() / SIZE) - 1];
            boolean isNotCollideWithOtherBricksOnTheUpSide = (movea == 0 || movea == GetControlledBrick().brickNumber) &&
                    (moveb == 0 || moveb == GetControlledBrick().brickNumber) && (movec == 0 || movec == GetControlledBrick().brickNumber);
            return isNotCollideWithOtherBricksOnTheUpSide;
        }
        return false;
    }
    public void MoveUp() {
        if (CanMoveUp()) {
            Move(0,-1);
        }
    }
    private boolean CanMoveDown() {
        boolean isNotGonnaOutOfDownBoundary = GetControlledBrick().a.getY() + MOVE <= YMAX - SIZE && GetControlledBrick().b.getY() + MOVE <= YMAX - SIZE
                && GetControlledBrick().c.getY() + MOVE <= YMAX - SIZE;
        if (isNotGonnaOutOfDownBoundary) {
            int movea = MESH[((int) GetControlledBrick().a.getX() / SIZE)][((int) GetControlledBrick().a.getY() / SIZE) + 1];
            int moveb = MESH[((int) GetControlledBrick().b.getX() / SIZE)][((int) GetControlledBrick().b.getY() / SIZE) + 1];
            int movec = MESH[((int) GetControlledBrick().c.getX() / SIZE)][((int) GetControlledBrick().c.getY() / SIZE) + 1];
            boolean isNotCollideWithOtherBricksOnTheDownSide = (movea == 0 || movea == GetControlledBrick().brickNumber) &&
                    (moveb == 0 || moveb == GetControlledBrick().brickNumber) && (movec == 0 || movec == GetControlledBrick().brickNumber);
            return isNotCollideWithOtherBricksOnTheDownSide;
        }
        return false;
    }
    public void MoveDown() {
        if (CanMoveDown()) {
            Move(0,1);
        }
    }
    private boolean CanMoveLeft() {
        boolean isNotGonnaOutOfLeftBoundary = GetControlledBrick().a.getX() - MOVE >= 0 && GetControlledBrick().b.getX() - MOVE >= 0
                && GetControlledBrick().c.getX() - MOVE >= 0;
        if (isNotGonnaOutOfLeftBoundary) {
            int movea = MESH[((int) GetControlledBrick().a.getX() / SIZE) - 1][((int) GetControlledBrick().a.getY() / SIZE)];
            int moveb = MESH[((int) GetControlledBrick().b.getX() / SIZE) - 1][((int) GetControlledBrick().b.getY() / SIZE)];
            int movec = MESH[((int) GetControlledBrick().c.getX() / SIZE) - 1][((int) GetControlledBrick().c.getY() / SIZE)];
            boolean isNotCollideWithOtherBricksOnTheLeftSide = (movea == 0 || movea == GetControlledBrick().brickNumber) &&
                    (moveb == 0 || moveb == GetControlledBrick().brickNumber) && (movec == 0 || movec == GetControlledBrick().brickNumber);
            return isNotCollideWithOtherBricksOnTheLeftSide;
        }
        return false;
    }
    public void MoveLeft() {
        if (CanMoveLeft()) {
            Move(-1, 0);
        }

    }

    private boolean CanMoveRight() {
        boolean isNotGonnaOutOfRightBoundary = GetControlledBrick().a.getX() + MOVE <= XMAX - SIZE && GetControlledBrick().b.getX() + MOVE <= XMAX - SIZE
                && GetControlledBrick().c.getX() + MOVE <= XMAX - SIZE;
        if (isNotGonnaOutOfRightBoundary) {
            int movea = MESH[((int) GetControlledBrick().a.getX() / SIZE) + 1][((int) GetControlledBrick().a.getY() / SIZE)];
            int moveb = MESH[((int) GetControlledBrick().b.getX() / SIZE) + 1][((int) GetControlledBrick().b.getY() / SIZE)];
            int movec = MESH[((int) GetControlledBrick().c.getX() / SIZE) + 1][((int) GetControlledBrick().c.getY() / SIZE)];
            boolean isNotCollideWithOtherBricksOnTheRightSide = (movea == 0 || movea == GetControlledBrick().brickNumber) &&
                    (moveb == 0 || moveb == GetControlledBrick().brickNumber) && (movec == 0 || movec == GetControlledBrick().brickNumber);
            return  isNotCollideWithOtherBricksOnTheRightSide;
        }
        return false;
    }

    public void MoveRight() {
        if (CanMoveRight()) {
            Move(1,0);
        }
    }
    private void Move(int x, int y) {
        //Move in Mesh
        MESH[((int) GetControlledBrick().a.getX() / SIZE)][((int) GetControlledBrick().a.getY() / SIZE)] = 0;
        MESH[((int) GetControlledBrick().b.getX() / SIZE)][((int) GetControlledBrick().b.getY() / SIZE)] = 0;
        MESH[((int) GetControlledBrick().c.getX() / SIZE)][((int) GetControlledBrick().c.getY() / SIZE)] = 0;
        MESH[((int) GetControlledBrick().a.getX() / SIZE) + x][((int) GetControlledBrick().a.getY() / SIZE) + y] = GetControlledBrick().brickNumber;
        MESH[((int) GetControlledBrick().b.getX() / SIZE) + x][((int) GetControlledBrick().b.getY() / SIZE) + y] = GetControlledBrick().brickNumber;
        MESH[((int) GetControlledBrick().c.getX() / SIZE) + x][((int) GetControlledBrick().c.getY() / SIZE) + y] = GetControlledBrick().brickNumber;

        //Move in Console
        GetControlledBrick().a.setX(GetControlledBrick().a.getX() + x * MOVE);
        GetControlledBrick().b.setX(GetControlledBrick().b.getX() + x * MOVE);
        GetControlledBrick().c.setX(GetControlledBrick().c.getX() + x * MOVE);
        GetControlledBrick().a.setY(GetControlledBrick().a.getY() + y * MOVE);
        GetControlledBrick().b.setY(GetControlledBrick().b.getY() + y * MOVE);
        GetControlledBrick().c.setY(GetControlledBrick().c.getY() + y * MOVE);

        UpdateHighlightBrickPosition();


    }
    private boolean CanRotateToHorizontal() {
        boolean isNotCollideWithBoundary = (GetControlledBrick().a.getX() + MOVE <= XMAX - SIZE) && (GetControlledBrick().a.getY() + MOVE <= YMAX - SIZE) &&
                (GetControlledBrick().c.getX() - MOVE >= 0) && (GetControlledBrick().c.getY() - MOVE >= 0);
        if (isNotCollideWithBoundary) {
            boolean isNotCollideWithOtherBrick = (MESH[((int) GetControlledBrick().a.getX() / SIZE) + 1][((int) GetControlledBrick().a.getY() / SIZE) + 1] == 0) &&
                    (MESH[((int) GetControlledBrick().c.getX() / SIZE) - 1][((int) GetControlledBrick().c.getY() / SIZE) - 1] == 0);
            return isNotCollideWithOtherBrick;
        }
        return false;
    }
    private boolean CanRotateToVertical() {
        boolean isNotCollideWithBoundary = (GetControlledBrick().a.getX() - MOVE >= 0) && (GetControlledBrick().a.getY() - MOVE >= 0) &&
                (GetControlledBrick().c.getX() + MOVE <= XMAX - SIZE) && (GetControlledBrick().c.getY() + MOVE <= YMAX - SIZE);
        if (isNotCollideWithBoundary) {
            boolean isNotCollideWithOtherBrick = (MESH[((int) GetControlledBrick().a.getX() / SIZE) - 1][((int) GetControlledBrick().a.getY() / SIZE) - 1] == 0) &&
                    (MESH[((int) GetControlledBrick().c.getX() / SIZE) + 1][((int) GetControlledBrick().c.getY() / SIZE) + 1] == 0);
            return isNotCollideWithOtherBrick;
        }
        return false;
    }
    public void Rotate() {
        if (GetControlledBrick().isVertical) {
            if (CanRotateToHorizontal()) {
                //Rotate in Mesh
                MESH[((int) GetControlledBrick().a.getX() / SIZE)][((int) GetControlledBrick().a.getY() / SIZE)] = 0;
                MESH[((int) GetControlledBrick().c.getX() / SIZE)][((int) GetControlledBrick().c.getY() / SIZE)] = 0;
                MESH[((int) GetControlledBrick().a.getX() / SIZE) + 1][((int) GetControlledBrick().a.getY() / SIZE) + 1] = GetControlledBrick().brickNumber;
                MESH[((int) GetControlledBrick().c.getX() / SIZE) - 1][((int) GetControlledBrick().c.getY() / SIZE) - 1] = GetControlledBrick().brickNumber;

                //Rotate in Console
                GetControlledBrick().a.setX(GetControlledBrick().a.getX() + MOVE);
                GetControlledBrick().a.setY(GetControlledBrick().a.getY() + MOVE);
                GetControlledBrick().c.setX(GetControlledBrick().c.getX() - MOVE);
                GetControlledBrick().c.setY(GetControlledBrick().c.getY() - MOVE);

                GetControlledBrick().isVertical = false;
            }
        } else {
            if (CanRotateToVertical()) {
                //Rotate in Mesh
                MESH[((int) GetControlledBrick().a.getX() / SIZE)][((int) GetControlledBrick().a.getY() / SIZE)] = 0;
                MESH[((int) GetControlledBrick().c.getX() / SIZE)][((int) GetControlledBrick().c.getY() / SIZE)] = 0;
                MESH[((int) GetControlledBrick().a.getX() / SIZE) - 1][((int) GetControlledBrick().a.getY() / SIZE) - 1] = GetControlledBrick().brickNumber;
                MESH[((int) GetControlledBrick().c.getX() / SIZE) + 1][((int) GetControlledBrick().c.getY() / SIZE) + 1] = GetControlledBrick().brickNumber;

                //Rotate in Console
                GetControlledBrick().a.setX(GetControlledBrick().a.getX() - MOVE);
                GetControlledBrick().a.setY(GetControlledBrick().a.getY() - MOVE);
                GetControlledBrick().c.setX(GetControlledBrick().c.getX() + MOVE);
                GetControlledBrick().c.setY(GetControlledBrick().c.getY() + MOVE);

                GetControlledBrick().isVertical = true;
            }
        }
    }
    public void ResetAllBrickPosition() {
        // Reset MESH into 0
        for (int[] a : MESH) {
            Arrays.fill(a, 0);
        }

        for (Brick brick : bricks) {
            //Reset Position
            brick.a.setX(SIZE * (brick.brickNumber - 1));
            brick.a.setY(0);
            brick.b.setX(SIZE * (brick.brickNumber - 1));
            brick.b.setY(SIZE);
            brick.c.setX(SIZE * (brick.brickNumber - 1));
            brick.c.setY(SIZE*2);


            //Reset MESH
            MESH[(int) brick.a.getX() / SIZE][(int) brick.a.getY() / SIZE] = brick.brickNumber;
            MESH[(int) brick.b.getX() / SIZE][(int) brick.b.getY() / SIZE] = brick.brickNumber;
            MESH[(int) brick.c.getX() / SIZE][(int) brick.c.getY() / SIZE] = brick.brickNumber;
        }
    }

    private Brick MakeBrick(int xPos, int yPos, int brickNumber) {
        //Set size
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

        UpdateHighlightBrickPosition();
    }
    private Brick GetControlledBrick() {
        return bricks.get(brickIndex);
    }
    public void PrintMeshInConsole() {
        for (int i = 0; i < MESH.length; i++) {
            for (int j = 0; j < MESH[0].length; j++) {
                System.out.print(MESH[i][j]);
            }
            System.out.println();
        }
        System.out.println();
        System.out.println();
        System.out.println();
    }

}
