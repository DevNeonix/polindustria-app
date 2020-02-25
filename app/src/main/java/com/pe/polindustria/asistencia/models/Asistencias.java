package com.pe.polindustria.asistencia.models;

public class Asistencias {
    public int id;
    public int personal;
    public int orden_trabajo;
    public String fecha;
    public int usuario_registra;

    public Asistencias(int id, int personal, int orden_trabajo, String fecha, int usuario_registra) {
        this.id = id;
        this.personal = personal;
        this.orden_trabajo = orden_trabajo;
        this.fecha = fecha;
        this.usuario_registra = usuario_registra;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getPersonal() {
        return personal;
    }

    public void setPersonal(int personal) {
        this.personal = personal;
    }

    public int getOrden_trabajo() {
        return orden_trabajo;
    }

    public void setOrden_trabajo(int orden_trabajo) {
        this.orden_trabajo = orden_trabajo;
    }

    public String getFecha() {
        return fecha;
    }

    public void setFecha(String fecha) {
        this.fecha = fecha;
    }

    public int getUsuario_registra() {
        return usuario_registra;
    }

    public void setUsuario_registra(int usuario_registra) {
        this.usuario_registra = usuario_registra;
    }
}
