package com.pe.polindustria.asistencia.fragments;


import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;
import android.widget.ProgressBar;
import android.widget.Toast;

import com.pe.polindustria.asistencia.Globales;
import com.pe.polindustria.asistencia.R;
import com.pe.polindustria.asistencia.adapters.OTAdapter;
import com.pe.polindustria.asistencia.models.OT;
import com.pe.polindustria.asistencia.models.Response;
import com.pe.polindustria.asistencia.services.OtListService;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Retrofit;

/**
 * A simple {@link Fragment} subclass.
 */
public class ListOtsFragment extends Fragment {


    private View view;
    List<OT> list;
    ListView lv;
    Retrofit retrofit;
    ProgressBar pb_flo;
    public ListOtsFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        view = inflater.inflate(R.layout.fragment_list_ots, container, false);
        lv = view.findViewById(R.id.lv__flo);
        pb_flo = view.findViewById(R.id.pb_flo);
        retrofit = Globales.myRetrofit;

        OtListService service = retrofit.create(OtListService.class);
        service.listOT().enqueue(new Callback<Response<List<OT>>>() {
            @Override
            public void onResponse(Call<Response<List<OT>>> call, retrofit2.Response<Response<List<OT>>> response) {


                OTAdapter adapter = new OTAdapter(response.body().getData(), R.layout.item_ot, getContext());
                pb_flo.setVisibility(View.GONE);
                lv.setVisibility(View.VISIBLE);
                lv.setAdapter(adapter);

//
            }

            @Override
            public void onFailure(Call<Response<List<OT>>> call, Throwable t) {
                Toast.makeText(getContext(), "No se pudo establecer conexión con el servidor.", Toast.LENGTH_SHORT).show();
            }
        });


        return view;
    }


}
