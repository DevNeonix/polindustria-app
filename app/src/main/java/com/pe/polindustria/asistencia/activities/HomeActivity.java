package com.pe.polindustria.asistencia.activities;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;

import android.os.Bundle;
import android.os.PersistableBundle;
import android.view.MenuItem;
import android.widget.Toast;

import com.google.android.material.navigation.NavigationView;
import com.pe.polindustria.asistencia.R;
import com.pe.polindustria.asistencia.fragments.ListOtsFragment;
import com.pe.polindustria.asistencia.fragments.ListPersonalFragment;
import com.pe.polindustria.asistencia.fragments.MarcarOTFragment;
import com.pe.polindustria.asistencia.fragments.MarcarPersonalFragment;

public class HomeActivity extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener {
    DrawerLayout drawer;
    NavigationView navigationView;
    Toolbar toolbar;
    Fragment currentFragment;

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


        navigationView.setNavigationItemSelectedListener(this);

    }


    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {
        switch (menuItem.getItemId()) {
            case R.id.mOts:
                currentFragment = new ListOtsFragment();
                changeFrame(currentFragment);
                break;
            case R.id.mPersonal:
                currentFragment = new ListPersonalFragment();
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
