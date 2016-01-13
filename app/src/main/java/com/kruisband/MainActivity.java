package com.kruisband;

import android.os.Bundle;
import android.support.design.widget.NavigationView;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.app.Fragment;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;

import com.kruisband.fragments.FaqFragment;
import com.kruisband.fragments.HomeFragment;
import com.kruisband.fragments.IllnessFragment;
import com.kruisband.fragments.PostTreatmentFragment;
import com.kruisband.fragments.TreatmentFragment;

public class MainActivity extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener, IllnessFragment.OnIllnessFragmentInteractionListener, HomeFragment.OnHomeFragmentInteractionListener,
        TreatmentFragment.OnTreatmentFragmentInteractionListener, PostTreatmentFragment.OnPostTreatmentFragmentInteractionListener ,FaqFragment.OnFaqFragmentInteractionListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        //Action button
//        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
//        fab.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
//                        .setAction("Action", null).show();
//            }
//        });

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.setDrawerListener(toggle);
        toggle.syncState();

        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);

        //Initial page to be shown
        displayView(R.id.nav_home);

        //Display of (justified) text
//        WebView webView = (WebView) findViewById(R.id.webView1);
//        webView.loadData(makeHTMLstring(getString(R.string.introduction)), "text/html", "utf-8");
    }

    @Override
    public void onBackPressed() {
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        //Handle navigation clicks
        displayView(item.getItemId());
        return true;
    }

    public void displayView(int viewId) {
        Fragment fragment = null;
        String title = getString(R.string.app_name);

        switch (viewId) {
            case R.id.nav_home:
                fragment = new HomeFragment();
                title = getString(R.string.nav_home);
                break;
            case R.id.nav_illness:
                fragment = new IllnessFragment();
                title  = getString(R.string.nav_illness);
                break;
            case R.id.nav_treatment:
                fragment = new TreatmentFragment();
                title  = getString(R.string.nav_treatment);
                break;
            case R.id.nav_post_treatment:
                fragment = new PostTreatmentFragment();
                title  = getString(R.string.nav_post_treatment);
                break;
            case R.id.nav_faq:
                fragment = new FaqFragment();
                title  = getString(R.string.nav_faq);
                break;
        }

        if (fragment != null) {
            FragmentTransaction ft = getSupportFragmentManager().beginTransaction();
            ft.replace(R.id.content_frame, fragment);
            ft.commit();
        }

        // set the toolbar title
        if (getSupportActionBar() != null) {
            getSupportActionBar().setTitle(title);
        }

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
    }

    //Interaction with fragments
    public void onIllnessFragmentInteraction(String text) {
        //Interaction possibilities with fragment
    }
    public void onHomeFragmentInteraction(String text) {

    }
    public void onTreatmentFragmentInteraction(String text) {

    }
    public void onPostTreatmentFragmentInteraction(String text) {

    }
    public void onFaqFragmentInteraction(String text) {

    }
}
