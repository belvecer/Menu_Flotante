package com.example.menu_flotante;

import android.graphics.Color;
import android.os.Bundle;
import android.view.ContextMenu;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    private TextView etiqueta;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        etiqueta = findViewById(R.id.etiqueta);
        registerForContextMenu(etiqueta);
    }

    @Override
    public void onCreateContextMenu(ContextMenu menu, View v,
                                    ContextMenu.ContextMenuInfo menuInfo) {
        super.onCreateContextMenu(menu, v, menuInfo);
        getMenuInflater().inflate(R.menu.menu_flotante, menu);
        menu.setHeaderTitle("Opciones");
    }

    @Override
    public boolean onContextItemSelected(MenuItem item) {
        int id = item.getItemId();

        if (id == R.id.accion_fondo) {
            etiqueta.setBackgroundColor(Color.parseColor("#C8E6C9"));
            return true;

        } else if (id == R.id.accion_tamano) {
            etiqueta.setTextSize(30);
            return true;

        } else if (id == R.id.accion_texto) {
            etiqueta.setText("Texto cambiado desde el menú");
            return true;
        }

        return super.onContextItemSelected(item);
    }
}