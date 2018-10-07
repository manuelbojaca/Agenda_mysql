package co.edu.udistrital.agenda.datos;

import java.sql.*;
import co.edu.udistrital.agenda.logica.*;

public class DBContactos {

    DBConexion cn;

    public DBContactos() {

        cn = new DBConexion();
    }

    public Contacto[] getContactos(){

        int registros = 0;
        
        try{
            PreparedStatement pstm = cn.getConexion().prepareStatement("SELECT count(1) as cont" +
                                                                        " FROM contactos ");
            ResultSet res = pstm.executeQuery();
            res.next();
            registros = res.getInt("cont");
            res.close();
        }catch(SQLException e){
            System.out.println(e);
        }
        Contacto[] data = new Contacto[registros];
        
        try{
        
            PreparedStatement pstm = cn.getConexion().prepareStatement("SELECT id, " +
                                                                   " nombre, " +
                                                                   " apellido, " +
                                                                   " telefono, " +
                                                                   " celular, " +
                                                                   " correo " +
                                                                   " FROM contactos " + 
                                                                   "ORDER BY nombre, apellido");
            ResultSet res = pstm.executeQuery();
            int i = 0;
            while(res.next()){
            
                data[i] = new Contacto();
                data[i].setId(res.getInt("id"));
                data[i].setNombre(res.getString("nombre"));
                data[i].setApellido(res.getString("apellido"));
                data[i].setTelefono(res.getString("telefono"));
                data[i].setCelular(res.getString("celular"));
                data[i].setCorreo(res.getString("correo"));
                i++;
            }
            res.close();
        }catch(SQLException e){

            System.out.println(e);
        }
        return data;
    }

    public int insertarContacto(Contacto c){
        
        int cont_usuario = -1;
        int resultado = 0;//no hubo errores de validacion
        
        try{
            
            PreparedStatement pstm = cn.getConexion().prepareStatement("select count(1) as cont " +
                                                                        " from contactos " +
                                                                        " where correo = ? ");
            pstm.setString(1, c.getCorreo());
            ResultSet res = pstm.executeQuery();
            res.next();
            cont_usuario = res.getInt("cont");
            res.close();
            if(cont_usuario == 0){
                pstm = cn.getConexion().prepareStatement("insert into contactos (nombre, " +
                                                            " apellido," +
                                                            " telefono," +                                                       " telefono_oficina," +
                                                            " celular," +
                                                            " correo)" +
                                                            " values(?,?,?,?,?,?,?,?)");
                pstm.setString(1, c.getNombre());
                pstm.setString(2, c.getApellido());
                pstm.setString(3, c.getTelefono());
                pstm.setString(4, c.getCelular());
                pstm.setString(5, c.getCorreo());
                pstm.executeUpdate();
                pstm = cn.getConexion().prepareStatement("select last_insert_id()");
                res = pstm.executeQuery();
                res.next();
                resultado = res.getInt(1);
                res.close();
            }else{
                resultado = -2;//el login ya existe
            }
        }catch(SQLException e){
            System.out.println(e);
        }
        return resultado;
    }
    
    public int actualizarContacto(Contacto c){

        int resultado = 0;
        try{

            PreparedStatement pstm = cn.getConexion().prepareStatement("update contactos " +
                                                                        " set nombre = ?, " +
                                                                        " apellido = ?," +
                                                                        " telefono = ?," +
                                                                        " celular = ?," +
                                                                        " correo = ?," +
                                                                        " where id = ?");
            pstm.setString(1, c.getNombre());
            pstm.setString(2, c.getApellido());
            pstm.setString(3, c.getTelefono());
            pstm.setString(4, c.getCelular());
            pstm.setString(5, c.getCorreo());
            pstm.setInt(6, c.getId());
            resultado = pstm.executeUpdate();     
        }catch(SQLException e){
            System.out.println(e);
        }
        return resultado;
    }
    
    public int borrarContacto(Contacto c){
        
        int resultado = 0;
        try{
            
            PreparedStatement pstm = cn.getConexion().prepareStatement("delete from contactos " +
                                                                        "where id = ?");
            pstm.setInt(1, c.getId());
            resultado = pstm.executeUpdate();
        }catch(SQLException e){
            System.out.println(e);
        }   
        return resultado;
    }

 public Contacto getContactoById(int id){
        Contacto c = new Contacto();
        try{
            PreparedStatement pstm = cn.getConexion().prepareStatement("SELECT con_id, " +
                                                                                " con_nombre, " +
                                                                                " con_apellido, " +
                                                                                " con_celular, " +
                                                                                " con_correo " +
                                                                        " FROM contactos " + 
                                                                        " WHERE con_id = ? ");
            pstm.setInt(1, id);
            
            ResultSet res = pstm.executeQuery();
            if(res.next()){
                c.setId(res.getInt("con_id"));
                c.setNombre(res.getString("con_nombre"));
                c.setApellido(res.getString("con_apellido"));
                c.setCelular(res.getString("con_celular"));
                c.setCorreo(res.getString("con_correo"));
            }
            res.close();	
            
            
        }catch(SQLException e){
            System.out.println(e);
        }
        return c;
    }
}