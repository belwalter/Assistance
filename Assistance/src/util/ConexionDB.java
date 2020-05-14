package util;

import java.sql.Connection;
import java.sql.DriverManager;
 
public class ConexionDB {
 
    
    private String direccioDb = "jdbc:postgresql://localhost:5432/perseo";
    private String user = "postgres";
    private String pass = "abcd1234";
    private Connection conexion;    
   
    
    public boolean start() {       
        try {
            Class.forName("org.postgresql.Driver");
            this.conexion = DriverManager.getConnection(direccioDb, user, pass);            
        } catch (Exception e) {
            e.printStackTrace();
            this.conexion = null;}        
        return conexion != null;
    }
    
    public boolean close() {    	
	    	if (getConexion() != null) {
	            try {
	                getConexion().close();
	                this.conexion = null;
	            } catch (Exception e) {
	                e.printStackTrace();}
	        }     
	    	return conexion == null;
    }
    
    public Connection getConexion() {
		return conexion;}

        
}
