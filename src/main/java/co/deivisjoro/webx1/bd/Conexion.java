package co.deivisjoro.webx1.bd;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Conexion {
    
    private Connection conexion;
    
    public Conexion(){
    }
    
    public Connection getConexion(){
    
        try{
            Class.forName("com.mysql.cj.jdbc.Driver");
            this.conexion = DriverManager.getConnection("jdbc:mysql://localhost:3306/api", "root", "");
            
        }
        catch(ClassNotFoundException e){
            System.out.println("Ocurrio un error seleccinando el driver de mysql: "+e.getMessage());
        }
        catch(SQLException e){
            System.out.println("Ocurrio un error conectandose al servidor mysql: "+e.getMessage());
        }
        
        return this.conexion;
    }
    
}
