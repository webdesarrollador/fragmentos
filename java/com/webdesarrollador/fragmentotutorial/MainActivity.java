package com.webdesarrollador.fragmentotutorial;

import android.app.Activity;
import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.os.Bundle;
import android.util.Log;

// Actividad implementa el listener del fragmento para manejar eventos
public class MainActivity extends Activity implements Fragmento1.OnItemSelectedListener {

    Fragmento1 fragmento;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //Creamos nuestro fragmento
        fragmento = new Fragmento1();
        //Obtenemos la instancia del administrador de fragmentos
        FragmentManager fragmentManager = getFragmentManager();
        // Creamos una transaccion
        FragmentTransaction transaction = fragmentManager.beginTransaction();
        //Añadimos el fragmento a nuestro FrameLayout
        transaction.add(R.id.contenedor_fragmentos, fragmento);
        // Completamos los cambios
        transaction.commit();

        //Le pasamos argumentos al fragmento
        Bundle bundle = new Bundle();
        bundle.putString("texto", "Esperando....");
        fragmento.setArguments(bundle);

    }
    @Override
    protected void onResume() {
        super.onResume();
        fragmento.setNombre("Raúl");
        Log.d("nombre",fragmento.getNombre().getText().toString());
    }

    //Definimos la acción cuando el fragmento dispara el evento
    @Override
    public void onPrueba(String palabra) {
        Log.d("palabra",palabra);
    }
}

