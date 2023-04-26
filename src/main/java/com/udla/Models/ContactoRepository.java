package com.udla.Models;


import javax.enterprise.context.ApplicationScoped;


import io.quarkus.mongodb.panache.PanacheMongoRepository;

@ApplicationScoped
public class ContactoRepository implements PanacheMongoRepository<Contacto>{

    public Contacto findByCedula(String cedula){
        Contacto contacto = find("cedula", cedula).firstResult();
        return contacto;
    }

}
