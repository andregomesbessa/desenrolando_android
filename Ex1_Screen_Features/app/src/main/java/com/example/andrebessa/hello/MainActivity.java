package com.example.andrebessa.hello;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.example.andrebessa.utils.Utils;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Utils util = new Utils(getResources().getConfiguration(), getResources().getDisplayMetrics());

        util.printLogDadosTela();
    }
}

