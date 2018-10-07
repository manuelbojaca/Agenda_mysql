package co.edu.udistrital.pryagenda.datos;

import java.sql.*;

public class DBConexion {

    private static final String bd = "Agenda";
    private static final String driver = "com.mysql.jdbc.Driver";
    private static final String login = "root";
    private static final String password = "";
    private static final String url = "jdbc:mysql://localhost:3306/" + bd;
    private static Connection conexion = null;

    public DBConexion() {

        try{
            
            Class.forName(driver);
            conexion = DriverManager.getConnection(url, login, password);
            if (conexion!=null){
                System.out.println("Conexión a base de datos " + bd + " establecida");
            }
        }catch(SQLException e){
            System.out.println(e);
        }catch(ClassNotFoundException e){
            System.out.println(e);
        }
    }
    
    public Connection getConexion(){
        return conexion;
    }
    
    public void desconectar(){
        conexion = null;
    }
}