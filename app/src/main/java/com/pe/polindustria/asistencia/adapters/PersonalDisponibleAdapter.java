package com.pe.polindustria.asistencia.adapters;

import android.content.Context;
import android.graphics.Color;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.LinearLayout;
import android.widget.Switch;
import android.widget.TextView;

import com.pe.polindustria.asistencia.R;
import com.pe.polindustria.asistencia.models.Asistencias;
import com.pe.polindustria.asistencia.models.ViewPersonalOT;
import com.pe.polindustria.asistencia.models.ViewPersonalOTDisponible;

import java.util.List;

public class PersonalDisponibleAdapter extends BaseAdapter {

    List<ViewPersonalOTDisponible> list;
    int layout;
    Context context;
    Boolean valueChecked = false;

    public PersonalDisponibleAdapter(List<ViewPersonalOTDisponible> list, int layout, Context context) {
        this.list = list;
        this.layout = layout;
        this.context = context;
    }

    public PersonalDisponibleAdapter(List<ViewPersonalOTDisponible> list, int layout, Context context, Boolean valueChecked) {
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
    public ViewPersonalOTDisponible getItem(int position) {
        return list.get(position);
    }

    @Override
    public long getItemId(int position) {
        return list.get(position).getId_personal();
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
//        if (convertView == null) {
        convertView = LayoutInflater.from(context).inflate(layout, parent, false);
//        }
        final ViewPersonalOTDisponible ot = getItem(position);

        TextView tv;
        Switch sw;
        LinearLayout ll;

        tv = convertView.findViewById(R.id.tv__ipm);
        sw = convertView.findViewById(R.id.switch__ipm);
        ll = convertView.findViewById(R.id.ll__ipm);
        sw.setChecked(valueChecked);
        tv.setText(ot.getNombre());

        int i = 0;
        for (Asistencias p :
                ot.getIngresos()) {

            View vi = LayoutInflater.from(context).inflate(android.R.layout.simple_list_item_1, parent, false);
            TextView txtPersonal = vi.findViewById(android.R.id.text1);

            String estado = i % 2 == 0 ? "Ingresó" : "Salió";

            txtPersonal.setText(estado + " " + p.getFecha().substring(0, 16));
            txtPersonal.setTextColor(Color.parseColor("#494949"));
            ll.addView(vi);

            i = i + 1;
        }


        return convertView;
    }


}
