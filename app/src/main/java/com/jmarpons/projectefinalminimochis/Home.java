package com.jmarpons.projectefinalminimochis;

import android.app.Dialog;
import android.content.Intent;
import android.graphics.Typeface;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import com.google.android.material.bottomappbar.BottomAppBar;

public class Home extends AppCompatActivity {

    private BottomAppBar mBottomAppBar;

    Dialog miDialog;

    @Override
    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.home);

        //iniciar dialog
        miDialog = new Dialog(Home.this);

        mBottomAppBar = findViewById(R.id.bottom_app_bar);
        setSupportActionBar(mBottomAppBar);

        mBottomAppBar.setOnMenuItemClickListener(new Toolbar.OnMenuItemClickListener() {

            @Override
            public boolean onMenuItemClick(MenuItem item) {
                if (item.getItemId()==R.id.app_bar_games){
                    Intent intent = new Intent(Home.this, Games.class);
                    startActivity(intent);
                }
                else if (item.getItemId()==R.id.app_bar_chat){
                    Intent intent = new Intent(Home.this, Chat.class);
                    startActivity(intent);
                } else if (item.getItemId()==R.id.app_bar_act){
                    Intent intent = new Intent(Home.this, Act.class);
                    startActivity(intent);
                } else if (item.getItemId()==R.id.app_menu){
                    Configuracio();
                }
                return false;
            }
        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        super.onCreateOptionsMenu(menu);
        getMenuInflater().inflate(R.menu.bottom_app_bar_menu, menu);
        return true;
    }

    private void Configuracio(){
        Button Perfil, Configuracio, info, SortirSessio, X;

        miDialog.setContentView(R.layout.configuracio);
        miDialog.setCanceledOnTouchOutside(false);
        miDialog.setCancelable(false);

        Perfil = miDialog.findViewById(R.id.Perfil);
        Configuracio = miDialog.findViewById(R.id.Configuracio);
        info = miDialog.findViewById(R.id.info);
        SortirSessio = miDialog.findViewById(R.id.SortirSessio);
        X = miDialog.findViewById(R.id.X);

        Perfil.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view){
                Intent intent = new Intent(Home.this, Perfil.class);
                startActivity(intent);
            }
        });

        Configuracio.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view){
                Intent intent = new Intent(Home.this, Ajustes.class);
                startActivity(intent);
            }
        });

        info.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view){
                Intent intent = new Intent(Home.this, Info.class);
                startActivity(intent);
            }
        });

        SortirSessio.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                TancarSessio();
                miDialog.dismiss();

            }
        });

        X.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                miDialog.dismiss();

            }
        });
        miDialog.show();
    }

    //Motode per tancar sessió
    private void TancarSessio() {
        Toast.makeText(this, "Has tancat sessió", Toast.LENGTH_SHORT).show();
    }

}
