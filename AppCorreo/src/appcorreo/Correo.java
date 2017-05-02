/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package appcorreo;

    
/**
 *
 * @author AlumMati
 */
public class Correo {

    /**
     * @param args the command line arguments
     */
    private String origen;
    private String destino;
    private String asunto;
    private String mensaje;
    
    public Correo (String o, String d, String a, String m){}

    /**
     * @return the origen
     */
    public String getOrigen() {
        return origen;
    }

    /**
     * @param origen the origen to set
     */
    public void el_Origen(String origen) {
        this.origen = origen;
    }

    /**
     * @return the destino
     */
    public String getDestino() {
        return destino;
    }

    /**
     * @param destino the destino to set
     */
    public void setDestino(String destino) {
        this.destino = destino;
    }

    /**
     * @return the asunto
     */
    public String getAsunto() {
        return asunto;
    }

    /**
     * @param asunto the asunto to set
     */
    public void setAsunto(String asunto) {
        this.asunto = asunto;
    }

    /**
     * @return the mensaje
     */
    public String getMensaje() {
        return mensaje;
    }

    /**
     * @param mensaje the mensaje to set
     */
    public void setMensaje(String mensaje) {
        this.mensaje = mensaje;
    }
    
    public String toString(){
        String cadena = ("\n Origen: " + getOrigen() + "\nDestino: " + getDestino() + "\nAsunto: " + getAsunto() + "\nMensaje:\n" + getMensaje());  
        return cadena;
    }
    
    
}
