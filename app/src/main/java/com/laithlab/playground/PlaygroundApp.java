package com.laithlab.playground;

import android.app.Application;
import android.content.Context;
import android.content.SharedPreferences;

import com.facebook.drawee.backends.pipeline.Fresco;
import com.laithlab.playground.DaggerExample.dagger.component.DaggerPlaygroundAppComponent;
import com.laithlab.playground.DaggerExample.dagger.component.PlaygroundAppComponent;
import com.laithlab.playground.DaggerExample.dagger.module.PlaygroundModule;
import com.laithlab.playground.DaggerExample.dagger.module.PrefModule;

import javax.inject.Inject;
import javax.inject.Named;

public class PlaygroundApp extends Application {

    public static String LAUNCH_COUNT_PREF = "launch_count";

    @Inject @Named("secret")
    SharedPreferences sharedPreferences;

    private PlaygroundAppComponent playgroundAppComponent;

    @Override
    public void onCreate() {
        super.onCreate();
        Fresco.initialize(this);
        playgroundAppComponent = DaggerPlaygroundAppComponent.builder()
                .playgroundModule(new PlaygroundModule(this))
                .prefModule(new PrefModule())
                .build();
        playgroundAppComponent.inject(this);
        SharedPreferences.Editor editor = sharedPreferences.edit();
        editor.putInt(LAUNCH_COUNT_PREF, getCurrentLaunchCount() + 1);
        editor.apply();

    }

    public static PlaygroundAppComponent getAppComponent(Context context) {
        return ((PlaygroundApp) context.getApplicationContext()).playgroundAppComponent;
    }

    private int getCurrentLaunchCount() {
        return sharedPreferences.getInt(LAUNCH_COUNT_PREF, 0);
    }
}
