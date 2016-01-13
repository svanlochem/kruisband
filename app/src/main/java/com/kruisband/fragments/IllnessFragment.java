package com.kruisband.fragments;

import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebView;

import com.kruisband.HelperClass;
import com.kruisband.R;

public class IllnessFragment extends Fragment {
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_TEXT1 = "text1";
    private static final String ARG_TEXT2 = "text2";

    private String mText1;
    private String mText2;

    private OnIllnessFragmentInteractionListener mListener;

    public IllnessFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     */
    public static IllnessFragment newInstance(String param1, String param2) {
        IllnessFragment fragment = new IllnessFragment();
        Bundle args = new Bundle();
        args.putString(ARG_TEXT1, param1);
        args.putString(ARG_TEXT2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mText1 = getArguments().getString(ARG_TEXT1);
            mText2 = getArguments().getString(ARG_TEXT2);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View myInflatedView = inflater.inflate(R.layout.fragment_illness, container, false);

        //Display of (justified) text
        WebView webView = (WebView) myInflatedView.findViewById(R.id.webView_illness);
        String text = HelperClass.makeHTMLstring(getResources().getString(R.string.illness_intro));
        webView.loadData(text, "text/html", "utf-8");

        return myInflatedView;
    }

    public void onButtonPressed(String text) {
        if (mListener != null) {
            mListener.onIllnessFragmentInteraction(text);
        }
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        if (context instanceof OnIllnessFragmentInteractionListener) {
            mListener = (OnIllnessFragmentInteractionListener) context;
        } else {
            throw new RuntimeException(context.toString()
                    + " must implement OnFragmentInteractionListener");
        }
    }

    @Override
    public void onDetach() {
        super.onDetach();
        mListener = null;
    }

    /**
     * This interface must be implemented by activities that contain this
     * fragment to allow an interaction in this fragment to be communicated
     * to the activity and potentially other fragments contained in that
     * activity.
     * <p/>
     * See the Android Training lesson <a href=
     * "http://developer.android.com/training/basics/fragments/communicating.html"
     * >Communicating with Other Fragments</a> for more information.
     */
    public interface OnIllnessFragmentInteractionListener {
        void onIllnessFragmentInteraction(String text);
    }
}
