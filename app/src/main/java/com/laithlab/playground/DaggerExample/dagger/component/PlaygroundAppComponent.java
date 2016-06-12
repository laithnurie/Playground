package com.laithlab.playground.DaggerExample.dagger.component;

import android.app.Application;
import android.content.SharedPreferences;

import com.laithlab.playground.DaggerExample.DaggerMainActivity;
import com.laithlab.playground.DaggerExample.PerApp;
import com.laithlab.playground.DaggerExample.dagger.module.PlaygroundModule;
import com.laithlab.playground.DaggerExample.dagger.module.PrefModule;
import com.laithlab.playground.PlaygroundApp;

import javax.inject.Named;

import dagger.Component;

@PerApp
@Component(
        modules = {
                PlaygroundModule.class,
                PrefModule.class
        }
)
public interface PlaygroundAppComponent {
    void inject(PlaygroundApp playgroundApp);
    void inject(DaggerMainActivity activity);
    Application app();

    @Named("default")
    SharedPreferences defaultPrefs();

    @Named("secret")
    SharedPreferences secretPrefs();
}
