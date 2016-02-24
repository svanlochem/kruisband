package com.kruisband;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MenuItem;

public class VideoActivity extends AppCompatActivity {
    private static String VIDEO_ID;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_video);

        //Get the input video id
        Intent intent = getIntent();
        VIDEO_ID = intent.getStringExtra("VIDEO_ID");
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            // Respond to the action bar's Up/Home button
            case android.R.id.home: //Return to MainActivity
//                NavUtils.navigateUpFromSameTask(this); //Go to home fragment
                onBackPressed(); //Go to previous fragment
                return true;
        }
        return super.onOptionsItemSelected(item);
    }
}
