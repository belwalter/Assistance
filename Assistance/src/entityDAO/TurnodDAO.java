package entityDAO;

import entity.Carrera;
import entity.Catedra;
import entity.Docente;
import entity.Persona;
import entity.Turnod;
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

public class TurnodDAO {
    
	private ConexionDB con;
	private String query;
	private Statement st;
    
    public void Guardar(Turnod t){
        con = new ConexionDB();
    	query = "Insert Into turnod (iddocente, fecha, hora, tipo) Values ('"+t.getDocente().getId()+"','"
                                    +t.getFecha()+"','"+t.getHora()+"','"+t.getTipo()+"')";
    	con.start();
    	
    	try{
            st = con.getConexion().createStatement();
            st.execute(query);
            System.out.println("La Carga de la Nueva turnod fue Completada");
            con.close();
            st.close();}
    	catch(Exception e){
            System.out.println("Error al intentar guardar Turnod "+e.getMessage());}
    }
    
    
    public List<Turnod> Filtro(){
        Calendar c = Calendar.getInstance();
        String fecha = c.get(Calendar.DAY_OF_MONTH)+"-"+(c.get(Calendar.MONTH)+1)+"-"+c.get(Calendar.YEAR);
        con = new ConexionDB();
    	query = "Select t.fecha, t.hora, t.tipo, p.apellido, p.nombre, c.nombre, ca.nombre, p.genero, ca.id, p.dni From turnod t, docente d, persona p, catedra c, carrera ca " +
    			"Where t.fecha='"+fecha+"' and d.id=t.iddocente and p.dni=d.idpersona and d.idcatedra=c.id and ca.id=c.idcarrera order by t.id";
    	con.start();
    	List<Turnod> turnos = new ArrayList<>(0);
    	
    	try{
	    	st = con.getConexion().createStatement();
	    	
	        ResultSet rs = st.executeQuery(query);
	        while (rs.next()){
	        	Turnod td = new Turnod();
	        	td.setFecha(rs.getDate(1));
	        	td.setHora(rs.getTime(2));
	        	td.setTipo(rs.getString(3).charAt(0));
	        	Docente d = new Docente();
	        	Persona p = new Persona();
                        p.setDni(rs.getInt(10));
	        	p.setApellido(rs.getString(4));
	        	p.setNombre(rs.getString(5));
	        	p.setSexo(rs.getString(8).charAt(0));
	        	d.setPersona(p);
	        	Catedra cat = new Catedra();
	        	cat.setNombre(rs.getString(6));
	        	Carrera ca = new Carrera();
	        	ca.setNombre(rs.getString(7));
                        ca.setId(rs.getInt(9));
	        	cat.setCarrera(ca);
	        	d.setCatedra(cat);
	        	td.setDocente(d);
	        	turnos.add(td);}
	        
	        con.close();
	        st.close();}
    	catch(Exception e){
    		System.out.println("Error al obtener lista de Turnos Docentes");
    	}
    	
        return turnos;
    }
    
    public List<Turnod> FiltroDoc(int dni, Date f1, Date f2){
        con = new ConexionDB();
        query = "Select t.fecha, t.hora, t.tipo, p.apellido, p.nombre, c.nombre, ca.nombre, p.genero, ca.id From turnod t, docente d, persona p, catedra c, carrera ca " +
                "Where t.fecha between '"+f1+"' and '"+f2+"' and d.id=t.iddocente and p.dni="+dni+" and p.dni=d.idpersona and d.idcatedra=c.id and ca.id=c.idcarrera order by t.id";
    	con.start();
    	List<Turnod> turnos = new ArrayList<>(0);
    	
    	try{
	    	st = con.getConexion().createStatement();
	    	
	        ResultSet rs = st.executeQuery(query);
	        while (rs.next()){
	        	Turnod td = new Turnod();
	        	td.setFecha(rs.getDate(1));
	        	td.setHora(rs.getTime(2));
	        	td.setTipo(rs.getString(3).charAt(0));
	        	Docente d = new Docente();
	        	Persona p = new Persona();
	        	p.setApellido(rs.getString(4));
                        p.setDni(dni);
	        	p.setNombre(rs.getString(5));
	        	p.setSexo(rs.getString(8).charAt(0));
	        	d.setPersona(p);
	        	Catedra cat = new Catedra();
	        	cat.setNombre(rs.getString(6));
	        	Carrera ca = new Carrera();
	        	ca.setNombre(rs.getString(7));
                        ca.setId(rs.getInt(9));
	        	cat.setCarrera(ca);
	        	d.setCatedra(cat);
	        	td.setDocente(d);
	        	turnos.add(td);}
	        
	        con.close();
	        st.close();}
    	catch(Exception e){
    		System.out.println("Error al obtener lista de Turnos Docentes por dni");
    	}
    	
        return turnos;
    }
    
    
    public int CantT(String id){
        int cant = 0;
        con = new ConexionDB();
    	query = "Select count(*) from turnod where iddocente='"+id+"'";
    	con.start();
    	
    	try{
	    	st = con.getConexion().createStatement();
	    	
	        ResultSet rs = st.executeQuery(query);
	        if(rs.next()){
	        	cant = rs.getInt(1);}
	        
	        con.close();
	        st.close();}
    	catch(Exception e){
    		System.out.println("Error al obtener el cantiad de Turnos Docente");
    	}
    	
        return cant;
    }
    
    public int cantTurnoDoc(String dni){
        int cant = 0;
        con = new ConexionDB();
    	query = "Select count(*) from turnod t, docente d where t.iddocente=d.id and d.idpersona='"+dni+"'";
    	con.start();
    	
    	try{
	    	st = con.getConexion().createStatement();
	    	
	        ResultSet rs = st.executeQuery(query);
	        if(rs.next()){
	        	cant = rs.getInt(1);}
	        
	        con.close();
	        st.close();}
    	catch(Exception e){
    		System.out.println("Error al obtener el cantiad de Turnos Docente por dni");
    	}
    	
        return cant;
    }
}
