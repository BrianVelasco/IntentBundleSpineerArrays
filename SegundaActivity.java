package com.brianvp.manejodebundle;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import java.lang.reflect.Array;
import java.util.ArrayList;

public class SegundaActivity extends AppCompatActivity {
    TextView campo, campo2;
    Spinner dias, dias2;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_segunda);
        campo = (TextView) findViewById(R.id.campo);
        campo2 = (TextView) findViewById(R.id.campo2);
        dias = (Spinner) findViewById(R.id.spinner);
        dias2 = (Spinner)findViewById(R.id.spinner2);
        ArrayList<String> combodias= new ArrayList<String>();

        combodias.add("Lunes");
        combodias.add("Martes");
        combodias.add("Miercoles");
        combodias.add("Jueves");
        combodias.add("Viernes");
        combodias.add("Sabado");
        combodias.add("Domingo");

        Bundle bundle = this.getIntent().getExtras();

        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this, R.array.options,android.R.layout.simple_spinner_item);
        ArrayAdapter<CharSequence> adapter1 = new ArrayAdapter(this,android.R.layout.simple_spinner_item,combodias);

        String nuevo = bundle.getString("nombre");






            if(bundle != null){
            campo.setText("Hola: " + nuevo);
        }

        dias.setAdapter(adapter);
        dias2.setAdapter(adapter1);
        dias.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                Toast.makeText(adapterView.getContext(),
                        "Seleccionando:  "+adapterView.getItemAtPosition(i).toString(), Toast.LENGTH_LONG).show();
                campo.setText("Seleccionando:  "+adapterView.getItemAtPosition(i).toString());
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });

        dias2.setOnItemSelectedListener(new  AdapterView.OnItemSelectedListener(){

            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                campo2.setText("Seleccionando:  "+adapterView.getItemAtPosition(i).toString());
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {
                campo2.setText("NADA SELECCIONADO");

            }
        });



    }
}
