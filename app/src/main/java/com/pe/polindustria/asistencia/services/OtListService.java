package com.pe.polindustria.asistencia.services;

import com.pe.polindustria.asistencia.models.Login;
import com.pe.polindustria.asistencia.models.OT;
import com.pe.polindustria.asistencia.models.Response;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.POST;

public interface OtListService {
    @GET("api/ots")
    Call<Response<List<OT>>> listOT();
}
