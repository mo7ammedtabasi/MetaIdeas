package com.mo7ammedtabasi.metaideas;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.View;
import android.widget.GridLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

public class Connect3 extends AppCompatActivity {

    int player= 0 ; // 0 = O ,,,, 1 = X
    boolean gameIsActive = true; // game is running
    boolean gameIsOver = true; // game is over
    boolean someOneHasWon = false; // some one has won

    int winningPosition[][]={
            {0,1,2},
            {3,4,5},
            {6,7,8},
            {0,3,6},
            {1,4,7},
            {2,5,8},
            {0,4,8},
            {2,4,6}
    };
    int gameState[]={2,2,2,2,2,2,2,2,2}; // 2 = Un player
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_connect3);
    }

    @SuppressLint("SetTextI18n")
    public void dropXO(View view) {
        ImageView xoImage=(ImageView) view;
        int tappedXO= Integer.parseInt(xoImage.getTag().toString());
       if (gameState[tappedXO]==2){
           gameState[tappedXO]=player;
           xoImage.setTranslationY(-1000f);
           if (player==0){
               xoImage.setImageResource(R.drawable.o); // setting O image
               player=1; // x will play now
           } else {
               xoImage.setImageResource(R.drawable.x);
               player=0;
           }
           xoImage.animate().translationYBy(1000f).rotation(360).setDuration(1000);
       }
       for (int [] winningPositions: winningPosition){
           if (gameState[winningPositions[0]]==gameState[winningPositions[1]] &&
                   gameState[winningPositions[1]]==gameState[winningPositions[2]] &&
                   gameState[winningPositions[0]] != 2 ){
               gameIsActive=false;
               someOneHasWon=true;
               String winner = "X";
               if (gameState[winningPositions[0]]==0){
                   winner = "O";
               }
               TextView txWinner = findViewById(R.id.txWinners);
               txWinner.setText("The Winner is : "+winner);
               LinearLayout winnerLayout = findViewById(R.id.winnerLayout);
               winnerLayout.setVisibility(View.VISIBLE);
           }else {
               gameIsOver=true;
               for (int state : gameState){
                   if (state == 2){
                       gameIsOver=false;
                   }
               }
               if (gameIsOver && !someOneHasWon){
                   TextView txWinner = findViewById(R.id.txWinners);
                   txWinner.setText("Its Draw");
                   LinearLayout winnerLayout = findViewById(R.id.winnerLayout);
                   winnerLayout.setVisibility(View.VISIBLE);
               }
           }
       }


    }
    public void playAgain(View view) {
        gameIsActive=true ;
        someOneHasWon=false;
        LinearLayout winnerLayout = findViewById(R.id.winnerLayout);
        winnerLayout.setVisibility(View.INVISIBLE);
        player = 0;
        for (int i=0; i<gameState.length;i++){
            gameState[i]=2;
        }
        GridLayout gridLayout = findViewById(R.id.gridLayoutBoard);
        for (int i=0; i< gridLayout.getChildCount();i++){
            ((ImageView) gridLayout.getChildAt(i)).setImageResource(0);
        }
    }


}