package com.kruisband.fragments;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.google.android.youtube.player.YouTubeInitializationResult;
import com.google.android.youtube.player.YouTubePlayer;
import com.google.android.youtube.player.YouTubePlayerSupportFragment;
import com.kruisband.R;
import com.kruisband.VideoActivity;

public class YoutubeFragment extends Fragment {
     private View rootView;

    public YoutubeFragment() {
        // Required empty public constructor
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        //Create rootview
        rootView = inflater.inflate(R.layout.fragment_youtube, container, false);

        //TODO: Load text
//        VideoActivity.TEXT_LOC

        //YOUTUBE
//        startVideo(getResources().getString(R.string.API_KEY),getResources().getString(R.string.VIDEO_ID));
        startVideo(getResources().getString(R.string.API_KEY), VideoActivity.VIDEO_ID);

        // Inflate the layout for this fragment
        return rootView;
    }

    //Function to start a youtube video
    private void startVideo(String API_KEY, final String VIDEO_ID) {
        YouTubePlayerSupportFragment youTubePlayerFragment = YouTubePlayerSupportFragment.newInstance();
        FragmentTransaction transaction = getChildFragmentManager().beginTransaction();
        transaction.add(R.id.youtube_layout, youTubePlayerFragment).commit();

        youTubePlayerFragment.initialize(API_KEY, new YouTubePlayer.OnInitializedListener() {
            @Override
            public void onInitializationSuccess(YouTubePlayer.Provider provider, YouTubePlayer player, boolean wasRestored) {
                if (!wasRestored) {
                    player.setPlayerStyle(YouTubePlayer.PlayerStyle.MINIMAL);
                    //Load video
//                    player.loadVideo(VIDEO_ID);   //Play immediately
                    player.cueVideo(VIDEO_ID);      //Load without starting it
                    //Show fullscreen in landscape and prevent app being rotated to landscape and
                    player.addFullscreenControlFlag(player.FULLSCREEN_FLAG_CONTROL_ORIENTATION);
                    //Fullscreen automatically activate on rotation to landscape
//                    player.addFullscreenControlFlag(player.FULLSCREEN_FLAG_ALWAYS_FULLSCREEN_IN_LANDSCAPE);
                    player.play();
                }
            }

            @Override
            public void onInitializationFailure(YouTubePlayer.Provider provider, YouTubeInitializationResult error) {
                // YouTube error
                String errorMessage = error.toString();
                Toast.makeText(getActivity(), errorMessage, Toast.LENGTH_LONG).show();
                Log.d("errorMessage:", errorMessage);
            }
        });
    }
}
