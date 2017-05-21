package com.matsuhiro.dagger2sample;

import com.matsuhiro.dagger2sample.module.AppModule;
import com.matsuhiro.dagger2sample.module.RepositoryModule;

import dagger.Component;

@Component(modules = {AppModule.class, RepositoryModule.class})
public interface ActivityComponent {
    void inject(MainActivity mainActivity);
}

