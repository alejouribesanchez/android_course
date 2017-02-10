package com.alejouribesanchez.class_7;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.CheckBox;
import android.widget.LinearLayout;

public class Main6Activity extends AppCompatActivity {

    public static String[] INDUSTRIAS = {
            "Arte",
            "Computación",
            "Ingeniería civil",
            "Bioquímica",
            "Música",
            "Astronomía",
            "Zoología"
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main6);

        LinearLayout seccionIndustria = (LinearLayout) findViewById(R.id.activity_main6);

        for (String industria : INDUSTRIAS) {
            CheckBox opcion = new CheckBox(this);
            opcion.setText(industria);
            opcion.setLayoutParams(
                    new LinearLayout.LayoutParams(LinearLayout.LayoutParams.WRAP_CONTENT, LinearLayout.LayoutParams.WRAP_CONTENT));
            seccionIndustria.addView(opcion);
        }
    }
}
