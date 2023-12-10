package com.cst2335.thom1640;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CompoundButton;
import android.widget.Switch;
import android.widget.Toast;

import com.google.android.material.snackbar.Snackbar;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_relative);

        Button clickHereButton = findViewById(R.id.clickHereButton);
        clickHereButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String toastMessage = getResources().getString(R.string.toast_message);
                Toast.makeText(getApplicationContext(), toastMessage, Toast.LENGTH_LONG).show();
            }
        });

        Switch mySwitch = findViewById(R.id.mySwitch);

        mySwitch.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                Snackbar snackbar = Snackbar.make(buttonView,
                        "The switch is now " + (isChecked ? "on" : "off"),
                        Snackbar.LENGTH_LONG);

                snackbar.setAction("Undo", new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        mySwitch.setChecked(!isChecked);
                    }
                });

                        snackbar.show();
            }
        });
    }
}