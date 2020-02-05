package com.example.lab2;

import android.os.Bundle;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.snackbar.Snackbar;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.TextView;

import java.util.Random;

public class MainActivity extends AppCompatActivity {

    private Weapon playerWeapon;
    private Weapon computerWeapon;
    private int playerScore;
    private int computerScore;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        FloatingActionButton fab = findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Have you played Atari Today?", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });

        playerScore = 0;
        computerScore = 0;
        TextView pScore = (TextView) findViewById(R.id.PScoreView);
        TextView cScore = (TextView) findViewById(R.id.CScoreView);
        TextView pWeapon = (TextView) findViewById(R.id.PlayerWeaponView);
        TextView cWeapon = (TextView) findViewById(R.id.ComputerWeaponView);
        TextView FunText = (TextView) findViewById(R.id.FunView);
    }

    public void pickComputerWeapon() {

        computerWeapon = Weapon.getRandomWeapon();

        Weapon winner = Weapon.determineWinner(playerWeapon, computerWeapon);
        // determine winner
        if (winner == playerWeapon) {
            TextView pWeapon = (TextView) findViewById(R.id.PlayerWeaponView);
            TextView cWeapon = (TextView) findViewById(R.id.ComputerWeaponView);
            if (playerWeapon == Weapon.ROCK) {
                pWeapon.setText(String.valueOf("Your Weapon: Rock"));
            }
            else if (playerWeapon == Weapon.PAPER) {
                pWeapon.setText(String.valueOf("Your Weapon: Paper"));
            }
            else if (playerWeapon == Weapon.SCISSORS) {
                pWeapon.setText(String.valueOf("Your Weapon: Scissors"));
            }
            if (computerWeapon == Weapon.ROCK) {
                cWeapon.setText(String.valueOf("Computer's Weapon: Rock"));
            }
            else if (computerWeapon == Weapon.PAPER) {
                cWeapon.setText(String.valueOf("Computer's Weapon: Paper"));
            }
            else if (computerWeapon == Weapon.SCISSORS) {
                cWeapon.setText(String.valueOf("Computer's Weapon: Scissors"));
            }
            ++playerScore;
            TextView pScore = (TextView) findViewById(R.id.PScoreView);
            pScore.setText(String.valueOf(playerScore));
        }
        else if (winner == computerWeapon) {
            TextView pWeapon = (TextView) findViewById(R.id.PlayerWeaponView);
            TextView cWeapon = (TextView) findViewById(R.id.ComputerWeaponView);
            if (playerWeapon == Weapon.ROCK) {
                pWeapon.setText(String.valueOf("Your Weapon: Rock"));
            }
            else if (playerWeapon == Weapon.PAPER) {
                pWeapon.setText(String.valueOf("Your Weapon: Paper"));
            }
            else if (playerWeapon == Weapon.SCISSORS) {
                pWeapon.setText(String.valueOf("Your Weapon: Scissors"));
            }
            if (computerWeapon == Weapon.ROCK) {
                cWeapon.setText(String.valueOf("Computer's Weapon: Rock"));
            }
            else if (computerWeapon == Weapon.PAPER) {
                cWeapon.setText(String.valueOf("Computer's Weapon: Paper"));
            }
            else if (computerWeapon == Weapon.SCISSORS) {
                cWeapon.setText(String.valueOf("Computer's Weapon: Scissors"));
            }
            ++computerScore;
            TextView cScore = (TextView) findViewById(R.id.CScoreView);
            cScore.setText(String.valueOf(computerScore));
        }
        else if (winner == null) {
            TextView pWeapon = (TextView) findViewById(R.id.PlayerWeaponView);
            TextView cWeapon = (TextView) findViewById(R.id.ComputerWeaponView);
            if (playerWeapon == Weapon.ROCK) {
                pWeapon.setText(String.valueOf("Your Weapon: Rock"));
            }
            else if (playerWeapon == Weapon.PAPER) {
                pWeapon.setText(String.valueOf("Your Weapon: Paper"));
            }
            else if (playerWeapon == Weapon.SCISSORS) {
                pWeapon.setText(String.valueOf("Your Weapon: Scissors"));
            }
            if (computerWeapon == Weapon.ROCK) {
                cWeapon.setText(String.valueOf("Computer's Weapon: Rock"));
            }
            else if (computerWeapon == Weapon.PAPER) {
                cWeapon.setText(String.valueOf("Computer's Weapon: Paper"));
            }
            else if (computerWeapon == Weapon.SCISSORS) {
                cWeapon.setText(String.valueOf("Computer's Weapon: Scissors"));
            }
        }
    }



    public void rockButtonClicked(View v) {

        playerWeapon = Weapon.ROCK;
        pickComputerWeapon();

    }

    public void paperButtonClicked(View v) {
        playerWeapon = Weapon.PAPER;
        pickComputerWeapon();

    }

    public void scissorsButtonClicked(View v) {
        playerWeapon = Weapon.SCISSORS;
        pickComputerWeapon();

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    public enum Weapon {

        ROCK("Rock"),
        PAPER("Paper"),
        SCISSORS("Scissors");
        private String message;

        private Weapon(String msg) { message = msg; }

        @Override
        public String toString() { return message; }

        public static Weapon getRandomWeapon() {
            Random r = new Random();
            Weapon[] values = Weapon.values();
            return ( values[ r.nextInt(values.length) ] );
        }

        public static Weapon determineWinner(Weapon p1, Weapon p2) {
            boolean p1_winner = false;

            switch (p1) {
                case ROCK:
                    if (p2 == Weapon.SCISSORS)
                        p1_winner = true;
                    break;
                case PAPER:
                    if (p2 == Weapon.ROCK)
                        p1_winner = true;
                    break;
                case SCISSORS:
                    if (p2 == Weapon.PAPER)
                        p1_winner = true;
                    break;
            }

            if (p1_winner) {
                return (p1);
            }
            else if (p1 == p2) {
                return (null);
            }
            else if (p1_winner == false) {
                return (p2);
            }
            // return value
            return (null);
        }

    };
}