package entityDAO;


import entity.Administrativo;
import entity.Persona;
import entity.Turnoa;

import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import util.ConexionDB;

/**
 *
 * @author Bel Walter
 */

public class TurnoaDAO {
    
	private ConexionDB con;
	private String query;
	private Statement st;
    
    public void Guardar(Turnoa t){
        con = new ConexionDB();
    	query = "Insert Into turnoa (idadmin, fecha, hora, tipo) Values ('"+t.getAdministrativo().getId()+"','"
                                    +t.getFecha()+"','"+t.getHora()+"','"+t.getTipo()+"')";
    	con.start();
    	
    	try{
            st = con.getConexion().createStatement();
            st.execute(query);
            System.out.println("La Carga de la Nueva turnoa fue Completada");
            con.close();
            st.close();}
    	catch(Exception e){
            System.out.println("Error al intentar guardar Turnoa "+e.getMessage());}
    }
    
    public List<Turnoa> Filtro(){
    	Calendar c = Calendar.getInstance();
        String fecha = c.get(Calendar.DAY_OF_MONTH)+"-"+(c.get(Calendar.MONTH)+1)+"-"+c.get(Calendar.YEAR);
        con = new ConexionDB();
    	query = "Select t.fecha, t.hora, t.tipo, p.apellido, p.nombre, a.cargo, p.genero, p.dni From turnoa t, administrativo a, persona p " +
    			"Where t.fecha='"+fecha+"' and a.id=t.idadmin and p.dni=a.idpersona order by t.id";
    	con.start();
    	List<Turnoa> turnos = new ArrayList<>(0);
    	
    	try{
	    	st = con.getConexion().createStatement();
	    	
	        ResultSet rs = st.executeQuery(query);
	        while (rs.next()){
	        	Turnoa ta = new Turnoa();
	        	ta.setFecha(rs.getDate(1));
	        	ta.setHora(rs.getTime(2));
	        	ta.setTipo(rs.getString(3).charAt(0));
	        	Administrativo a = new Administrativo();
	        	Persona p = new Persona();
                        p.setDni(rs.getInt(8));
	        	p.setApellido(rs.getString(4));
	        	p.setNombre(rs.getString(5));
	        	p.setSexo(rs.getString(7).charAt(0));
	        	a.setPersona(p);
	        	a.setCargo(rs.getString(6));
	        	ta.setAdministrativo(a);
	        	turnos.add(ta);}
	        
	        con.close();
	        st.close();}
    	catch(Exception e){
    		System.out.println("Error al obtener lista de Turnos Administrativos");
    	}
    	
        return turnos;
    }
    
    public List<Turnoa> FiltroAdmin(int dni, Date f1, Date f2){
        con = new ConexionDB();
        
        query = "Select t.fecha, t.hora, t.tipo, p.apellido, p.nombre, a.cargo, p.genero From turnoa t, administrativo a, persona p " +
                "Where t.fecha between '"+f1+"'and '"+f2+"' and a.id=t.idadmin and p.dni="+dni+" and p.dni=a.idpersona order by t.id";
    	con.start();
    	List<Turnoa> turnos = new ArrayList<>(0);
    	
    	try{
	    	st = con.getConexion().createStatement();
	    	
	        ResultSet rs = st.executeQuery(query);
	        while (rs.next()){
	        	Turnoa ta = new Turnoa();
	        	ta.setFecha(rs.getDate(1));
	        	ta.setHora(rs.getTime(2));
	        	ta.setTipo(rs.getString(3).charAt(0));
	        	Administrativo a = new Administrativo();
	        	Persona p = new Persona();
                        p.setDni(dni);
	        	p.setApellido(rs.getString(4));
	        	p.setNombre(rs.getString(5));
	        	p.setSexo(rs.getString(7).charAt(0));
	        	a.setPersona(p);
	        	a.setCargo(rs.getString(6));
	        	ta.setAdministrativo(a);
	        	turnos.add(ta);}
	        
	        con.close();
	        st.close();}
    	catch(Exception e){
    		System.out.println("Error al obtener lista de Turnos Administrativos por dni");
    	}
        return turnos;
    }
    
    
    public int CantT(String id){
        int cant = 0;
        con = new ConexionDB();
    	query = "Select count(*) from turnoa where idadmin='"+id+"'";
    	con.start();
    	
    	try{
	    	st = con.getConexion().createStatement();
	    	
	        ResultSet rs = st.executeQuery(query);
	        if(rs.next()){
	        	cant = rs.getInt(1);}
	        
	        con.close();
	        st.close();}
    	catch(Exception e){
    		System.out.println("Error al obtener el cantiad de Turnos Administrativo");
    	}
    	
        return cant;
    }
    
    public int cantTurnoAdmin(String dni){
        int cant = 0;
        con = new ConexionDB();
    	query = "Select count(*) from turnoa t , administrativo a where t.idadmin=a.id and a.idpersona='"+dni+"'";
    	con.start();
    	
    	try{
	    	st = con.getConexion().createStatement();
	    	
	        ResultSet rs = st.executeQuery(query);
	        if(rs.next()){
	        	cant = rs.getInt(1);}
	        
	        con.close();
	        st.close();}
    	catch(Exception e){
    		System.out.println("Error al obtener el cantiad de Turnos Administrativo por dni");
    	}
    	
        return cant;
    }   
}
