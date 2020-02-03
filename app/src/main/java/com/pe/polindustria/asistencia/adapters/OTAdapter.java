package com.pe.polindustria.asistencia.adapters;

import android.app.AlertDialog;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Adapter;
import android.widget.ArrayAdapter;
import android.widget.BaseAdapter;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.TextView;

import androidx.core.view.ViewCompat;

import com.pe.polindustria.asistencia.Globales;
import com.pe.polindustria.asistencia.R;
import com.pe.polindustria.asistencia.models.OT;
import com.pe.polindustria.asistencia.models.Response;
import com.pe.polindustria.asistencia.models.ViewPersonalOT;
import com.pe.polindustria.asistencia.services.PersonalOTListService;
import com.rilixtech.materialfancybutton.MaterialFancyButton;

import org.w3c.dom.Text;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Retrofit;

public class OTAdapter extends BaseAdapter {

    List<OT> list;
    int layout;
    Context context;

    public OTAdapter(List<OT> list, int layout, Context context) {
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
                AlertDialog dialog = Globales.customDialog(context, R.layout.dialog_personallist, v).create();
                dialog.show();
                TextView tv = dialog.findViewById(R.id.tv__dpl);
                final LinearLayout ll = dialog.findViewById(R.id.ll__dpl);


                tv.setText("Listado del personal: " + ot.getCliente() + " " + ot.getProducto_fabricar());

                Retrofit retrofit = Globales.myRetrofit;
                PersonalOTListService service = retrofit.create(PersonalOTListService.class);
                final List<String> personalList = new ArrayList<>();
                service.listOTPersonal(ot.getId()).enqueue(new Callback<Response<List<ViewPersonalOT>>>() {
                    @Override
                    public void onResponse(Call<Response<List<ViewPersonalOT>>> call, retrofit2.Response<Response<List<ViewPersonalOT>>> response) {
                        for (ViewPersonalOT p :
                                response.body().getData()) {

                            View vi = LayoutInflater.from(context).inflate(android.R.layout.simple_list_item_1, null);
                            TextView txtPersonal = vi.findViewById(android.R.id.text1);
                            txtPersonal.setText(p.getNombre());
                            ll.addView(vi);


                        }

                    }

                    @Override
                    public void onFailure(Call<Response<List<ViewPersonalOT>>> call, Throwable t) {

                    }
                });


            }
        });

        tvCliente.setText(ot.getCliente());
        tvProducto.setText(ot.getProducto_fabricar());

        return convertView;
    }
}
