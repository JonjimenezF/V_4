package controlador;

import bd.Conexion;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import modelo.Medico;
import modelo.Paciente;

/**
 *
 * @author jimen
 */
public class RegistroPaciente {

    public boolean agregarPaciente(Paciente paciente) {
        try {
            Conexion con = new Conexion();
            Connection cnx = con.obtenerConexion();

            String query = "INSERT INTO paciente(Rut,nombre,genero,isapre,edad,celular) VALUES (?,?,?,?,?,?)";
            PreparedStatement stmt = cnx.prepareCall(query);
            stmt.setString(1, paciente.getRut());
            stmt.setString(2, paciente.getNombre());
            stmt.setString(3, paciente.getGenero());
            stmt.setString(4, paciente.getIsapre());
            stmt.setInt(5, paciente.getEdad());
            stmt.setInt(6, paciente.getCelular());

            stmt.executeUpdate();
            stmt.close();
            cnx.close();
            return true;
        } catch (SQLException e) {
            System.out.println("Error en la consulta SQL agregar, " + e.getMessage());
            return false;
        }

    }
    
    
    public boolean actualizarPaciente(String rut, String nombreNew,int edadNew,int celularNew) {
 
        try {
            Conexion con = new Conexion();
            Connection cnx = con.obtenerConexion();

            String query = "UPDATE paciente SET nombre = ?,edad = ?,celular = ? WHERE rut = ?";
            PreparedStatement stmt = cnx.prepareCall(query);
            stmt.setString(1, nombreNew);
            stmt.setInt(2, edadNew);
            stmt.setInt(3, celularNew);
            stmt.setString(4, rut);

            stmt.executeUpdate();
            stmt.close();
            cnx.close();          
            return true;

        } catch (SQLException e) {
            System.out.println("Error en la consulta SQL actualizar, " + e.getMessage());
            return false;
        }
    }
    
    
    public Paciente buscarPaciente(String rut) {
        Paciente p = new Paciente();

        try {

            Conexion con = new Conexion();
            Connection cnx = con.obtenerConexion();

            String query = "SELECT * FROM paciente WHERE rut = ? ";
            PreparedStatement stmt = cnx.prepareCall(query);
            stmt.setString(1, rut);

            ResultSet rs = stmt.executeQuery();
            if (rs.next()) {
                p.setRut(rs.getString("rut"));
                p.setNombre(rs.getString("nombre"));
                p.setGenero(rs.getString("genero"));
                p.setIsapre(rs.getString("isapre"));
                p.setEdad(rs.getInt("edad"));
                p.setCelular(rs.getInt("celular"));
                

            }

            
            rs.close();
            stmt.close();
            cnx.close();

        } catch (SQLException e) {
            System.out.println("Error en la consulta SQL por buscar M, " + e.getMessage());

        }

        return p;
    }
    
    public List<Paciente> ListarP(String rut) {

        List<Paciente> lista = new ArrayList<>();

        try {

            Conexion con = new Conexion();
            Connection cnx = con.obtenerConexion();
            String query;
            
            if(rut.equalsIgnoreCase("")){
                query = "SELECT * FROM paciente";
                PreparedStatement stmt = cnx.prepareCall(query);
                
                ResultSet rs = stmt.executeQuery();
                while (rs.next()) {
                Paciente p = new Paciente();
                p.setRut(rs.getString("rut"));
                p.setNombre(rs.getString("nombre"));
                p.setGenero(rs.getString("genero"));
                p.setIsapre(rs.getString("isapre"));
                p.setEdad(rs.getInt("edad"));
                p.setCelular(rs.getInt("celular"));
                
                lista.add(p);

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
                Paciente p = new Paciente();
                 
                p.setRut(rs.getString("rut"));
                p.setNombre(rs.getString("nombre"));
                p.setGenero(rs.getString("genero"));
                p.setIsapre(rs.getString("isapre"));
                p.setEdad(rs.getInt("edad"));
                p.setCelular(rs.getInt("celular"));
                lista.add(p);
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
