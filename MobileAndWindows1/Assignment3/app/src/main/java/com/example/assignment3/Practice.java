package com.example.assignment3;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Random;

public class Practice extends AppCompatActivity {
    TextView oper;
    EditText ans;
    TextView num1, num2;
    Button b;
    String op, diff;
    MediaPlayer wrong, corr;
    int numQuestions = 0, correct = 0, questionPlace = 0;

    Toast toast;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_practice);
        oper = findViewById(R.id.operButton);
        num1 = findViewById(R.id.firstButton);
        num2 = findViewById(R.id.secondButton);
        ans = findViewById(R.id.answer);
        corr = MediaPlayer.create(this, R.raw.rightsound);
        wrong = MediaPlayer.create(this,R.raw.wrongsound);


        Intent intent = getIntent();
        numQuestions = intent.getIntExtra("PROBLEMS", 2);
        op = intent.getStringExtra("OPERAND");
        diff = intent.getStringExtra("DIFFICULTY");
        if(op.equals("Addition"))
            oper.setText("+");
        else if(op.equals("Subtraction"))
            oper.setText("-");
        else if(op.equals("Multiplication"))
            oper.setText("x");
        else if(op.equals("Division"))
            oper.setText("/");

        //setting first numbers
        switch (diff) {
            case "Easy":
                num1.setText(String.valueOf(easy()));
                num2.setText(String.valueOf(easy()));
                break;
            case "Medium":
                num1.setText(String.valueOf(medium()));
                num2.setText(String.valueOf(medium()));
                break;
            case "Hard":
                num1.setText(String.valueOf(hard()));
                num2.setText(String.valueOf(hard()));
                break;
        }


        b = findViewById(R.id.doneButton);
        b.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                double total = 0;
                double firstNum = Double.parseDouble(num1.getText().toString());
                double secondNum = Double.parseDouble(num2.getText().toString());
                switch (op) {
                    case "Addition":
                        total = firstNum + secondNum;
                        break;
                    case "Subtraction":
                        total = firstNum - secondNum;
                        break;
                    case "Multiplication":
                        total = firstNum * secondNum;
                        break;
                    case "Division":
                        total = firstNum / secondNum;
                        break;
                }

                try {

                    double user = Double.parseDouble(ans.getText().toString());
                    if(total == user) {
                        correct++;
                        corr.start();
                        toast = Toast.makeText(getApplicationContext(), "Correct!", Toast.LENGTH_SHORT);
                        toast.show();
                    }
                    else {
                        wrong.start();
                        toast = Toast.makeText(getApplicationContext(), "Wrong.", Toast.LENGTH_SHORT);
                        toast.show();
                    }
                    questionPlace++;
                    //go on to the next question
                    switch (diff) {
                        case "Easy":
                            num1.setText(String.valueOf(easy()));
                            num2.setText(String.valueOf(easy()));
                            break;
                        case "Medium":
                            num1.setText(String.valueOf(medium()));
                            num2.setText(String.valueOf(medium()));
                            break;
                        case "Hard":
                            num1.setText(String.valueOf(hard()));
                            num2.setText(String.valueOf(hard()));
                            break;
                    }
                } catch (Exception e) {
                    toast = Toast.makeText(getApplicationContext(), "Enter only numbers", Toast.LENGTH_SHORT);
                    toast.show();
                }

                //if you get to questions limit, go to ending screen
                if(questionPlace >= numQuestions)
                {
                    Intent intent = new Intent();
                    intent.putExtra("CORRECT", String.valueOf(correct));
                    intent.putExtra("QUESTIONS", String.valueOf(numQuestions));
                    intent.putExtra("OPERATOR", String.valueOf(op));
                    //startActivity(intent);
                    setResult(RESULT_OK,intent);
                    finish();
                }



            }
        });
    }
    public int easy()
    {
        Random random = new Random();
        return (random.nextInt(10) + 1);
    }

    public int medium()
    {
        Random random = new Random();
        return(random.nextInt(25)+1);
    }

    @Override
    protected void onStop() {
        corr.release();
        wrong.release();
        corr = null;
        wrong = null;
        super.onStop();
    }

    public int hard()
    {
        Random random = new Random();
        return(random.nextInt(50)+1);
    }
}