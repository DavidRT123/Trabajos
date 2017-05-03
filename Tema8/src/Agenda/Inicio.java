/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Agenda;

import DAO.Conexion_DB;
import DAO.ContactoDAO;
import Entidad.Contacto;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author AlumMati
 */
public class Inicio {
    
    public Inicio() throws IOException, Exception{
        menu();
    }
    
    public static void main(String[] args) throws IOException, Exception{
        Inicio object = new Inicio();
    }
    
    public void menu() throws IOException, Exception{
        int resp;
        BufferedReader sc = new BufferedReader(new InputStreamReader(System.in));
        ContactoDAO DAO = new ContactoDAO();
        try {
            do {
                System.out.println("\n****** MENÚ *******\n1. Consultar contacto\n2. Modificar contacto\n3. Eliminar contacto\n4. Añadir nuevo contacto\n5. Imprimir todos los contactos\n0. Salir\n******************************");
                resp = Integer.parseInt(sc.readLine());
                switch (resp) {
                    case 1:
                        consultar();
                        break;
                    case 2:
                        modificar();
                        break;
                    case 3:
                        eliminar();
                        break;
                    case 4:
                        crearContacto();
                        break;
                    case 5:
                        DAO.listar();
                        break;
                }
            } while (resp != 0);
        } catch (ParseException ex) {
            Logger.getLogger(Inicio.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public void crearContacto() throws ParseException{
        try {
            BufferedReader sc = new BufferedReader(new InputStreamReader(System.in));
            String nombre, apellido, direccion, nota, fecha;
            Date cal;
            Contacto cont;
            int telefono;
            System.out.println("Introduce nombre: ");
            nombre = sc.readLine();
            System.out.println("Introduce apellido: ");
            apellido = sc.readLine();
            System.out.println("Introduce direccion: ");
            direccion = sc.readLine();
            System.out.println("Introduce teléfono: ");
            telefono = Integer.parseInt(sc.readLine());
            System.out.println("Introduce anotación: ");
            nota = sc.readLine();
            System.out.println("Introduce fecha de nacimiento: ");
            fecha = sc.readLine();
            SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
            cal = sdf.parse(fecha);
            
            cont = new Contacto(nombre, apellido, direccion, telefono, cal, nota);
            
            ContactoDAO DAO = new ContactoDAO();
            DAO.añadirContactoBD(cont);
            
        } catch (IOException ex) {
            Logger.getLogger(Inicio.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public void eliminar() throws Exception{
        try {
            BufferedReader sc = new BufferedReader(new InputStreamReader(System.in));
            String nombre;
            int resp;
            System.out.println("\nIntroduce el nombre del contacto a borrar: ");
            nombre = sc.readLine();
            ContactoDAO DAO = new ContactoDAO();
            DAO.buscarContacto(nombre);
            System.out.println("\nIntroduce el índice del usuario que quieres borrar: ");
            resp = Integer.parseInt(sc.readLine());
            DAO.eliminarContacto(resp);
        } catch (IOException ex) {
            Logger.getLogger(Inicio.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public void consultar() throws Exception{
        try{
        ContactoDAO DAO = new ContactoDAO();
        BufferedReader sc = new BufferedReader(new InputStreamReader(System.in));
        String nombre;
        System.out.println("\nIntroduce el nombre del contacto que quieres consultar: ");
        nombre = sc.readLine();
        DAO.buscarContacto(nombre);
        }catch(IOException ex){
            Logger.getLogger(Inicio.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public void modificar() throws Exception{
        try {
            BufferedReader sc = new BufferedReader(new InputStreamReader(System.in));
            String nombre;
            int resp;
            System.out.println("\nIntroduce el nombre del contacto que quieres modificar: ");
            nombre = sc.readLine();
            ContactoDAO DAO = new ContactoDAO();
            DAO.buscarContacto(nombre);
            System.out.println("\nIntroduce el índice del contacto que quieres modificar: ");
            resp = Integer.parseInt(sc.readLine());
            DAO.modificarContacto(resp);
        } catch (IOException ex) {
            Logger.getLogger(Inicio.class.getName()).log(Level.SEVERE, null, ex);
        }    
    }
}
