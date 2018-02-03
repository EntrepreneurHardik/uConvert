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
public class square_measure_converter extends AppCompatActivity{

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_square_measure);
        Toolbar myToolbar = (Toolbar) findViewById(R.id.my_toolbar);
        setSupportActionBar(myToolbar);
    }

    //variable declarations
    double final_result = 0;
    double value= 0;

    boolean checkedFromSquareFeet = false;
    boolean checkedFromSquareInch = false;
    boolean checkedFromSquareYard = false;
    boolean checkedFromSquareRod = false;
    boolean checkedFromSquareMile = false;
    boolean checkedFromAcre = false;
    boolean checkedFromHectare = false;
    boolean checkedFromSquareCentimeter = false;
    boolean checkedFromSquareMeter = false;
    boolean checkedFromSquareKilometer = false;

    boolean checkedToSquareFeet = false;
    boolean checkedToSquareInch = false;
    boolean checkedToSquareYard = false;
    boolean checkedToSquareRod = false;
    boolean checkedToSquareMile = false;
    boolean checkedToAcre = false;
    boolean checkedToHectare = false;
    boolean checkedToSquareCentimeter = false;
    boolean checkedToSquareMeter = false;
    boolean checkedToSquareKilometer = false;

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

        if (checkedFromSquareFeet == true) {
            if (checkedToSquareInch == true)
                final_result = value * 114;
            else if (checkedToSquareYard == true)
                final_result = value * 0.11111;
            else if (checkedToSquareRod == true)
                final_result = value * 0.00367309;
            else if (checkedToSquareMile == true)
                final_result = value * 0.0000000358701;
            else if (checkedToAcre == true)
                final_result = value * 0.0000229568;
            else if (checkedToHectare == true)
                final_result = value * 0.0000092903;
            else if (checkedToSquareCentimeter == true)
                final_result = value * 929.03;
            else if (checkedToSquareMeter == true)
                final_result = value * 0.092903;
            else if (checkedToSquareKilometer == true)
                final_result = value * 0.000000092903;
        } else if (checkedFromSquareInch== true) {
            if (checkedToSquareFeet== true)
                final_result = value * 0.00694444;
            else if (checkedToSquareYard== true)
                final_result = value * 0.000771605;
            else if (checkedToSquareRod== true)
                final_result = value * 0.0000255076;
            else if (checkedToSquareMile== true)
                final_result = value * 0.000000000249098;
            else if (checkedToAcre== true)
                final_result = value * 0.000000159423;
            else if (checkedToHectare== true)
                final_result = value * 0.000000064516;
            else if (checkedToSquareCentimeter == true)
                final_result = value * 6.4516;
            else if (checkedToSquareMeter == true)
                final_result = value * 0.00064516;
            else if (checkedToSquareKilometer== true)
                final_result = value * 0.00000000064516;
        } else if (checkedFromSquareYard == true) {
            if (checkedToSquareFeet == true)
                final_result = value * 9;
            else if (checkedToSquareInch == true)
                final_result = value * 1296;
            else if (checkedToSquareRod == true)
                final_result = value * 0.0330579;
            else if (checkedToSquareMile == true)
                final_result = value * 0.000000322831;
            else if (checkedToAcre == true)
                final_result = value * 0.000206612;
            else if (checkedToHectare == true)
                final_result = value * 0.0000836127;
            else if (checkedToSquareCentimeter == true)
                final_result = value * 8361.27;
            else if (checkedToSquareMeter == true)
                final_result = value * 0.836127;
            else if (checkedToSquareKilometer == true)
                final_result = value * 0.000000836127;
        } else if (checkedFromSquareRod == true) {
            if (checkedToSquareFeet == true)
                final_result = value * 272.25;
            else if (checkedToSquareInch == true)
                final_result = value * 39204;
            else if (checkedToSquareYard == true)
                final_result = value * 30.25;
            else if (checkedToSquareMile == true)
                final_result = value * 0.00000976563;
            else if (checkedToAcre == true)
                final_result = value * 0.00625;
            else if (checkedToHectare == true)
                final_result = value * 0.00252929;
            else if (checkedToSquareCentimeter == true)
                final_result = value * 252929;
            else if (checkedToSquareMeter == true)
                final_result = value * 25.2929;
            else if (checkedToSquareKilometer == true)
                final_result = value * 0.0000252929;
        }
        else if (checkedFromSquareMile == true) {
            if (checkedToSquareFeet == true)
                final_result = value * 27880000;
            else if (checkedToSquareInch == true)
                final_result = value * 4014000000.0;
            else if (checkedToSquareYard == true)
                final_result = value * 3098000;
            else if (checkedToSquareRod == true)
                final_result = value * 102400;
            else if (checkedToAcre == true)
                final_result = value * 640;
            else if (checkedToHectare == true)
                final_result = value * 258.999;
            else if (checkedToSquareCentimeter == true)
                final_result = value * 25900000000.0;
            else if (checkedToSquareMeter == true)
                final_result = value * 2590000;
            else if (checkedToSquareKilometer == true)
                final_result = value * 2.58999;
        } else if (checkedFromAcre == true) {
            if (checkedToSquareFeet == true)
                final_result = value * 43560;
            else if (checkedToSquareInch == true)
                final_result = value * 6273000;
            else if (checkedToSquareYard == true)
                final_result = value * 4840;
            else if (checkedToSquareRod == true)
                final_result = value * 160;
            else if (checkedToSquareMile == true)
                final_result = value * 0.0015625;
            else if (checkedToHectare == true)
                final_result = value * 0.404686;
            else if (checkedToSquareCentimeter == true)
                final_result = value * 40470000;
            else if (checkedToSquareMeter == true)
                final_result = value * 4046.86;
            else if (checkedToSquareKilometer == true)
                final_result = value * 0.00404686;
        } else if (checkedFromHectare == true) {
            if (checkedToSquareFeet == true)
                final_result = value * 107639;
            else if (checkedToSquareInch == true)
                final_result = value * 15500000;
            else if (checkedToSquareYard == true)
                final_result = value * 11959.9;
            else if (checkedToSquareRod == true)
                final_result = value * 395.369;
            else if (checkedToSquareMile == true)
                final_result = value * 0.00386102;
            else if (checkedToAcre == true)
                final_result = value * 2.47105;
            else if (checkedToSquareCentimeter == true)
                final_result = value * 100000000;
            else if (checkedToSquareMeter == true)
                final_result = value * 10000;
            else if (checkedToSquareKilometer == true)
                final_result = value * 0.01;
        }
        else if (checkedFromSquareCentimeter == true) {
            if (checkedToSquareFeet == true)
                final_result = value * 0.00107639;
            else if (checkedToSquareInch == true)
                final_result = value * 0.155;
            else if (checkedToSquareYard == true)
                final_result = value * 0.000119599;
            else if (checkedToSquareRod == true)
                final_result = value * 0.00000395369;
            else if (checkedToSquareMile == true)
                final_result = value * 0.0000000000386102;
            else if (checkedToAcre == true)
                final_result = value * 0.0000000247105;
            else if (checkedToHectare == true)
                final_result = value * 0.00000001;
            else if (checkedToSquareMeter == true)
                final_result = value * 0.0001;
            else if (checkedToSquareKilometer == true)
                final_result = value * 0.0000000001;
        } else if (checkedFromSquareMeter == true) {
            if (checkedToSquareFeet == true)
                final_result = value * 10.7639;
            else if (checkedToSquareInch == true)
                final_result = value * 1550;
            else if (checkedToSquareYard == true)
                final_result = value * 1.19599;
            else if (checkedToSquareRod == true)
                final_result = value * 0.0395369;
            else if (checkedToSquareMile == true)
                final_result = value * 0.000000386102;
            else if (checkedToAcre == true)
                final_result = value * 0.000247105;
            else if (checkedToHectare == true)
                final_result = value * 0.0001;
            else if (checkedToSquareCentimeter == true)
                final_result = value * 10000;
            else if (checkedToSquareKilometer == true)
                final_result = value * 0.000001;
        } else if (checkedFromSquareKilometer == true) {
            if (checkedToSquareFeet == true)
                final_result = value * 10760000;
            else if (checkedToSquareInch == true)
                final_result = value * 1550000000;
            else if (checkedToSquareYard == true)
                final_result = value * 1196000;
            else if (checkedToSquareRod == true)
                final_result = value * 39536.9;
            else if (checkedToSquareMile == true)
                final_result = value * 0.386102;
            else if (checkedToAcre == true)
                final_result = value * 247.105;
            else if (checkedToHectare == true)
                final_result = value * 100;
            else if (checkedToSquareCentimeter == true)
                final_result = value * 10000000000.0;
            else if (checkedToSquareMeter == true)
                final_result = value * 1000000;
        }
        displayResult(final_result);
    }

    //from checkboxes
    public void from_square_feet(View view) {
        boolean checked = ((RadioButton) view).isChecked();
        checkedFromSquareFeet = checked;
    }

    public void from_square_inch(View view) {
        boolean checked = ((RadioButton) view).isChecked();
        checkedFromSquareInch = checked;
    }

    public void from_square_yard(View view) {
        boolean checked = ((RadioButton) view).isChecked();
        checkedFromSquareYard = checked;
    }

    public void from_square_rod(View view) {
        boolean checked = ((RadioButton) view).isChecked();
        checkedFromSquareRod = checked;
    }

    public void from_square_mile(View view) {
        boolean checked = ((RadioButton) view).isChecked();
        checkedFromSquareMile= checked;
    }

    public void from_acre(View view) {
        boolean checked = ((RadioButton) view).isChecked();
        checkedFromAcre = checked;
    }

    public void from_hectare(View view) {
        boolean checked = ((RadioButton) view).isChecked();
        checkedFromHectare = checked;
    }

    public void from_square_centimeter(View view) {
        boolean checked = ((RadioButton) view).isChecked();
        checkedFromSquareCentimeter = checked;
    }

    public void from_square_meter(View view) {
        boolean checked = ((RadioButton) view).isChecked();
        checkedFromSquareMeter = checked;
    }

    public void from_square_kilometer(View view) {
        boolean checked = ((RadioButton) view).isChecked();
        checkedFromSquareKilometer = checked;
    }

    //TO CHECKBOXES
    public void to_square_feet(View view) {
        boolean checked = ((RadioButton) view).isChecked();
        checkedToSquareFeet = checked;
    }

    public void to_square_inch(View view) {
        boolean checked = ((RadioButton) view).isChecked();
        checkedToSquareInch = checked;
    }

    public void to_square_yard(View view) {
        boolean checked = ((RadioButton) view).isChecked();
        checkedToSquareYard = checked;
    }

    public void to_square_rod(View view) {
        boolean checked = ((RadioButton) view).isChecked();
        checkedToSquareRod = checked;
    }

    public void to_square_mile(View view) {
        boolean checked = ((RadioButton) view).isChecked();
        checkedToSquareMile = checked;
    }

    public void to_acre(View view) {
        boolean checked = ((RadioButton) view).isChecked();
        checkedToAcre = checked;
    }

    public void to_hectare(View view) {
        boolean checked = ((RadioButton) view).isChecked();
        checkedToHectare = checked;
    }

    public void to_square_centimeter(View view) {
        boolean checked = ((RadioButton) view).isChecked();
        checkedToSquareCentimeter = checked;
    }

    public void to_square_meter(View view) {
        boolean checked = ((RadioButton) view).isChecked();
        checkedToSquareMeter = checked;
    }

    public void to_square_kilometer(View view) {
        boolean checked = ((RadioButton) view).isChecked();
        checkedToSquareKilometer = checked;
    }

    //RESULT
    public void displayResult(double result) {
        TextView resultTextView = (TextView) findViewById(R.id.result);
        resultTextView.setText(Double.toString(result));
    }


    public boolean onCreateOptionsMenu(Menu menu) {

        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_inner, menu);
        return super.onCreateOptionsMenu(menu);
    }


}
