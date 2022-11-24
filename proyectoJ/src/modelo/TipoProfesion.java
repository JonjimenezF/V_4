
package modelo;

/**
 *
 * @author jimen
 */
public class TipoProfesion {
    
    private int idProfesion;
    private String nombre;

    public TipoProfesion() {
    }

    public TipoProfesion(int idProfesion, String nombre) {
        this.idProfesion = idProfesion;
        this.nombre = nombre;
    }

    public int getIdProfesion() {
        return idProfesion;
    }

    public void setIdProfesion(int idProfesion) {
        this.idProfesion = idProfesion;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    @Override
    public String toString() {
        return "TipoProfesion{" + "idProfesion=" + idProfesion + ", nombre=" + nombre + '}';
    }
    
    
    
    
}
