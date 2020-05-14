package entity;

import java.util.Date;

/**
 *
 * @author Bel Walter
 */

public class Recupera{

    private int id;
    private Date fecha;
    private int canthoras;

    public Recupera() {
    }

    public int getId() {
        return this.id;
    }
    
    public void setId(int id) {
        this.id = id;
    }

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    public int getCanthoras() {
        return canthoras;
    }

    public void setCanthoras(int canthoras) {
        this.canthoras = canthoras;
    }
    
    
}


