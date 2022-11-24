
package modelo;

/**
 *
 * @author jimen
 */
public class Paciente {
    private String rut,nombre,genero,isapre;
    private int edad,celular;

    public Paciente() {
    }

    public Paciente(String rut, String nombre, String genero, String isapre, int edad, int celular) {
        this.rut = rut;
        this.nombre = nombre;
        this.genero = genero;
        this.isapre = isapre;
        this.edad = edad;
        this.celular = celular;
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

    public String getIsapre() {
        return isapre;
    }

    public void setIsapre(String isapre) {
        this.isapre = isapre;
    }

    public int getEdad() {
        return edad;
    }

    public void setEdad(int edad) {
        this.edad = edad;
    }

    public int getCelular() {
        return celular;
    }

    public void setCelular(int celular) {
        this.celular = celular;
    }

    @Override
    public String toString() {
        return "Paciente{" + "rut=" + rut + ", nombre=" + nombre + ", genero=" + genero + ", isapre=" + isapre + ", edad=" + edad + ", celular=" + celular + '}';
    }
    
    
    
    
}
