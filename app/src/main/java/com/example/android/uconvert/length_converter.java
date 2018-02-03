package com.example.android.uconvert;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.os.Bundle;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.text.Layout;
import android.text.StaticLayout;
import android.text.TextPaint;
import android.util.AttributeSet;
import android.util.TypedValue;
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
public class length_converter extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {     //Saves prior information, otherwise returns NULL
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_length);
        Toolbar myToolbar = (Toolbar) findViewById(R.id.my_toolbar);
        setSupportActionBar(myToolbar);

    }

    //variable declarations
    public double final_result = 0;
    public double value= 0;

    boolean checkedFromFeet = false;
    boolean checkedFromInch = false;
    boolean checkedFromYard = false;
    boolean checkedFromRod = false;
    boolean checkedFromFurlong = false;
    boolean checkedFromMile = false;
    boolean checkedFromFathom = false;
    boolean checkedFromLeague = false;
    boolean checkedFromNauticalMile = false;
    boolean checkedFromHand = false;
    boolean checkedFromCentimeter = false;
    boolean checkedFromMeter = false;
    boolean checkedFromKilometer = false;

    boolean checkedToFeet = false;
    boolean checkedToInch = false;
    boolean checkedToYard = false;
    boolean checkedToRod = false;
    boolean checkedToFurlong = false;
    boolean checkedToMile = false;
    boolean checkedToFathom = false;
    boolean checkedToLeague = false;
    boolean checkedToNauticalMile = false;
    boolean checkedToHand = false;
    boolean checkedToCentimeter = false;
    boolean checkedToMeter = false;
    boolean checkedToKilometer = false;

    public boolean onCreateOptionsMenu(Menu menu) {

        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_inner, menu);
        return super.onCreateOptionsMenu(menu);
    }

    //Actions on toolbar
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

            if (checkedFromFeet == true) {

                if (checkedToInch == true)
                    final_result = value * 12.0;
                else if (checkedToYard == true)
                    final_result = value * 0.33333;
                else if (checkedToRod == true)
                    final_result = value * 0.0606;
                else if (checkedToFurlong == true)
                    final_result = value * 0.0015;
                else if (checkedToMile == true)
                    final_result = value * 0.000189;
                else if (checkedToFathom == true)
                    final_result = value * 0.16666;
                else if (checkedToLeague == true)
                    final_result = value * 0.0000548;
                else if (checkedToNauticalMile == true)
                    final_result = value * 0.0001645;
                else if (checkedToCentimeter == true)
                    final_result = value * 30.48;
                else if (checkedToMeter == true)
                    final_result = value * 0.3048;
                else if (checkedToKilometer == true)
                    final_result = value * 000.3048;
                displayResult(final_result);
            } else if (checkedFromInch == true) {

                if (checkedToFeet == true)
                    final_result = value * 0.083333;
                else if (checkedToYard == true)
                    final_result = value * 0.0277778;
                else if (checkedToRod == true)
                    final_result = value * 0.00505;
                else if (checkedToFurlong == true)
                    final_result = value * 0.000126;
                else if (checkedToMile == true)
                    final_result = value * 0.0000157;
                else if (checkedToFathom == true)
                    final_result = value * 0.0138889;
                else if (checkedToLeague == true)
                    final_result = value * 0.00000457;
                else if (checkedToNauticalMile == true)
                    final_result = value * 0.0000136;
                else if (checkedToCentimeter == true)
                    final_result = value * 2.54;
                else if (checkedToMeter == true)
                    final_result = value * 0.0254;
                else if (checkedToKilometer == true)
                    final_result = value * 0.0000254;
                displayResult(final_result);
            } else if (checkedFromYard == true) {

                if (checkedToFeet == true)
                    final_result = value * 3.0;
                else if (checkedToInch == true)
                    final_result = value * 36.0;
                else if (checkedToRod == true)
                    final_result = value * 0.1818;
                else if (checkedToFurlong == true)
                    final_result = value * 0.004545;
                else if (checkedToMile == true)
                    final_result = value * 0.0005681;
                else if (checkedToFathom == true)
                    final_result = value * 0.5;
                else if (checkedToLeague == true)
                    final_result = value * 0.0001645;
                else if (checkedToNauticalMile == true)
                    final_result = value * 0.0004937;
                else if (checkedToCentimeter == true)
                    final_result = value * 91.44;
                else if (checkedToMeter == true)
                    final_result = value * 0.9144;
                else if (checkedToKilometer == true)
                    final_result = value * 0.0009144;
                displayResult(final_result);
            } else if (checkedFromRod == true) {

                if (checkedToFeet == true)
                    final_result = value * 16.5;
                else if (checkedToInch == true)
                    final_result = value * 198;
                else if (checkedToYard == true)
                    final_result = value * 5.5;
                else if (checkedToFurlong == true)
                    final_result = value * 0.025;
                else if (checkedToMile == true)
                    final_result = value * 0.003125;
                else if (checkedToFathom == true)
                    final_result = value * 2.75;
                else if (checkedToLeague == true)
                    final_result = value * 0.000905;
                else if (checkedToNauticalMile == true)
                    final_result = value * 0.002715;
                else if (checkedToCentimeter == true)
                    final_result = value * 502.92;
                else if (checkedToMeter == true)
                    final_result = value * 5.0292;
                else if (checkedToKilometer == true)
                    final_result = value * 0.0050292;
                displayResult(final_result);
            } else if (checkedFromFurlong == true) {

                if (checkedToFeet == true)
                    final_result = value * 660.001;
                else if (checkedToInch == true)
                    final_result = value * 7920.02;
                else if (checkedToYard == true)
                    final_result = value * 220;
                else if (checkedToRod == true)
                    final_result = value * 40.0001;
                else if (checkedToMile == true)
                    final_result = value * 0.125;
                else if (checkedToFathom == true)
                    final_result = value * 110;
                else if (checkedToLeague == true)
                    final_result = value * 0.0362074;
                else if (checkedToNauticalMile == true)
                    final_result = value * 0.108622;
                else if (checkedToCentimeter == true)
                    final_result = value * 20116.8;
                else if (checkedToMeter == true)
                    final_result = value * 201.168;
                else if (checkedToKilometer == true)
                    final_result = value * 0.201168;
                displayResult(final_result);
            } else if (checkedFromMile == true) {

                if (checkedToFeet == true)
                    final_result = value * 5280;
                else if (checkedToInch == true)
                    final_result = value * 63360;
                else if (checkedToYard == true)
                    final_result = value * 1760;
                else if (checkedToRod == true)
                    final_result = value * 320;
                else if (checkedToFurlong == true)
                    final_result = value * 7.99998;
                else if (checkedToFathom == true)
                    final_result = value * 880;
                else if (checkedToLeague == true)
                    final_result = value * 0.289659;
                else if (checkedToNauticalMile == true)
                    final_result = value * 0.868976;
                else if (checkedToCentimeter == true)
                    final_result = value * 160934;
                else if (checkedToMeter == true)
                    final_result = value * 1609.34;
                else if (checkedToKilometer == true)
                    final_result = value * 1.60934;
                displayResult(final_result);
            } else if (checkedFromFathom == true) {

                if (checkedToFeet == true)
                    final_result = value * 6.0;
                else if (checkedToInch == true)
                    final_result = value * 72.0;
                else if (checkedToYard == true)
                    final_result = value * 22.0;
                else if (checkedToRod == true)
                    final_result = value * 0.363636;
                else if (checkedToFurlong == true)
                    final_result = value * 0.00909;
                else if (checkedToMile == true)
                    final_result = value * 0.00113636;
                else if (checkedToLeague == true)
                    final_result = value * 0.000329158;
                else if (checkedToNauticalMile == true)
                    final_result = value * 0.000987473;
                else if (checkedToCentimeter == true)
                    final_result = value * 182.88;
                else if (checkedToMeter == true)
                    final_result = value * 1.8288;
                else if (checkedToKilometer == true)
                    final_result = value * 0.0018288;
                displayResult(final_result);
            } else if (checkedFromLeague == true) {

                if (checkedToFeet == true)
                    final_result = value * 18228.3;
                else if (checkedToInch == true)
                    final_result = value * 218740;
                else if (checkedToYard == true)
                    final_result = value * 6076.12;
                else if (checkedToRod == true)
                    final_result = value * 1104.75;
                else if (checkedToFurlong == true)
                    final_result = value * 27.6187;
                else if (checkedToMile == true)
                    final_result = value * 3.45234;
                else if (checkedToFathom == true)
                    final_result = value * 3038.06;
                else if (checkedToNauticalMile == true)
                    final_result = value * 3.0;
                else if (checkedToCentimeter == true)
                    final_result = value * 555600;
                else if (checkedToMeter == true)
                    final_result = value * 5556;
                else if (checkedToKilometer == true)
                    final_result = value * 5.556;
                displayResult(final_result);
            } else if (checkedFromNauticalMile == true) {

                if (checkedToFeet == true)
                    final_result = value * 6076.12;
                else if (checkedToInch == true)
                    final_result = value * 72913.4;
                else if (checkedToYard == true)
                    final_result = value * 2025.37;
                else if (checkedToRod == true)
                    final_result = value * 368.249;
                else if (checkedToFurlong == true)
                    final_result = value * 9.20622;
                else if (checkedToMile == true)
                    final_result = value * 1.15078;
                else if (checkedToFathom == true)
                    final_result = value * 1012.69;
                else if (checkedToLeague == true)
                    final_result = value * 0.33333;
                else if (checkedToCentimeter == true)
                    final_result = value * 185200;
                else if (checkedToMeter == true)
                    final_result = value * 1852;
                else if (checkedToKilometer == true)
                    final_result = value * 1.852;
                displayResult(final_result);
            } else if (checkedFromCentimeter == true) {

                if (checkedToFeet == true)
                    final_result = value * 0.0328084;
                else if (checkedToInch == true)
                    final_result = value * 0.393701;
                else if (checkedToYard == true)
                    final_result = value * 0.0109361;
                else if (checkedToRod == true)
                    final_result = value * 0.00198839;
                else if (checkedToFurlong == true)
                    final_result = value * 0.0000497;
                else if (checkedToMile == true)
                    final_result = value * 0.0000062137;
                else if (checkedToFathom == true)
                    final_result = value * 0.00546807;
                else if (checkedToLeague == true)
                    final_result = value * 0.000001799;
                else if (checkedToNauticalMile == true)
                    final_result = value * 0.000005399;
                else if (checkedToMeter == true)
                    final_result = value * 0.01;
                else if (checkedToKilometer == true)
                    final_result = value * 0.00001;
                displayResult(final_result);
            } else if (checkedFromMeter == true) {

                if (checkedToFeet == true)
                    final_result = value * 03.28084;
                else if (checkedToInch == true)
                    final_result = value * 39.3701;
                else if (checkedToYard == true)
                    final_result = value * 1.09361;
                else if (checkedToRod == true)
                    final_result = value * 0.198839;
                else if (checkedToFurlong == true)
                    final_result = value * 0.00497;
                else if (checkedToMile == true)
                    final_result = value * 0.0006213;
                else if (checkedToFathom == true)
                    final_result = value * 0.5468;
                else if (checkedToLeague == true)
                    final_result = value * 0.0001799;
                else if (checkedToNauticalMile == true)
                    final_result = value * 0.0005399;
                else if (checkedToCentimeter == true)
                    final_result = value * 100.0;
                else if (checkedToKilometer == true)
                    final_result = value * 0.001;
                displayResult(final_result);
            } else if (checkedFromKilometer == true) {

                if (checkedToFeet == true)
                    final_result = value * 3280.84;
                else if (checkedToInch == true)
                    final_result = value * 39370.1;
                else if (checkedToYard == true)
                    final_result = value * 1093.61;
                else if (checkedToRod == true)
                    final_result = value * 198.839;
                else if (checkedToFurlong == true)
                    final_result = value * 4.97096;
                else if (checkedToMile == true)
                    final_result = value * 0.621371;
                else if (checkedToFathom == true)
                    final_result = value * 546.807;
                else if (checkedToLeague == true)
                    final_result = value * 0.179986;
                else if (checkedToNauticalMile == true)
                    final_result = value * 0.539957;
                else if (checkedToCentimeter == true)
                    final_result = value * 100000.0;
                else if (checkedToMeter == true)
                    final_result = value * 1000;
                displayResult(final_result);
            } else {
                Context context = getApplicationContext();
                CharSequence text = "Select each FROM & TO";
                int duration = Toast.LENGTH_SHORT;

                Toast toast = Toast.makeText(context, text, duration);
                toast.show();
            }

        }

    //from checkboxes
    public void from_feet(View view) {
        boolean checked = ((RadioButton) view).isChecked();
        checkedFromFeet = checked;
    }

    public void from_inch(View view) {
        boolean checked = ((RadioButton) view).isChecked();
        checkedFromInch = checked;
    }

    public void from_yard(View view) {
        boolean checked = ((RadioButton) view).isChecked();
        checkedFromYard = checked;
    }

    public void from_rod(View view) {
        boolean checked = ((RadioButton) view).isChecked();
        checkedFromRod = checked;
    }

    public void from_furlong(View view) {
        boolean checked = ((RadioButton) view).isChecked();
        checkedFromFurlong = checked;
    }

    public void from_mile(View view) {
        boolean checked = ((RadioButton) view).isChecked();
        checkedFromMile = checked;
    }

    public void from_fathom(View view) {
        boolean checked = ((RadioButton) view).isChecked();
        checkedFromFathom = checked;
    }

    public void from_league(View view) {
        boolean checked = ((RadioButton) view).isChecked();
        checkedFromLeague = checked;
    }

    public void from_nautical_mile(View view) {
        boolean checked = ((RadioButton) view).isChecked();
        checkedFromNauticalMile = checked;
    }

    public void from_hand(View view) {
        boolean checked = ((RadioButton) view).isChecked();
        checkedFromHand = checked;
    }

    public void from_centimeter(View view) {
        boolean checked = ((RadioButton) view).isChecked();
        checkedFromCentimeter = checked;
    }

    public void from_meter(View view) {
        boolean checked = ((RadioButton) view).isChecked();
        checkedFromMeter = checked;
    }

    public void from_kilometer(View view) {
        boolean checked = ((RadioButton) view).isChecked();
        checkedFromKilometer = checked;
    }

    //TO CHECKBOXES
    public void to_feet(View view) {
        boolean checked = ((RadioButton) view).isChecked();
        checkedToFeet = checked;
    }

    public void to_inch(View view) {
        boolean checked = ((RadioButton) view).isChecked();
        checkedToInch = checked;
    }

    public void to_yard(View view) {
        boolean checked = ((RadioButton) view).isChecked();
        checkedToYard = checked;
    }

    public void to_rod(View view) {
        boolean checked = ((RadioButton) view).isChecked();
        checkedToRod = checked;
    }

    public void to_furlong(View view) {
        boolean checked = ((RadioButton) view).isChecked();
        checkedToFurlong = checked;
    }

    public void to_mile(View view) {
        boolean checked = ((RadioButton) view).isChecked();
        checkedToMile = checked;
    }

    public void to_fathom(View view) {
        boolean checked = ((RadioButton) view).isChecked();
        checkedToFathom = checked;
    }

    public void to_league(View view) {
        boolean checked = ((RadioButton) view).isChecked();
        checkedToLeague = checked;
    }

    public void to_nautical_mile(View view) {
        boolean checked = ((RadioButton) view).isChecked();
        checkedToNauticalMile = checked;
    }

    public void to_hand(View view) {
        boolean checked = ((RadioButton) view).isChecked();
        checkedToHand = checked;
    }

    public void to_centimeter(View view) {
        boolean checked = ((RadioButton) view).isChecked();
        checkedToCentimeter = checked;
    }

    public void to_meter(View view) {
        boolean checked = ((RadioButton) view).isChecked();
        checkedToMeter = checked;
    }

    public void to_kilometer(View view) {
        boolean checked = ((RadioButton) view).isChecked();
        checkedToKilometer = checked;
    }

    //RESULT
    public void displayResult(double result) {
        TextView resultTextView = (TextView) findViewById(R.id.result);
        resultTextView.setText(Double.toString(result));
    }

}