package org.example.demo;

import javafx.scene.image.Image;

public class Card {
    int[][] MESH_Sol = new int[10][10];
    int score;
    int cardNumber;
    Image image;

    public Card(int cardNumber, int MESH_Sol[][], int Score, Image image){
        for(int i = 0; i < 10; i++){
            for(int j = 0; j < 10; j++){
                this.MESH_Sol[i][j] = MESH_Sol[i][j];
            }
        }

        this.image = image;
        this.score = Score;
        this.cardNumber = cardNumber;
    }
}
