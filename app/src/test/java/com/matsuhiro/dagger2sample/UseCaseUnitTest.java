package com.matsuhiro.dagger2sample;

import com.matsuhiro.dagger2sample.data.SettingRepository;
import com.matsuhiro.dagger2sample.domain.SomeBusinessService;
import com.matsuhiro.dagger2sample.domain.UseCase;
import com.matsuhiro.dagger2sample.module.RepositoryModule;
import com.matsuhiro.dagger2sample.module.RepositoryModule_ProvideSettingRepositoryFactory;

import org.junit.Test;
import org.mockito.Mockito;

import static org.junit.Assert.*;

/**
 * Example local unit test, which will execute on the development machine (host).
 *
 * @see <a href="http://d.android.com/tools/testing">Testing documentation</a>
 */
public class UseCaseUnitTest {

    final class MockedSettingRepositoryImpl implements SettingRepository {
        @Override
        public String getValue(String key) {
            return "mockrepo";
        }

        @Override
        public void setValue(String key, String value) {}
    }

    @Test
    public void MockedRepository() throws Exception {
        UseCase useCase = new UseCase(new SomeBusinessService(), new MockedSettingRepositoryImpl());
        String message = useCase.doSomething("hoge");

        assertEquals(message, "mockrepo,biz");
    }

    @Test
    public void MockedService() throws Exception {
        SomeBusinessService mockedSomeBusinessService = Mockito.mock(SomeBusinessService.class);
        Mockito.when(mockedSomeBusinessService.doSomething(Mockito.any(String.class))).thenReturn("mockbiz");

        UseCase useCase = new UseCase(mockedSomeBusinessService, RepositoryModule_ProvideSettingRepositoryFactory.create(new RepositoryModule()).get());
        String message = useCase.doSomething("hoge");

        assertEquals(message, "mockbiz");
    }

    @Test
    public void MockedInput() throws Exception {
        SomeBusinessService mockedSomeBusinessService = Mockito.mock(SomeBusinessService.class);
        Mockito.when(mockedSomeBusinessService.doSomething(Mockito.any(String.class))).thenReturn("mockbiz");

        UseCase useCase = new UseCase(mockedSomeBusinessService, new MockedSettingRepositoryImpl());
        String message = useCase.doSomething("hoge");

        assertEquals(message, "mockbiz");
    }

    @Test
    public void MockedInput2() throws Exception {
        SomeBusinessService mockedSomeBusinessService = Mockito.mock(SomeBusinessService.class);
        Mockito.when(mockedSomeBusinessService.doSomething(Mockito.any(String.class))).thenReturn("mockbiz");

        SettingRepository mockedSettingRepository = Mockito.mock(SettingRepository.class);
        Mockito.when(mockedSettingRepository.getValue(Mockito.any(String.class))).thenReturn("mockrepo");

        UseCase useCase = new UseCase(mockedSomeBusinessService, mockedSettingRepository);
        String message = useCase.doSomething("hoge");

        assertEquals(message, "mockbiz");
    }
}