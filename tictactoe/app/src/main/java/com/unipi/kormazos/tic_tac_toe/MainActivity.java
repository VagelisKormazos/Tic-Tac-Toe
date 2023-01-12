package com.unipi.kormazos.tic_tac_toe;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TableLayout;
import android.widget.TableRow;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;

public class MainActivity extends AppCompatActivity {
    //EditText block1;
    int player=1;

    List<String> allTheAnswers =new ArrayList<String>();

    // Create a list of strings
    String[] strings = {"x", "o"};

    // Create a random number generator
    Random rand = new Random();

    // Generate a random integer between 0 and 1
    int index = rand.nextInt(2);

    // Get the random string
    String symbol = strings[index];


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        setNewSymbol();

    }

    public void start(View view){


        player = rand.nextInt(2);
        setPlayerColor();
        changePlayer();
        reset();
    }

    public void setNewSymbol(){
        index = rand.nextInt(2);
        symbol = strings[index];

        TextView textViewSymbol1 = findViewById(R.id.textView11);
        TextView textViewSymbol2 = findViewById(R.id.textView12);
        textViewSymbol1.setText(symbol);
        changeSymbol();
        textViewSymbol2.setText(symbol);
        changeSymbol();
    }
    public void setPlayerColor(){
        TextView textViewSymbol1 = findViewById(R.id.textView11);
        TextView textViewSymbol2 = findViewById(R.id.textView12);
        if(player==1){
            TextView textView = findViewById(R.id.textView3);
            textView.setBackgroundColor(Color.GREEN);
            TextView textView1 = findViewById(R.id.textView4);
            textView1.setBackgroundColor(Color.TRANSPARENT);
            symbol=textViewSymbol1.getText().toString();

        }else{
            TextView textView = findViewById(R.id.textView4);
            textView.setBackgroundColor(Color.GREEN);
            TextView textView1 = findViewById(R.id.textView3);
            textView1.setBackgroundColor(Color.TRANSPARENT);
            symbol=textViewSymbol2.getText().toString();

        }
    }

    public void reset(){

        TableLayout tableLayout = findViewById(R.id.tableLayout);

        for(int i = 0, s = tableLayout.getChildCount(); i < s; ++i) {
            TableRow row = (TableRow)tableLayout.getChildAt(i);
            for(int j = 0, s2 = tableLayout.getChildCount(); j < s2; ++j) {
                TextView name = (TextView)row.getChildAt(j);
                name.setText("");
            }
        }
    }

    public void changeSymbol(){

        if (symbol=="x"){
            symbol="o";
        }else {
            symbol="x";
        }

    }

    public void changePlayer(){

        TextView textViewPlayer1 = findViewById(R.id.textView3);
        TextView textViewPlayer2 = findViewById(R.id.textView4);

        if(player==1){
            player=2;
            textViewPlayer1.setBackgroundColor(Color.GREEN);
            textViewPlayer2.setBackgroundColor(Color.TRANSPARENT);

        }else {
            player=1;
            textViewPlayer2.setBackgroundColor(Color.GREEN);
            textViewPlayer1.setBackgroundColor(Color.TRANSPARENT);

        }
    }

    public void addInScore() {

        int x;
        TextView textViewSymbol1 = findViewById(R.id.textView11);
        TextView textViewSymbol2 = findViewById(R.id.textView12);
        TextView textViewScore1 = findViewById(R.id.textView5);
        TextView textViewScore2 = findViewById(R.id.textView7);

        if (textViewSymbol1.getText().toString() == symbol) {
            x = Integer.parseInt(textViewScore1.getText().toString());
            x++;
            textViewScore1.setText(Integer.toString(x));
        }
        if (textViewSymbol2.getText().toString() == symbol) {
            x = Integer.parseInt(textViewScore2.getText().toString());
            x++;
            textViewScore2.setText(Integer.toString(x));
        }


        //Toast.makeText(getApplicationContext(), "New Game started", Toast.LENGTH_SHORT).show();
        reset();
    }

    public void checkIfWin(){

        TableLayout tableLayout = findViewById(R.id.tableLayout);
         for(int i = 0, s = tableLayout.getChildCount(); i < s; ++i) {
            TableRow row = (TableRow)tableLayout.getChildAt(i);
            for(int j = 0, s2 = tableLayout.getChildCount(); j < s2; ++j) {
                TextView name = (TextView)row.getChildAt(j);
                allTheAnswers.add(name.getText().toString());
            }
        }
        int x;
        if(player==1){
            x=2;


        }else {
            x=1;

        }

        for(int k =0 ;k<3;k++) {
            if (allTheAnswers.get(k)!="" && allTheAnswers.get(k) == allTheAnswers.get(k+3) && allTheAnswers.get(k+6) == allTheAnswers.get(k+3)) {
                Toast.makeText(getApplicationContext(), "Player "+ x +" Win", Toast.LENGTH_SHORT).show();
                addInScore();
            }
        }
        if (allTheAnswers.get(0)!="" && allTheAnswers.get(1) == allTheAnswers.get(0) && allTheAnswers.get(1) == allTheAnswers.get(2)){
            Toast.makeText(getApplicationContext(), "Player "+ x +" Win", Toast.LENGTH_SHORT).show();
            addInScore();
        }
        if (allTheAnswers.get(3)!="" && allTheAnswers.get(3) == allTheAnswers.get(4) && allTheAnswers.get(4) == allTheAnswers.get(5)){
            Toast.makeText(getApplicationContext(), "Player "+ x +" Win", Toast.LENGTH_SHORT).show();
            addInScore();
        }
        if (allTheAnswers.get(6)!="" && allTheAnswers.get(6) == allTheAnswers.get(7) && allTheAnswers.get(7) == allTheAnswers.get(8)){
            Toast.makeText(getApplicationContext(), "Player "+ x +" Win", Toast.LENGTH_SHORT).show();
            addInScore();
        }

        if (allTheAnswers.get(0)!="" && allTheAnswers.get(8) == allTheAnswers.get(0) && allTheAnswers.get(4) == allTheAnswers.get(0)) {
            Toast.makeText(getApplicationContext(), "Player "+ x +" Win", Toast.LENGTH_SHORT).show();
            addInScore();
        }
        if (allTheAnswers.get(2)!="" && allTheAnswers.get(4) == allTheAnswers.get(2) && allTheAnswers.get(2) == allTheAnswers.get(6)) {
            Toast.makeText(getApplicationContext(), "Player "+ x +" Win", Toast.LENGTH_SHORT).show();
            addInScore();
        }
        allTheAnswers.clear();
    }


    public void setValue00(View view){
        TableLayout tableLayout = findViewById(R.id.tableLayout);
        TableRow tableRow = (TableRow) tableLayout.getChildAt(0);
        TextView textView = (TextView) tableRow.getChildAt(0);
        if(textView.getText().toString().isEmpty()) {
            textView.setText(symbol);
            checkIfWin();
            changeSymbol();
            changePlayer();
        }
    }
    public void setValue01(View view){
        TableLayout tableLayout = findViewById(R.id.tableLayout);
        TableRow tableRow = (TableRow) tableLayout.getChildAt(0);
        TextView textView = (TextView) tableRow.getChildAt(1);
        if(textView.getText().toString().isEmpty()) {
            textView.setText(symbol);
            checkIfWin();
            changeSymbol();
            changePlayer();
        }
    }
    public void setValue02(View view){
        TableLayout tableLayout = findViewById(R.id.tableLayout);
        TableRow tableRow = (TableRow) tableLayout.getChildAt(0);
        TextView textView = (TextView) tableRow.getChildAt(2);
        if(textView.getText().toString().isEmpty()) {
            textView.setText(symbol);
            checkIfWin();
            changeSymbol();
            changePlayer();
        }
    }
    public void setValue10(View view){
        TableLayout tableLayout = findViewById(R.id.tableLayout);
        TableRow tableRow = (TableRow) tableLayout.getChildAt(1);
        TextView textView = (TextView) tableRow.getChildAt(0);
        if(textView.getText().toString().isEmpty()) {
            textView.setText(symbol);
            checkIfWin();
            changeSymbol();
            changePlayer();
        }
    }
    public void setValue11(View view){
        TableLayout tableLayout = findViewById(R.id.tableLayout);
        TableRow tableRow = (TableRow) tableLayout.getChildAt(1);
        TextView textView = (TextView) tableRow.getChildAt(1);
        if(textView.getText().toString().isEmpty()) {
            textView.setText(symbol);
            checkIfWin();
            changeSymbol();
            changePlayer();
        }
    }
    public void setValue12(View view){
        TableLayout tableLayout = findViewById(R.id.tableLayout);
        TableRow tableRow = (TableRow) tableLayout.getChildAt(1);
        TextView textView = (TextView) tableRow.getChildAt(2);
        if(textView.getText().toString().isEmpty()) {
            textView.setText(symbol);
            checkIfWin();
            changeSymbol();
            changePlayer();
        }
    }
    public void setValue20(View view){
        TableLayout tableLayout = findViewById(R.id.tableLayout);
        TableRow tableRow = (TableRow) tableLayout.getChildAt(2);
        TextView textView = (TextView) tableRow.getChildAt(0);
        if(textView.getText().toString().isEmpty()) {
            textView.setText(symbol);
            checkIfWin();
            changeSymbol();
            changePlayer();
        }
    }
    public void setValue21(View view){
        TableLayout tableLayout = findViewById(R.id.tableLayout);
        TableRow tableRow = (TableRow) tableLayout.getChildAt(2);
        TextView textView = (TextView) tableRow.getChildAt(1);
        if(textView.getText().toString().isEmpty()) {
            textView.setText(symbol);
            checkIfWin();
            changeSymbol();
            changePlayer();
        }
    }
    public void setValue22(View view){
        TableLayout tableLayout = findViewById(R.id.tableLayout);
        TableRow tableRow = (TableRow) tableLayout.getChildAt(2);
        TextView textView = (TextView) tableRow.getChildAt(2);
        if(textView.getText().toString().isEmpty()) {
            textView.setText(symbol);
            checkIfWin();
            changeSymbol();
            changePlayer();
        }
    }
}