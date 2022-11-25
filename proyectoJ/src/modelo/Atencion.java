package modelo;

import java.util.Date;

/**
 *
 * @author jimen
 */
public class Atencion {
    
    private int idAtencion;
    private Date fecha_Atencion;
    private String hr_Atencion,rutM,rutP;

    public Atencion() {
    }

    public Atencion(int idAtencion, Date fecha_Atencion, String hr_Atencion, String rutM, String rutP) {
        this.idAtencion = idAtencion;
        this.fecha_Atencion = fecha_Atencion;
        this.hr_Atencion = hr_Atencion;
        this.rutM = rutM;
        this.rutP = rutP;
    }

    public int getIdAtencion() {
        return idAtencion;
    }

    public void setIdAtencion(int idAtencion) {
        this.idAtencion = idAtencion;
    }

    public Date getFecha_Atencion() {
        return fecha_Atencion;
    }

    public void setFecha_Atencion(Date fecha_Atencion) {
        this.fecha_Atencion = fecha_Atencion;
    }

    public String getHr_Atencion() {
        return hr_Atencion;
    }

    public void setHr_Atencion(String hr_Atencion) {
        this.hr_Atencion = hr_Atencion;
    }

    public String getRutM() {
        return rutM;
    }

    public void setRutM(String rutM) {
        this.rutM = rutM;
    }

    public String getRutP() {
        return rutP;
    }

    public void setRutP(String rutP) {
        this.rutP = rutP;
    }

    @Override
    public String toString() {
        return "Atencion{" + "idAtencion=" + idAtencion + ", fecha_Atencion=" + fecha_Atencion + ", hr_Atencion=" + hr_Atencion + ", rutM=" + rutM + ", rutP=" + rutP + '}';
    }
    
    
    
    
}
