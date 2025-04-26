/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package rest.restaurante;

import java.sql.Connection;
import java.sql.DriverManager;
import javax.swing.JOptionPane;
import java.sql.PreparedStatement;
import java.sql.SQLException;

/**
 *
 * @author Andy
 */
public class Conexion {
    Connection conexion = null;
    String HOST = "localhost";
    String PUERTO = "5432";
    String DB = "restaurante_base";
    String USER = "postgres";
    String PASSWORD = "andyapolo";
    
    public void Conectarme(){
        try {
            conexion = DriverManager.getConnection("jdbc:postgresql://localhost:5432/restaurante_base", USER, PASSWORD);
            JOptionPane.showMessageDialog(null, "Grabado");
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, e);
        }
    }
    public void Ingreso(String script){
        PreparedStatement p = null;
        Conectarme();
        
        try {
            p = conexion.prepareStatement(script);
            p.executeUpdate();
            JOptionPane.showMessageDialog(null, "Ejecucion completa");
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
                    
        }
    }
}