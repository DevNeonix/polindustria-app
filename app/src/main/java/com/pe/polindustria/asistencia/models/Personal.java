package com.pe.polindustria.asistencia.models;

public class Personal {
    int id;
    String nombres;
    String apellidos;
    String doc_ide;
    String tipo;
    String usuario;
    String clave;

    public Personal(int id, String nombres, String apellidos, String doc_ide, String tipo, String usuario, String clave) {
        this.id = id;
        this.nombres = nombres;
        this.apellidos = apellidos;
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

    public String getNombres() {
        return nombres;
    }

    public void setNombres(String nombres) {
        this.nombres = nombres;
    }

    public String getApellidos() {
        return apellidos;
    }

    public void setApellidos(String apellidos) {
        this.apellidos = apellidos;
    }

    public String getDoc_ide() {
        return doc_ide;
    }

    public void setDoc_ide(String doc_ide) {
        this.doc_ide = doc_ide;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
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
