package com.example.quizapproadsigns;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class ResultActivity extends AppCompatActivity implements View.OnClickListener {

    private String scorePassed ="";
    private String scoreFailed = "";
    private String status = "";
    private DbManager dbManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_result);

        TextView scoreView = findViewById(R.id.scoreView);

        int score = getIntent().getIntExtra("SCORE", 0);
        int questionNumber = getIntent().getIntExtra("QUESTION#", 0);
        int percentage = (score * 100) / questionNumber;


        if (percentage >= 70) {
            scorePassed = getString(R.string.scorePassed, percentage, score, questionNumber);
            scoreView.setText(scorePassed);
            status = "PASSED";
        } else {
            scoreFailed = getString(R.string.scoreFailed, percentage, score, questionNumber);
            scoreView.setText(scoreFailed);
            status = "FAILED";
        }

        dbManager = new DbManager(this);
        dbManager.open();

        String correct = score + "/" + questionNumber;

        dbManager.insert(percentage + "%", correct, status);


        Button button1 = findViewById(R.id.buttonMainMenu);
        button1.setOnClickListener(this); // calling onClick() method
    }

    @Override
    public void onClick(View view) {
        Intent mainIntent = new Intent(ResultActivity.this, MainActivity.class);
        startActivity(mainIntent);
    }
}
