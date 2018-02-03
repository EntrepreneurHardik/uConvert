package com.example.android.uconvert;

import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar myToolbar = (Toolbar) findViewById(R.id.my_toolbar_1);
        setSupportActionBar(myToolbar);

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {

        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return super.onCreateOptionsMenu(menu);
    }

    //length is tapped
    public void initialize_length_converter (View view){
        Intent lengthConverterIntent= new Intent(this, length_converter.class);
        startActivity(lengthConverterIntent);

    }

    //weight is tapped
    public void initialize_weight_converter (View view) {
        Intent weightConverterIntent= new Intent(this, weight_converter.class);
        startActivity(weightConverterIntent);
    }

    //time is tapped
    public void initialize_time_converter (View view){
        Intent currencyConverterIntent= new Intent(this, time_converter.class);
        startActivity(currencyConverterIntent);
    }

    //temperature is tapped
    public void initialize_temperature_converter (View view) {
        Intent temperatureConverterIntent= new Intent(this, temperature_converter.class);
        startActivity(temperatureConverterIntent);
    }

    //square measure is tapped
    public void initialize_square_measure_converter (View view){
        Intent squareMeasureConverterIntent= new Intent(this, square_measure_converter.class);
        startActivity(squareMeasureConverterIntent);
    }

    //cubic volume is tapped
    public void initialize_cubic_volume_converter (View view){
        Intent cubicVolumeConverterIntent= new Intent(this, cubic_volume_converter.class);
        startActivity(cubicVolumeConverterIntent);
    }

}
