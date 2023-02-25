package com.example.sharedpreferencesactivitylevel;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

public class SecondActivity extends AppCompatActivity {

    private TextView txvName, txvId, txvMajor;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);

        txvName = findViewById(R.id.txvName);
        txvId = findViewById(R.id.txvID);
        txvMajor = findViewById(R.id.txvMajor);
    }

    public void loadData(View view) {
        SharedPreferences sharedPreferences = getSharedPreferences("my_pref_file", Context.MODE_PRIVATE);

        String name = sharedPreferences.getString("name","Name is not available!");
        String major = sharedPreferences.getString("major","Major is not available!");
        String Id = sharedPreferences.getString("Id","Student ID is not available!");

        txvName.setText(name);
        txvMajor.setText(major);
        txvId.setText(Id);
    }

    public void clearData(View view) {
        SharedPreferences sharedPreferences = getSharedPreferences("my_pref_file", Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = sharedPreferences.edit();
        editor.clear();
        editor.apply();
    }

    public void removeStudentMajor(View view) {
        SharedPreferences sharedPreferences = getSharedPreferences("my_pref_file", Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = sharedPreferences.edit();
        editor.remove("major");
        editor.apply();
    }
}
