package com.matsuhiro.dagger2sample.domain;

import javax.inject.Inject;

public class SomeBusinessService {
    @Inject
    public SomeBusinessService() {}

    public String doSomething(String value) {
        return value + ",biz";
    }
}
