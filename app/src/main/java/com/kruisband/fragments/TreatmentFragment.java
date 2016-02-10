package com.kruisband.fragments;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.google.android.youtube.player.YouTubeInitializationResult;
import com.google.android.youtube.player.YouTubeThumbnailLoader;
import com.google.android.youtube.player.YouTubeThumbnailView;
import com.kruisband.R;

public class TreatmentFragment extends Fragment implements YouTubeThumbnailView.OnInitializedListener {
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    private String mParam1;
    private String mParam2;

    private YouTubeThumbnailView youtubeThumbnailView;
    private YouTubeThumbnailLoader youtubeThumbnailLoader;

    View rootView;

    public TreatmentFragment() {
        // Required empty public constructor
    }

    public static TreatmentFragment newInstance(String param1, String param2) {
        TreatmentFragment fragment = new TreatmentFragment();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        rootView = inflater.inflate(R.layout.fragment_treatment, container, false);

        youtubeThumbnailView = (YouTubeThumbnailView) rootView.findViewById(R.id.thumbnailView);
        youtubeThumbnailView.initialize(getResources().getString(R.string.API_KEY), this);

        youtubeThumbnailView.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View arg0) {
                Log.d("TEST","CLICK!");
//                if (youTubePlayer != null) {
//                    youTubePlayer.cueVideo(VIDEO1_ID);
//                    youTubePlayer.play();
//                    mainScrollView.smoothScrollTo(0, 0);
//                }
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

        youtubeThumbnailLoader = thumbnailLoader;
        thumbnailLoader.setOnThumbnailLoadedListener(new ThumbnailListener());

        youtubeThumbnailLoader.setVideo(getResources().getString(R.string.VIDEO_ID));

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
