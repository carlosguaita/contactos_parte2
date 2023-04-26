package com.udla.Controllers;

import java.util.ArrayList;
import java.util.List;

import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import com.oracle.svm.core.annotate.Inject;
import com.udla.Models.Contacto;
import com.udla.Models.ContactoDTO;
import com.udla.Models.ContactoRepository;



@Path("/v1/api")
public class ApiController {

    @Inject
    ContactoRepository _repository;

    public ApiController(ContactoRepository repository){
        this._repository=repository;
    }

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Response hello() {
        //return Response.ok(Utils.listaContactos).build();
        List<Contacto> listaContactos = _repository.listAll();
        List<ContactoDTO> listaContactosDto =  new ArrayList<ContactoDTO>();
        for (Contacto contacto: listaContactos){
            listaContactosDto.add(new ContactoDTO(contacto));
        } 
        return Response.ok(listaContactosDto).build();
    }

    @GET
    @Path("{cedula}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response getContacto(@PathParam(value = "cedula") String cedula) {
        //Contacto contacto = Utils.listaContactos.stream().filter(x->x.getCedula().equals(cedula)).findAny().orElse(null);
        Contacto contacto = _repository.findByCedula(cedula);
        
        if (contacto!=null){
            return Response.ok(new ContactoDTO(contacto)).build();
        }else{
            return Response.status(Response.Status.BAD_REQUEST).build();
        }
    }

    @POST
    @Produces(MediaType.APPLICATION_JSON)
    public Response guardarContacto(ContactoDTO contactoDto){

        //Utils.listaContactos.add(contacto);
        //Contacto.persist(contacto);
        _repository.persist(new Contacto(contactoDto));

        return Response.ok(contactoDto).build();
    }

    @PUT
    @Path("{cedula}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response actualizarContacto(@PathParam(value = "cedula") String cedula, ContactoDTO contactoDto){
        //Contacto contactoObtenido = Utils.listaContactos.stream().filter(x->x.getCedula().equals(cedula)).findAny().orElse(null);
        Contacto contactoObtenido = _repository.findByCedula(cedula);
        if (contactoObtenido!=null){
            contactoObtenido.setNombre(contactoDto.nombre);
            contactoObtenido.setDireccion(contactoDto.direccion);
            contactoObtenido.setTelefono(contactoDto.telefono);
            _repository.update(contactoObtenido);
            return Response.ok(contactoDto).build();
        }else{
            return Response.status(Response.Status.BAD_REQUEST).build();
        }

    }

    @DELETE
    @Path("{cedula}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response borrarContacto(@PathParam(value = "cedula") String cedula){
        //Contacto contactoObtenido = Utils.listaContactos.stream().filter(x->x.getCedula().equals(cedula)).findAny().orElse(null);
        Contacto contactoObtenido = _repository.findByCedula(cedula);
        if (contactoObtenido!=null){
            //Utils.listaContactos.remove(contactoObtenido);
            _repository.delete(contactoObtenido);
            return Response.status(Response.Status.NO_CONTENT).build();
        }else{
            return Response.status(Response.Status.BAD_REQUEST).build();
        }

    }

}