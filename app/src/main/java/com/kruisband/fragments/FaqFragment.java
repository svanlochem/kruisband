package com.kruisband.fragments;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebView;
import android.widget.ExpandableListView;

import com.kruisband.ExpandableListAdapter;
import com.kruisband.R;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class FaqFragment extends Fragment {
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    private String mParam1;
    private String mParam2;

    View rootView;

    ExpandableListAdapter listAdapter;
    ExpandableListView expListView;
    List<String> listDataHeader;
    HashMap<String, List<String>> listDataChild;

    public FaqFragment() {
        // Required empty public constructor
    }

    public static FaqFragment newInstance(String param1, String param2) {
        FaqFragment fragment = new FaqFragment();
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
        rootView = inflater.inflate(R.layout.fragment_faq, container, false);

        // get the listview
        expListView = (ExpandableListView) rootView.findViewById(R.id.expListView);

//      Tutorial ExpandableListView  http://www.androidhive.info/2013/07/android-expandable-list-view-tutorial/
        // preparing list data
        prepareListData();
        listAdapter = new ExpandableListAdapter(getContext(), listDataHeader, listDataChild);
        // setting list adapter
        expListView.setAdapter(listAdapter);
        // Listview Group click listener
        expListView.setOnGroupClickListener(new ExpandableListView.OnGroupClickListener() {

            @Override
            public boolean onGroupClick(ExpandableListView parent, View v,
                                        int groupPosition, long id) {
                return false;
            }
        });

        // Listview Group expanded listener
        expListView.setOnGroupExpandListener(new ExpandableListView.OnGroupExpandListener() {

            @Override
            public void onGroupExpand(int groupPosition) {

            }
        });

        // Listview Group collasped listener
        expListView.setOnGroupCollapseListener(new ExpandableListView.OnGroupCollapseListener() {

            @Override
            public void onGroupCollapse(int groupPosition) {
                //Clear the webview
                WebView webView = (WebView) rootView.findViewById(R.id.lblListItem);
                webView.loadUrl("about:blank");
            }
        });

        // Listview on child click listener
        expListView.setOnChildClickListener(new ExpandableListView.OnChildClickListener() {

            @Override
            public boolean onChildClick(ExpandableListView parent, View v,
                                        int groupPosition, int childPosition, long id) {
                return false;
            }
        });

        return rootView;
    }

    /*
     * Preparing the list data
     */
    private void prepareListData() {
        listDataHeader = new ArrayList<>();
        listDataChild = new HashMap<>();

        // Adding child data
        listDataHeader.add(getResources().getString(R.string.faq_q1));
        listDataHeader.add(getResources().getString(R.string.faq_q2));
        listDataHeader.add(getResources().getString(R.string.faq_q3));
        listDataHeader.add(getResources().getString(R.string.faq_q4));
        listDataHeader.add(getResources().getString(R.string.faq_q5));
        listDataHeader.add(getResources().getString(R.string.faq_q6));
        listDataHeader.add(getResources().getString(R.string.faq_q7));
        listDataHeader.add(getResources().getString(R.string.faq_q8));
        listDataHeader.add(getResources().getString(R.string.faq_q9));
        listDataHeader.add(getResources().getString(R.string.faq_q10));


        // Adding child data
        List<String> q1 = new ArrayList<>();
        q1.add(getResources().getString(R.string.faq_a1));
        List<String> q2 = new ArrayList<>();
        q2.add(getResources().getString(R.string.faq_a2));
        List<String> q3 = new ArrayList<>();
        q3.add(getResources().getString(R.string.faq_a3));
        List<String> q4 = new ArrayList<>();
        q4.add(getResources().getString(R.string.faq_a4));
        List<String> q5 = new ArrayList<>();
        q5.add(getResources().getString(R.string.faq_a5));
        List<String> q6 = new ArrayList<>();
        q6.add(getResources().getString(R.string.faq_a6));
        List<String> q7 = new ArrayList<>();
        q7.add(getResources().getString(R.string.faq_a7));
        List<String> q8 = new ArrayList<>();
        q8.add(getResources().getString(R.string.faq_a8));
        List<String> q9 = new ArrayList<>();
        q9.add(getResources().getString(R.string.faq_a9));
        List<String> q10 = new ArrayList<>();
        q10.add(getResources().getString(R.string.faq_a10));

        listDataChild.put(listDataHeader.get(0), q1); // Header, Child data
        listDataChild.put(listDataHeader.get(1), q2);
        listDataChild.put(listDataHeader.get(2), q3);
        listDataChild.put(listDataHeader.get(3), q4);
        listDataChild.put(listDataHeader.get(4), q5);
        listDataChild.put(listDataHeader.get(5), q6);
        listDataChild.put(listDataHeader.get(6), q7);
        listDataChild.put(listDataHeader.get(7), q8);
        listDataChild.put(listDataHeader.get(8), q9);
        listDataChild.put(listDataHeader.get(9), q10);
    }
}
