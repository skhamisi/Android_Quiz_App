package com.example.quizapproadsigns;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.text.InputType;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    Button start, view;
    String userInput = "";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        start = findViewById(R.id.startQuizButton);
        start.setOnClickListener(this); // calling onClick() method

        view = findViewById(R.id.viewAttemptsButton);
        view.setOnClickListener(this); // calling onClick() method
    }

    @Override
    public void onClick(View v) {

//        switch (v.getId()) {
//            case R.id.startQuizButton:
//                Intent quizIntent = new Intent(MainActivity.this, QuizActivity.class);
//                startActivity(quizIntent);
//            case R.id.viewAttemptsButton:
//                Intent viewIntent = new Intent(MainActivity.this, AttemptsRecordActivity.class);
//                startActivity(viewIntent);
//        }

        if (v == start) {
            Intent quizIntent = new Intent(MainActivity.this, QuizActivity.class);
            startActivity(quizIntent);
        }
        else if (v == view) {

            Intent viewIntent = new Intent(MainActivity.this, AttemptsRecordActivity.class);
            startActivity(viewIntent);
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        int id = item.getItemId();
        if (id == R.id.settingsButton) {

//            Intent settings = new Intent(this, SettingsActivity.class);
//            startActivity(settings);
            getSettings();

        }
        return super.onOptionsItemSelected(item);
    }

    public void getSettings() {

        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setTitle("How many questions would you like?");

        // Set up the input
        final EditText input = new EditText(this);
        // Specify the type of input expected
        input.setInputType(InputType.TYPE_CLASS_NUMBER);
        input.setHint("Enter Amount");
        builder.setView(input);

        // Set up the buttons
        builder.setPositiveButton("Start Quiz", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                userInput = input.getText().toString();

                Intent passUserInput = new Intent(MainActivity.this, QuizActivity.class);
                passUserInput.putExtra("userInput", userInput);
                System.out.println(userInput);
                startActivity(passUserInput);
            }
        });
        builder.setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                dialog.cancel();
            }
        });

        builder.show();
    }
}