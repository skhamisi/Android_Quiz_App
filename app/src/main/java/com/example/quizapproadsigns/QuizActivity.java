package com.example.quizapproadsigns;

import android.content.Intent;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class QuizActivity extends AppCompatActivity {

    private ImageView signImageView;
    private TextView questionView;
    private Button buttonChoice1;
    private Button buttonChoice2;
    private Button buttonChoice3;
    private Button buttonChoice4;
    private String answer;
    private int score = 0;
    private int questionNumber = 0;
    private int userCustomQuestionInput = 0;
    private Questions questions = new Questions();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_quiz);

        Intent intent = getIntent();
        String userInput = intent.getStringExtra("userInput");

        //Avoids Null value exception from userInput variable
        if (userInput != null) {
            userCustomQuestionInput = Integer.parseInt(userInput);
        }
        else {
            //If userValue is null, sets userCustomQuestionInput to current size of questions array
            userCustomQuestionInput = questions.questions.length;
        }

        signImageView = findViewById(R.id.signImageView);
        questionView = findViewById(R.id.questionView);
        buttonChoice1 = findViewById(R.id.buttonChoice1);
        buttonChoice2 = findViewById(R.id.buttonChoice2);
        buttonChoice3 = findViewById(R.id.buttonChoice3);
        buttonChoice4 = findViewById(R.id.buttonChoice4);

        updateQuestion();

        buttonChoice1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                // Checks if user answer is correct
                if(buttonChoice1.getText() == answer)
                {
                    // Increments score if correct
                    score += 1;
                    // Displays "Correct" pop up to user
                    Toast.makeText(QuizActivity.this,"Correct",Toast.LENGTH_SHORT).show();
                }
                else {
                    // Does not increment score if wrong
                    // Displays "Wrong" pop to user
                    Toast.makeText(QuizActivity.this,"Wrong",Toast.LENGTH_SHORT).show();

                }
                // Continues quiz and displays next question
                updateQuestion();
            }
        });

        buttonChoice2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(buttonChoice2.getText() == answer)
                {

                    score += 1;
                    Toast.makeText(QuizActivity.this,"Correct",Toast.LENGTH_SHORT).show();
                }
                else {
                    Toast.makeText(QuizActivity.this,"Wrong",Toast.LENGTH_SHORT).show();
                }

                updateQuestion();
            }
        });

        buttonChoice3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(buttonChoice3.getText() == answer)
                {

                    score += 1;
                    Toast.makeText(QuizActivity.this,"Correct",Toast.LENGTH_SHORT).show();
                }
                else {
                    Toast.makeText(QuizActivity.this,"Wrong",Toast.LENGTH_SHORT).show();
                }

                updateQuestion();
            }
        });

        buttonChoice4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                if(buttonChoice4.getText() == answer)
                {

                    score += 1;
                    Toast.makeText(QuizActivity.this,"Correct",Toast.LENGTH_SHORT).show();
                }
                else {
                    Toast.makeText(QuizActivity.this,"Wrong",Toast.LENGTH_SHORT).show();
                }
                updateQuestion();
            }
        });
    }

    private void updateQuestion()
    {
        // Once the last question has been reached, ends quiz and redirects to the results page
        if (questionNumber > userCustomQuestionInput - 1)
        {
            Intent resultIntent = new Intent (this, ResultActivity.class);
            resultIntent.putExtra("SCORE", score);
            resultIntent.putExtra("QUESTION#", questionNumber);
            startActivity(resultIntent);
        } else {
            //gets image from array
            Resources res = getResources();
            String stringImage = questions.getImage(questionNumber);
            // Looking through res/drawable for .jpg ID that matches passed string
            int resID = res.getIdentifier(stringImage, "drawable", getPackageName());
            Drawable image = res.getDrawable(resID);

            // Displays all of the quiz information to the user
            signImageView.setImageDrawable(image);
            questionView.setText(questions.getQuestion(questionNumber));
            buttonChoice1.setText(questions.getChoice1(questionNumber));
            buttonChoice2.setText(questions.getChoice2(questionNumber));
            buttonChoice3.setText(questions.getChoice3(questionNumber));
            buttonChoice4.setText(questions.getChoice4(questionNumber));
            answer = questions.getCorrectAnswer(questionNumber);
            questionNumber++; // Keeps track of which question the user is currently on

        }
    }

    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.back, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        int id = item.getItemId();
        if (id == R.id.backButton) {

            Intent back = new Intent(this, MainActivity.class);
            startActivity(back);

        }
        return super.onOptionsItemSelected(item);
    }
}
