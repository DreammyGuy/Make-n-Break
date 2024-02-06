package org.example.demo;

public class Card {
    int[][] meshSol = new int[10][10];
    int Score;

    public Card(int meshSol[][], int Score){
        for(int i = 0; i < 10; i++){
            for(int j = 0; j < 10; j++){
                this.meshSol[i][j] = meshSol[i][j];
            }
        }

        this.Score = Score;
    }
    
}
