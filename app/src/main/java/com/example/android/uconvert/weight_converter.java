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
public class weight_converter extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_weight);

        Toolbar myToolbar = (Toolbar) findViewById(R.id.my_toolbar);
        setSupportActionBar(myToolbar);
    }

    //variable declarations
    double final_result = 0;
    double value = 0;

    boolean checkedFromOunce = false;
    boolean checkedFromPound = false;
    boolean checkedFromTon = false;
    boolean checkedFromGram = false;
    boolean checkedFromKilogram = false;

    boolean checkedToOunce = false;
    boolean checkedToPound = false;
    boolean checkedToTon = false;
    boolean checkedToGram = false;
    boolean checkedToKilogram = false;

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

        if (checkedFromOunce == true) {
            if (checkedToPound == true)
                final_result = value * 0.0625;
            else if (checkedToTon == true)
                final_result = value * 0.00003125;
            else if (checkedToGram == true)
                final_result = value * 28.3495;
            else if (checkedToKilogram == true)
                final_result = value * 0.0283495;

        } else if (checkedFromPound == true) {
            if (checkedToOunce == true)
                final_result = value * 16.0;
            else if (checkedToTon == true)
                final_result = value * 0.0005;
            else if (checkedToGram == true)
                final_result = value * 453.592;
            else if (checkedToKilogram == true)
                final_result = value * 0.453592;
        } else if (checkedFromTon == true) {
            if (checkedToOunce == true)
                final_result = value * 32000.0;
            else if (checkedToPound == true)
                final_result = value * 2000.0;
            else if (checkedToGram == true)
                final_result = value * 907185.0;
            else if (checkedToKilogram == true)
                final_result = value * 907.185;
        } else if (checkedFromGram == true) {
            if (checkedToOunce == true)
                final_result = value * 0.035274;
            else if (checkedToPound == true)
                final_result = value * 0.00220462;
            else if (checkedToTon == true)
                final_result = value * 0.00000110;
            else if (checkedToKilogram == true)
                final_result = value * 0.001;

        } else if (checkedFromKilogram == true) {
            if (checkedToOunce == true)
                final_result = value * 35.274;
            else if (checkedToPound == true)
                final_result = value * 2.20462;
            else if (checkedToTon == true)
                final_result = value * 0.00110231;
            else if (checkedToGram == true)
                final_result = value * 1000.0;
        }
        displayResult(final_result);
    }

    //from checkboxes
    public void from_ounce(View view) {
        boolean checked = ((RadioButton) view).isChecked();
        checkedFromOunce = checked;
    }

    public void from_pound(View view) {
        boolean checked = ((RadioButton) view).isChecked();
        checkedFromPound = checked;
    }

    public void from_ton(View view) {
        boolean checked = ((RadioButton) view).isChecked();
        checkedFromTon = checked;
    }

    public void from_gram(View view) {
        boolean checked = ((RadioButton) view).isChecked();
        checkedFromGram = checked;
    }

    public void from_kilogram(View view) {
        boolean checked = ((RadioButton) view).isChecked();
        checkedFromKilogram = checked;
    }

    //to checkboxes
    public void to_ounce(View view) {
        boolean checked = ((RadioButton) view).isChecked();
        checkedToOunce = checked;
    }

    public void to_pound(View view) {
        boolean checked = ((RadioButton) view).isChecked();
        checkedToPound = checked;
    }

    public void to_ton(View view) {
        boolean checked = ((RadioButton) view).isChecked();
        checkedToTon = checked;
    }

    public void to_gram(View view) {
        boolean checked = ((RadioButton) view).isChecked();
        checkedToGram = checked;
    }

    public void to_kilogram(View view) {
        boolean checked = ((RadioButton) view).isChecked();
        checkedToKilogram = checked;
    }

    //RESULT
    public void displayResult(double result) {
        TextView resultTextView = (TextView) findViewById(R.id.result);
        resultTextView.setText(Double.toString(result));
    }


}
