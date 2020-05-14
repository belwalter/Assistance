package entityDAO;

import entity.Carrera;

import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import util.ConexionDB;

/**
 *
 * @author Bel Walter
 */

public class CarreraDAO {
    
	private ConexionDB con;
	private String query;
	private Statement st;
 
    public List<Carrera> buscarTodo(){
    	con = new ConexionDB();
    	query = "Select * From carrera Order By nombre";
    	con.start();
    	List<Carrera> carreras = new ArrayList<>(0);
    	
    	try{
	    	st = con.getConexion().createStatement();
	    	
	        ResultSet rs = st.executeQuery(query);
	        while (rs.next()){
	        	Carrera c = new Carrera();
	        	c.setId(rs.getInt("id"));
	        	c.setNombre(rs.getString("nombre"));
	        	carreras.add(c);}
	        
	        con.close();
	        st.close();}
    	catch(Exception e){
    		carreras=null;
    		System.out.println("Error al obtener lista de Carreras");
    	}
        
    	return carreras;
    }
   
    public Carrera FiltroN(String nombre){
    	con = new ConexionDB();
    	query = "Select * From carrera Where nombre='"+nombre+"'";
    	con.start();
    	Carrera c = new Carrera();
    	
    	try{
            st = con.getConexion().createStatement();

            ResultSet rs = st.executeQuery(query);
            while (rs.next()){
                    c.setId(rs.getInt("id"));
                    c.setNombre(rs.getString("nombre"));}

            con.close();
            st.close();}
    	catch(Exception e){
    		c=null;
    		System.out.println("Error al filtrar Carreras por nombre");}
        
    	return c;
    }
        
    /*public static Carrera buscarId(int id){
        s = HibernateUtil.getSessionFactory().getCurrentSession();
        t = s.beginTransaction();
        Carrera c = (Carrera) s.load(Carrera.class, id);
        return c;
    }*/
    
}
