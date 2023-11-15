package com.example.myapplication.TicTacToe;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.myapplication.MainActivity;

public class AddPlayers extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_players);

        EditText playerOne = findViewById(R.id.playerOne);
        EditText playerTwo = findViewById(R.id.playerTwo);
        Button startGameButton = findViewById(R.id.startGameButton);

        startGameButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String getPlayerOneName = playerOne.getText().toString().trim();
                String getPlayerTwoName = playerTwo.getText().toString().trim();

                if (TextUtils.isEmpty(getPlayerOneName) || TextUtils.isEmpty(getPlayerTwoName)) {
                    Toast.makeText(AddPlayers.this, "Please enter player names", Toast.LENGTH_SHORT).show();
                } else {
                    startGame(getPlayerOneName, getPlayerTwoName);
                }
            }
        });
    }

    private void startGame(String playerOneName, String playerTwoName) {
        Intent intent = new Intent(AddPlayers.this, MainActivity.class);
        intent.putExtra("playerOne", playerOneName);
        intent.putExtra("playerTwo", playerTwoName);
        startActivity(intent);
    }
}
