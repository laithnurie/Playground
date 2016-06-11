package com.laithlab.playground.BindingExample;

import android.databinding.DataBindingUtil;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

import com.laithlab.playground.R;
import com.laithlab.playground.databinding.ActivityDbExampleBinding;

public class DBExampleActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        final ActivityDbExampleBinding binding = DataBindingUtil.setContentView(this, R.layout.activity_db_example);
        final Image image = new Image("test","https://pbs.twimg.com/profile_images/638751551457103872/KN-NzuRl.png");
        binding.setImage(image);

        binding.imageFresco.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                binding.setImage(image);
                binding.getImage().setUrl("http://vignette4.wikia.nocookie.net/naruto/images/f/f6/Naruto_as_the_Seventh_Hokage.png");
            }
        });
    }
}