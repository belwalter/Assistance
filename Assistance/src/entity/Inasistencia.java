package entity;

import java.util.Date;

/**
*
* @author Bel Walter
*/

public class Inasistencia  implements java.io.Serializable {

     private int id;
     private Persona persona;
     private Persona carga;
     private Date fechaaviso;
     private Date fechafalta;
     private boolean aviso;
     private String causa;
     
     private Recupera recupera;
     private Actividad actividad;
      
    public Inasistencia() {
    }

    public int getId() {
        return this.id;
    }
    
    public void setId(int id) {
        this.id = id;
    }

    public Persona getPersona() {
        return persona;
    }

    public void setPersona(Persona persona) {
        this.persona = persona;
    }
    
    public Persona getCarga() {
        return carga;
    }

    public void setCarga(Persona carga) {
        this.carga = carga;
    }

    public Date getFechaaviso() {
        return fechaaviso;
    }

    public void setFechaaviso(Date fechaaviso) {
        this.fechaaviso = fechaaviso;
    }

    public Date getFechafalta() {
        return fechafalta;
    }

    public void setFechafalta(Date fechafalta) {
        this.fechafalta = fechafalta;
    }

    public boolean isAviso() {
        return aviso;
    }

    public void setAviso(boolean aviso) {
        this.aviso = aviso;
    }

    public String getCausa() {
        return causa;
    }

    public void setCausa(String causa) {
        this.causa = causa;
    }

    public Recupera getRecupera() {
        return recupera;
    }

    public void setRecupera(Recupera recupera) {
        this.recupera = recupera;
    }

    public Actividad getActividad() {
        return actividad;
    }

    public void setActividad(Actividad actividad) {
        this.actividad = actividad;
    }
   

}


