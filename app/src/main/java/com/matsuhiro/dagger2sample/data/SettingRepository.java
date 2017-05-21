package com.matsuhiro.dagger2sample.data;

public interface SettingRepository {
    String getValue(String key);
    void setValue(String key, String value);
}
