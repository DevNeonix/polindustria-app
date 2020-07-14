package com.pe.polindustria.asistencia.activities;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.material.dialog.MaterialAlertDialogBuilder;
import com.pe.polindustria.asistencia.Globales;
import com.pe.polindustria.asistencia.R;
import com.pe.polindustria.asistencia.adapters.OTAdapter2;
import com.pe.polindustria.asistencia.models.Response;
import com.pe.polindustria.asistencia.models.ViewPersonalOT;
import com.pe.polindustria.asistencia.services.EnviaAsistenciaService;
import com.pe.polindustria.asistencia.services.Ot2ListService;
import com.rilixtech.materialfancybutton.MaterialFancyButton;

import org.json.JSONObject;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Retrofit;

public class MarcacionPersonal extends AppCompatActivity {
    Toolbar toolbar;
    ListView lv;
    Retrofit retrofit;
    String dni;
    OTAdapter2 adapter2;
    SharedPreferences preferences;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_marcacion_personal);

        bind();

        Ot2ListService service = retrofit.create(Ot2ListService.class);
        service.listOT(dni).enqueue(new Callback<Response<List<ViewPersonalOT>>>() {
            @Override
            public void onResponse(Call<Response<List<ViewPersonalOT>>> call, retrofit2.Response<Response<List<ViewPersonalOT>>> response) {


                if (response.body().getMessage().equals("")) {
                    adapter2 = new OTAdapter2(response.body().getData(), R.layout.item_ot2, getApplicationContext(), new OTAdapter2.onClickAsistencia() {
                        @Override
                        public void enviaAsistencia(ViewPersonalOT ot, View view, Boolean viatico, String Obs) {
                            enviaAsistenciaHttp(ot, view, viatico, Obs);
                        }

                        @Override
                        public void addObservaciones(final TextView et) {
                            AlertDialog.Builder builder = new AlertDialog.Builder(MarcacionPersonal.this);
                            builder.setTitle("Ingrese las observaciones");
                            // set the custom layout
                            final View customLayout = getLayoutInflater().inflate(R.layout.dialog_edittext, null);
                            builder.setView(customLayout);

                            final EditText e = customLayout.findViewById(R.id.etAgregarObservaciones);
                            MaterialFancyButton b = customLayout.findViewById(R.id.btnGuardarObservaciones);
                            final AlertDialog dialog = builder.create();
                            dialog.show();
                            b.setOnClickListener(new View.OnClickListener() {
                                @Override
                                public void onClick(View view) {
                                    if (e.getText().equals("")){
                                        et.setText("Observaciones");
                                    }else{
                                        et.setText(e.getText());
                                    }
                                    dialog.dismiss();
                                }
                            });





                        }
                    });

                    lv.setAdapter(adapter2);
                } else {
                    Globales.customMessageDialog(MarcacionPersonal.this, "", response.body().getMessage()).show();
                }


            }

            @Override
            public void onFailure(Call<Response<List<ViewPersonalOT>>> call, Throwable t) {
                Toast.makeText(getApplicationContext(), "Error al conectarse con el servidor", Toast.LENGTH_SHORT).show();
            }
        });

    }

    private void bind() {
        toolbar = findViewById(R.id.toolbar__amp);
        lv = findViewById(R.id.lv__amp);
        retrofit = Globales.myRetrofit;
        preferences = getApplicationContext().getSharedPreferences("asistencia", MODE_PRIVATE);

        Bundle extras = getIntent().getExtras();
        if (extras != null) {
            dni = extras.getString("personal_dni");
            toolbar.setTitle("Asistencia " + dni);
        } else {
            dni = "";
            Toast.makeText(getApplicationContext(), "Vuelva escanear los datos por favor.", Toast.LENGTH_SHORT).show();
        }
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setDisplayShowHomeEnabled(true);

    }

    public void enviaAsistenciaHttp(ViewPersonalOT ot, final View view, Boolean viatico, String obs) {
        Toast.makeText(getApplicationContext(), "Enviando asistencia.", Toast.LENGTH_SHORT).show();

        EnviaAsistenciaService service = retrofit.create(EnviaAsistenciaService.class);


        service.enviaAsistencia(ot.getId_personal() + "", ot.getId_ot() + "", preferences.getString("usuario", "0") + "", viatico + "", obs)
                .enqueue(new Callback<Response<List<String>>>() {
                    @Override
                    public void onResponse(Call<Response<List<String>>> call, final retrofit2.Response<Response<List<String>>> response) {

                        Toast.makeText(getApplicationContext(), response.body().getMessage(), Toast.LENGTH_SHORT).show();
                        final AlertDialog dialog = Globales.customDialog(MarcacionPersonal.this, R.layout.success_layout, view).create();
                        dialog.show();
                        TextView tv = dialog.findViewById(R.id.tvMessage__success_layout);
                        tv.setText(response.body().getMessage());
                        dialog.findViewById(R.id.btnaceptar__success_layout).setOnClickListener(new View.OnClickListener() {
                            @Override
                            public void onClick(View v) {


                                if (response.body().getMessage().contains("No puede generarse")) {

                                } else {
                                    MarcacionPersonal.super.onBackPressed();
                                }
                                dialog.dismiss();
                            }
                        });


                    }

                    @Override
                    public void onFailure(Call<Response<List<String>>> call, Throwable t) {
                        Toast.makeText(getApplicationContext(), "Error al conectarse con el servidor", Toast.LENGTH_SHORT).show();
                    }
                });
    }
}
