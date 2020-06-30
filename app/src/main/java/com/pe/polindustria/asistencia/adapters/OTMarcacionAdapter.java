package com.pe.polindustria.asistencia.adapters;

import android.app.AlertDialog;
import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.CheckBox;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.pe.polindustria.asistencia.Globales;
import com.pe.polindustria.asistencia.R;
import com.pe.polindustria.asistencia.activities.MarcacionPersonalOTActivity;
import com.pe.polindustria.asistencia.models.OT;
import com.pe.polindustria.asistencia.models.Response;
import com.pe.polindustria.asistencia.models.ViewPersonalOT;
import com.pe.polindustria.asistencia.services.PersonalOTListService;
import com.rilixtech.materialfancybutton.MaterialFancyButton;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Retrofit;

public class OTMarcacionAdapter extends BaseAdapter {

    List<OT> list;
    int layout;
    Context context;

    public OTMarcacionAdapter(List<OT> list, int layout, Context context) {
        this.list = list;
        this.layout = layout;
        this.context = context;
    }

    @Override
    public int getCount() {
        return list.size();
    }

    @Override
    public OT getItem(int position) {
        return list.get(position);
    }

    @Override
    public long getItemId(int position) {
        return list.get(position).getId();
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        if (convertView == null) {
            convertView = LayoutInflater.from(context).inflate(layout, parent, false);
        }
        final OT ot = getItem(position);

        TextView tvCliente = convertView.findViewById(R.id.tvCliente__iot);
        TextView tvProducto = convertView.findViewById(R.id.tvProducto__iot);


        MaterialFancyButton button = convertView.findViewById(R.id.btnVerPersonal__iot);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(context, "Seleccionaste la ot #" + ot.getNro_orden(), Toast.LENGTH_SHORT).show();
                Intent intent = new Intent(context, MarcacionPersonalOTActivity.class);
                context.startActivity(intent);

            }
        });

        tvCliente.setText(ot.getNro_orden() + ": " + ot.getCliente());
        tvProducto.setText(ot.getProducto_fabricar());

        return convertView;
    }
}
