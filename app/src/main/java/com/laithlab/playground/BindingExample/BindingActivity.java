package com.laithlab.playground.BindingExample;

import android.databinding.DataBindingUtil;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

import com.facebook.drawee.backends.pipeline.Fresco;
import com.laithlab.playground.R;
import com.laithlab.playground.databinding.ActivityMainBinding;

public class BindingActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Fresco.initialize(this);
        ActivityMainBinding binding = DataBindingUtil.setContentView(this, R.layout.activity_main);
        final Image image = new Image("test","https://pbs.twimg.com/profile_images/638751551457103872/KN-NzuRl.png");
        binding.setImage(image);

        binding.imageFresco.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                image.setTitle("pressed");
            }
        });
    }
}