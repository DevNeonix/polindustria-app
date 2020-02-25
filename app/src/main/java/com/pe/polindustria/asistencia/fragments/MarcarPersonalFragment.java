package com.pe.polindustria.asistencia.fragments;


import android.content.Intent;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.Toast;

import com.budiyev.android.codescanner.AutoFocusMode;
import com.budiyev.android.codescanner.CodeScanner;
import com.budiyev.android.codescanner.CodeScannerView;
import com.budiyev.android.codescanner.DecodeCallback;
import com.budiyev.android.codescanner.ScanMode;
import com.google.zxing.Result;
import com.pe.polindustria.asistencia.R;
import com.pe.polindustria.asistencia.activities.MarcacionPersonal;
import com.rilixtech.materialfancybutton.MaterialFancyButton;

/**
 * A simple {@link Fragment} subclass.
 */
public class MarcarPersonalFragment extends Fragment {


    private View view;
    CodeScannerView scannerView;
    CodeScanner codeScanner;
    EditText etDni;
    MaterialFancyButton btnEnviar;

    public MarcarPersonalFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        view = inflater.inflate(R.layout.fragment_marcar_personal, container, false);
        btnEnviar = view.findViewById(R.id.btn__fmp);
        scannerView = view.findViewById(R.id.scanner_view);
        codeScanner = new CodeScanner(getContext(), scannerView);
        codeScanner.setCamera(CodeScanner.CAMERA_BACK); // or CAMERA_FRONT or specific camera id
        codeScanner.setFormats(CodeScanner.ALL_FORMATS); // list of type BarcodeFormat,
        // ex. listOf(BarcodeFormat.QR_CODE)
        codeScanner.setAutoFocusMode(AutoFocusMode.SAFE); // or CONTINUOUS
        codeScanner.setScanMode(ScanMode.SINGLE); // or CONTINUOUS or PREVIEW
        codeScanner.setAutoFocusEnabled(true); // Whether to enable auto focus or not
        codeScanner.setFlashEnabled(false); // Whether to enable flash or not


        etDni = view.findViewById(R.id.etDni__fmp);


        codeScanner.setDecodeCallback(new DecodeCallback() {
            @Override
            public void onDecoded(@NonNull final Result result) {
                getActivity().runOnUiThread(new Runnable() {
                    @Override
                    public void run() {
                        Toast.makeText(getActivity(), result.getText(), Toast.LENGTH_SHORT).show();
                        etDni.setText(result.getText());
                        goToMarcacion(result.getText());

                    }
                });

            }
        });
        scannerView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                codeScanner.startPreview();
            }
        });


        btnEnviar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                goToMarcacion(etDni.getText().toString());

            }
        });

        return view;
    }

    @Override
    public void onResume() {
        super.onResume();
        codeScanner.startPreview();
        if (etDni != null) {
            etDni.setText("");
        }

    }

    @Override
    public void onPause() {
        super.onPause();
        codeScanner.releaseResources();

    }

    public void goToMarcacion(String dni) {
        if (etDni.getText().toString().equals("")) {
            Toast.makeText(getContext(), "Necesitas colocar|escanear el DNI", Toast.LENGTH_SHORT).show();
        } else {
            Intent intent = new Intent(getActivity(), MarcacionPersonal.class);
            intent.putExtra("personal_dni", dni);
            startActivity(intent);
        }
    }

}
