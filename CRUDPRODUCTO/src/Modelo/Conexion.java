/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Modelo;

import com.mysql.jdbc.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Conexion{
    private final String base ="bdPrueba";
    private final String user ="root";
    private final String pass ="";
    private final String url ="jdbc:mysql://localhost:3306/" + base;
    private Connection con = null;
    
    public Connection getConexion(){
       try{
           Class.forName("com.mysql.jdbc.Driver");
           con = (Connection) DriverManager.getConnection(this.url,this.user,this.pass);
       } catch(SQLException e){
           System.err.println(e);
           
       } catch (ClassNotFoundException ex) {
            Logger.getLogger(Conexion.class.getName()).log(Level.SEVERE, null, ex);
        }
       return con;
    }
}
