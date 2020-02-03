package com.pe.polindustria.asistencia.services;

import com.pe.polindustria.asistencia.models.OT;
import com.pe.polindustria.asistencia.models.Response;
import com.pe.polindustria.asistencia.models.ViewPersonalOT;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface PersonalOTListService {
    @GET("api/ots_personal")
    Call<Response<List<ViewPersonalOT>>> listOTPersonal(@Query("ot") int ot);
}
