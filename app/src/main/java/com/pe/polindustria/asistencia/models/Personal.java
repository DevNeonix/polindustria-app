package com.pe.polindustria.asistencia.models;

public class Personal {
    int id;
    String nombre;
    String doc_ide;
    int tipo;
    String usuario;
    String clave;

    public Personal(int id, String nombre, String doc_ide, int tipo, String usuario, String clave) {
        this.id = id;
        this.nombre = nombre;
        this.doc_ide = doc_ide;
        this.tipo = tipo;
        this.usuario = usuario;
        this.clave = clave;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
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

    public String getUsuario() {
        return usuario;
    }

    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }

    public String getClave() {
        return clave;
    }

    public void setClave(String clave) {
        this.clave = clave;
    }
}
