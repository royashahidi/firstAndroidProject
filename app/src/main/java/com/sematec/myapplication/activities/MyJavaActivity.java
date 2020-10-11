package com.sematec.myapplication.activities;

import android.util.Log;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import com.sematec.myapplication.R;

public class MyJavaActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_my_test_java);
        Log.d("ActivityLifeCycle: ", "onCreate");
    }

    @Override
    protected void onStart() {
        super.onStart();
        Log.d("ActivityLifeCycle: ", "onStart");
    }

    @Override
    protected void onResume() {
        super.onResume();
        Log.d("ActivityLifeCycle: ", "onResume");
    }

    @Override
    protected void onPause() {
        super.onPause();
        Log.d("ActivityLifeCycle: ", "onPause");
    }

    @Override
    protected void onStop() {
        super.onStop();
        Log.d("ActivityLifeCycle: ", "onStop");
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Log.d("ActivityLifeCycle: ", "onDestroy");
    }
}