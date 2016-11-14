package com.serviciosPubli.Utilidades;


import com.serviciosPubli.Persistencia.SQLHelpers;
import java.sql.*;//importa todos los paquetes de sql
import java.util.logging.Level;
import java.util.logging.Logger;


public class Conexion {

   public Connection con;

    public Connection conexion() {
        try {
            Class.forName("com.mysql.jdbc.Driver");
            con = DriverManager.getConnection("jdbc:mysql://127.0.0.1/serviciospublicos", "serviPublic", "");
        } catch (ClassNotFoundException | SQLException e) {
            System.out.println("ClassNotFoundException  :"
                    + e.getMessage());
        }

        return con;
    }

    public Connection getCon() {
        conexion();
        return con;
    }

    public void setCon(Connection con) {
        this.con = con;
    }
    public void cerrarConexion() throws SQLException {
        this.con.close();
    }

    
    public static void main(String param[]) {
        Conexion c = new Conexion();
        Connection con;
        
        try {
            ResultSet r = c.getCon().prepareStatement(com.serviciosPubli.Persistencia.SQLHelpers.getTiposServicio()).executeQuery();
            if (r.next()) {
                System.out.println("Nombre :" + r.getString(2));
                while (r.next()) {
                    System.out.println("Nombre :" + r.getString(2));
                }// fin while
            } else {
                System.out.println("No hay datos ");
                
            }// fin si

            
        } catch (Exception e) {
            System.out.println("Error : " + e.getMessage() + " Causa " + e.getCause());
            
        } finally {
            try {
                c.cerrarConexion();
            } catch (SQLException ex) {
                Logger.getLogger(Conexion.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        
    }
}
