package co.deivisjoro.webx1.modelos.dao;

import co.deivisjoro.webx1.bd.Conexion;
import co.deivisjoro.webx1.modelos.entidades.Estudiante;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class EstudianteDAO {

    private Conexion conexion;
    
    public EstudianteDAO(Conexion conexion) {
        this.conexion = conexion;
    }
    
    //metodos crud
    public Estudiante add(Estudiante estudiante){
    
        try{
            String sql = "INSERT INTO estudiantes VALUES (?,?,?,?,?)";
            PreparedStatement pst = this.conexion.getConexion().prepareStatement(sql, PreparedStatement.RETURN_GENERATED_KEYS);
            pst.setInt(1, 0);
            pst.setString(2, estudiante.getNombre());
            pst.setFloat(3, estudiante.getNota1());
            pst.setFloat(4, estudiante.getNota2());
            pst.setFloat(5, estudiante.getNota3());
            int filas = pst.executeUpdate();
            if(filas>0){
                ResultSet rs = pst.getGeneratedKeys();
                while(rs.next()){
                    estudiante.setId(rs.getInt(1));
                }
            }
            
        }
        catch(SQLException e){
            e.printStackTrace();
        }
        
        return estudiante;        
    }
    
    public ArrayList<Estudiante> list(){
        ArrayList<Estudiante> estudiantes = new ArrayList<>();
        
        try{
            String sql = "SELECT * FROM estudiantes";
            PreparedStatement pst = this.conexion.getConexion().prepareStatement(sql);
            ResultSet rs = pst.executeQuery();
            while(rs.next()){
                Estudiante e = new Estudiante();
                e.setId(rs.getInt("id"));
                e.setNombre(rs.getString("nombre"));
                e.setNota1(rs.getFloat("nota1"));
                e.setNota2(rs.getFloat("nota2"));
                e.setNota3(rs.getFloat("nota3"));
                
                estudiantes.add(e);
                
            }
           
            
        }
        catch(SQLException e){
            e.printStackTrace();
        }
        
        return estudiantes;
    }
    
    
}
