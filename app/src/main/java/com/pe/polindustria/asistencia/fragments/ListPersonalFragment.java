package com.pe.polindustria.asistencia.fragments;


import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.pe.polindustria.asistencia.R;

/**
 * A simple {@link Fragment} subclass.
 */
public class ListPersonalFragment extends Fragment {


    public ListPersonalFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_list_personal, container, false);
    }

}