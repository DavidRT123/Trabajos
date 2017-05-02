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
public class CarpetaCorreo {
    
    private final Correo carpeta[];
    private final Correo eliminados[];
    
    // Constructor
    public CarpetaCorreo(){
         carpeta = new Correo[40];
         eliminados = new Correo[40];
    }
    public void añadirC (Correo c){
        int i = 0;
        while(carpeta[i] != null && i < carpeta.length){
            i ++;
        }
        carpeta[i]= c;
    }
    /*public Correo borrarC (int i){
        while(){
        
        }
        
        return mess;
    }*/
    public  Correo  busca  (String  orig){
        Correo mess = null;
        
        return mess;
    }
}
