package com.pe.polindustria.asistencia.adapters;

import android.app.AlertDialog;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.pe.polindustria.asistencia.Globales;
import com.pe.polindustria.asistencia.R;
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

public class OTAdapter2 extends BaseAdapter {

    List<ViewPersonalOT> list;
    int layout;
    Context context;
    onClickAsistencia onClickAsistencia;

    public OTAdapter2(List<ViewPersonalOT> list, int layout, Context context, OTAdapter2.onClickAsistencia onClickAsistencia) {
        this.list = list;
        this.layout = layout;
        this.context = context;
        this.onClickAsistencia = onClickAsistencia;
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
        return list.get(position).getId_ot();
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        if (convertView == null) {
            convertView = LayoutInflater.from(context).inflate(layout, parent, false);
        }

        final ViewPersonalOT ot = getItem(position);

        TextView tvCliente = convertView.findViewById(R.id.tvCliente__iot);
        TextView tvProducto = convertView.findViewById(R.id.tvProducto__iot);
        MaterialFancyButton button = convertView.findViewById(R.id.btnVerPersonal__iot);
        tvCliente.setText(ot.getCliente());
        tvProducto.setText(ot.getProducto_fabricar());

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onClickAsistencia.enviaAsistencia(ot,v);
            }
        });

        return convertView;
    }

    public interface onClickAsistencia {
        void enviaAsistencia(ViewPersonalOT ot, View view);
    }

}
