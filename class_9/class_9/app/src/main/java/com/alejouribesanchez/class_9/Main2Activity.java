package com.alejouribesanchez.class_9;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ListView;

public class Main2Activity extends AppCompatActivity {

    ListView listView;
    LeadsAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        listView = (ListView) findViewById(R.id.leads_list);
        adapter = new LeadsAdapter(this, LeadsRepository.getInstance().getLeads());

        //Relacionando la lista con el adaptador
        listView.setAdapter(adapter);

        View view = (View) findViewById(R.id.button);
        view.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(Main2Activity.this,Main3Activity.class));
            }
        });

    }
}
