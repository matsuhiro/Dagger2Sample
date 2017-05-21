package com.matsuhiro.dagger2sample;

import com.matsuhiro.dagger2sample.module.RepositoryModule;

import dagger.Component;

@Component(modules = {RepositoryModule.class})
public interface RepositoryComponent {
    void inject(MainActivity mainActivity);
}

