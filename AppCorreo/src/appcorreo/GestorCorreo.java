 /*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package appcorreo;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
/**
 *
 * @author AlumMati
 */
public class GestorCorreo {
    static BufferedReader sc = new BufferedReader(new InputStreamReader(System.in));
    public static void main(String [] argm) throws IOException{
        menu();
    }
    
    public static void menu() throws IOException{
    int resp;
        do{
        System.out.println("****** MENÚ PRINCIPAL *******\n1. Mostrar correos\n2. Añadir un correo\n3. Borrar un correo\n4. Buscar un  correo\n0. Terminar\nElige una opción:\n******************************");
        resp = sc.read();
        switch(resp){
            case 1:
                
                break;
            case 2:
                
                break;
            case 3:
                
                break;
            case 4:
                
                break;
        }
                }while(resp != 0);
        
    }
}
