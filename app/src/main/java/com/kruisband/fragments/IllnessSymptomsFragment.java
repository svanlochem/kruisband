package com.kruisband.fragments;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebView;

import com.kruisband.R;

public class IllnessSymptomsFragment extends Fragment {
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    private String mParam1;
    private String mParam2;


    public IllnessSymptomsFragment() {
        // Required empty public constructor
    }

    public static IllnessSymptomsFragment newInstance(String param1, String param2) {
        IllnessSymptomsFragment fragment = new IllnessSymptomsFragment();
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
        View myInflatedView = inflater.inflate(R.layout.fragment_text, container, false);

        //Display of text
        WebView webView = (WebView) myInflatedView.findViewById(R.id.webView_text);
        webView.loadUrl(getResources().getString(R.string.ref_assets) + getResources().getString(R.string.ref_illness_symptoms));

        // Inflate the layout for this fragment
        return myInflatedView;
    }
}