package com.laithlab.playground.DaggerExample;


import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;

import com.laithlab.playground.PlaygroundApp;
import com.laithlab.playground.R;

import javax.inject.Inject;

import static com.laithlab.playground.PlaygroundApp.LAUNCH_COUNT_PREF;

public class DaggerMainActivity extends AppCompatActivity {

    /*
    * So there is 2 ways to use the dependency in Dagger
    *  1 - inject the dependency (LINE A) and register the class that is using it(LINE B) or...
    *  2 - get hold of the component and get the dependency, using the component interface(LINE C)
    * */

    //LINE A
    @Inject
    SharedPreferences sharedPreferences;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dagger);
        //LINE B
        PlaygroundApp.getAppComponent(this).inject(this);
        TextView launchCount = (TextView) findViewById(R.id.txt_launch_count);
        launchCount.setText(Integer.toString(getCurrentLaunchCount()));
    }

    private int getCurrentLaunchCount() {
//        LINE C
//        return PlaygroundApp.getAppComponent(this).prefs().getInt(LAUNCH_COUNT_PREF, 0);
        return sharedPreferences.getInt(LAUNCH_COUNT_PREF, 0);
    }
}
