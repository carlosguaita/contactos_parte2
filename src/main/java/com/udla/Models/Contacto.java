package com.udla.Models;


import io.quarkus.mongodb.panache.PanacheMongoEntity;

public class Contacto extends PanacheMongoEntity{

    public String cedula;
    public String nombre;
    public String direccion;
    public String telefono;

    public Contacto(String cedula, String nombre, String direccion, String telefono) {
        this.cedula = cedula;
        this.nombre = nombre;
        this.direccion = direccion;
        this.telefono = telefono;
    }

    public Contacto() {
    }

    public Contacto(ContactoDTO contacto){
        this.cedula=contacto.cedula;
        this.nombre=contacto.nombre;
        this.direccion=contacto.direccion;
        this.telefono=contacto.telefono;
    }

    

    public String getCedula() {
        return cedula;
    }

    public void setCedula(String cedula) {
        this.cedula = cedula;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    
    

}
