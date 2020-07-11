package com.example.hanyang;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import butterknife.ButterKnife;

public class BaseActivity extends AppCompatActivity {

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    public void toastSHow(String text) {
        Toast.makeText(this.getApplicationContext(),text,Toast.LENGTH_SHORT).show();
    }

    public void newStartActivity(Class activity) {
        Intent i = new Intent(getApplicationContext(), activity);
        startActivity(i);
    }


}
