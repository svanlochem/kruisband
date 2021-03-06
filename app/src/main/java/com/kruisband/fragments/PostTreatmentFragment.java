package com.kruisband.fragments;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.google.android.youtube.player.YouTubeInitializationResult;
import com.google.android.youtube.player.YouTubeThumbnailLoader;
import com.google.android.youtube.player.YouTubeThumbnailView;
import com.kruisband.R;
import com.kruisband.VideoActivity;

public class PostTreatmentFragment extends Fragment implements YouTubeThumbnailView.OnInitializedListener {

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View rootView = inflater.inflate(R.layout.fragment_post_treatment, container, false);

        YouTubeThumbnailView youtubeThumbnailView = (YouTubeThumbnailView) rootView.findViewById(R.id.thumbnailView);
        youtubeThumbnailView.initialize(getResources().getString(R.string.API_KEY), this);

        youtubeThumbnailView.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View arg0) {
                //Start video in new activity
                Intent myIntent = new Intent(getActivity(),VideoActivity.class);
                myIntent.putExtra("VIDEO_ID",getResources().getString(R.string.VIDEO_ID_legExtension));
                myIntent.putExtra("TEXT_LOC",getResources().getString(R.string.ref_leg_extension));
                startActivity(myIntent);
            }
        });

        return rootView;
    }


    @Override
    public void onInitializationFailure(YouTubeThumbnailView thumbnailView,
                                        YouTubeInitializationResult errorReason) {

    }

    @Override
    public void onInitializationSuccess(YouTubeThumbnailView thumbnailView,
                                        YouTubeThumbnailLoader thumbnailLoader) {

        thumbnailLoader.setOnThumbnailLoadedListener(new ThumbnailListener());

        thumbnailLoader.setVideo(getResources().getString(R.string.VIDEO_ID_legExtension));

    }

    private final class ThumbnailListener implements
            YouTubeThumbnailLoader.OnThumbnailLoadedListener {

        @Override
        public void onThumbnailLoaded(YouTubeThumbnailView thumbnail, String videoId) {

        }

        @Override
        public void onThumbnailError(YouTubeThumbnailView thumbnail, YouTubeThumbnailLoader.ErrorReason reason) {

        }
    }
}
