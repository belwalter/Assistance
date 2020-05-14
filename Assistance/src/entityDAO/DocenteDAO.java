package entityDAO;

import entity.Carrera;
import entity.Catedra;
import entity.Docente;
import entity.Persona;

import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import util.ConexionDB;

/**
 *
 * @author Bel Walter
 */
public class DocenteDAO {
    
    private ConexionDB con;
    private String query;
    private Statement st;
    	
    public List<Docente> buscarTodo(){
            con = new ConexionDB();
            query = "Select p.nombre, p.apellido, c.nombre, cat.nombre, ca.nombre, cat.anio From docente d, persona p, cargo c, catedra cat, carrera ca " +
                            "Where d.idcatedra=cat.id and d.idpersona=p.id and d.idcargo=c.id and cat.idcarrera=ca.id and d.fechafin is Null " +
                            "Order By ca.nombre, cat.anio, cat.nombre, p.apellido, p.nombre, c.nombre Desc";
    con.start();
    List<Docente> docentes = new ArrayList<>(0);
    try{
            st = con.getConexion().createStatement();
            ResultSet rs = st.executeQuery(query);

            while (rs.next()){
                    Persona p = new Persona();
                    p.setApellido(rs.getString(2));
                    p.setNombre(rs.getString(1));
                    Carrera ca = new Carrera();
                    ca.setNombre(rs.getString(5));
                    Catedra cat = new Catedra();
                    cat.setNombre(rs.getString(4));
                    cat.setCarrera(ca);
                    Docente d = new Docente();
                    d.setPersona(p);
                    d.setCatedra(cat);
                    docentes.add(d);
            }

            con.close();
            st.close();}
    catch(Exception e){
            docentes=null;
            System.out.println("Error al obtener lista de Docentes");}

    return docentes;
    }
    
    /*public static  List<Docente> FiltroDC(Carrera c){
        s = HibernateUtil.getSessionFactory().getCurrentSession();
        t = s.beginTransaction();
        List<Docente> Docentes = s.createCriteria(Docente.class)
                .createAlias("catedra", "c")
                .createAlias("persona", "p")
                .add(Restrictions.isNull("fechafin"))
                .add(Restrictions.eq("c.carrera",c))
                .addOrder(Order.asc("p.apellido")).list();
        return Docentes;
    }*/
    /*
    public static  List<Docente> FiltroDCat(String cadena){
        s = HibernateUtil.getSessionFactory().getCurrentSession();
        t = s.beginTransaction();
        List<Docente> Docentes = s.createCriteria(Docente.class)
        		.createAlias("persona", "p")
                .add(Restrictions.isNull("fechafin"))
                .add(Restrictions.eq("catedra",CatedraDAO.Filtro(cadena, CarreraDAO.FiltroN("Administrativo"))))
                .addOrder(Order.asc("p.apellido")).list();
        return Docentes;
    }*/
    
    /*public int FiltroCC(Cargo c){
    	int cant=0;
    	con = new ConexionDB();
    	query = "Select count(*) From docente Where fechafin is null and idcargo="+c.getId();
    	con.start();
    	
    	try{
	    	st = con.getConexion().createStatement();
	    	
	        ResultSet rs = st.executeQuery(query);
	        if (rs.next()){
	        	cant = rs.getInt(1);}
	        
	        con.close();
	        st.close();}
    	catch(Exception e){
    		System.out.println("Error al calcular la cantiad de Docentes con este Cargo");
    	}
        
    	return cant;
    }
    */
    public boolean esDocente(String dni){
        boolean control = false;
        con = new ConexionDB();
        query = "select * from docente d where d.idpersona = '"+dni+"' and d.activo"; 
        con.start();
        
        try{
            st = con.getConexion().createStatement();
	    	
            ResultSet rs = st.executeQuery(query);
            if (rs.next()){
                control=true;}

            con.close();
            st.close();}
        catch(Exception ex){
            System.out.println("Error al intentar consultar docente por dni");}
    	
        return control;
    }
    
    public List<Docente> FiltroDNI(String dni){
        List<Docente> ld = new ArrayList<>();
        con = new ConexionDB();
        query = "select c.nombre, ca.nombre, d.id, ca.id, p.dni, p.apellido, p.nombre, p.genero, c.id from docente d, catedra c, carrera ca, persona p "
                + "where d.idpersona = '"+dni+"' and d.idcatedra=c.id and c.idcarrera=ca.id and d.activo and p.dni =d.idpersona"
                +" order by ca.nombre, c.nombre"; 
        con.start();
        
        try{
            st = con.getConexion().createStatement();
            ResultSet rs = st.executeQuery(query);
            while (rs.next()){
                Docente d = new Docente();
                Carrera ca = new Carrera();
                ca.setNombre(rs.getString(2));
                ca.setId(rs.getInt(4));
                Catedra c = new Catedra();
                c.setCarrera(ca);
                c.setNombre(rs.getString(1));
                c.setId(rs.getInt(9));
                Persona p = new Persona();
                p.setDni(rs.getInt(5));
                p.setApellido(rs.getString(6));
                p.setNombre(rs.getString(7));
                p.setSexo(rs.getString(8).charAt(0));
                d.setPersona(p);
                d.setCatedra(c);
                
                d.setId(rs.getInt(3));
                ld.add(d);
                }
            
            con.close();
            st.close();}
        catch(Exception ex){
            ld = null;
            System.out.println("Error al intentar consultar docentes por dni");}
    	
        return ld;
    }
    
    public Docente FiltroDNICatedra(int dni, int idcatedra){
        Docente d = null;
        con = new ConexionDB();
        query = "select c.nombre, ca.nombre, d.id, ca.id, p.dni, p.apellido, p.nombre, p.genero, c.id from docente d, catedra c, carrera ca, persona p "
                + "where d.idpersona = '"+dni+"' and d.idcatedra=c.id and c.idcarrera=ca.id and d.activo and p.dni =d.idpersona and c.id='"+idcatedra+"'"
                +" order by ca.nombre, c.nombre"; 
        con.start();
        
        try{
            st = con.getConexion().createStatement();
            ResultSet rs = st.executeQuery(query);
            while (rs.next()){
                d = new Docente();
                Carrera ca = new Carrera();
                ca.setNombre(rs.getString(2));
                ca.setId(rs.getInt(4));
                Catedra c = new Catedra();
                c.setCarrera(ca);
                c.setNombre(rs.getString(1));
                c.setId(rs.getInt(9));
                Persona p = new Persona();
                p.setDni(rs.getInt(5));
                p.setApellido(rs.getString(6));
                p.setNombre(rs.getString(7));
                p.setSexo(rs.getString(8).charAt(0));
                d.setPersona(p);
                d.setCatedra(c);
                d.setId(rs.getInt(3));
                }
            
            con.close();
            st.close();}
        catch(Exception ex){
            System.out.println("Error al intentar consultar docentes por dni y idcatedras (compartida)");}
    	
        return d;
    }

}
