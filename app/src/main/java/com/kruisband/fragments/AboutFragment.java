package com.kruisband.fragments;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebView;
import android.webkit.WebViewClient;

import com.kruisband.MainActivity;
import com.kruisband.R;

public class AboutFragment extends Fragment {
    View rootView;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
       }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        rootView = inflater.inflate(R.layout.fragment_text, container, false);

        //Display of text
        WebView webView = (WebView) rootView.findViewById(R.id.webView_text);
        webView.loadUrl(getResources().getString(R.string.ref_assets) + getResources().getString(R.string.ref_about));

        webView.setWebViewClient(new WebViewClient() {
            @Override
            public boolean shouldOverrideUrlLoading(WebView view, String url) {
                if (url.equals("file:///android_asset/go_to_movies")) {
                    //Go to the videos fragment
                    ((MainActivity)getActivity()).goToVideos();
                }
                return super.shouldOverrideUrlLoading(view, url);
            }
        });

        return rootView;
    }
}
