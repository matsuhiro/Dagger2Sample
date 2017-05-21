package com.matsuhiro.dagger2sample.data;

public class SettingRepositoryImpl implements SettingRepository {
    @Override
    public String getValue(String key) {
        return "repo";
    }

    @Override
    public void setValue(String key, String value) {
    }
}
