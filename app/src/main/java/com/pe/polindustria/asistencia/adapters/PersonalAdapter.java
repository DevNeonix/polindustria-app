package com.pe.polindustria.asistencia.adapters;

import android.app.AlertDialog;
import android.app.Person;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.LinearLayout;
import android.widget.Switch;
import android.widget.TextView;

import com.pe.polindustria.asistencia.Globales;
import com.pe.polindustria.asistencia.R;
import com.pe.polindustria.asistencia.models.OT;
import com.pe.polindustria.asistencia.models.Personal;
import com.pe.polindustria.asistencia.models.Response;
import com.pe.polindustria.asistencia.models.ViewPersonalOT;
import com.pe.polindustria.asistencia.services.PersonalOTListService;
import com.rilixtech.materialfancybutton.MaterialFancyButton;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Retrofit;

public class PersonalAdapter extends BaseAdapter {

    List<ViewPersonalOT> list;
    int layout;
    Context context;
    Boolean valueChecked = false;

    public PersonalAdapter(List<ViewPersonalOT> list, int layout, Context context) {
        this.list = list;
        this.layout = layout;
        this.context = context;
    }

    public PersonalAdapter(List<ViewPersonalOT> list, int layout, Context context, Boolean valueChecked) {
        this.list = list;
        this.layout = layout;
        this.context = context;
        this.valueChecked = valueChecked;
    }

    @Override
    public int getCount() {
        return list.size();
    }

    @Override
    public ViewPersonalOT getItem(int position) {
        return list.get(position);
    }

    @Override
    public long getItemId(int position) {
        return list.get(position).getId_personal();
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        if (convertView == null) {
            convertView = LayoutInflater.from(context).inflate(layout, parent, false);
        }
        final ViewPersonalOT ot = getItem(position);

        TextView tv;
        Switch sw;

        tv = convertView.findViewById(R.id.tv__ipm);
        sw = convertView.findViewById(R.id.switch__ipm);

        sw.setChecked(valueChecked);

        tv.setText(ot.getNombre());


        return convertView;
    }


}
