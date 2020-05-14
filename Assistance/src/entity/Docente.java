package entity;

import java.util.Date;

/**
 *
 * @author Bel Walter
 */

public class Docente{

    private int id;
     //private Cargo cargo;
    private Catedra catedra;
    private Persona persona;
    private boolean activo;
    //private Date fechafin;
    //private Set<Turnod> turnos = new HashSet<Turnod>(0);

    public Docente() {
    }
   
    public int getId() {
        return this.id;
    }
    
    public void setId(int id) {
        this.id = id;
    }

    /*public Cargo getCargo() {
        return this.cargo;
    }
    
    public void setCargo(Cargo cargo) {
        this.cargo = cargo;
    }*/

    public Catedra getCatedra() {
        return this.catedra;
    }
    
    public void setCatedra(Catedra catedra) {
        this.catedra = catedra;
    }

    public Persona getPersona() {
        return this.persona;
    }
    
    public void setPersona(Persona persona) {
        this.persona = persona;
    }
    
    public boolean getActivo() {
        return this.activo;
    }
    
    public void setActivo(boolean activo) {
        this.activo = activo;
    }

    /*public Date getFechafin() {
        return this.fechafin;
    }
    
    public void setFechafin(Date fechafin) {
        this.fechafin = fechafin;
    }*/

    /*public Set<Turnod> getTurnos() {
        return this.turnos;
    }
    
    public void setTurnos(Set<Turnod> turnos) {
        this.turnos = turnos;
    }*/

}


