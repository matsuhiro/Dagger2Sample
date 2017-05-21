package com.matsuhiro.dagger2sample.module;

import com.matsuhiro.dagger2sample.data.SettingRepository;
import com.matsuhiro.dagger2sample.data.SettingRepositoryImpl;

import dagger.Module;
import dagger.Provides;

@Module
public class RepositoryModule {
    @Provides
    SettingRepository provideSettingRepository() {
        return new SettingRepositoryImpl();
    }
}
