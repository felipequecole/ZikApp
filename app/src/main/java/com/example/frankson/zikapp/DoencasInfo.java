package com.example.frankson.zikapp;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.List;

public class DoencasInfo extends AppCompatActivity {
    ListView listViewDoenca;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_doencas_info);

        ActionBar actionBar = getSupportActionBar();
        actionBar.setTitle("Doenças causadas");
        actionBar.setDisplayHomeAsUpEnabled(true);


        List doencas = new ArrayList<String>();
        doencas.add("Dengue");
        doencas.add("Zika");
        doencas.add("Chikungunya");

        listViewDoenca = (ListView) findViewById(R.id.list_view_doencas);
        ArrayAdapter<String> AdapterDoenca = new ArrayAdapter<String>(DoencasInfo.this,R.layout.listview_doenca_item,doencas);

        listViewDoenca.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {

                if(i == 0){
                    Intent abrirInfo;
                    abrirInfo = new Intent(getBaseContext(), DengueInfo.class);
                    startActivity(abrirInfo);
                }else if(i == 1){
                    Intent abrirInfo;
                    abrirInfo = new Intent(getBaseContext(), ZikaInfo.class);
                    startActivity(abrirInfo);
                }else if(i == 2){
                    Intent abrirInfo;
                    abrirInfo = new Intent(getBaseContext(), ChikungunyaInfo.class);
                    startActivity(abrirInfo);
                }


            }
        });

        listViewDoenca.setAdapter(AdapterDoenca);

    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();
        if (id == android.R.id.home) {
            this.finish();
            return true;
        }
        return super.onOptionsItemSelected(item);
    }
}
