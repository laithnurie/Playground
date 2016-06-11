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

    @Inject
    SharedPreferences sharedPreferences;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dagger);
        PlaygroundApp.getAppComponent(this).inject(this);
        TextView launchCount = (TextView) findViewById(R.id.txt_launch_count);
        launchCount.setText(Integer.toString(getCurrentLaunchCount()));
    }

    private int getCurrentLaunchCount() {
        return sharedPreferences.getInt(LAUNCH_COUNT_PREF, 0);
    }
}
