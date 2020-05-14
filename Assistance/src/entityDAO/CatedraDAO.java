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

public class CatedraDAO {
    
	private ConexionDB con;
	private String query;
	private Statement st;
    
    /*public static void Guardar(Catedra c){
        s = HibernateUtil.getSessionFactory().getCurrentSession();
        t = s.beginTransaction();
        try{
            s.save(c);
            t.commit();}
        catch(HibernateException he){
            t.rollback();
            throw he;
        }
    }*/
    
    /*public static List<Catedra> buscarTodo(){
        s = HibernateUtil.getSessionFactory().getCurrentSession();
        t = s.beginTransaction();
        Query q = s.createQuery("from Catedra");
        List<Catedra> Catedras = (List<Catedra>) q.list();
        return Catedras;
    }*/
    
    public List<Catedra> Filtro(Carrera car){
    	con = new ConexionDB();
    	query = "Select * From catedra Where idcarrera='"+car.getId()+"' Order By anio, nombre";
    	con.start();
    	List<Catedra> catedras = new ArrayList<>(0);
    	
    	try{
	    	st = con.getConexion().createStatement();
	    	
	        ResultSet rs = st.executeQuery(query);
	        while (rs.next()){
	        	Catedra c = new Catedra();
	        	c.setId(rs.getInt("id"));
	        	c.setNombre(rs.getString("nombre"));
	        	c.setAnio(rs.getInt("anio"));
	        	//c.setPlectivo(rs.getString("plectivo"));
	        	catedras.add(c);}
	        
	        con.close();
	        st.close();}
    	catch(Exception e){
    		catedras=null;
    		System.out.println("Error al intentar obtener lista de Catedras");}
        
    	return catedras;
    }
    
    public Catedra Filtro(String nombre, Carrera c){
    	con = new ConexionDB();
    	query = "Select * From catedra Where nombre='"+nombre+"' and idcarrera='"+c.getId()+"'";
    	con.start();
    	Catedra cat = new Catedra();
    	
    	try{
	    	st = con.getConexion().createStatement();
	    	
	        ResultSet rs = st.executeQuery(query);
	        if (rs.next()){
	        	cat.setId(rs.getInt("id"));
	        	cat.setNombre(rs.getString("nombre"));}
	        query = "Select p.nombre, p.apellido, c.nombre, d.id From docente d, persona p, cargo c Where d.idcatedra='"+cat.getId()+"' and d.idpersona=p.id and d.idcargo=c.id and d.fechafin is Null Order By c.nombre Desc";
	        
	        rs = st.executeQuery(query);
	        while (rs.next()){
	        	Persona p = new Persona();
	        	p.setApellido(rs.getString(2));
	        	p.setNombre(rs.getString(1));
	        	Docente d = new Docente();
	        	d.setPersona(p);
	        	//cat.setDocentes(d);
	        }
	        con.close();
	        st.close();}
    	catch(Exception e){
    		cat=null;
    		System.out.println("Error al filtrar Catedra por nombre y Carrera");}
        
    	return cat;
    }
    
    public boolean esCompartida(int id){
        boolean control = false;
        con = new ConexionDB();
        query = "select * from compartida c where c.idcatedra1 = '"+id+"'"; 
        con.start();
        
        try{
            st = con.getConexion().createStatement();
	    	
            ResultSet rs = st.executeQuery(query);
            if (rs.next()){
                control=true;}

            con.close();
            st.close();}
        catch(Exception ex){
            System.out.println("Error al intentar consultar si la catedra es compartida");}
        return control;
    }
    
    public List<Integer> listaCompartida(int idcatedra1){
    	con = new ConexionDB();
    	query = "Select idcatedra2 From compartida Where idcatedra1='"+idcatedra1+"'";
    	con.start();
    	List<Integer> listaid = new ArrayList<>(0);
    	
    	try{
	    	st = con.getConexion().createStatement();
	    	
	        ResultSet rs = st.executeQuery(query);
	        while (rs.next()){
	        	//Integer i = new Integer(rs.getInt("idcatedra2"));
	        	listaid.add(rs.getInt("idcatedra2"));}
	        
	        con.close();
	        st.close();}
    	catch(Exception e){
    		listaid=null;
    		System.out.println("Error al intentar obtener lista de id de Catedras Compartidas");}
        
    	return listaid;
    }
    
  /*  public static Catedra buscarId(int id){
        s = HibernateUtil.getSessionFactory().getCurrentSession();
        t = s.beginTransaction();
        Catedra c = (Catedra) s.load(Catedra.class, id);
        return c;
    }*/
    
    /*public static void Actualizar(Catedra c) { 
        s = HibernateUtil.getSessionFactory().getCurrentSession();
        t = s.beginTransaction();
        try{ 
            s.update(c);
            t.commit(); 
        }catch (HibernateException he){ 
            t.rollback();
            throw he; 
        }
    }*/
}
