package com.webdesarrollador.fragmentotutorial;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

/**
 * Created by raulrevillas on 15/12/2016.
 */

public class Fragmento1 extends Fragment {

    TextView saludo,nombre;
    View view;
    private OnItemSelectedListener listener;

    //Para crear la vista inflaremos el layout fragmento1
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup parent, Bundle savedInstanceState) {

        view = inflater.inflate(R.layout.fragmento1, parent, false);
        return view;
    }

    //Se ejecuta justo despues de onCreateView
    //Para gestionar vistas
    @Override
    public void onViewCreated(View view, Bundle savedInstanceState) {

        saludo = (TextView) view.findViewById(R.id.saludo);
        nombre = (TextView) view.findViewById(R.id.nombre);

        Button boton = (Button) view.findViewById(R.id.button);
        boton.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                saludo.setText("Hola Mundo");
            }
        });

        Button botonInterfaz = (Button) view.findViewById(R.id.buttonInterfaz);
        botonInterfaz.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                onButtonClick("funciona la interfaz");
            }
        });
    }

    //COMUNICACIONES

    @Override
    public void onActivityCreated(Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        Bundle bundle = getArguments();
        if (bundle != null) {
            saludo.setText(bundle.getString("texto"));
        }
    }
    public void setNombre(String palabra) {
        nombre.setText(palabra);
    }
    public TextView getNombre() {
        return nombre;
    }

    // Definimos la interfaz
    public interface OnItemSelectedListener {
        void onPrueba(String link);
    }

    @Override
    public void onAttach(Activity activity) {
        super.onAttach(activity);

        // Checkeamos que la actividad contenedora haya implementado la interfaz. Si no, lanzamos una excepción
        // Almacena el listener
        if (activity instanceof OnItemSelectedListener) {
            listener = (OnItemSelectedListener) activity;
        } else {
            throw new ClassCastException(activity.toString()+ " debe implementar OnItemSelectedListener");
        }
    }
    // Cuando clickemos el bont de probando interfaz, se dispara el evento
    public void onButtonClick(String palabra) {
        listener.onPrueba(palabra);
    }
}
