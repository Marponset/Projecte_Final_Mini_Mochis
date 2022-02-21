package com.jmarpons.projectefinalminimochis;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import com.google.android.material.bottomappbar.BottomAppBar;

public class Home extends AppCompatActivity {

    private BottomAppBar mBottomAppBar;

    @Override
    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.home);

        mBottomAppBar = findViewById(R.id.bottom_app_bar);
        setSupportActionBar(mBottomAppBar);

        mBottomAppBar.setOnMenuItemClickListener(new Toolbar.OnMenuItemClickListener() {
            @Override
            public boolean onMenuItemClick(MenuItem item) {
                if (item.getItemId()==R.id.app_bar_games){
                   Toast.makeText(Home.this, "hola", Toast.LENGTH_SHORT).show();
                }
                else if (item.getItemId()==R.id.app_bar_chat){
                    Intent intent = new Intent(Home.this, Configuracio.class);
                    //startActivity(intent);
                } else if (item.getItemId()==R.id.app_bar_act){
                    Intent intent = new Intent(Home.this, Configuracio.class);
                    startActivity(intent);
                }
                return false;
            }
        });

        /*mBottomAppBar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Home.this, Configuracio.class);
                startActivity(intent);
            }
        });*/
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        super.onCreateOptionsMenu(menu);
        getMenuInflater().inflate(R.menu.bottom_app_bar_menu, menu);
        return true;
    }

}
