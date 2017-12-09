package com.example.frankson.zikapp;

import android.content.Intent;
import android.content.SharedPreferences;
import android.net.Uri;
import android.os.Bundle;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;


public class PostosInfo extends AppCompatActivity {
    ListView listView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_postos_info);

        ActionBar actionBar = getSupportActionBar();
        actionBar.setTitle("Postos de saúde próximos");
        actionBar.setDisplayHomeAsUpEnabled(true);

        SharedPreferences.Editor editor = getSharedPreferences("posto_data", MODE_PRIVATE).edit();

        //Enderecos de unidades basica de saudes default
        editor.putString("UBS Azulville", "Rua Madre Marie Blanche, 1021");
        editor.putString("UBS Cidade Aracy","UBS Cidade Aracy - Rua Sebastião Lemos, São Carlos");
        editor.putString("UBS Botafogo","Av. José Pereira Lopes, 1650 - Jardim Botafogo 1, São Carlos - SP, 12547-300");
        editor.putString("UBS Cruzeiro do Sul","Rua Basílio Dibbo, 1055 - Vila Morumbi, São Carlos - State of São Paulo");
        editor.putString("UBS Fagga","Av. João de Lourenço, 44 - Maria Stella Faga, São Carlos - SP");
        editor.putString("UBS Parque Delta","R. Pedro Cavarette, 151 - Jardim Hikare, São Carlos - SP, 13564-490");
        editor.putString("UBS Redencao","R. Des. Júlio de Faria, 1700 - Vila Prado, São Carlos - SP, 13575-006");
        editor.putString("UBS Santa Felicia","R. Joaquim Augusto Ribeiro de Souza, 40 - Santa Felícia, São Carlos - SP, 13562-100");
        editor.putString("UBS Santa Paula","Rua Luiz Saia, 44 - Parque Arnold Schimidt, São Carlos - SP, 13564-010");
        editor.putString("UBS São Jose","Av. Araraquara, 422 - Vila Brasilia, São Carlos - SP, 13566-770");
        editor.putString("UBS Vila Isabel","R. Vicente de Carvalho, 566 - Vila Marcelino, São Carlos - SP, 13570-593");
        editor.putString("UBS Vila Nery","R. da Imprensa, 410 - Vila Faria, São Carlos - SP, 13569-160");

        //Enderecos Unidade de pronto atendimento default
        editor.putString("UPA da Vila Prado","Av. Grécia, 229 - Vila Prado, São Carlos - SP, 13574-140");
        editor.putString("UPA do Cidade Aracy","R. Sebastião Lemos, 426 - Cidade Aracy, São Carlos - SP, 13560-970");
        editor.putString("UPA da Santa Felicia","Rua João Navarro, s/n - Santa Felícia, São Carlos - SP, 13563-714");

        editor.apply();


        List postos = new ArrayList<String>();
        postos.add("UBS Azulville");
        postos.add("UBS Cidade Aracy");
        postos.add("UBS Botafogo");
        postos.add("UBS Cruzeiro do Sul");
        postos.add("UBS Fagga");
        postos.add("UBS Parque Delta");
        postos.add("UBS Redencao");
        postos.add("UBS Santa Felicia");
        postos.add("UBS Santa Paula");
        postos.add("UBS São Jose");
        postos.add("UBS Vila Isabel");
        postos.add("UBS Vila Nery");
        postos.add("UPA da Vila Prado");
        postos.add("UPA do Cidade Aracy");
        postos.add("UPA da Santa Felicia");

        listView = (ListView) findViewById(R.id.list_view_postos);
        ArrayAdapter<String> mAdapter = new ArrayAdapter<String>(PostosInfo.this,android.R.layout.simple_list_item_1,postos);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {

                String key = (String)listView.getItemAtPosition(i).toString();
                SharedPreferences prefs = getSharedPreferences("posto_data", MODE_PRIVATE);
                String endereco = prefs.getString(key, null);

                Intent intentMapa = new Intent(Intent.ACTION_VIEW);
                intentMapa.setData(Uri.parse("geo:0,0?q=" + endereco));
                if(intentMapa.resolveActivity(getPackageManager()) != null) {
                    startActivity(intentMapa);
                }else {
                    Toast toast = Toast.makeText(PostosInfo.this, "Impossível abrir o recurso", Toast.LENGTH_LONG);
                    toast.show();
                }

            }
        });

        listView.setAdapter(mAdapter);

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