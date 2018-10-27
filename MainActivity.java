package com.brianvp.manejodebundle;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    EditText entrada;
    TextView salida;
    Button ingresar, enviar;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        entrada = (EditText) findViewById(R.id.campo1);
        salida = (TextView) findViewById(R.id.salida);
        ingresar = (Button) findViewById(R.id.ingresar);
        enviar = (Button) findViewById(R.id.enviar);
    }

    public void ingresa (View v){
        String nombre = entrada.getText().toString();
        salida.setText("Hola " + nombre);
    }
    public void enviar (View v){
        Intent intent = new Intent(MainActivity.this,SegundaActivity.class);

        Bundle bundle = new Bundle();
        bundle.putString("nombre",entrada.getText().toString());
        intent.putExtras(bundle);
        startActivity(intent);
    }
}
