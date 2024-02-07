package org.example.demo;

import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Checker {
    List<Card> listOfCards = new ArrayList<>();
    ImageView imageView = new ImageView();
    public int [][] MESH = Make_Break.MESH;
    public static final int SIZE = 40;
    public static int XMAX = SIZE * 10;
    public static int YMAX = SIZE * 10;
    private int cardIndex = 0;


    Checker() {
        //Add cards
        listOfCards.add(MakeCard(1, CardSolutionData.MESH_Sol_1, CardSolutionData.score1, CardSolutionData.image1));
        listOfCards.add(MakeCard(2, CardSolutionData.MESH_Sol_2, CardSolutionData.score2, CardSolutionData.image2));
        listOfCards.add(MakeCard(3, CardSolutionData.MESH_Sol_3, CardSolutionData.score3, CardSolutionData.image3));
        listOfCards.add(MakeCard(4, CardSolutionData.MESH_Sol_4, CardSolutionData.score4, CardSolutionData.image4));
        listOfCards.add(MakeCard(5, CardSolutionData.MESH_Sol_5, CardSolutionData.score5, CardSolutionData.image5));
        listOfCards.add(MakeCard(6, CardSolutionData.MESH_Sol_6, CardSolutionData.score6, CardSolutionData.image6));
        listOfCards.add(MakeCard(7, CardSolutionData.MESH_Sol_7, CardSolutionData.score7, CardSolutionData.image7));
        listOfCards.add(MakeCard(8, CardSolutionData.MESH_Sol_8, CardSolutionData.score8, CardSolutionData.image8));
        listOfCards.add(MakeCard(9, CardSolutionData.MESH_Sol_9, CardSolutionData.score9, CardSolutionData.image9));
        listOfCards.add(MakeCard(10, CardSolutionData.MESH_Sol_10, CardSolutionData.score10, CardSolutionData.image10));
        listOfCards.add(MakeCard(11, CardSolutionData.MESH_Sol_11, CardSolutionData.score11, CardSolutionData.image11));
        listOfCards.add(MakeCard(12, CardSolutionData.MESH_Sol_12, CardSolutionData.score12, CardSolutionData.image12));
        listOfCards.add(MakeCard(13, CardSolutionData.MESH_Sol_13, CardSolutionData.score13, CardSolutionData.image13));
        listOfCards.add(MakeCard(14, CardSolutionData.MESH_Sol_14, CardSolutionData.score14, CardSolutionData.image14));
        listOfCards.add(MakeCard(15, CardSolutionData.MESH_Sol_15, CardSolutionData.score15, CardSolutionData.image15));
        listOfCards.add(MakeCard(16, CardSolutionData.MESH_Sol_16, CardSolutionData.score16, CardSolutionData.image16));



        //Set Up Image
        imageView.setX(XMAX + 4);
        imageView.setY(200);
        imageView.setFitHeight(160);
        imageView.setFitWidth(150);
        imageView.setPreserveRatio(true);
        imageView.setImage(GetCurrentCard().image);
    }

    public boolean Check(BricksController bricksController) {
        for (int i = 0; i < MESH.length; i++) {
            for (int j = 0; j < MESH[0].length; j++) {
                if (bricksController.MESH[i][j] != GetCurrentCard().MESH_Sol[i][j]) {
                    System.out.println("Wrong answer");
                    return false;
                }
            }
        }

        RandomCardIndex();
        imageView.setImage(GetCurrentCard().image);
        bricksController.ResetAllBrickPosition();
        return true;
    }
    private Card GetCurrentCard() {
        return listOfCards.get(cardIndex);
    }
    private void RandomCardIndex() {
        Random random = new Random();
        cardIndex = random.nextInt(listOfCards.size());
    }

    private Card MakeCard(int cardNumber, int[][] meshSol, int score, Image image) {
        return new Card(cardNumber, meshSol, score, image);
    }
}
