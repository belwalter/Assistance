package entity;

import java.util.Date;

/**
*
* @author Bel Walter
*/
public class Turnod  implements java.io.Serializable {

    private int id;
    private Docente docente;
    private Date hora;
    private Date fecha;
    private char tipo;

    public Turnod() {
    }

    public Turnod(Docente docente, Date hora, Date fecha, char tipo) {
        this.docente = docente;
        this.hora = hora;
        this.fecha = fecha;
        this.tipo = tipo;
    }
    
    public int getId() {
        return this.id;
    }
    
    public void setId(int id) {
        this.id = id;
    }
    
    public Docente getDocente() {
        return this.docente;
    }
    
    public void setDocente(Docente docente) {
        this.docente = docente;
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


