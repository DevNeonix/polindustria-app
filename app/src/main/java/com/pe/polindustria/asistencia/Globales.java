package com.pe.polindustria.asistencia;

import android.app.AlertDialog;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class Globales {
    int icon = android.R.drawable.ic_dialog_alert;
    public static Retrofit myRetrofit = new Retrofit.Builder()
            .baseUrl("http://ok.polindustria.com.pe/asistencia/public/")
            .addConverterFactory(GsonConverterFactory.create())
            .build();

    public static AlertDialog.Builder customDialog(Context context, int layout, View v) {
        AlertDialog.Builder builder = new AlertDialog.Builder(context);
        ViewGroup viewGroup = v.findViewById(android.R.id.content);
        View dialogView = LayoutInflater.from(v.getContext()).inflate(layout, viewGroup, false);
        builder.setView(dialogView);
        return builder;
    }

    public static AlertDialog.Builder customMessageDialog(Context context, String title, String message) {

        AlertDialog.Builder builder = new AlertDialog.Builder(context)
                .setTitle(title)
                .setMessage(message)
                .setNegativeButton(android.R.string.no, null)
                .setIcon(android.R.drawable.ic_dialog_alert);
        return builder;
    }
    public static AlertDialog.Builder customMessageDialog(Context context, String title, String message,int icon) {

        AlertDialog.Builder builder = new AlertDialog.Builder(context)
                .setTitle(title)
                .setMessage(message)
                .setNegativeButton(android.R.string.no, null)
                .setIcon(icon);
        return builder;
    }

}
