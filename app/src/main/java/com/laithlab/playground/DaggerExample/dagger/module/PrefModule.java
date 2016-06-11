package com.laithlab.playground.DaggerExample.dagger.module;

import android.app.Application;
import android.content.Context;
import android.content.SharedPreferences;

import com.laithlab.playground.DaggerExample.PerApp;

import dagger.Module;
import dagger.Provides;

@Module
public class PrefModule {

    @Provides
    @PerApp
    SharedPreferences provideSharedPrefs(Application app) {
        return app.getSharedPreferences("playgroundPref", Context.MODE_PRIVATE);
    }
}
