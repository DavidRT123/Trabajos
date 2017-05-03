/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;
import java.sql.*;
/**
 *
 * @author AlumMati
 */
public class Conexion_DB {
        public Connection AbrirConexion() throws Exception
        {
            Connection con = null;
            try{
                Class.forName("com.mysql.jdbc.Driver");
                String urldbc = "jdbc:mysql://localhost:3306/agenda";
                con = (java.sql.DriverManager.getConnection(urldbc, "root", ""));
                return con;
            }catch(ClassNotFoundException | SQLException e){
                System.out.println("Ha sido imposible establecer la conexión "+e.getMessage()); 
            }
            return con;
        }
        
        public void CerrarConexion(Connection con) throws Exception
        {
            try{
                if (con != null){
                    con.close();
                }
            }catch(SQLException e){
                System.out.println("Ha sido imposible establecer la conexión"+e.getMessage()); 
            }
        }
}