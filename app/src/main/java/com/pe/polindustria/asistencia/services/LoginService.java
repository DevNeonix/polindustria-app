package com.pe.polindustria.asistencia.services;

import com.pe.polindustria.asistencia.models.LoginResponse;
import com.pe.polindustria.asistencia.models.Response;
import com.pe.polindustria.asistencia.models.Login;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.POST;

public interface LoginService {
    @POST("api/login")
    Call<Response> login(@Body Login login);
}
