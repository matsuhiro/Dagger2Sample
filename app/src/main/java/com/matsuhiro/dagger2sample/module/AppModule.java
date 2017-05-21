package com.matsuhiro.dagger2sample.module;

import com.google.gson.Gson;

import dagger.Module;
import dagger.Provides;

@Module
public class AppModule {
    @Provides
    Gson provideGson() {
        return new Gson();
    }
}
