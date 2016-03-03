package com.kruisband.fragments;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.kruisband.R;
import com.kruisband.VideoActivity;

public class VideoFragment extends Fragment {
    View rootview;

    private ImageView[] images = new ImageView[2];

    public VideoFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        rootview = inflater.inflate(R.layout.fragment_video, container, false);

        images[0] = (ImageView) rootview.findViewById(R.id.imageview1);
        images[1] = (ImageView) rootview.findViewById(R.id.imageview2);

        for (int i = 0; i < images.length; i++) {
            images[i].setOnClickListener(mOnClickListener);
        }

        return rootview;
    }

    private final View.OnClickListener mOnClickListener = new View.OnClickListener() {

        @Override
        public void onClick(View v) {
            if(v==images[0]){
                startMovie(getResources().getString(R.string.VIDEO_ID1),"TEST");
            } else if(v==images[1]){
                startMovie(getResources().getString(R.string.VIDEO_ID2),"TEST");
            }
        }
    };

    private void startMovie(String videoID, String text_location) {
        //Start video in new activity
        Intent myIntent = new Intent(getActivity(),VideoActivity.class);
        myIntent.putExtra("VIDEO_ID",videoID);
        myIntent.putExtra("TEXT_LOC",text_location);
        startActivity(myIntent);
    }
}
