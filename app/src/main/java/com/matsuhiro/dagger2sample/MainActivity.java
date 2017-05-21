package com.matsuhiro.dagger2sample;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

import com.matsuhiro.dagger2sample.domain.UseCase;

import javax.inject.Inject;

public class MainActivity extends AppCompatActivity {

    @Inject
    UseCase useCase;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        DaggerAppComponent.create().inject(this);
        DaggerRepositoryComponent.create().inject(this);

        String huga = useCase.doSomething("hoge");
        TextView textView = (TextView) findViewById(R.id.message);
        textView.setText(huga);
    }
}
