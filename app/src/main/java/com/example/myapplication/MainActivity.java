package com.example.myapplication;

import android.app.Dialog;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.example.myapplication.Games.chess.FirstPage;
import com.example.myapplication.Paint.PaintActivity;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private ImageButton frameLayout, paintLayout;
    private final List<int[]> combinationList = new ArrayList<>();
    private int[] boxPositions;
    private int playerTurn;
    private int totalSelectedBoxes;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        frameLayout = findViewById(R.id.imageButton);
        paintLayout = findViewById(R.id.paintIB);

        // Initialize game variables
        initializeGame();

        frameLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent mIntent1 = getPackageManager().getLaunchIntentForPackage("com.snapchat.android");
                Intent mIntent2 = getPackageManager().getLaunchIntentForPackage("net.one97.paytm");

                if (mIntent1 != null) {
                    startActivity(mIntent1);
                } else {
                    Toast.makeText(MainActivity.this, "Snapchat app not installed", Toast.LENGTH_SHORT).show();
                }

                showDialog();
            }
        });

        paintLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, PaintActivity.class);
                startActivity(intent);
            }
        });
    }

    private void initializeGame() {
        boxPositions = new int[]{0, 0, 0, 0, 0, 0, 0, 0, 0}; // 9 zero
        playerTurn = 1;
        totalSelectedBoxes = 1;

        // Add combinations to check for winning
        combinationList.add(new int[]{0, 1, 2});
        combinationList.add(new int[]{3, 4, 5});
        combinationList.add(new int[]{6, 7, 8});
        combinationList.add(new int[]{0, 3, 6});
        combinationList.add(new int[]{1, 4, 7});
        combinationList.add(new int[]{2, 5, 8});
        combinationList.add(new int[]{2, 4, 6});
        combinationList.add(new int[]{0, 4, 8});
    }

    private void showDialog() {
        Dialog dialog = new Dialog(this);
        dialog.setCancelable(true);

        View view = getLayoutInflater().inflate(R.layout.custom_dialogbox, null);
        dialog.setContentView(view);

        ImageButton chess1 = view.findViewById(R.id.chess);
        ImageButton carrom1 = view.findViewById(R.id.carrom);
        ImageButton puzzle1 = view.findViewById(R.id.puzzle);

        chess1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(MainActivity.this, FirstPage.class));
                dialog.dismiss();
            }
        });

        carrom1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(MainActivity.this, "Carrom", Toast.LENGTH_SHORT).show();
                dialog.dismiss();
            }
        });

        puzzle1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(MainActivity.this, "Puzzle", Toast.LENGTH_SHORT).show();
                dialog.dismiss();
            }
        });

        dialog.show();
    }

    public void restartMatch() {
    }

    // Other methods remain unchanged...
}
