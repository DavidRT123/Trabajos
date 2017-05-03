/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import Agenda.Inicio;
import Entidad.Contacto;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author AlumMati
 */
public class ContactoDAO {
    public void añadirContactoBD(Contacto cont){
        try {
        Conexion_DB c = new Conexion_DB();
        Connection con = c.AbrirConexion();
        PreparedStatement stmt = con.prepareStatement("INSERT INTO contacto(Nombre, Apellido, Telefono, FechaNac) VALUES(?, ?, ?, ?)");
        stmt.setString(1, cont.getNombre());
        stmt.setString(2, cont.getApellido());
        stmt.setInt(3, cont.getTelefono());
        
        java.util.Date utilDate = new java.util.Date();
        
        utilDate = cont.getFecha();
        
        java.sql.Date sqlDate = new java.sql.Date(utilDate.getTime());
        
        stmt.setDate(4, sqlDate);
        stmt.executeUpdate();
        } catch (Exception ex) {
            Logger.getLogger(Inicio.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public void buscarContacto(String nom) throws Exception{
        ResultSet r = null;
        Conexion_DB conexion_DB = new Conexion_DB();
        Connection con = conexion_DB.AbrirConexion();
        Statement stmt = con.createStatement();
        r = stmt.executeQuery("SELECT * FROM contacto WHERE Nombre='"+nom+"'");
        mostrar(r);
    }
    
    public void eliminarContacto(int i){
        try {
        Conexion_DB c = new Conexion_DB();
        Connection con = c.AbrirConexion();
        PreparedStatement stmt = con.prepareStatement("DELETE FROM contacto WHERE Id=?");
        stmt.setInt(1, i);
        stmt.executeUpdate();
            System.out.println("\nEl contacto ha sido eliminado con éxito\n");
        } catch (Exception ex) {
            Logger.getLogger(Inicio.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public void modificarContacto(int i){
        try {
            BufferedReader sc = new BufferedReader(new InputStreamReader(System.in));
            Conexion_DB c = new Conexion_DB();
            Connection con = c.AbrirConexion();
            int resp, telefono;
            String nombre, apellido, fecha;
            Date cal;
            PreparedStatement stmt = null;
            do{
                //Menú
                System.out.println("\n***************************************************************");
                System.out.println("Pulsa 1 para modificar el nombre");
                System.out.println("Pulsa 2 para modificar el apellido");
                System.out.println("Pulsa 3 para modificar el teléfono");
                System.out.println("Pulsa 4 para modificar la fecha de nacimiento");
                System.out.println("Pulsa 0 para terminar de modificar");
                System.out.println("***************************************************************\n");
                resp = Integer.parseInt(sc.readLine());

                //switch opciones del menú
                switch(resp){
                    case 0:
                        System.out.println("\nLa moficicación se ha realizado correctamente\n");
                    break;

                    case 1:
                        System.out.println("Introduce el nuevo nombre: ");
                        nombre = sc.readLine();
                        stmt = con.prepareStatement("UPDATE contacto SET Nombre = '"+nombre+"' WHERE Id='"+i+"'");
                    break;

                    case 2:
                        System.out.println("Introduce el nuevo apellido: ");
                        apellido = sc.readLine();
                        stmt = con.prepareStatement("UPDATE contacto SET Apellido = '"+apellido+"' WHERE Id='"+i+"'");
                    break;

                    case 3:
                        System.out.println("Introduce el nuevo teléfono: ");
                        telefono = Integer.parseInt(sc.readLine());
                        stmt = con.prepareStatement("UPDATE contacto SET Telefono = '"+telefono+"' WHERE Id='"+i+"'");
                    break;

                    case 4:
                        System.out.println("Introduce la nueva fecha de nacimiento: ");
                        fecha = sc.readLine();
                        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
                        cal = sdf.parse(fecha);
                        
                        java.util.Date utilDate = new java.util.Date();
        
                        utilDate = cal;

                        java.sql.Date sqlDate = new java.sql.Date(utilDate.getTime());
                        stmt = con.prepareStatement("UPDATE contacto SET FechaNac = '"+sqlDate+"' WHERE Id='"+i+"'");
                    break;
                }
                stmt.executeUpdate();
            }while(resp != 0);
        } catch (Exception ex) {
            Logger.getLogger(Inicio.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public void listar() throws Exception{
        ResultSet r = null;
        Conexion_DB conexion_DB = new Conexion_DB();
        Connection con = conexion_DB.AbrirConexion();
        Statement stmt = con.createStatement();
        r = stmt.executeQuery("SELECT * FROM contacto");
        mostrar(r);
    }
    
    public void mostrar(ResultSet r) throws SQLException{
        while(r.next()){
            int i = r.getInt("Id");
            String n = r.getString("Nombre");
            String a = r.getString("Apellido");
            String t = r.getString("Telefono");
            Date f = r.getDate("FechaNac");
            System.out.println("\n*************** Índice: "+ i + " ***************");
            System.out.println("Nombre: " + n + "\n Apellido: " + a + "\nTeléfono: " + t + "\nFecha de nacimiento: " + f);
        }
    }
}
