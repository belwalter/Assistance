package entity;

/**
 *
 * @author Bel Walter
 */

public class Catedra{

    private int id;
    private Carrera carrera;
    private String nombre;
    private int anio;
    //private String plectivo;
    //private List<Docente> docentes = new ArrayList<>(0);

    public Catedra() {
    }

    public int getId() {
        return this.id;
    }
    
    public void setId(int id) {
        this.id = id;
    }
    
    public Carrera getCarrera() {
        return this.carrera;
    }
    
    public void setCarrera(Carrera carrera) {
        this.carrera = carrera;
    }
    
    public String getNombre() {
        return this.nombre;
    }
    
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    
    public int getAnio() {
        return this.anio;
    }
    
    public void setAnio(int anio) {
        this.anio = anio;
    }
    
    /*public String getPlectivo() {
        return this.plectivo;
    }
    
    public void setPlectivo(String plectivo) {
        this.plectivo = plectivo;
    }

    public List<Docente> getDocentes() {
        return this.docentes;
    }
    
    public void setDocentes(Docente docente) {
        this.docentes.add(docente);
    }*/

}


