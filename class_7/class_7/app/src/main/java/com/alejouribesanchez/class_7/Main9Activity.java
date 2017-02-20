package com.alejouribesanchez.class_7;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.RadioButton;
import android.widget.RadioGroup;

public class Main9Activity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main9);

        RadioGroup contenedor = (RadioGroup) findViewById(R.id.grupo_dias);
        RadioButton opcionI2 = (RadioButton) contenedor.getChildAt(2);
        opcionI2.setChecked(true);
    }
}
