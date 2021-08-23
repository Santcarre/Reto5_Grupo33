/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package utility;

import java.sql.*;

/**
 *
 * @author Santiago
 */
public class conexion {
    private static final String UBICACION_BD="ProyectosConstruccion.db";
    
    String url = "jdbc:sqlite:"+ UBICACION_BD;
    
    Connection conn = null;
    
    public conexion (){
        try {
            Class.forName("org.sqlite.JDBC");
            conn = DriverManager.getConnection(url);
            System.out.println("Conexion Establecida");
        } catch (Exception e) {
            System.out.println(e);
        }
    }
    
    public ResultSet consultarRegistro(String url){
        try {
            PreparedStatement pstm = conn.prepareStatement(url);
            ResultSet respuesta = pstm.executeQuery();
            return respuesta;
        }   catch (Exception e){
            System.out.println(e);
            return null;
        }
    }
}
