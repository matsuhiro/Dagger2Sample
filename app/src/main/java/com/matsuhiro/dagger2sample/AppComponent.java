package com.matsuhiro.dagger2sample;

import com.matsuhiro.dagger2sample.module.AppModule;

import dagger.Component;

@Component(modules = {AppModule.class})
public interface AppComponent {
    void inject(MainActivity mainActivity);
}

