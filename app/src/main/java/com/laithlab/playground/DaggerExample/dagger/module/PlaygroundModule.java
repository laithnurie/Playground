package com.laithlab.playground.DaggerExample.dagger.module;

import android.app.Application;

import com.laithlab.playground.DaggerExample.PerApp;
import com.laithlab.playground.PlaygroundApp;

import dagger.Module;
import dagger.Provides;

@Module
public class PlaygroundModule {

    private PlaygroundApp app;

    public PlaygroundModule(PlaygroundApp app) {
        this.app = app;
    }

    @Provides
    @PerApp
    PlaygroundApp providePlaygroundApp() {
        return app;
    }

    @Provides
    @PerApp
    Application provideApplication(PlaygroundApp app) {
        return app;
    }
}
