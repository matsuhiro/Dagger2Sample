package com.matsuhiro.dagger2sample.domain;

import com.matsuhiro.dagger2sample.data.SettingRepository;

import javax.inject.Inject;

public class UseCase {
    private final SomeBusinessService service;
    private final SettingRepository repository;

    @Inject
    public UseCase(SomeBusinessService service, SettingRepository repository) {
        this.service = service;
        this.repository = repository;
    }

    public String doSomething(String key) {
        String value = this.repository.getValue(key);
        return this.service.doSomething(value);
    }

}
