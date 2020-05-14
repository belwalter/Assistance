package entityDAO;

import entity.Administrativo;
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

public class AdministrativoDAO {
    
    private ConexionDB con;
    private String query;
    private Statement st;
	
    public List<Administrativo> buscarTodo(){
            con = new ConexionDB();
            query = "Select p.nombre, p.apellido, c.nombre, d.nombre From administrativo a, persona p, cargo c, departamento d " +
                            "Where a.iddepartamento=d.id and a.idpersona=p.id and a.idcargo=c.id and a.fechafin is Null " +
                            "Order By d.nombre, p.apellido, p.nombre, c.nombre Desc";
    con.start();
    List<Administrativo> admins = new ArrayList<>(0);
    try{
            st = con.getConexion().createStatement();
            ResultSet rs = st.executeQuery(query);

            while (rs.next()){
                    Persona p = new Persona();
                    p.setApellido(rs.getString(2));
                    p.setNombre(rs.getString(1));
                    Administrativo a = new Administrativo();
                    a.setCargo("cargo");
                    a.setPersona(p);
                    admins.add(a);
            }

            con.close();
            st.close();}
    catch(Exception e){
            admins=null;
            System.out.println("Error al obtener lista de Administrativos");}

    return admins;
    }
    
    public boolean esAdmin(String dni){
        boolean control = false;
        con = new ConexionDB();
        query = "select * from administrativo a where a.idpersona = '"+dni+"' and a.activo"; 
        con.start();
        
        try{
            st = con.getConexion().createStatement();
	    	
            ResultSet rs = st.executeQuery(query);
            if (rs.next()){
                control=true;}

            con.close();
            st.close();}
        catch(Exception ex){
            System.out.println("Error al intentar consultar administrativo por dni");}
    	
        return control;
    }
    
    public List<Administrativo> FiltroDNI(String dni){
        List<Administrativo> la = new ArrayList<>();
        con = new ConexionDB();
        query = "select a.id, a.cargo, p.dni, p.apellido, p.nombre, p.genero from administrativo a, persona p "
                    + "where a.idpersona = '"+dni+"' and activo and a.idpersona=p.dni"
                    +" order by cargo"; 
        con.start();
        
        try{
            st = con.getConexion().createStatement();
            ResultSet rs = st.executeQuery(query);
            while (rs.next()){
                Administrativo a = new Administrativo();
                Persona p = new Persona();
                p.setDni(rs.getInt(3));
                p.setApellido(rs.getString(4));
                p.setNombre(rs.getString(5));
                p.setSexo(rs.getString(6).charAt(0));
                a.setPersona(p);
                a.setCargo(rs.getString(2));
                a.setId(rs.getInt(1));
                la.add(a);
                }
            
            con.close();
            st.close();}
        catch(Exception ex){
            la = null;
            System.out.println("Error al intentar consultar administrativos por dni");}
    	
        return la;
    }
}
