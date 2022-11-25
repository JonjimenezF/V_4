
package controlador;

import bd.Conexion;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import modelo.Atencion;
import modelo.Medico;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author jimen
 */
public class RegistroAtencion {
    
    public boolean agregarAtencion(Atencion atencion){
        try {
            Conexion con = new Conexion();
            Connection cnx = con.obtenerConexion();
            
            String query = "INSERT INTO atencion(fecha_Atencion,hr_Atencion,rutM,rutP) VALUES (?,?,?,?)";
            PreparedStatement stmt = cnx.prepareCall(query);
            
            stmt.setDate(1, (Date) atencion.getFecha_Atencion());
            stmt.setString(2, atencion.getHr_Atencion());            
            stmt.setString(3, atencion.getRutM());
            stmt.setString(4, atencion.getRutP());
           

            stmt.executeUpdate();
            stmt.close();
            cnx.close();
            return true;
        } catch (SQLException e) {
            System.out.println("Error en la consulta SQL agregar, " + e.getMessage());
            return false;
        }
        
    }
    
    
    public List<Atencion> buscarTodo() {

        List<Atencion> lista = new ArrayList<>();

        try {

            Conexion con = new Conexion();
            Connection cnx = con.obtenerConexion();

            String query = "SELECT * FROM atencion ORDER BY fecha_Atencion ";
            PreparedStatement stmt = cnx.prepareCall(query);

            ResultSet rs = stmt.executeQuery();
            while (rs.next()) {
                Atencion a = new Atencion();
                a.setIdAtencion(rs.getInt("idAtencion"));
                a.setFecha_Atencion(rs.getDate("fecha_Atencion"));
                a.setHr_Atencion(rs.getString("hr_Atencion"));
                a.setRutM(rs.getString("rutM"));
                a.setRutP(rs.getString("rutP"));
                lista.add(a);

            }

            stmt.executeUpdate();
            stmt.close();
            cnx.close();

        } catch (SQLException e) {
            System.out.println("Error en la consulta SQL Buscar todo, " + e.getMessage());

        }

        return lista;
    }
    
    /*
    public List<Atencion> Listar(String rut) {

        List<Atencion> lista = new ArrayList<>();

        try {

            Conexion con = new Conexion();
            Connection cnx = con.obtenerConexion();
            String query;
            
            if(rut.equalsIgnoreCase("")){
                query = "SELECT * FROM atencion ORDER BY fecha_Atencion";
                PreparedStatement stmt = cnx.prepareCall(query);
                
                ResultSet rs = stmt.executeQuery();
                while (rs.next()) {
                Atencion a = new Atencion();
                a.setFecha_Atencion(rs.getDate("fecha_Atencion"));
                a.setHr_Atencion(rs.getString("hr_Atencion"));
                a.setRutM(rs.getString("rutM"));
                a.setRutP(rs.getString("rutP"));
                lista.add(a);

                }

                stmt.executeUpdate();
                stmt.close();
                cnx.close();
            }else{
                query = "SELECT * FROM atencion WHERE rutP = ?  ORDER BY idAtencion";
                PreparedStatement stmt = cnx.prepareCall(query);
                stmt.setString(1, rut);
                
                ResultSet rs = stmt.executeQuery();
                if (rs.next()) {
                Atencion a = new Atencion();
                
                a.setFecha_Atencion(rs.getDate("fecha_Atencion"));
                a.setHr_Atencion(rs.getString("hr_Atencion"));
                a.setRutM(rs.getString("rutM"));
                a.setRutP(rs.getString("rutP"));
                lista.add(a);

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
    */
}
