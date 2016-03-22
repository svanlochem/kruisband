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

    private final ImageView[] images_mobilisation = new ImageView[2];
    private final ImageView[] images_force = new ImageView[3];

    public VideoFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View rootview = inflater.inflate(R.layout.fragment_video, container, false);

        //Mobilisation Scrollview images
        images_mobilisation[0] = (ImageView) rootview.findViewById(R.id.imageview1_1);
        images_mobilisation[1] = (ImageView) rootview.findViewById(R.id.imageview1_2);

        for (ImageView anImages_mobilisation : images_mobilisation) {
            anImages_mobilisation.setOnClickListener(mOnClickListener);
        }

        //Force Scrollview images
        images_force[0] = (ImageView) rootview.findViewById(R.id.imageview2_1);
        images_force[1] = (ImageView) rootview.findViewById(R.id.imageview2_2);
        images_force[2] = (ImageView) rootview.findViewById(R.id.imageview2_3);

        for (ImageView anImages_force : images_force) {
            anImages_force.setOnClickListener(mOnClickListener);
        }

        return rootview;
    }

    private final View.OnClickListener mOnClickListener = new View.OnClickListener() {

        @Override
        public void onClick(View v) {
            if(v==images_mobilisation[0]){//Leg Extension
                startMovie(getResources().getString(R.string.VIDEO_ID_legExtension),getResources().getString(R.string.ref_leg_extension));
            } else if(v==images_mobilisation[1]){//Ankle Pumps
                startMovie(getResources().getString(R.string.VIDEO_ID_anklePumps),getResources().getString(R.string.ref_ankle_pumps));
            }

            else if(v==images_force[0]){//Straight Leg Raise
                startMovie(getResources().getString(R.string.VIDEO_ID_straightLegRaise),getResources().getString(R.string.ref_straight_leg_raise));
            } else if(v==images_force[1]) {//Knee Extension
                startMovie(getResources().getString(R.string.VIDEO_ID_kneeExtension),getResources().getString(R.string.ref_knee_extension));
            } else if(v==images_force[2]) {//Hip Abduction
                startMovie(getResources().getString(R.string.VIDEO_ID_hipAbduction),getResources().getString(R.string.ref_hip_abduction));
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
