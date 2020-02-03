package com.pe.polindustria.asistencia.models;

public class OT {
    int id;
    String nro_orden;
    String producto_fabricar;
    String cliente;
    int estado;

    public OT(int id, String nro_orden, String producto_fabricar, String cliente, int estado) {
        this.id = id;
        this.nro_orden = nro_orden;
        this.producto_fabricar = producto_fabricar;
        this.cliente = cliente;
        this.estado = estado;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNro_orden() {
        return nro_orden;
    }

    public void setNro_orden(String nro_orden) {
        this.nro_orden = nro_orden;
    }

    public String getProducto_fabricar() {
        return producto_fabricar;
    }

    public void setProducto_fabricar(String producto_fabricar) {
        this.producto_fabricar = producto_fabricar;
    }

    public String getCliente() {
        return cliente;
    }

    public void setCliente(String cliente) {
        this.cliente = cliente;
    }

    public int getEstado() {
        return estado;
    }

    public void setEstado(int estado) {
        this.estado = estado;
    }
}
