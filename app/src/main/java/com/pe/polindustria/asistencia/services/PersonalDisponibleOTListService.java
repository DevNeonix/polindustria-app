package com.pe.polindustria.asistencia.services;

import com.pe.polindustria.asistencia.models.Response;
import com.pe.polindustria.asistencia.models.ViewPersonalOT;
import com.pe.polindustria.asistencia.models.ViewPersonalOTDisponible;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface PersonalDisponibleOTListService {
    @GET("api/ots_personal_disponible")
    Call<Response<List<ViewPersonalOTDisponible>>> listOTPersonal(@Query("ot") int ot);
}
