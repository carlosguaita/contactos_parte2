package com.udla.Models;

public class ContactoDTO {

    public String cedula;
    public String nombre;
    public String direccion;
    public String telefono;

    public ContactoDTO(String cedula, String nombre, String direccion, String telefono) {
        this.cedula = cedula;
        this.nombre = nombre;
        this.direccion = direccion;
        this.telefono = telefono;
    }

    public ContactoDTO(Contacto contacto){
        this.cedula=contacto.cedula;
        this.nombre=contacto.nombre;
        this.direccion=contacto.direccion;
        this.telefono=contacto.telefono;
    }

    
    
}
