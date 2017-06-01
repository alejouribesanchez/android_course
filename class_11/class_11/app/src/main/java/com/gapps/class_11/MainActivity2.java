package com.gapps.class_11;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v7.app.AppCompatActivity;
import android.view.MenuItem;
import android.widget.TextView;

import com.gapps.class_11.dummy.DummyContent;

public class MainActivity2 extends AppCompatActivity implements Fragment1.OnListFragmentInteractionListener, Fragment2.OnListFragmentInteractionListener, Fragment3.OnListFragmentInteractionListener{


    private BottomNavigationView.OnNavigationItemSelectedListener mOnNavigationItemSelectedListener
            = new BottomNavigationView.OnNavigationItemSelectedListener() {

        @Override
        public boolean onNavigationItemSelected(@NonNull MenuItem item) {
            Fragment fragment = null;
            Class fragmentClass =  null;
            switch (item.getItemId()) {
                case R.id.navigation_home:
                    fragmentClass = Fragment1.class;
                    break;
                case R.id.navigation_dashboard:
                    fragmentClass = Fragment2.class;
                    break;
                case R.id.navigation_notifications:
                    fragmentClass = Fragment3.class;
                    break;
                default:
                    fragmentClass = Fragment1.class;
                    break;
            }

            try {
                fragment = (Fragment) fragmentClass.newInstance();
            } catch (Exception e) {
                e.printStackTrace();
                return false;
            }

            // Insert the fragment by replacing any existing fragment
            FragmentManager fragmentManager = getSupportFragmentManager();
            fragmentManager.beginTransaction().replace(R.id.content, fragment).commit();
            setTitle(item.getTitle());
            return true;
        }

    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        BottomNavigationView navigation = (BottomNavigationView) findViewById(R.id.navigation);
        navigation.setOnNavigationItemSelectedListener(mOnNavigationItemSelectedListener);

        Class fragmentClass =  Fragment1.class;
        Fragment fragment = null;
        try {
            fragment = (Fragment) fragmentClass.newInstance();
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        }

        FragmentManager fragmentManager = getSupportFragmentManager();
        fragmentManager.beginTransaction().replace(R.id.content, fragment).commit();
    }

    @Override
    public void onListFragmentInteraction(DummyContent.DummyItem item) {
        startActivity(new Intent(MainActivity2.this, Main3Activity.class));
    }
}
