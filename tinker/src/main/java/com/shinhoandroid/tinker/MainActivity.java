package com.shinhoandroid.tinker;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.TextView;

import com.tinkerpatch.sdk.TinkerPatch;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        TextView tv = findViewById(R.id.tv);
        //tv.setText("我是BUG");
        //tv.setText("BUG已修复，但是有新的BUG");
        tv.setText("所有BUG已修复，没有BUG");
        //tv.setText("load tinker patch successful !!!");

    }

    public void requestPatch(View v) {
        TinkerPatch.with().fetchPatchUpdate(true);
    }
}
