package com.pe.polindustria.asistencia;

import android.app.AlertDialog;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class Globales {

    public static Retrofit myRetrofit = new Retrofit.Builder()
            .baseUrl("http://192.168.1.2:8000/")
            .addConverterFactory(GsonConverterFactory.create())
            .build();

    public static AlertDialog.Builder customDialog(Context context, int layout, View v) {
        AlertDialog.Builder builder = new AlertDialog.Builder(context);
        ViewGroup viewGroup = v.findViewById(android.R.id.content);
        View dialogView = LayoutInflater.from(v.getContext()).inflate(layout, viewGroup, false);
        builder.setView(dialogView);
        return builder;
    }
}
