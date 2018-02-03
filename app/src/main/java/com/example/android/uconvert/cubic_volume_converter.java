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

public class cubic_volume_converter extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_cubic_volume);
        Toolbar myToolbar = (Toolbar) findViewById(R.id.my_toolbar);
        setSupportActionBar(myToolbar);
    }

    //variable declarations
    double final_result = 0;
    double value = 0;

    boolean checkedFromCubicFeet = false;
    boolean checkedFromCubicInch = false;
    boolean checkedFromCubicYard = false;
    boolean checkedFromCord = false;
    boolean checkedFromCubicCentimeter = false;
    boolean checkedFromCubicMeter = false;
    boolean checkedFromQuart = false;
    boolean checkedFromPint = false;
    boolean checkedFromPeck = false;
    boolean checkedFromBushel = false;
    boolean checkedFromLitre = false;
    boolean checkedFromCup = false;
    boolean checkedFromGallon = false;

    boolean checkedToCubicFeet = false;
    boolean checkedToCubicInch = false;
    boolean checkedToCubicYard = false;
    boolean checkedToCord = false;
    boolean checkedToCubicCentimeter = false;
    boolean checkedToCubicMeter = false;
    boolean checkedToQuart = false;
    boolean checkedToPint = false;
    boolean checkedToPeck = false;
    boolean checkedToBushel = false;
    boolean checkedToLitre = false;
    boolean checkedToCup = false;
    boolean checkedToGallon = false;

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

        if (checkedFromCubicFeet == true) {
            if (checkedToCubicInch == true)
                final_result = value * 1728;
            else if (checkedToCubicYard == true)
                final_result = value * 0.037037;
            else if (checkedToCord == true)
                final_result = value * 0.0078125;
            else if (checkedToCubicCentimeter == true)
                final_result = value * 28316.8;
            else if (checkedToCubicMeter == true)
                final_result = value * 0.0283168;
            else if (checkedToQuart == true)
                final_result = value * 29.9221;
            else if (checkedToPint == true)
                final_result = value * 59.8442;
            else if (checkedToPeck == true)
                final_result = value * 3.21426;
            else if (checkedToBushel == true)
                final_result = value * 0.803564;
            else if (checkedToLitre == true)
                final_result = value * 28.3168;
            else if (checkedToCup == true)
                final_result = value * 119.688;
            else if (checkedToGallon == true)
                final_result = value * 7.48052;
        } else if (checkedFromCubicInch == true) {
            if (checkedToCubicFeet == true)
                final_result = value * 0.000578704;
            else if (checkedToCubicYard == true)
                final_result = value * 0.0000214335;
            else if (checkedToCord == true)
                final_result = value * 0.00000452112;
            else if (checkedToCubicCentimeter == true)
                final_result = value * 16.3871;
            else if (checkedToCubicMeter == true)
                final_result = value * 0.0000163871;
            else if (checkedToQuart == true)
                final_result = value * 0.017316;
            else if (checkedToPint == true)
                final_result = value * 0.034632;
            else if (checkedToPeck == true)
                final_result = value * 0.0018601;
            else if (checkedToBushel == true)
                final_result = value * 0.000465025;
            else if (checkedToLitre == true)
                final_result = value * 0.0163871;
            else if (checkedToCup == true)
                final_result = value * 0.0692641;
            else if (checkedToGallon == true)
                final_result = value * 0.004329;
        } else if (checkedFromCubicYard == true) {
            if (checkedToCubicInch == true)
                final_result = value * 46656;
            else if (checkedToCubicFeet == true)
                final_result = value * 27;
            else if (checkedToCord == true)
                final_result = value * 0.210937;
            else if (checkedToCubicCentimeter == true)
                final_result = value * 764555;
            else if (checkedToCubicMeter == true)
                final_result = value * 0.764555;
            else if (checkedToQuart == true)
                final_result = value * 807.896;
            else if (checkedToPint == true)
                final_result = value * 1615.79;
            else if (checkedToPeck == true)
                final_result = value * 86.7849;
            else if (checkedToBushel == true)
                final_result = value * 21.6962;
            else if (checkedToLitre == true)
                final_result = value * 764.555;
            else if (checkedToCup == true)
                final_result = value * 3231.58;
            else if (checkedToGallon == true)
                final_result = value * 201.974;
        } else if (checkedFromCord == true) {
            if (checkedToCubicInch == true)
                final_result = value * 221184;
            else if (checkedToCubicYard == true)
                final_result = value * 4.74074;
            else if (checkedToCubicFeet == true)
                final_result = value * 128;
            else if (checkedToCubicCentimeter == true)
                final_result = value * 3625000;
            else if (checkedToCubicMeter == true)
                final_result = value * 3.62456;
            else if (checkedToQuart == true)
                final_result = value * 3830.03;
            else if (checkedToPint == true)
                final_result = value * 7660.05;
            else if (checkedToPeck == true)
                final_result = value * 411.425;
            else if (checkedToBushel == true)
                final_result = value * 102.856;
            else if (checkedToLitre == true)
                final_result = value * 3624.56;
            else if (checkedToCup == true)
                final_result = value * 15320.1;
            else if (checkedToGallon == true)
                final_result = value * 957.507;
        } else if (checkedFromCubicCentimeter == true) {
            if (checkedToCubicInch == true)
                final_result = value * 0.0610237;
            else if (checkedToCubicYard == true)
                final_result = value * 0.00000130795;
            else if (checkedToCord == true)
                final_result = value * 0.000000275896;
            else if (checkedToCubicFeet == true)
                final_result = value * 0.0000353147;
            else if (checkedToCubicMeter == true)
                final_result = value * 0.000001;
            else if (checkedToQuart == true)
                final_result = value * 0.00105669;
            else if (checkedToPint == true)
                final_result = value * 0.00211338;
            else if (checkedToPeck == true)
                final_result = value * 0.00011351;
            else if (checkedToBushel == true)
                final_result = value * 0.0000283776;
            else if (checkedToLitre == true)
                final_result = value * 0.001;
            else if (checkedToCup == true)
                final_result = value * 0.00422675;
            else if (checkedToGallon == true)
                final_result = value * 0.000264172;
        } else if (checkedFromCubicMeter == true) {
            if (checkedToCubicInch == true)
                final_result = value * 61023.7;
            else if (checkedToCubicYard == true)
                final_result = value * 1.30795;
            else if (checkedToCord == true)
                final_result = value * 0.275896;
            else if (checkedToCubicCentimeter == true)
                final_result = value * 1000000;
            else if (checkedToCubicFeet == true)
                final_result = value * 35.3147;
            else if (checkedToQuart == true)
                final_result = value * 1056.69;
            else if (checkedToPint == true)
                final_result = value * 2113.38;
            else if (checkedToPeck == true)
                final_result = value * 113.51;
            else if (checkedToBushel == true)
                final_result = value * 28.3776;
            else if (checkedToLitre == true)
                final_result = value * 1000;
            else if (checkedToCup == true)
                final_result = value * 4226.75;
            else if (checkedToGallon == true)
                final_result = value * 264.172;
        } else if (checkedFromQuart == true) {
            if (checkedToCubicInch == true)
                final_result = value * 57.75;
            else if (checkedToCubicYard == true)
                final_result = value * 0.00123778;
            else if (checkedToCord == true)
                final_result = value * 0.000261095;
            else if (checkedToCubicCentimeter == true)
                final_result = value * 946.353;
            else if (checkedToCubicMeter == true)
                final_result = value * 0.000946353;
            else if (checkedToCubicFeet == true)
                final_result = value * 0.0334201;
            else if (checkedToPint == true)
                final_result = value * 2;
            else if (checkedToPeck == true)
                final_result = value * 0.107421;
            else if (checkedToBushel == true)
                final_result = value * 0.0268552;
            else if (checkedToLitre == true)
                final_result = value * 0.946353;
            else if (checkedToCup == true)
                final_result = value * 4;
            else if (checkedToGallon == true)
                final_result = value * 0.25;
        } else if (checkedFromPint == true) {
            if (checkedToCubicInch == true)
                final_result = value * 28.875;
            else if (checkedToCubicYard == true)
                final_result = value * 0.000618891;
            else if (checkedToCord == true)
                final_result = value * 0.000130547;
            else if (checkedToCubicCentimeter == true)
                final_result = value * 473.176;
            else if (checkedToCubicMeter == true)
                final_result = value * 0.000473176;
            else if (checkedToQuart == true)
                final_result = value * 0.5;
            else if (checkedToCubicFeet == true)
                final_result = value * 0.0167101;
            else if (checkedToPeck == true)
                final_result = value * 0.0537104;
            else if (checkedToBushel == true)
                final_result = value * 0.0134276;
            else if (checkedToLitre == true)
                final_result = value * 0.473176;
            else if (checkedToCup == true)
                final_result = value * 2;
            else if (checkedToGallon == true)
                final_result = value * 0.124999;
        } else if (checkedFromPeck == true) {
            if (checkedToCubicInch == true)
                final_result = value * 537.605;
            else if (checkedToCubicYard == true)
                final_result = value * 0.0115227;
            else if (checkedToCord == true)
                final_result = value * 0.00243058;
            else if (checkedToCubicCentimeter == true)
                final_result = value * 8809.77;
            else if (checkedToCubicMeter == true)
                final_result = value * 0.00880977;
            else if (checkedToQuart == true)
                final_result = value * 9.30918;
            else if (checkedToPint == true)
                final_result = value * 18.6184;
            else if (checkedToCubicFeet == true)
                final_result = value * 0.311114;
            else if (checkedToBushel == true)
                final_result = value * 0.25;
            else if (checkedToLitre == true)
                final_result = value * 8.80977;
            else if (checkedToCup == true)
                final_result = value * 37.2367;
            else if (checkedToGallon == true)
                final_result = value * 2.32729;
        } else if (checkedFromBushel == true) {
            if (checkedToCubicInch == true)
                final_result = value * 2150.42;
            else if (checkedToCubicYard == true)
                final_result = value * 0.046091;
            else if (checkedToCord == true)
                final_result = value * 0.00972231;
            else if (checkedToCubicCentimeter == true)
                final_result = value * 35239.1;
            else if (checkedToCubicMeter == true)
                final_result = value * 0.0352391;
            else if (checkedToQuart == true)
                final_result = value * 37.2367;
            else if (checkedToPint == true)
                final_result = value * 74.4734;
            else if (checkedToPeck == true)
                final_result = value * 4;
            else if (checkedToCubicFeet == true)
                final_result = value * 1.24446;
            else if (checkedToLitre == true)
                final_result = value * 35.2391;
            else if (checkedToCup == true)
                final_result = value * 148.947;
            else if (checkedToGallon == true)
                final_result = value * 9.30918;
        } else if (checkedFromLitre == true) {
            if (checkedToCubicInch == true)
                final_result = value * 61.0237;
            else if (checkedToCubicYard == true)
                final_result = value * 0.00130795;
            else if (checkedToCord == true)
                final_result = value * 0.000275896;
            else if (checkedToCubicCentimeter == true)
                final_result = value * 1000;
            else if (checkedToCubicMeter == true)
                final_result = value * 0.001;
            else if (checkedToQuart == true)
                final_result = value * 1.05669;
            else if (checkedToPint == true)
                final_result = value * 2.11338;
            else if (checkedToPeck == true)
                final_result = value * 0.11351;
            else if (checkedToBushel == true)
                final_result = value * 0.0283776;
            else if (checkedToCubicFeet == true)
                final_result = value * 0.0353147;
            else if (checkedToCup == true)
                final_result = value * 4.22675;
            else if (checkedToGallon == true)
                final_result = value * 0.264172;
        } else if (checkedFromCup == true) {
            if (checkedToCubicInch == true)
                final_result = value * 14.4375;
            else if (checkedToCubicYard == true)
                final_result = value * 0.000309446;
            else if (checkedToCord == true)
                final_result = value * 0.0000652737;
            else if (checkedToCubicCentimeter == true)
                final_result = value * 236.588;
            else if (checkedToCubicMeter == true)
                final_result = value * 0.000236588;
            else if (checkedToQuart == true)
                final_result = value * 0.25;
            else if (checkedToPint == true)
                final_result = value * 0.5;
            else if (checkedToPeck == true)
                final_result = value * 0.0268552;
            else if (checkedToBushel == true)
                final_result = value * 0.0067138;
            else if (checkedToLitre == true)
                final_result = value * 0.236588;
            else if (checkedToCubicFeet == true)
                final_result = value * 0.00835503;
            else if (checkedToGallon == true)
                final_result = value * 0.0625;
        } else if (checkedFromGallon == true) {
            if (checkedToCubicInch == true)
                final_result = value * 231;
            else if (checkedToCubicYard == true)
                final_result = value * 0.00495113;
            else if (checkedToCord == true)
                final_result = value * 0.00104438;
            else if (checkedToCubicCentimeter == true)
                final_result = value * 3785.41;
            else if (checkedToCubicMeter == true)
                final_result = value * 0.00378541;
            else if (checkedToQuart == true)
                final_result = value * 4;
            else if (checkedToPint == true)
                final_result = value * 8;
            else if (checkedToPeck == true)
                final_result = value * 0.429684;
            else if (checkedToBushel == true)
                final_result = value * 0.107421;
            else if (checkedToLitre == true)
                final_result = value * 3.78541;
            else if (checkedToCup == true)
                final_result = value * 16;
            else if (checkedToCubicFeet == true)
                final_result = value * 0.133681;
        }
        displayResult(final_result);
    }

    //from checkboxes
    public void from_cubic_feet(View view) {
        boolean checked = ((RadioButton) view).isChecked();
        checkedFromCubicFeet = checked;
    }

    public void from_cubic_inch(View view) {
        boolean checked = ((RadioButton) view).isChecked();
        checkedFromCubicInch = checked;
    }

    public void from_cubic_yard(View view) {
        boolean checked = ((RadioButton) view).isChecked();
        checkedFromCubicYard = checked;
    }

    public void from_cord(View view) {
        boolean checked = ((RadioButton) view).isChecked();
        checkedFromCord = checked;
    }

    public void from_cubic_centimeter(View view) {
        boolean checked = ((RadioButton) view).isChecked();
        checkedFromCubicCentimeter = checked;
    }

    public void from_cubic_meter(View view) {
        boolean checked = ((RadioButton) view).isChecked();
        checkedFromCubicMeter = checked;
    }

    public void from_quart(View view) {
        boolean checked = ((RadioButton) view).isChecked();
        checkedFromQuart = checked;
    }

    public void from_pint(View view) {
        boolean checked = ((RadioButton) view).isChecked();
        checkedFromPint = checked;
    }

    public void from_peck(View view) {
        boolean checked = ((RadioButton) view).isChecked();
        checkedFromPeck = checked;
    }

    public void from_bushel(View view) {
        boolean checked = ((RadioButton) view).isChecked();
        checkedFromBushel = checked;
    }


    public void from_litre(View view) {
        boolean checked = ((RadioButton) view).isChecked();
        checkedFromLitre = checked;
    }

    public void from_cup(View view) {
        boolean checked = ((RadioButton) view).isChecked();
        checkedFromCup = checked;
    }

    public void from_gallon(View view) {
        boolean checked = ((RadioButton) view).isChecked();
        checkedFromGallon = checked;
    }


    //TO CHECKBOXES
    public void to_cubic_feet(View view) {
        boolean checked = ((RadioButton) view).isChecked();
        checkedToCubicFeet = checked;
    }

    public void to_cubic_inch(View view) {
        boolean checked = ((RadioButton) view).isChecked();
        checkedToCubicInch = checked;
    }

    public void to_cubic_yard(View view) {
        boolean checked = ((RadioButton) view).isChecked();
        checkedToCubicYard = checked;
    }

    public void to_cord(View view) {
        boolean checked = ((RadioButton) view).isChecked();
        checkedToCord = checked;
    }

    public void to_cubic_centimeter(View view) {
        boolean checked = ((RadioButton) view).isChecked();
        checkedToCubicCentimeter = checked;
    }

    public void to_cubic_meter(View view) {
        boolean checked = ((RadioButton) view).isChecked();
        checkedToCubicMeter = checked;
    }

    public void to_quart(View view) {
        boolean checked = ((RadioButton) view).isChecked();
        checkedToQuart = checked;
    }

    public void to_pint(View view) {
        boolean checked = ((RadioButton) view).isChecked();
        checkedToPint = checked;
    }

    public void to_peck(View view) {
        boolean checked = ((RadioButton) view).isChecked();
        checkedToPeck = checked;
    }

    public void to_bushel(View view) {
        boolean checked = ((RadioButton) view).isChecked();
        checkedToBushel = checked;
    }

    public void to_litre(View view) {
        boolean checked = ((RadioButton) view).isChecked();
        checkedToLitre = checked;
    }

    public void to_cup(View view) {
        boolean checked = ((RadioButton) view).isChecked();
        checkedToCup = checked;
    }

    public void to_gallon(View view) {
        boolean checked = ((RadioButton) view).isChecked();
        checkedToGallon = checked;
    }

    //RESULT
    public void displayResult(double result) {
        TextView resultTextView = (TextView) findViewById(R.id.result);
        resultTextView.setText(Double.toString(result));
    }




}
