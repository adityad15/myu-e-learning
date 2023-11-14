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

public class MainActivity extends AppCompatActivity {

    ImageButton frameLayout, paintLayout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        frameLayout = findViewById(R.id.imageButton);
        paintLayout = findViewById(R.id.paintIB);

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

    protected void showDialog() {
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
                // Do something
                startActivity(new Intent(MainActivity.this, FirstPage.class));
                dialog.dismiss();  // Dismiss the dialog if needed
            }
        });

        carrom1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // Do something
                Toast.makeText(MainActivity.this, "Carrom", Toast.LENGTH_SHORT).show();
                dialog.dismiss();  // Dismiss the dialog if needed
            }
        });

        puzzle1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // Do something
                Toast.makeText(MainActivity.this, "Puzzle", Toast.LENGTH_SHORT).show();
                dialog.dismiss();  // Dismiss the dialog if needed
            }
        });

        dialog.show();
    }
}
