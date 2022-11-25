package controlador;

import bd.Conexion;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;
import modelo.TipoProfesion;

/**
 *
 * @author jimen
 */
public class RegistroProfesion {
    
    
    //AGREGAR PROFESION(NOMBRE)
    public boolean agregarProfesion(TipoProfesion tipoprofesion) {
        try {
            Conexion con = new Conexion();
            Connection cnx = con.obtenerConexion();

            String query = "INSERT INTO tipoprofesion(nombre) VALUES (?)";
            PreparedStatement stmt = cnx.prepareCall(query);
            stmt.setString(1, tipoprofesion.getNombre());

            stmt.executeUpdate();
            stmt.close();
            cnx.close();
            return true;

        } catch (SQLException e) {
            System.out.println("Error en la consulta SQL agregar, " + e.getMessage());
            return false;
        }

    }
    
    //ELIMINAR PROFESION(NOMBRE)
    
    public boolean eliminarProfesion(String nombre) {
        boolean flag = false;

        try {
            Conexion con = new Conexion();
            Connection cnx = con.obtenerConexion();

            String query = "DELETE FROM tipoprofesion WHERE nombre = ?";
            PreparedStatement stmt = cnx.prepareCall(query);
            stmt.setString(1, nombre);

            int resp = JOptionPane.showConfirmDialog(null, "¿Seguro que desea eliminar?", "eliminar tipo profesion", 1);
            if (resp == 0) {
                stmt.executeUpdate();
                stmt.close();
                cnx.close();
                flag = true;

            }

        } catch (SQLException e) {
            System.out.println("Error en la consulta SQL eliminar, " + e.getMessage());
            flag = false;
        }
        return flag;

    }
    
    //ACTUALIZAR PROFESION(NOMBRE)
    
    public boolean actualizarProfesion(String nombre, String nombreNew) {

        try {
            Conexion con = new Conexion();
            Connection cnx = con.obtenerConexion();

            String query = "UPDATE tipoprofesion SET nombre = ? WHERE nombre = ?";
            PreparedStatement stmt = cnx.prepareCall(query);
            stmt.setString(1, nombreNew);
            stmt.setString(2, nombre);

            stmt.executeUpdate();
            stmt.close();
            cnx.close();
            System.out.println(nombreNew);
            System.out.println(nombre);
            return true;

        } catch (SQLException e) {
            System.out.println("Error en la consulta SQL actualizar, " + e.getMessage());
            return false;
        }
    }
    
    
    
    
    public TipoProfesion buscarProfesion(String nombre) {
        TipoProfesion tp = new TipoProfesion();

        try {

            Conexion con = new Conexion();
            Connection cnx = con.obtenerConexion();

            String query = "SELECT * FROM tipoprofesion WHERE nombre = ? ";
            PreparedStatement stmt = cnx.prepareCall(query);
            stmt.setString(1, nombre);

            ResultSet rs = stmt.executeQuery();
            if (rs.next()) {
                tp.setIdProfesion(rs.getInt("idProfesion"));
                tp.setNombre(rs.getString("nombre"));

            }

            
            rs.close();
            stmt.close();
            cnx.close();

        } catch (SQLException e) {
            System.out.println("Error en la consulta SQL por buscar nombre, " + e.getMessage());

        }

        return tp;
    }
    
    //BUSCAR TODO
    
    public List<TipoProfesion> buscarTodo() {

        List<TipoProfesion> lista = new ArrayList<>();

        try {

            Conexion con = new Conexion();
            Connection cnx = con.obtenerConexion();

            String query = "SELECT * FROM tipoprofesion ";
            PreparedStatement stmt = cnx.prepareCall(query);

            ResultSet rs = stmt.executeQuery();
            while (rs.next()) {
                TipoProfesion tp = new TipoProfesion();
                tp.setIdProfesion(rs.getInt("idProfesion"));
                tp.setNombre(rs.getString("nombre"));

                lista.add(tp);

            }

            stmt.executeUpdate();
            stmt.close();
            cnx.close();

        } catch (SQLException e) {
            System.out.println("Error en la consulta SQL Buscar todo, " + e.getMessage());

        }

        return lista;
    }
}
