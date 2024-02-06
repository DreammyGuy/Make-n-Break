package org.example.demo;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import java.util.Scanner;

public class Checker {
    List<Card> listOfCards = new ArrayList<>();

    private Card MakeCard(int[][] meshSol, Integer Score){
        return new Card(meshSol, Score);
    }
    
    public Checker(){
        listOfCards.add(MakeCard(meshSol_0, Score0));   //delete later
        listOfCards.add(MakeCard(meshSol_1, Score1));   
        listOfCards.add(MakeCard(meshSol_2, Score2));   
    }


    public boolean CheckSolution(int[][] Mesh, int Picture){
        int sz = 10;
        int meshSol[][] =  listOfCards.get(Picture % listOfCards.size()).meshSol;

        System.out.printf("%d %d\n", Picture, Picture % listOfCards.size());
        for (int i = 0; i < meshSol.length; i++) {
            for (int j = 0; j < meshSol[0].length; j++) {
                System.out.print(meshSol[i][j]);
                System.out.print(' ');
            }
            System.out.println();
        }
        System.out.println();
        System.out.println();
        System.out.println();

        for(int i = 0; i < sz; i++){
            for(int j = 0; j < sz; j++){
                if (Mesh[i][j] != meshSol[i][j]) {
                    System.out.println("Wrong answer");           
                    return false;
                }
            }
        }
        
        System.out.println("Right answer");
        return true;
    }
    
    public Integer GetScore(int Picture){
        return listOfCards.get(Picture % listOfCards.size()).Score;
    }
    
    int[][] meshSol_0 = {
        {1, 1, 1, 0, 0, 0, 0, 0, 0, 0},
        {2, 2, 2, 0, 0, 0, 0, 0, 0, 0},
        {3, 3, 3, 0, 0, 0, 0, 0, 0, 0},
        {4, 4, 4, 0, 0, 0, 0, 0, 0, 0},
        {5, 5, 5, 0, 0, 0, 0, 0, 0, 0},
        {6, 6, 6, 0, 0, 0, 0, 0, 0, 0},
        {7, 7, 7, 0, 0, 0, 0, 0, 0, 0},
        {8, 8, 8, 0, 0, 0, 0, 0, 0, 0},
        {0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
        {0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
    };
    int Score0 = 0;
    

    int[][] meshSol_1 = {
        {1, 1, 1, 0, 0, 0, 0, 5, 5, 5},
        {2, 2, 2, 0, 0, 3, 0, 0, 0, 8},
        {0, 0, 0, 0, 0, 3, 4, 4, 4, 8},
        {0, 0, 0, 0, 0, 3, 0, 0, 0, 8},
        {0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
        {6, 6, 6, 0, 0, 0, 0, 0, 0, 0},
        {7, 7, 7, 0, 0, 0, 0, 0, 0, 0},
        {0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
        {0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
        {0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
    };
    int Score1 = 1;

    int[][] meshSol_2 = {
        {0, 0, 4, 0, 0, 0, 1, 0, 0, 0},
        {0, 0, 4, 3, 3, 3, 1, 6, 6, 6},
        {0, 0, 4, 0, 0, 0, 1, 0, 0, 0},
        {0, 0, 5, 0, 0, 0, 8, 0, 0, 0},
        {0, 0, 5, 2, 2, 2, 8, 7, 7, 7},
        {0, 0, 5, 0, 0, 0, 8, 0, 0, 0},
        {0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
        {0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
        {0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
        {0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
    };
    int Score2 = 3;    
}