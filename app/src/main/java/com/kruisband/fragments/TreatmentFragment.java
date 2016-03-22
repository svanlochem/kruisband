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

public class TreatmentFragment extends Fragment {

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View rootView= inflater.inflate(R.layout.fragment_treatment, container, false);

        TabLayout tabLayout = (TabLayout) rootView.findViewById(R.id.tab_layout_treatment);
        tabLayout.addTab(tabLayout.newTab().setText(getResources().getString(R.string.tab_treatment_home)));
        tabLayout.addTab(tabLayout.newTab().setText(getResources().getString(R.string.tab_treatment_conservative)));
        tabLayout.addTab(tabLayout.newTab().setText(getResources().getString(R.string.tab_treatment_operation_patella)));
        tabLayout.addTab(tabLayout.newTab().setText(getResources().getString(R.string.tab_treatment_operation_hamsting)));

        final ViewPager viewPager = (ViewPager) rootView.findViewById(R.id.viewpager_treatment);

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

        return rootView;
    }

    public class PagerAdapter extends FragmentStatePagerAdapter {
        final int mNumOfTabs;

        public PagerAdapter(FragmentManager fm, int NumOfTabs) {
            super(fm);
            this.mNumOfTabs = NumOfTabs;
        }

        @Override
        public Fragment getItem(int position) {
            switch (position) {
                case 0:
                    return new TreatmentHomeFragment();
                case 1:
                    return new TreatmentConservativeFragment();
                case 2:
                    return new TreatmentPatellaFragment();
                case 3:
                    return new TreatmentHamstringFragment();
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
