package Entidad;

import java.io.Serializable;
import java.util.Calendar;
import java.util.Date;

/**
 *
 * @author AlumMati
 */
public class Contacto implements Serializable{
    
    //Atributos
    private String nombre;
    private String apellido;
    private String direccion;
    private int telefono;
    private Date cal;
    private String anotacion;
    
    //Constructores
    public Contacto(){}
    
    public Contacto(String n, String ap, String d, int t, Date f, String a){
        setNombre(n);
        setApellido(ap);
        setDireccion(d);
        setTelefono(t);
        setFecha(f);
        setAnotacion(a);
    }

    /**
     * @return the nombre
     */
    public String getNombre() {
        return nombre;
    }

    /**
     * @param nombre the nombre to set
     */
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    /**
     * @return the direccion
     */
    public String getDireccion() {
        return direccion;
    }

    /**
     * @param direccion the direccion to set
     */
    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    /**
     * @return the telefono
     */
    public int getTelefono() {
        return telefono;
    }

    /**
     * @param telefono the telefono to set
     */
    public void setTelefono(int telefono) {
        this.telefono = telefono;
    }

    /**
     * @return the fecha
     */
    public Date getFecha() {
        return cal;
    }

    /**
     * @param fecha the fecha to set
     */
    public void setFecha(Date fecha) {
        this.cal = fecha;
    }

    /**
     * @return the anotacion
     */
    public String getAnotacion() {
        return anotacion;
    }

    /**
     * @param anotacion the anotacion to set
     */
    public void setAnotacion(String anotacion) {
        this.anotacion = anotacion;
    }

    /**
     * @return the apellido
     */
    public String getApellido() {
        return apellido;
    }

    /**
     * @param apellido the apellido to set
     */
    public void setApellido(String apellido) {
        this.apellido = apellido;
    }
}