package com.duyhq.roomdatabase;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.ViewModelProvider;

import android.os.Bundle;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        PersonViewModel personViewModel =
                new ViewModelProvider(this).get(PersonViewModel.class);

        personViewModel.insert(new Person("An", "Nguyen"));

        personViewModel.getAll().observe(this, newData -> {
            Toast.makeText(this, Integer.toString(newData.size()),
                    Toast.LENGTH_SHORT).show();

            // Use newData ...
        });
    }
}