package com.kruisband;

import android.content.Intent;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MenuItem;

import com.kruisband.fragments.YoutubeFragment;

public class VideoActivity extends AppCompatActivity {
    public static String VIDEO_ID;
    public static String TEXT_LOC;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_video);

        //Get the input video id
        Intent intent = getIntent();
        VIDEO_ID = intent.getStringExtra("VIDEO_ID");
        TEXT_LOC = intent.getStringExtra("TEXT_LOC");

        Fragment fragment = new YoutubeFragment();
        FragmentTransaction ft = getSupportFragmentManager().beginTransaction();
        ft.replace(R.id.content_frame, fragment);
        ft.commit();
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
