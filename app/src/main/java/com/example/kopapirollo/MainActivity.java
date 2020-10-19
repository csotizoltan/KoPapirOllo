package com.example.kopapirollo;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Random;


public class MainActivity extends AppCompatActivity {

    private ImageView imgGamer, imgComputer;
    private ImageView imgComputerHp1, imgComputerHp2, imgComputerHp3, imgGamerHp1, imgGamerHp2, imgGamerHp3;
    private TextView tvResult;
    private Button btnRock, btnPaper, btnScissors;
    private AlertDialog.Builder AlertEndGame;

    private int hpGamer, hpComputer, hpEqual;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        init();

        btnRock.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                imgGamer.setImageResource(R.drawable.rock);
                ComputerDraws(0);
            }
        });

        btnPaper.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                imgGamer.setImageResource(R.drawable.paper);
                ComputerDraws(1);
            }
        });

        btnScissors.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                imgGamer.setImageResource(R.drawable.scissors);
                ComputerDraws(2);
            }
        });
    }


    private void ComputerDraws(int gamer) {
        int computer = (int)(Math.random() * 3);

        //Random rnd = new Random();
        //int computer = rnd.nextInt(3);


        if (computer == 0) {
            imgComputer.setImageResource(R.drawable.rock);
        }

        else if (computer == 1) {
            imgComputer.setImageResource(R.drawable.paper);
        }

        else {                  // computer == 2
            imgComputer.setImageResource(R.drawable.scissors);
        }


        String resultMessage;

        resultMessage = (gamer == 0 && computer == 2 || gamer == 1 && computer == 0 || gamer == 2 && computer == 1
                ? "Nyert" : computer == gamer ? "Döntetlen" : "Vesztet");

        Toast.makeText(getApplicationContext(), resultMessage, Toast.LENGTH_SHORT).show();

        Evaluates(gamer, computer);

        tvResult.setText("Döntetlenek száma: " + hpEqual);

        EngGame();
    }


    private void Evaluates(int gamer, int   computer) {

        if (gamer == 0 && computer == 2 || gamer == 1 && computer == 0 || gamer == 2 && computer == 1) {
            hpGamer++;

            if (hpGamer == 1) {
                imgComputerHp1.setImageResource(R.drawable.heart1);
            }

            else if (hpGamer == 2) {
                imgComputerHp2.setImageResource(R.drawable.heart1);
            }

            else {
                imgComputerHp3.setImageResource(R.drawable.heart1);
            }
        }

        else if (gamer == computer) {
            hpEqual++;
        }

        else {
            hpComputer++;

            if (hpComputer == 1) {
                imgGamerHp1.setImageResource(R.drawable.heart1);
            }

            else if (hpComputer == 2) {
                imgGamerHp2.setImageResource(R.drawable.heart1);
            }

            else {
                imgGamerHp3.setImageResource(R.drawable.heart1);
            }
        }
    }


    private void EngGame() {

        AlertDialog.Builder AlertEndGame = new AlertDialog.Builder(this);

        if (hpGamer == 3 || hpComputer == 3) {
            AlertEndGame = new AlertDialog.Builder(MainActivity.this);
            AlertEndGame.setTitle("A játék véget ért.");

            AlertEndGame.setCancelable(false).setMessage("Szeretne új játékot játszani?")
                    .setPositiveButton("Nem", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialog, int which) {
                            System.exit(0);
                        }
                    })
                    .setNegativeButton("Igen", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialog, int which) {
                            NewGame();
                        }
                    });
            AlertEndGame.create().show();
        }
    }


    private void NewGame() {
        hpGamer = 0;
        hpComputer = 0;
        hpEqual = 0;

        tvResult.setText("Döntetlenek száma: 0");

        imgComputerHp1.setImageResource(R.drawable.heart2);
        imgComputerHp2.setImageResource(R.drawable.heart2);
        imgComputerHp3.setImageResource(R.drawable.heart2);
        imgGamerHp3.setImageResource(R.drawable.heart2);
        imgGamerHp2.setImageResource(R.drawable.heart2);
        imgGamerHp1.setImageResource(R.drawable.heart2);
    }


    private void init() {
        imgGamer = findViewById(R.id.imgGamer);
        imgComputer = findViewById(R.id.imgComputer);
        imgComputerHp1 = findViewById(R.id.imgComputerHp1);
        imgComputerHp2 = findViewById(R.id.imgComputerHp2);
        imgComputerHp3 = findViewById(R.id.imgComputerHp3);
        imgGamerHp1 = findViewById(R.id.imgGamerHp1);
        imgGamerHp2 = findViewById(R.id.imgGamerHp2);
        imgGamerHp3 = findViewById(R.id.imgGamerHp3);
        tvResult = findViewById(R.id.tvResult);
        btnRock = findViewById(R.id.btnRock);
        btnPaper = findViewById(R.id.btnPaper);
        btnScissors = findViewById(R.id.btnScissors);
        hpGamer = 0;
        hpComputer = 0;
        hpEqual = 0;
    }
}