package com.nickjwpark.rockpaperscissorshomework;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Random;

public class MainActivity extends AppCompatActivity {

    Button btnScissors;
    Button btnRock;
    Button btnPaper;
    Button btnPlay;
    TextView textViewResult;
    ImageView imageViewMe;
    ImageView imageViewComputer;

    String me = "";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btnScissors = (Button) findViewById(R.id.btnScissors);
        btnRock = (Button) findViewById(R.id.btnRock);
        btnPaper = (Button) findViewById(R.id.btnPaper);
        btnPlay = (Button) findViewById(R.id.btnPlay);
        textViewResult = (TextView) findViewById(R.id.textViewResult);
        imageViewMe = (ImageView) findViewById(R.id.imageViewMe);
        imageViewComputer = (ImageView) findViewById(R.id.imageViewComputer);

        btnScissors.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                me = "scissors";
                setMeImage(me);
            }
        });
        btnRock.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                me = "rock";
                setMeImage(me);
            }
        });
        btnPaper.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                me = "paper";
                setMeImage(me);
            }
        });
        btnPlay.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String computer = randomComputer();
                setComputerImage(computer);
                String result = whoWon(me, computer);
                showToast(result);
                showResult(result);
            }
        });
    }

    public void setMeImage(String me){
        if(me.equals("scissors")){
            imageViewMe.setImageResource(R.drawable.left_scissors);
        } else if(me.equals("rock")){
            imageViewMe.setImageResource(R.drawable.left_rock);
        } else if(me.equals("paper")){
            imageViewMe.setImageResource(R.drawable.left_paper);
        }
    }

    public void setComputerImage(String computer){
        if(computer.equals("scissors")){
            imageViewComputer.setImageResource(R.drawable.right_scissors);
        } else if(computer.equals("rock")){
            imageViewComputer.setImageResource(R.drawable.right_rock);
        } else if(computer.equals("paper")){
            imageViewComputer.setImageResource(R.drawable.right_paper);
        }
    }

    public String randomComputer(){
        String computer = "";
        Random rand = new Random();
        int random = rand.nextInt(3);
        if(random==0){
            computer = "scissors";
        } else if(random==1){
            computer = "rock";
        } else if(random==2){
            computer = "paper";
        } else {
            computer = "error";
        }
        return computer;
    }

    public String whoWon(String me, String computer){
        String result = "";

        if (me.equals("rock")) {
            if(computer.equals("rock")){
                result = "Draw!";
            } else if(computer.equals("paper")){
                result = "Lose!";
            } else if(computer.equals("scissors")){
                result = "Win!";
            } else {
                result = "Typo!";
            }
        } else if(me.equals("paper")){
            if(computer.equals("rock")){
                result = "Win!";
            } else if(computer.equals("paper")){
                result = "Draw!";
            } else if(computer.equals("scissors")){
                result = "Lose!";
            } else {
                result = "Typo!";
            }
        } else if(me.equals("scissors")){
            if(computer.equals("rock")){
                result = "Lose!";
            } else if(computer.equals("paper")){
                result = "Win!";
            } else if(computer.equals("scissors")){
                result = "Draw!";
            } else {
                result = "Typo!";
            }
        } else {
            result = "Please select your move!";
        }

        return result;
    }

    public void showToast(String message){
        Toast.makeText(getApplicationContext(), message, Toast.LENGTH_SHORT).show();
    }

    public void showResult(String result){
        textViewResult.setText(result);
    }

}
