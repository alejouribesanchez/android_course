package com.gapps.class_12;

import android.content.DialogInterface;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private TextView textView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        textView = (TextView) findViewById(R.id.textView);
        Button button = (Button) findViewById(R.id.button);
        Button button2 = (Button) findViewById(R.id.button2);
        Button button3 = (Button) findViewById(R.id.button3);
        Button button4 = (Button) findViewById(R.id.button4);
        Button button5 = (Button) findViewById(R.id.button5);
        Button button6 = (Button) findViewById(R.id.button6);
        button.setOnClickListener(this);
        button2.setOnClickListener(this);
        button3.setOnClickListener(this);
        button4.setOnClickListener(this);
        button5.setOnClickListener(this);
        button6.setOnClickListener(this);

    }

    public AlertDialog creatSimpleAlertDialog(){
        AlertDialog.Builder builder = new AlertDialog.Builder(this);

        builder.setTitle("Title Alert")
                .setMessage("Message for user")
                .setPositiveButton("OK",
                        new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                                textView.setText("OK");
                            }
                        })
                .setNegativeButton("CANCEL",
                        new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                                textView.setText("CANCEL");
                            }
                        });

        return builder.create();

    }

    public AlertDialog createSingleListDialog() {
        AlertDialog.Builder builder = new AlertDialog.Builder(this);

        final CharSequence[] items = new CharSequence[3];

        items[0] = "Orange";
        items[1] = "Mango";
        items[2] = "Banana";

        builder.setTitle("List Dialog")
                .setItems(items, new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        Toast.makeText(
                                MainActivity.this,
                                "Selected:" + items[which],
                                Toast.LENGTH_SHORT)
                                .show();
                    }
                });

        return builder.create();
    }

    public AlertDialog createRadioListDialog() {
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        final CharSequence[] items = new CharSequence[3];
        items[0] = "Single";
        items[1] = "Married";
        items[2] = "Divorced";
        builder.setTitle("Civil state")
                .setSingleChoiceItems(items, 0, new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        Toast.makeText(
                                MainActivity.this,
                                "Selected: " + items[which],
                                Toast.LENGTH_SHORT)
                                .show();
                    }
                });
        return builder.create();
    }

    public AlertDialog createMultipleListDialog() {
        AlertDialog.Builder builder = new AlertDialog.Builder(this);

        final ArrayList itemsSeleccionados = new ArrayList();

        CharSequence[] items = new CharSequence[3];

        items[0] = "Android Development";
        items[1] = "iOS Development";
        items[2] = "Mobile Development";

        builder.setTitle("Interesting")
                .setMultiChoiceItems(items, null, new DialogInterface.OnMultiChoiceClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which, boolean isChecked) {
                        if (isChecked) {
                            // Guardar indice seleccionado
                            itemsSeleccionados.add(which);
                            Toast.makeText(
                                    MainActivity.this,
                                    "Checks selected:(" + itemsSeleccionados.size() + ")",
                                    Toast.LENGTH_SHORT)
                                    .show();
                        } else if (itemsSeleccionados.contains(which)) {
                            // Remover indice sin selección
                            itemsSeleccionados.remove(Integer.valueOf(which));
                        }
                    }
                });

        return builder.create();
    }

    public AlertDialog customDialog() {
        AlertDialog.Builder builder = new AlertDialog.Builder(this);

        LayoutInflater inflater = this.getLayoutInflater();

        View v = inflater.inflate(R.layout.custom_dialog, null);

        builder.setView(v);

        Button signup = (Button) v.findViewById(R.id.crear_boton);
        Button signin = (Button) v.findViewById(R.id.entrar_boton);

        signup.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        // Crear Cuenta...
                        //dismiss();
                    }
                }
        );

        signin.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        // Loguear...
                        //dismiss();
                    }
                }

        );

        return builder.create();
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.button:
                creatSimpleAlertDialog().show();
                break;
            case R.id.button3:
                createSingleListDialog().show();
                break;
            case R.id.button4:
                createRadioListDialog().show();
                break;
            case R.id.button5:
                createMultipleListDialog().show();
                break;
            case R.id.button6:
                customDialog().show();
                break;
            case R.id.button2:
                break;
        }
    }
}
