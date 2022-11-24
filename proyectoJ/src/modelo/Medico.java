
package modelo;

/**
 *
 * @author jimen
 */
public class Medico {
    
    private String rut,nombre,genero;
    private int idProfesion;

    public Medico() {
    }

    public Medico(String rut, String nombre, String genero, int idProfesion) {
        this.rut = rut;
        this.nombre = nombre;
        this.genero = genero;
        this.idProfesion = idProfesion;
    }

    public String getRut() {
        return rut;
    }

    public void setRut(String rut) {
        this.rut = rut;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getGenero() {
        return genero;
    }

    public void setGenero(String genero) {
        this.genero = genero;
    }

    public int getIdProfesion() {
        return idProfesion;
    }

    public void setIdProfesion(int idProfesion) {
        this.idProfesion = idProfesion;
    }

    @Override
    public String toString() {
        return "Medico{" + "rut=" + rut + ", nombre=" + nombre + ", genero=" + genero + ", idProfesion=" + idProfesion + '}';
    }
    
    
    
}
