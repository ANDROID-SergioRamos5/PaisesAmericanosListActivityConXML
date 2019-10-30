package com.example.paisesamericanoslistactivityconxml;

import androidx.appcompat.app.AppCompatActivity;

import android.app.ListActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends ListActivity {

    private String[] paises = {"Argentina","Chile","Paraguay","Bolivia","Peru", "Ecuador", "Brasil", "Colombia",
            "Venezuela", "Uruguay", "TODOS"};
    private int[] poblacion = {40000000, 17000000,6500000,10000000,30000000,
            14000000,183000000,44000000,29000000,3500000};

    private TextView tV;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ArrayAdapter adapter = new ArrayAdapter(MainActivity.this, R.layout.support_simple_spinner_dropdown_item, paises);
        setListAdapter(adapter);

        tV = (TextView)findViewById(R.id.textView);
    }

    @Override
    protected void onListItemClick(ListView l, View v, int position, long id)
    {
        super.onListItemClick(l,v,position,id);
        int suma = 0;
        if (paises[position] == "TODOS")
        {
            for (int i = 0; i<poblacion.length; i++)
            {
                suma += poblacion[i];
            }
            tV.setText("Poblacion de " + paises[position] + " es " + suma + " millones.");
        }
        else
            tV.setText("Poblacion de " + paises[position] + " es " + poblacion[position] + " millones");
    }
}
