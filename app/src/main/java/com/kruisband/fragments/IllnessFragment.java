package com.kruisband.fragments;

import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.kruisband.R;

public class IllnessFragment extends Fragment {
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_TEXT1 = "text1";
    private static final String ARG_TEXT2 = "text2";

    private String mText1;
    private String mText2;


    public IllnessFragment() {
        // Required empty public constructor
    }

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

        TabLayout tabLayout = (TabLayout) myInflatedView.findViewById(R.id.tab_layout);
        tabLayout.addTab(tabLayout.newTab().setText(getResources().getString(R.string.tab_illness_anatomy)));
        tabLayout.addTab(tabLayout.newTab().setText(getResources().getString(R.string.tab_illness_causes)));
        tabLayout.addTab(tabLayout.newTab().setText(getResources().getString(R.string.tab_illness_symptoms)));
        tabLayout.addTab(tabLayout.newTab().setText(getResources().getString(R.string.tab_illness_diagnosis)));

        final ViewPager viewPager = (ViewPager) myInflatedView.findViewById(R.id.viewpager);

        viewPager.setAdapter(new PagerAdapter
                (getFragmentManager(), tabLayout.getTabCount()));
        viewPager.addOnPageChangeListener(new TabLayout.TabLayoutOnPageChangeListener(tabLayout));
        tabLayout.setOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
            @Override
            public void onTabSelected(TabLayout.Tab tab) {
                viewPager.setCurrentItem(tab.getPosition());
            }

            @Override
            public void onTabUnselected(TabLayout.Tab tab) {

            }

            @Override
            public void onTabReselected(TabLayout.Tab tab) {

            }
        });

        return myInflatedView;
    }

    public class PagerAdapter extends FragmentStatePagerAdapter {
        int mNumOfTabs;

        public PagerAdapter(FragmentManager fm, int NumOfTabs) {
            super(fm);
            this.mNumOfTabs = NumOfTabs;
        }

        @Override
        public Fragment getItem(int position) {
            switch (position) {
                case 0:
                    return new IllnessAnatomyFragment();
                case 1:
                    return new IllnessCausesFragment();
                case 2:
                    return new IllnessSymptomsFragment();
                case 3:
                    return new IllnessDiagnosisFragment();
                default:
                    return null;
            }
        }

        @Override
        public int getCount() {
            return mNumOfTabs;
        }
    }

}