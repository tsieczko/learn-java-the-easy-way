package net.sieczko.guessinggameandroid;

import android.content.DialogInterface;
import android.os.Bundle;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.snackbar.Snackbar;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.view.KeyEvent;
import android.view.MenuInflater;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    private EditText txtGuess;
    private Button btnGuess;
    private TextView lblOutput;
    private int randomNumber;
    private int range = 100;
    private TextView lblRange;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        txtGuess = (EditText) findViewById(R.id.txtGuess);
        txtGuess.setOnEditorActionListener(new TextView.OnEditorActionListener() {
            @Override
            public boolean onEditorAction(TextView v, int actionId, KeyEvent event) {
                checkGuess();
                return true;
            }
        });

        btnGuess = (Button) findViewById(R.id.btnGuess);
        btnGuess.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                checkGuess();
            }
        });

        lblOutput = (TextView) findViewById(R.id.lblOutput);

        lblRange = (TextView) findViewById(R.id.lblPrompt);

        newGame();

        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.action_settings:
                final CharSequence[] items = {"1 to 10", "1 to 100", "1 to 1000"};
                AlertDialog.Builder builder = new AlertDialog.Builder(this);
                builder.setTitle("Select the Range:");
                builder.setItems(items, new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int item) {
                        switch (item) {
                            case 0:
                                range = 10;
                                newGame();
                                break;
                            case 1:
                                range = 100;
                                newGame();
                                break;
                            case 2:
                                range = 1000;
                                newGame();
                                break;
                        }
                        dialog.dismiss();
                    }
                });
                AlertDialog alert = builder.create();
                alert.show();
                return true;
            case R.id.action_newgame:
                newGame();
            case R.id.action_gamestats:
                return true;
            case R.id.action_about:
                AlertDialog aboutDialog = new AlertDialog.Builder(MainActivity.this).create();
                aboutDialog.setTitle("About Guessing Game");
                aboutDialog.setMessage("2019");
                aboutDialog.setButton(AlertDialog.BUTTON_NEUTRAL, "OK",
                    new DialogInterface.OnClickListener() {
                        public void onClick(DialogInterface dialog, int which) {
                            dialog.dismiss();
                        }
                    });
                aboutDialog.show();
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }

    public void newGame() {
        randomNumber = (int) (Math.random() * range + 1);
        lblRange.setText("Enter a number between 1 and " + range + '.');
        lblOutput.setText("Enter a number, then click guess!");
        txtGuess.setText("" + range/2);
        txtGuess.requestFocus();
        txtGuess.selectAll();
    }

    public void checkGuess() {
        String guessText = txtGuess.getText().toString();
        String message = "";
        try {
            int guess = Integer.parseInt(guessText);
            if (guess < randomNumber) {
                message = guess + " is too low. Try again.";
            }
            if (guess > randomNumber) {
                message = guess + " is too high. Try again.";
            }
            if (guess == randomNumber) {
                message = guess + " is correct. You win! Let's play again!";
                newGame();
            }

        } catch (Exception e) {
            message = "Enter a whole number between 1 and " + range + ".";
        } finally {
            lblOutput.setText(message);
            txtGuess.requestFocus();
            txtGuess.selectAll();
        }
    }
}