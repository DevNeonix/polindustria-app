package com.pe.polindustria.asistencia.activities;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;

import com.google.android.material.navigation.NavigationView;
import com.pe.polindustria.asistencia.R;
import com.pe.polindustria.asistencia.fragments.ListOtsFragment;
import com.pe.polindustria.asistencia.fragments.MarcarOTFragment;
import com.pe.polindustria.asistencia.fragments.MarcarPersonalFragment;

public class HomeActivity extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener {
    DrawerLayout drawer;
    NavigationView navigationView;
    Toolbar toolbar;
    Fragment currentFragment;
    SharedPreferences preferences;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);


        setContentView(R.layout.activity_home);
        setToolbar();

        changeFrame(new MarcarPersonalFragment());
    }

    private void setToolbar() {
        toolbar = (Toolbar) findViewById(R.id.toolbar__ah);
        navigationView = findViewById(R.id.navview);
        setSupportActionBar(toolbar);
        drawer = (DrawerLayout) findViewById(R.id.drawerLayout__ah);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.addDrawerListener(toggle);
        toggle.syncState();


        preferences = getApplicationContext().getSharedPreferences("asistencia", MODE_PRIVATE);
        View headerView = navigationView.getHeaderView(0);
        TextView navUsername = headerView.findViewById(R.id.username);
        TextView toweb = headerView.findViewById(R.id.toweb);
        toweb.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getApplicationContext(), WebActivity.class));
            }
        });
        navUsername.setText(preferences.getString("usuario_nombre", "..."));

        navigationView.setNavigationItemSelectedListener(this);

    }


    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {
        switch (menuItem.getItemId()) {
            case R.id.mOts:
                currentFragment = new ListOtsFragment();
                changeFrame(currentFragment);
                break;

            case R.id.mMarcacionOT:
                currentFragment = new MarcarOTFragment();
                changeFrame(currentFragment);
                break;
            case R.id.mMarcacionPe:
                currentFragment = new MarcarPersonalFragment();
                changeFrame(currentFragment);
                break;
            case R.id.mCerrar:
                SharedPreferences.Editor editor = preferences.edit();

                editor.remove("usuario");
                editor.remove("usuario_nombre");
                editor.apply();

                Intent intent = new Intent(getApplicationContext(), MainActivity.class);
                intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK | Intent.FLAG_ACTIVITY_NEW_TASK);
                startActivity(intent);

                break;
            default:
                currentFragment = new MarcarPersonalFragment();
                changeFrame(currentFragment);
                break;

        }
        return true;
    }

    public void changeFrame(Fragment frm) {


        FragmentManager fragmentManager = getSupportFragmentManager();
        fragmentManager
                .beginTransaction()
                .replace(R.id.content__ah, frm)
                .commit();

        drawer.closeDrawers(); // Cerrar drawer

    }


}
