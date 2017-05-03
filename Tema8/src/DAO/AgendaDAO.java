/*
 * Todos los métodos que interactuan con la base de datos aquí
 */
package DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;

/**
 *
 * @author AlumMati
 */
/*
public class AgendaDAO {

    
    
    public static void main(String[] args) {
        try {
            Conexion_DB conexion_DB = new Conexion_DB();
            System.out.println("Abrir conexión");
            Connection con = conexion_DB.AbrirConexion();
            System.out.println("Conexión abierta");
            PreparedStatement stmt;
            stmt = con.prepareStatement("UPDATE contacto SET Nombre = 'Toñito' WHERE Id=?");
            stmt.setInt(1, 1);
            
            int retorno = stmt.executeUpdate();
            System.out.println("Cerrar conexión");
            conexion_DB.CerrarConexion(con);
            System.out.println("Conexión cerrada");
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }
    
    //Métodos
    public void consultar(){
        int i = 0;
        //boolean para saber si se ha encontrado, por lo menos, un contacto con el nombre buscado 
        boolean b = false;
        //Este while nos devuelve todos los contactos que tengan el mismo nombre
        while(i < (agend.size())){
            if(agend.get(i).getNombre().equalsIgnoreCase(nombre) == true){
                mostrar(i);
                b = true;
            }
            i++;
        }
        if(b == false){
            System.out.println("No se ha encontrado ningún usuario con ese nombre");
        }
    }
}
*/