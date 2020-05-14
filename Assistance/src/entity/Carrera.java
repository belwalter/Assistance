package entity;

/**
 *
 * @author Bel Walter
 */

public class Carrera{

    private int id;
    private String nombre;
    //private Set<Catedra> catedras = new HashSet<Catedra>(0);

    public Carrera() {
    }

    public int getId() {
        return this.id;
    }
    
    public void setId(int id) {
        this.id = id;
    }

    public String getNombre() {
        return this.nombre;
    }
    
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    /*public Set<Catedra> getCatedras() {
        return this.catedras;
    }
    
    public void setCatedras(Set<Catedra> catedras) {
        this.catedras = catedras;
    }*/

}


