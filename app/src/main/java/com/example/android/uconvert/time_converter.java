package com.example.android.uconvert;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.RadioButton;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * Created by HARDIK SHARMA on 5/17/2016.
 */
public class time_converter extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_time);
        Toolbar myToolbar = (Toolbar) findViewById(R.id.my_toolbar);
        setSupportActionBar(myToolbar);
    }

    //variable declarations
    double final_result = 0;
    double value = 0;

    boolean checkedFromFemtosecond = false;
    boolean checkedFromPicosecond = false;
    boolean checkedFromNanosecond = false;
    boolean checkedFromMicrosecond = false;
    boolean checkedFromMillisecond = false;
    boolean checkedFromSecond = false;
    boolean checkedFromMinute = false;
    boolean checkedFromHour = false;
    boolean checkedFromDay = false;
    boolean checkedFromWeek = false;

    boolean checkedToFemtosecond = false;
    boolean checkedToPicosecond = false;
    boolean checkedToNanosecond = false;
    boolean checkedToMicrosecond = false;
    boolean checkedToMillisecond = false;
    boolean checkedToSecond = false;
    boolean checkedToMinute = false;
    boolean checkedToHour = false;
    boolean checkedToDay = false;
    boolean checkedToWeek = false;

    public boolean onCreateOptionsMenu(Menu menu) {

        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_inner, menu);
        return super.onCreateOptionsMenu(menu);

    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.calculator:
                ArrayList<HashMap<String,Object>> items =new ArrayList<HashMap<String,Object>>();
                final PackageManager pm;
                pm = getPackageManager();
                List<PackageInfo> packs = pm.getInstalledPackages(0);
                for (PackageInfo pi : packs) {
                    if( pi.packageName.toString().toLowerCase().contains("calcul")){
                        HashMap<String, Object> map = new HashMap<String, Object>();
                        map.put("appName", pi.applicationInfo.loadLabel(pm));
                        map.put("packageName", pi.packageName);
                        items.add(map);
                    }
                }
                if(items.size()>=1){
                    String packageName = (String) items.get(0).get("packageName");
                    Intent i = pm.getLaunchIntentForPackage(packageName);
                    if (i != null)
                        startActivity(i);
                }
                else{
                    Context context = getApplicationContext();
                    CharSequence text = "No calculator on this device";
                    int duration = Toast.LENGTH_SHORT;

                    Toast toast = Toast.makeText(context, text, duration);
                    toast.show();

                }
                return true;

            case R.id.share:
                // User chose the "Favorite" action, mark the current item
                // as a favorite...
                Intent intent = new Intent(Intent.ACTION_SEND);
                intent.setType("*/*");
                intent.putExtra(Intent.EXTRA_SUBJECT, "Conversion from KONVERT app\n" + final_result);
                if (intent.resolveActivity(getPackageManager()) != null) {
                    startActivity(intent);
                }
                return true;

            default:
                // If we got here, the user's action was not recognized.
                // Invoke the superclass to handle it.
                return super.onOptionsItemSelected(item);

        }
    }

    //convert button
    public void convert(View view) {

        EditText valueField = (EditText) findViewById(R.id.value_field);
        value = Double.parseDouble(valueField.getText().toString());

        if (checkedFromFemtosecond == true) {
            if (checkedToPicosecond == true)
                final_result = value * 0.001;
            else if (checkedToNanosecond == true)
                final_result = value * 1e-6;
            else if (checkedToMicrosecond == true)
                final_result = value * 1e-9;
            else if (checkedToMillisecond == true)
                final_result = value * 1e-12;
            else if (checkedToSecond == true)
                final_result = value * 1e-15;
            else if (checkedToMinute == true)
                final_result = value * 1.66667e-17;
            else if (checkedToHour == true)
                final_result = value * 2.77778e-19 ;
            else if (checkedToDay == true)
                final_result = value * 1.15741e-20;
            else if (checkedToWeek == true)
                final_result = value * 1.65344e-21;

        } else if (checkedFromPicosecond == true) {
            if (checkedToFemtosecond == true)
                final_result = value * 1000;
            else if (checkedToNanosecond == true)
                final_result = value * 0.001;
            else if (checkedToMicrosecond == true)
                final_result = value * 1e-6;
            else if (checkedToMillisecond == true)
                final_result = value * 1e-9;
            else if (checkedToSecond == true)
                final_result = value * 1e-12;
            else if (checkedToMinute == true)
                final_result = value * 1.66667e-14;
            else if (checkedToHour == true)
                final_result = value * 2.77778e-16;
            else if (checkedToDay == true)
                final_result = value * 1.15741e-17;
            else if (checkedToWeek == true)
                final_result = value * 1.65344e-18;

        } else if (checkedFromNanosecond == true) {
            if (checkedToFemtosecond == true)
                final_result = value * 1000000;
            else if (checkedToPicosecond == true)
                final_result = value * 1000;
            else if (checkedToMicrosecond == true)
                final_result = value * 0.001;
            else if (checkedToMillisecond == true)
                final_result = value * 1e-6;
            else if (checkedToSecond == true)
                final_result = value * 1e-9;
            else if (checkedToMinute == true)
                final_result = value * 1.66667e-11;
            else if (checkedToHour == true)
                final_result = value * 2.77778e-13;
            else if (checkedToDay == true)
                final_result = value * 1.15741e-14;
            else if (checkedToWeek == true)
                final_result = value * 1.65344e-15;

        } else if (checkedFromMicrosecond == true) {
            if (checkedToFemtosecond == true)
                final_result = value * 1e+9;
            else if (checkedToPicosecond == true)
                final_result = value * 1000000;
            else if (checkedToNanosecond == true)
                final_result = value * 1000;
            else if (checkedToMillisecond == true)
                final_result = value * 0.001;
            else if (checkedToSecond == true)
                final_result = value * 1e-6;
            else if (checkedToMinute == true)
                final_result = value * 1.66667e-8;
            else if (checkedToHour == true)
                final_result = value * 2.77778e-10;
            else if (checkedToDay == true)
                final_result = value * 1.15741e-11;
            else if (checkedToWeek == true)
                final_result = value * 1.65344e-12;

        } else if (checkedFromMillisecond == true) {
            if (checkedToFemtosecond == true)
                final_result = value * 1e+12;
            else if (checkedToPicosecond == true)
                final_result = value * 1e+9;
            else if (checkedToNanosecond == true)
                final_result = value * 1000000;
            else if (checkedToMicrosecond == true)
                final_result = value * 1000;
            else if (checkedToSecond == true)
                final_result = value * 0.001;
            else if (checkedToMinute == true)
                final_result = value * 1.66667e-5;
            else if (checkedToHour == true)
                final_result = value * 2.77778e-7;
            else if (checkedToDay == true)
                final_result = value * 1.15741e-8;
            else if (checkedToWeek == true)
                final_result = value * 1.65344e-9;

        } else if (checkedFromSecond == true) {
            if (checkedToFemtosecond == true)
                final_result = value * 1e+15;
            else if (checkedToPicosecond == true)
                final_result = value * 1e+12;
            else if (checkedToNanosecond == true)
                final_result = value * 1e+9;
            else if (checkedToMicrosecond == true)
                final_result = value * 1000000;
            else if (checkedToMillisecond == true)
                final_result = value * 1000;
            else if (checkedToMinute == true)
                final_result = value * 0.0166667;
            else if (checkedToHour == true)
                final_result = value * 0.000277778;
            else if (checkedToDay == true)
                final_result = value * 1.15741e-5;
            else if (checkedToWeek == true)
                final_result = value * 1.65344e-6;

        } else if (checkedFromMinute == true) {
            if (checkedToFemtosecond == true)
                final_result = value * 6e+16;
            else if (checkedToPicosecond == true)
                final_result = value * 6e+13;
            else if (checkedToNanosecond == true)
                final_result = value * 6e+10;
            else if (checkedToMicrosecond == true)
                final_result = value * 6e+7;
            else if (checkedToMillisecond == true)
                final_result = value * 60000;
            else if (checkedToSecond == true)
                final_result = value * 60;
            else if (checkedToHour == true)
                final_result = value * 0.0166667;
            else if (checkedToDay == true)
                final_result = value * 0.000694444;
            else if (checkedToWeek == true)
                final_result = value * 9.92063e-5;

        } else if (checkedFromHour == true) {
            if (checkedToFemtosecond == true)
                final_result = value * 3.6e+18;
            else if (checkedToPicosecond == true)
                final_result = value * 3.6e+15;
            else if (checkedToNanosecond == true)
                final_result = value * 3.6e+12;
            else if (checkedToMicrosecond == true)
                final_result = value * 3.6e+9;
            else if (checkedToMillisecond == true)
                final_result = value * 3.6e+6;
            else if (checkedToSecond == true)
                final_result = value * 3600;
            else if (checkedToMinute == true)
                final_result = value * 60;
            else if (checkedToDay == true)
                final_result = value * 0.0416667;
            else if (checkedToWeek == true)
                final_result = value * 0.00595238;

        } else if (checkedFromDay == true) {
            if (checkedToFemtosecond == true)
                final_result = value * 8.64e+19;
            else if (checkedToPicosecond == true)
                final_result = value * 8.64e+16;
            else if (checkedToNanosecond == true)
                final_result = value * 8.64e+13;
            else if (checkedToMicrosecond == true)
                final_result = value * 8.64e+10;
            else if (checkedToMillisecond == true)
                final_result = value * 8.64e+7;
            else if (checkedToSecond == true)
                final_result = value * 86400;
            else if (checkedToMinute == true)
                final_result = value * 1440;
            else if (checkedToHour == true)
                final_result = value * 24;
            else if (checkedToWeek == true)
                final_result = value * 0.142857;

        } else if (checkedFromWeek == true) {
            if (checkedToFemtosecond == true)
                final_result = value * 6.048e+20;
            else if (checkedToPicosecond == true)
                final_result = value * 6.048e+17;
            else if (checkedToNanosecond == true)
                final_result = value * 6.048e+14;
            else if (checkedToMicrosecond == true)
                final_result = value * 6.048e+11 ;
            else if (checkedToMillisecond == true)
                final_result = value * 6.048e+8;
            else if (checkedToSecond == true)
                final_result = value * 604800;
            else if (checkedToMinute == true)
                final_result = value * 10080;
            else if (checkedToHour == true)
                final_result = value * 168;
            else if (checkedToDay == true)
                final_result = value * 7;

        }
        displayResult(final_result);
    }
    //from checkboxes
    public void from_femtosecond (View view) {
        boolean checked = ((RadioButton) view).isChecked();
        checkedFromFemtosecond = checked;
    }

    public void from_picosecond (View view) {
        boolean checked = ((RadioButton) view).isChecked();
        checkedFromPicosecond = checked;
    }

    public void from_nanosecond (View view) {
        boolean checked = ((RadioButton) view).isChecked();
        checkedFromNanosecond = checked;
    }

    public void from_microsecond (View view) {
        boolean checked = ((RadioButton) view).isChecked();
        checkedFromMicrosecond = checked;
    }

    public void from_millisecond (View view) {
        boolean checked = ((RadioButton) view).isChecked();
        checkedFromMillisecond = checked;
    }

    public void from_second (View view) {
        boolean checked = ((RadioButton) view).isChecked();
        checkedFromSecond = checked;
    }

    public void from_minute (View view) {
        boolean checked = ((RadioButton) view).isChecked();
        checkedFromMinute = checked;
    }

    public void from_hour (View view) {
        boolean checked = ((RadioButton) view).isChecked();
        checkedFromHour = checked;
    }

    public void from_day (View view) {
        boolean checked = ((RadioButton) view).isChecked();
        checkedFromDay = checked;
    }

    public void from_week (View view) {
        boolean checked = ((RadioButton) view).isChecked();
        checkedFromWeek = checked;
    }


    //TO CHECKBOXES
    public void to_femtosecond (View view) {
        boolean checked = ((RadioButton) view).isChecked();
        checkedToFemtosecond = checked;
    }

    public void to_picosecond (View view) {
        boolean checked = ((RadioButton) view).isChecked();
        checkedToPicosecond = checked;
    }

    public void to_nanosecond (View view) {
        boolean checked = ((RadioButton) view).isChecked();
        checkedToNanosecond = checked;
    }

    public void to_microsecond (View view) {
        boolean checked = ((RadioButton) view).isChecked();
        checkedToMicrosecond = checked;
    }

    public void to_millisecond (View view) {
        boolean checked = ((RadioButton) view).isChecked();
        checkedToMillisecond = checked;
    }

    public void to_second (View view) {
        boolean checked = ((RadioButton) view).isChecked();
        checkedToSecond = checked;
    }

    public void to_minute (View view) {
        boolean checked = ((RadioButton) view).isChecked();
        checkedToMinute = checked;
    }

    public void to_hour (View view) {
        boolean checked = ((RadioButton) view).isChecked();
        checkedToHour = checked;
    }

    public void to_day (View view) {
        boolean checked = ((RadioButton) view).isChecked();
        checkedToDay = checked;
    }

    public void to_week (View view) {
        boolean checked = ((RadioButton) view).isChecked();
        checkedToWeek = checked;
    }

    //RESULT
    public void displayResult(double result) {
        TextView resultTextView = (TextView) findViewById(R.id.result);
        resultTextView.setText(Double.toString(result));
    }



}
