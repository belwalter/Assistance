package entity;

import java.util.Date;

/**
*
* @author Bel Walter
*/

public class Turnoa  implements java.io.Serializable {

     private int id;
     private Administrativo administrativo;
     private Date hora;
     private Date fecha;
     private char tipo;

    public Turnoa() {
    }

    public int getId() {
        return this.id;
    }
    
    public void setId(int id) {
        this.id = id;
    }

    public Administrativo getAdministrativo() {
        return this.administrativo;
    }
    
    public void setAdministrativo(Administrativo administrativo) {
        this.administrativo = administrativo;
    }

    public Date getHora() {
        return this.hora;
    }
    
    public void setHora(Date hora) {
        this.hora = hora;
    }
    
    public Date getFecha() {
        return this.fecha;
    }
    
    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }
    
    public char getTipo() {
        return this.tipo;
    }
    
    public void setTipo(char tipo) {
        this.tipo = tipo;
    }

}


