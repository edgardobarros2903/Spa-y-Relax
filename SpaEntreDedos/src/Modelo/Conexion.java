package Modelo;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import javax.swing.JOptionPane;


public class Conexion {
    
    private static final String url = "jdbc:mariadb://localHost/";
    private static final String db = "spayrelax";
    private static final String usuario = "root";
    private static final String pass = "";
    private static  Connection conexion;
    
    public static Connection getConexion(){
        if(conexion == null){
            try{
                Class.forName("org.mariadb.jdbc.Driver");
                conexion = DriverManager.getConnection(url+db, usuario, pass);
            }catch(SQLException ex){
                JOptionPane.showMessageDialog(null, "Error de conexion ..."+ex.getMessage());
            }catch(ClassNotFoundException ex){
                JOptionPane.showMessageDialog(null, "Error al cargar los driver ..."+ex.getMessage());
            }
                    
        }
        return conexion;
    }
}

