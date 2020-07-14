package com.pe.polindustria.asistencia.services;

import com.pe.polindustria.asistencia.models.LoginResponse;
import com.pe.polindustria.asistencia.models.Personal;
import com.pe.polindustria.asistencia.models.Response;
import com.pe.polindustria.asistencia.models.Login;
import com.pe.polindustria.asistencia.models.User;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.POST;

public interface LoginService {
    @POST("api/login")
    Call<Response<User>> login(@Body Login login);
}
