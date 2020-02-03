package com.pe.polindustria.asistencia.models;

public class ViewPersonalOT {
    int id_personal;
    String nombre;
    String doc_ide;
    int tipo;
    int id_ot;
    String nro_orden;
    String producto_fabricar;
    String cliente;
    int estado;

    public ViewPersonalOT(int id_personal, String nombre, String doc_ide, int tipo, int id_ot, String nro_orden, String producto_fabricar, String cliente, int estado) {
        this.id_personal = id_personal;
        this.nombre = nombre;
        this.doc_ide = doc_ide;
        this.tipo = tipo;
        this.id_ot = id_ot;
        this.nro_orden = nro_orden;
        this.producto_fabricar = producto_fabricar;
        this.cliente = cliente;
        this.estado = estado;
    }

    public int getId_personal() {
        return id_personal;
    }

    public void setId_personal(int id_personal) {
        this.id_personal = id_personal;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDoc_ide() {
        return doc_ide;
    }

    public void setDoc_ide(String doc_ide) {
        this.doc_ide = doc_ide;
    }

    public int getTipo() {
        return tipo;
    }

    public void setTipo(int tipo) {
        this.tipo = tipo;
    }

    public int getId_ot() {
        return id_ot;
    }

    public void setId_ot(int id_ot) {
        this.id_ot = id_ot;
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
