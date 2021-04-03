package com.example.bikecliente;

import android.os.Bundle;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.snackbar.Snackbar;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.recyclerview.widget.DefaultItemAnimator;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.View;
import android.widget.Toast;

import java.util.ArrayList;

import controller.ConexaoController;
import modelDominio.Bike;

public class MainActivity extends AppCompatActivity {
    RecyclerView rvElementos;
    InformacoesApp infoApp;
    BikeAdapter bikeAdapter;
    ArrayList<Bike> listaBikes;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        FloatingActionButton fab = findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        // associar os componentes
        rvElementos = findViewById(R.id.rvElementos);

        // pegar o contexto
        infoApp = (InformacoesApp) getApplicationContext();

        Thread t = new Thread(){
            @Override
            public void run() {
                ConexaoController ccont = new ConexaoController(infoApp);
                listaBikes = ccont.bikeLista();
                runOnUiThread(new Runnable() {
                    @Override
                    public void run() {
                        bikeAdapter = new BikeAdapter(listaBikes,tratacliqueItem);
                        RecyclerView.LayoutManager mLayoutManager = new LinearLayoutManager(MainActivity.this);
                        rvElementos.setLayoutManager(mLayoutManager);
                        rvElementos.setItemAnimator(new DefaultItemAnimator());
                        rvElementos.setAdapter(bikeAdapter);
                    }
                });

            }
        };
        t.start();

    }

    BikeAdapter.BikeOnClickListener tratacliqueItem = new BikeAdapter.BikeOnClickListener() {
        @Override
        public void onClickBike(View view, int position) {
            Bike bk = listaBikes.get(position);
            Toast.makeText(MainActivity.this, Float.toString(bk.getValor()), Toast.LENGTH_SHORT).show();
        }
    };

}
