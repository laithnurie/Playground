package com.laithlab.playground.DaggerExample.dagger.module;

import android.app.Application;
import android.content.Context;
import android.content.SharedPreferences;
import android.preference.PreferenceManager;

import com.laithlab.playground.DaggerExample.PerApp;

import javax.inject.Named;

import dagger.Module;
import dagger.Provides;

@Module
public class PrefModule {

    @Provides
    @PerApp
    @Named("default")
    SharedPreferences provideDefaultSharedPrefs(Application app) {
        return PreferenceManager.getDefaultSharedPreferences(app);
    }

    @Provides
    @PerApp
    @Named("secret")
    SharedPreferences provideSecretSharedPrefs(Application app) {
        return app.getSharedPreferences("playgroundPref", Context.MODE_PRIVATE);
    }
}
