package com.alejouribesanchez.class_2;

import android.content.res.Resources;
import android.graphics.Typeface;
import android.graphics.drawable.Drawable;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Html;
import android.text.SpannableStringBuilder;
import android.text.Spanned;
import android.text.style.StyleSpan;
import android.widget.TextView;

import java.util.Random;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //Get resources
        Resources resources = getResources();
        String appName = resources.getString(R.string.app_name);

        //Get Color
        int color = resources.getColor(R.color.colorAccent);
        int color2 =  ContextCompat.getColor(this, R.color.colorPrimary);

        //Get Drawable
        Drawable drawable =  resources.getDrawable(R.mipmap.ic_launcher);
        Drawable drawable2 = ContextCompat.getDrawable(this, R.mipmap.ic_launcher);

        //Strings
        String text1 = resources.getString(R.string.example);
        TextView textView = (TextView)findViewById(R.id.text_view_example);
        textView.setText(text1);

        TextView textViewPlurals = (TextView)findViewById(R.id.text_view_plurals);

        //Strings-Plurals
        Random random = new Random();
        int amount = random.nextInt(9);

        if (amount == 0) {
            textViewPlurals.setText(R.string.zero);
        } else {
            Resources res = getResources();
            String string = res.getQuantityString(R.plurals.found_product, amount, amount);
            textView.setText(string);
        }


        //Strings Format
        Resources res = getResources();
        String recurso = res.getString(R.string.string_formate);
        String stringFormate = String.format(recurso, "James", 120);
        TextView textView2 = (TextView)findViewById(R.id.text_view_example2);
        textView2.setText(stringFormate);


        //String html
        String text2= res.getString(R.string.string_html);
        CharSequence textoInterpretado = Html.fromHtml(text2);
        TextView textView3 = (TextView)findViewById(R.id.text_view_example3);
        textView3.setText(textoInterpretado);


        //String html data
        String text3 = res.getString(R.string.string_html_cdata);
        TextView textView4 = (TextView)findViewById(R.id.text_view_example4);
        CharSequence textoInterpretado2 = Html.fromHtml(text3);
        textView4.setText(textoInterpretado2);

        //String spannable
        TextView textView5 = (TextView)findViewById(R.id.text_view_example5);
        SpannableStringBuilder stringBuilder =
                new SpannableStringBuilder(getString(R.string.example));

        stringBuilder.setSpan(new StyleSpan(Typeface.BOLD),0,1, Spanned.SPAN_EXCLUSIVE_EXCLUSIVE);
        textView5.setText(stringBuilder);




    }
}
