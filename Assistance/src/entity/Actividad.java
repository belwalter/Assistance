package entity;

/**
*
* @author Bel Walter
*/

public class Actividad  implements java.io.Serializable {

     private int id;
     private String descripcion;
     private int canthoras;
      
    public Actividad() {
    }

    public int getId() {
        return this.id;
    }
    
    public void setId(int id) {
        this.id = id;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public int getCanthoras() {
        return canthoras;
    }

    public void setCanthoras(int canthoras) {
        this.canthoras = canthoras;
    }


}


