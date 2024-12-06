/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package Vista;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;


/**
 *
 * @author LENOVO
 */
public class Conexion {
     private final String bd = "bd_sistema_mikrom"; //nombre de la BD
    private final String user = "root"; //usuario con permisos para manejar la BD
    private final String password = "12345"; //contraseña asignada al usario root
    //Nombre del servidor. localhost:3306 es la ruta y el puerto de la conexión MariaDB
    private final String url = "jdbc:mariadb://localhost:3306/" + bd;
    private Connection conector = null;
    
    public Connection Conectar() {
        try {
            //Driver JDBC
            Class.forName("org.mariadb.jdbc.Driver");
            //Se inicia la conexión
            conector = DriverManager.getConnection(url, user, password);
            System.out.println("Conexion muy exitosa");
            //JOptionPane.showMessageDialog(null, "Conexion correcta");
        } catch (ClassNotFoundException ex) {
            System.out.println("Error en la conexión a la base de datos:" + ex);
            //JOptionPane.showMessageDialog(null, ex, "Error en la conexión a la base de datos: " + ex.getMessage(), JOptionPane.ERROR_MESSAGE);
        } catch (SQLException ex) {
            //JOptionPane.showMessageDialog(null, ex, "Error en la conexión a la base de datos: " + ex.getMessage(), JOptionPane.ERROR_MESSAGE);
            System.out.println("Error en la conexión a la base de datos:" + ex);
        } catch (Exception ex) {
            //JOptionPane.showMessageDialog(null, ex, "Error en la conexión a la base de datos: " + ex.getMessage(), JOptionPane.ERROR_MESSAGE);
            System.out.println("Error en la conexión a la base de datos:" + ex);
        }
        return conector;
    }

    public void cerrar() {
        try {
            if (conector != null) {
                conector.close();
            }
        } catch (SQLException e) {
            System.err.println(e);
        }
    }
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
         Conexion c1 = new Conexion();
        c1.Conectar(); 
    }
    
}
