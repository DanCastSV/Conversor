package com.example.conversor;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.Switch;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button Convertir = findViewById(R.id.btnConvertir);
        TextView Resultado = findViewById(R.id.txtResultado);
        TextView Euro = findViewById(R.id.txtEuro);
        EditText USD = findViewById(R.id.tbUSD);
        EditText EUR = findViewById(R.id.tbEUR);
        Switch Divisa = findViewById(R.id.switch1);
        Button Integrantes = findViewById(R.id.btnIntegrantes);

        Divisa.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
                if(Divisa.isChecked()){
                    EUR.setVisibility(View.VISIBLE);
                    Euro.setVisibility(View.VISIBLE);

                }
                else{
                    EUR.setVisibility(View.INVISIBLE);
                    Euro.setVisibility(View.INVISIBLE);

                }


            }
        });
        Convertir.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(Divisa.isChecked()){
                    double USD1 = Double.parseDouble(String.valueOf(USD.getText()));
                    double EUR1 = Double.parseDouble(String.valueOf(EUR.getText()));

                    double Resultado1 =USD1*EUR1;

                    Resultado.setText(Double.toString(Resultado1));


                }
                else{
                    double USD1 = Double.parseDouble(String.valueOf(USD.getText()));
                    double EUR1 = 0.9;

                    double Resultado1 =USD1*EUR1;

                    Resultado.setText(Double.toString(Resultado1));


                }

            }
        });
        Integrantes.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                MainActivity.this.startActivity(new Intent(MainActivity.this,Integrantes.class));
            }
        });

    }
}