package com.example.myapplication;

import android.content.ActivityNotFoundException;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import java.io.File;

public class MainActivity extends AppCompatActivity {

    ImageButton frameLayout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        File directoryToStore;
        directoryToStore = getBaseContext().getExternalFilesDir("TestFolder");
        if (!directoryToStore.exists()) {
            if (directoryToStore.mkdir()) ; //directory is created;
        }

        frameLayout = findViewById(R.id.imageButton);

        frameLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // Toast.makeText(MainActivity.this, "Opening GAMES", Toast.LENGTH_SHORT).show();

                Intent mIntent = getPackageManager().getLaunchIntentForPackage("com.google.android.youtube");
                if (mIntent != null) {
                    startActivity(mIntent);
                } else {
                    // Handle the case where YouTube app is not installed
                    Toast.makeText(MainActivity.this, "YouTube app not installed", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }
}
