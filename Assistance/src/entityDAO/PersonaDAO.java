package entityDAO;

import entity.Persona;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;
import util.ConexionDB;

/**
 *
 * @author Bel Walter
 */
public class PersonaDAO {
    
    private ConexionDB con;
    private String query;
    private Statement st;
    
    public void Guardar(Persona p){
    	con = new ConexionDB();
    	query = "Insert Into persona (nombre, apellido, dni, genero) Values ('"+p.getNombre()+"','"+p.getApellido()+"','"+p.getDni()+"','"+p.getSexo()+"')";
    	con.start();
    	
    	try{
	    	st = con.getConexion().createStatement();
	        st.execute(query);
	        JOptionPane.showMessageDialog(null, "La Carga de la Nueva Persona fue Completada");
	        con.close();
	        st.close();}
    	catch(Exception e){
    		System.out.println("Error al intentar guardar Persona "+e.getMessage());}    
    }
    
    public List<Persona> buscarTodo(){
    	con = new ConexionDB();
    	query = "Select apellido,nombre, dni From persona Order By apellido, nombre";
    	con.start();
    	List<Persona> personas = new ArrayList<>(0);
    	
    	try{
	    	st = con.getConexion().createStatement();
	    	
	        ResultSet rs = st.executeQuery(query);
	        while (rs.next()){
	        	Persona p = new Persona();
	        	p.setApellido(rs.getString("apellido"));
	        	p.setNombre(rs.getString("nombre"));
	        	p.setDni(rs.getInt("dni"));
	        	personas.add(p);}
	        
	        con.close();
	        st.close();}
    	catch(Exception e){
    		personas=null;
    		System.out.println("Error al intentar obtener lista de Personas");
    	}
        
    	return personas;
    }
    
    public boolean DniDisponible(String dni){
    	boolean control = true;
    	con = new ConexionDB();
    	query = "Select dni From persona Where dni='"+dni+"'";
    	con.start();
    	
    	try{
            st = con.getConexion().createStatement();

            ResultSet rs = st.executeQuery(query);
            if (rs.next()){
                control=false;}

            con.close();
            st.close();}
    	catch(Exception e){
    		System.out.println("Error al intentar consultar dni de la Persona");}
        
    	return control;
    }
    
    public boolean ExisteDni(String dni){
    	boolean control = false;
    	con = new ConexionDB();
    	query = "Select dni From persona Where dni='"+dni+"'";
    	con.start();
    	
    	try{
            st = con.getConexion().createStatement();

            ResultSet rs = st.executeQuery(query);
            if (rs.next()){
                control=true;}

            con.close();
            st.close();}
    	catch(Exception e){
    		System.out.println("Error al intentar consultar dni de la Persona");
    	}
        
    	return control;
    }
        
    public Persona buscarId(int dni){
        Persona p = null;
        con = new ConexionDB();
    	query = "Select * From persona Where dni='"+dni+"'";
    	con.start();
    	
    	try{
            st = con.getConexion().createStatement();

            ResultSet rs = st.executeQuery(query);
            if (rs.next()){
                p = new Persona();
                p.setApellido(rs.getString("apellido"));
                p.setNombre(rs.getString("nombre"));
                p.setDni(rs.getInt("dni"));
                p.setSexo(rs.getString("genero").charAt(0));}

            con.close();
            st.close();}
    	catch(Exception e){
    		System.out.println("Error al intentar obtener la Persona");}
        return p;
    }
    
}
