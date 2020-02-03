package com.pe.polindustria.asistencia.activities;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;

import android.Manifest;
import android.app.Person;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.pm.PackageManager;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.material.textfield.TextInputEditText;
import com.google.gson.Gson;
import com.pe.polindustria.asistencia.Globales;
import com.pe.polindustria.asistencia.R;
import com.pe.polindustria.asistencia.models.LoginResponse;
import com.pe.polindustria.asistencia.models.Login;
import com.pe.polindustria.asistencia.models.Personal;
import com.pe.polindustria.asistencia.models.Response;
import com.pe.polindustria.asistencia.services.LoginService;
import com.rilixtech.materialfancybutton.MaterialFancyButton;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Retrofit;

public class MainActivity extends AppCompatActivity {
    EditText etUsuario;
    EditText etPassword;
    MaterialFancyButton btnIngresar;
    Retrofit retrofit;
    SharedPreferences preferences;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        bind();
        chkPermisos();
    }

    private void chkPermisos() {
        if (ContextCompat.checkSelfPermission(this, Manifest.permission.CAMERA) != PackageManager.PERMISSION_GRANTED) {
            ActivityCompat.requestPermissions(this, new String[]{Manifest.permission.CAMERA}, 50);
        }

    }

    private void bind() {
        preferences = getApplicationContext().getSharedPreferences("asistencia", MODE_PRIVATE);

        if (preferences.getString("usuario", "").trim() != "") {
            goToHome();
        }


        etUsuario = (EditText) findViewById(R.id.etUsuario__am);
        etPassword = (EditText) findViewById(R.id.etPassword__am);
        btnIngresar = findViewById(R.id.btnIngresar__am);


        btnIngresar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(MainActivity.this, "Autenticando...", Toast.LENGTH_SHORT).show();
                retrofit = Globales.myRetrofit;
                LoginService loginService = retrofit.create(LoginService.class);
                String u = etUsuario.getText().toString();
                String p = etPassword.getText().toString();

                loginService.login(new Login(u, p)).enqueue(new Callback<Response>() {
                    @Override
                    public void onResponse(Call<Response> call, retrofit2.Response<Response> response) {
                        if (response.isSuccessful()) {
                            Toast.makeText(MainActivity.this, response.body().getMessage(), Toast.LENGTH_SHORT).show();


                            SharedPreferences.Editor editor = preferences.edit();

                            Personal personal = new Gson().fromJson(response.body().getData().toString(), Personal.class);
                            Log.i("User ID", personal.getId() + "");
                            editor.putString("usuario", personal.getId() + "");
                            editor.apply();

                            goToHome();

                        } else {
                            Toast.makeText(MainActivity.this, "Usuario o contraseña errada", Toast.LENGTH_SHORT).show();
                        }


                    }

                    @Override
                    public void onFailure(Call<Response> call, Throwable t) {
                        Toast.makeText(MainActivity.this, "No se pudo establecer conexion con el servidor", Toast.LENGTH_SHORT).show();
                    }
                });

            }
        });
    }

    private void goToHome() {
        Intent intent = new Intent(getApplicationContext(), HomeActivity.class);
        intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK | Intent.FLAG_ACTIVITY_NEW_TASK);
        startActivity(intent);
    }


}

