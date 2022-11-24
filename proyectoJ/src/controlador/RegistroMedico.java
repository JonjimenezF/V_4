
package controlador;

import bd.Conexion;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;
import modelo.Medico;

/**
 *
 * @author jimen
 */
public class RegistroMedico {
    
    //AGREGAR MEDICO
    public boolean agregarMedico(Medico medico){
        try {
            Conexion con = new Conexion();
            Connection cnx = con.obtenerConexion();
            
            String query = "INSERT INTO Medico(rut,nombre,genero,idProfesion) VALUES (?,?,?,?)";
            PreparedStatement stmt = cnx.prepareCall(query);
            stmt.setString(1, medico.getRut());
            stmt.setString(2, medico.getNombre());
            stmt.setString(3,medico.getGenero());
            stmt.setInt(4,medico.getIdProfesion());
           

            stmt.executeUpdate();
            stmt.close();
            cnx.close();
            return true;
        } catch (SQLException e) {
            System.out.println("Error en la consulta SQL agregar, " + e.getMessage());
            return false;
        }
        
    }
    
    //ELIMINAR MEDICO
    
    public boolean eliminarMedico(String rut) {
        boolean flag = false;

        try {
            Conexion con = new Conexion();
            Connection cnx = con.obtenerConexion();

            String query = "DELETE FROM medico WHERE ruT = ?";
            PreparedStatement stmt = cnx.prepareCall(query);
            stmt.setString(1, rut);

            int resp = JOptionPane.showConfirmDialog(null, "¿Seguro que desea eliminar?", "eliminar Medico", 1);
            if (resp == 0) {
                stmt.executeUpdate();
                stmt.close();
                cnx.close();
                flag = true;
            }

        }catch (SQLException e) {
            System.out.println("Error en la consulta SQL eliminar, " + e.getMessage());
            flag = false;
        }
        return flag;

    }
    
    
    
    public boolean actualizarMedico(String rut, String nombreNew) {
 
        try {
            Conexion con = new Conexion();
            Connection cnx = con.obtenerConexion();

            String query = "UPDATE medico SET nombre = ? WHERE rut = ?";
            PreparedStatement stmt = cnx.prepareCall(query);
            stmt.setString(1, nombreNew);
            
            stmt.setString(2, rut);

            stmt.executeUpdate();
            stmt.close();
            cnx.close();          
            return true;

        } catch (SQLException e) {
            System.out.println("Error en la consulta SQL actualizar, " + e.getMessage());
            return false;
        }
    }
    
    
    public Medico buscarMedico(String rut) {
        Medico m = new Medico();

        try {

            Conexion con = new Conexion();
            Connection cnx = con.obtenerConexion();

            String query = "SELECT * FROM medico WHERE rut = ? ";
            PreparedStatement stmt = cnx.prepareCall(query);
            stmt.setString(1, rut);

            ResultSet rs = stmt.executeQuery();
            if (rs.next()) {
                m.setRut(rs.getString("rut"));
                m.setNombre(rs.getString("nombre"));
                m.setGenero(rs.getString("genero"));               
                m.setIdProfesion(rs.getInt("idProfesion"));
                

            }

            
            rs.close();
            stmt.close();
            cnx.close();

        } catch (SQLException e) {
            System.out.println("Error en la consulta SQL por buscar M, " + e.getMessage());

        }

        return m;
    }
    
    
    
    public List<Medico> Listar(String rut) {

        List<Medico> lista = new ArrayList<>();

        try {

            Conexion con = new Conexion();
            Connection cnx = con.obtenerConexion();
            String query;
            
            if(rut.equalsIgnoreCase("")){
                query = "SELECT * FROM medico";
                PreparedStatement stmt = cnx.prepareCall(query);
                
                ResultSet rs = stmt.executeQuery();
                while (rs.next()) {
                Medico m = new Medico();
                m.setRut(rs.getString("rut"));
                m.setNombre(rs.getString("nombre"));
                m.setGenero(rs.getString("genero"));               
                m.setIdProfesion(rs.getInt("idProfesion"));
                lista.add(m);

                }

                stmt.executeUpdate();
                stmt.close();
                cnx.close();
            }else{
                query = "SELECT * FROM paciente WHERE rut = ? ";
                PreparedStatement stmt = cnx.prepareCall(query);
                stmt.setString(1, rut);
                
                ResultSet rs = stmt.executeQuery();
                if (rs.next()) {
                Medico m = new Medico();
                m.setRut(rs.getString("rut"));
                m.setNombre(rs.getString("nombre"));
                m.setGenero(rs.getString("genero"));
                m.setIdProfesion(rs.getInt("idProfesion"));
                lista.add(m);

            }

                stmt.executeUpdate();
                stmt.close();
                cnx.close();
                
            }
                       
      
        } catch (SQLException e) {
            System.out.println("Error en la consulta SQL Buscar todo, " + e.getMessage());

        }

        return lista;
    }
    
    
}
