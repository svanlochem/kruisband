package com.kruisband.fragments;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebView;

import com.kruisband.R;

public class IllnessAnatomyFragment extends Fragment {

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_text, container, false);

        //Display of text
        WebView webView = (WebView) rootView.findViewById(R.id.webView_text);
        webView.loadUrl(getResources().getString(R.string.ref_assets) + getResources().getString(R.string.ref_illness_anatomy));
//        webView.loadData(getResources().getString(R.string.illness_anatomy), "text/html", "utf-8");

        // Inflate the layout for this fragment
        return rootView;
    }
}