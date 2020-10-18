package com.example.kopapirollo;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import java.text.MessageFormat;
import java.util.Random;

public class MainActivity extends AppCompatActivity {

    private ImageView imgGamer, imgComputer;
    private ImageView imgComputerHp1, imgComputerHp2, imgComputerHp3, imgGamerHp1, imgGamerHp2, imgGamerHp3;
    private TextView tvResult;
    private Button btnKo, btnPapir, btnOllo;

    private int hpGamer, hpComputer, hpEqual;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        init();

        btnKo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                imgGamer.setImageResource(R.drawable.rock);
                GepSorsol(0);
            }
        });

        btnPapir.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                imgGamer.setImageResource(R.drawable.paper);
                GepSorsol(1);
            }
        });

        btnOllo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                imgGamer.setImageResource(R.drawable.scissors);
                GepSorsol(2);
            }
        });
    }

    private void GepSorsol(int gamer) {
        int computer = (int)(Math.random() * 3);

        //Random rnd = new Random();
        //int r = rnd.nextInt(3);

        switch (computer) {
            case 1:
                imgComputer.setImageResource(R.drawable.rock);
                //TvEredmeny.setText(MessageFormat.format("{0}", "G: " + GepValaszt));
                break;

            case 2:
                imgComputer.setImageResource(R.drawable.paper);
                break;

            case 3:
                imgComputer.setImageResource(R.drawable.scissors);
                break;
        }
    }

    private void Kiertekel() {

        /*Szabályok
        Kő veri az ollót.
        Olló veri a papírt.
        Papír veri a követ.*/

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
        btnKo = findViewById(R.id.btnKo);
        btnPapir = findViewById(R.id.btnPapir);
        btnOllo = findViewById(R.id.btnOllo);
        hpGamer = 0;
        hpComputer = 0;
        hpEqual = 0;
    }
}