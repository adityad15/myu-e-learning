package com.example.myapplication;

import android.content.ActivityNotFoundException;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageButton;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import java.io.File;
import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    ImageButton frameLayout;
    ImageButton chess = findViewById(R.id.chess), carrom = findViewById(R.id.carrom), puzzle = findViewById(R.id.puzzle);

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        LayoutInflater inflater = (LayoutInflater) getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        RelativeLayout layoutMain = (RelativeLayout) inflater.inflate(R.layout.activity_main, null);
        RelativeLayout layoutBox = (RelativeLayout) inflater.inflate(R.layout.custom_dialogbox, null);


        frameLayout = findViewById(R.id.imageButton);

        frameLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // Toast.makeText(MainActivity.this, "Opening GAMES", Toast.LENGTH_SHORT).show();

                Intent mIntent1 = getPackageManager().getLaunchIntentForPackage("com.snapchat.android");
                Intent mIntent2 = getPackageManager().getLaunchIntentForPackage("net.one97.paytm");

                if (mIntent1 != null) {
                    startActivity(mIntent1);
                } else {
                    // Handle the case where YouTube app is not installed
                    Toast.makeText(MainActivity.this, "YouTube app not installed", Toast.LENGTH_SHORT).show();
                }

                AlertDialog.Builder builder = new AlertDialog.Builder(MainActivity.this);
                builder.setTitle("GAMES");
                final View customLayout = getLayoutInflater().inflate(R.layout.custom_dialogbox, null);
                builder.setView(customLayout);

//                builder.setItems(new CharSequence[]
//                        {"Button 1", "Button 2", "Button 3"}, new DialogInterface.OnClickListener() {
//                    @Override
//                    public void onClick(DialogInterface dialogInterface, int i) {
//                        switch (i){
//                            case 0:
//                                Toast.makeText(MainActivity.this, "Button 1", Toast.LENGTH_SHORT).show();
//                                break;
//                            case 1:
//                                Toast.makeText(MainActivity.this, "Button 2", Toast.LENGTH_SHORT).show();
//                                break;
//                            case 2:
//                                Toast.makeText(MainActivity.this, "Button 3", Toast.LENGTH_SHORT).show();
//                                break;
//                        }
//                    }
//                });
                builder.create().show();
            }
        });
    }
}
