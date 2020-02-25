package com.pe.polindustria.asistencia.services;

import com.pe.polindustria.asistencia.models.OT;
import com.pe.polindustria.asistencia.models.Response;
import com.pe.polindustria.asistencia.models.ViewPersonalOT;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface Ot2ListService {
    @GET("api/personal_ots")
    Call<Response<List<ViewPersonalOT>>> listOT(@Query("dni") String dni);
}
