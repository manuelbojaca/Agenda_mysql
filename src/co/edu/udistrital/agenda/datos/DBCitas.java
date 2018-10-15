package co.edu.udistrital.agenda.datos;

import java.sql.*;
import co.edu.udistrital.agenda.logica.*;

public class DBCitas {

    DBConexion cn;

    public DBCitas() {
        cn = new DBConexion();
    }

    /**
     * trae una cita por su id
     */
    public Cita getCitaById(int id) {
        Cita data = new Cita();
        try {
            PreparedStatement pstm = cn.getConexion().prepareStatement("SELECT c_id, "
                                                                        + " id, "
                                                                        + " lugar, "
                                                                        + " fecha, "
                                                                        + " hora,"
                                                                        + " asunto "
                                                                        + " FROM citas "
                                                                        + " where c_id = ? ");

            pstm.setInt(1, id);
            ResultSet res = pstm.executeQuery();
            int i = 0;
            DBContactos dbc = new DBContactos();
            if (res.next()) {
                data = new Cita();
                data.setC_id(res.getInt("c_id"));
                data.setContacto(dbc.getContactoById(res.getInt("id")));
                data.setLugar(res.getString("lugar"));
                data.setFecha(res.getString("fecha"));
                data.setHora(res.getString("hora"));
                data.setAsunto(res.getString("asunto"));
            }
            res.close();

        } catch (SQLException e) {
            System.out.println(e + " p1");
        }
        return data;
    }

    /**
     * trae todos los registros de la tabla contactos
     */
    public Cita[] getCitas() {
        int registros = 0;

        try {
            PreparedStatement pstm = cn.getConexion().prepareStatement("SELECT count(1) as cont"
                                                                        + " FROM citas ");

            ResultSet res = pstm.executeQuery();

            res.next();
            registros = res.getInt("cont");
            res.close();

        } catch (SQLException e) {
            System.out.println(e+ " p2");
        }
        Cita[] data = new Cita[registros];
        try {
            PreparedStatement pstm = cn.getConexion().prepareStatement("SELECT c_id, "
                                                                        + " id, "
                                                                        + " hora, "
                                                                        + " fecha, "
                                                                        + " asunto,"
                                                                        + " lugar "
                                                                        + " FROM citas "
                                                                        + " ORDER BY fecha desc, hora desc ");

            ResultSet res = pstm.executeQuery();
            int i = 0;
            DBContactos dbc = new DBContactos();
            while (res.next()) {
                data[i] = new Cita();
                data[i].setC_id(res.getInt("c_id"));
                data[i].setContacto(dbc.getContactoById(res.getInt("id")));
                data[i].setLugar(res.getString("lugar"));
                data[i].setFecha(res.getString("fecha"));
                data[i].setHora(res.getString("hora"));
                data[i].setAsunto(res.getString("asunto"));
                i++;
            }
            res.close();

        } catch (SQLException e) {
            System.out.println(e + " Falla en citas :-)");
        }
        return data;
    }

    public int insertarCita(Cita c) {
        int resultado = 0;//no hubo errores de validacion
        try {
            PreparedStatement pstm = cn.getConexion().prepareStatement("insert into citas (id,"
                                                                        + " lugar,"
                                                                        + " fecha,"
                                                                        + " hora,"
                                                                        + " asunto) "
                                                                        + " values(?,?,?,?,?)");
            pstm.setInt(1, c.getContacto().getId());
            pstm.setString(2, c.getLugar());
            pstm.setString(3, c.getFecha());
            pstm.setString(4, c.getHora());
            pstm.setString(5, c.getAsunto());
            pstm.executeUpdate();

            pstm = cn.getConexion().prepareStatement("select last_insert_id()");
            ResultSet res = pstm.executeQuery();
            res.next();
            resultado = res.getInt(1);
            res.close();
        }catch (SQLException e) {
            System.out.println(e+ " p3");
        }
        return resultado;
    }

    public int actualizarCita(Cita c) {
        int resultado = 0;
        System.out.println("resultado 1 = " + resultado);
        try {
            PreparedStatement pstm = cn.getConexion().prepareStatement("update citas set id = ?, "
                                                                        + " lugar = ?,"
                                                                        + " fecha = ?,"
                                                                        + " hora = ?,"
                                                                        + " asunto = ? "
                                                                        + "where c_id = ?");
            pstm.setInt(1, c.getContacto().getId());
            pstm.setString(2, c.getLugar());
            pstm.setString(3, c.getFecha());
            pstm.setString(4, c.getHora());
            pstm.setString(5, c.getAsunto());
            pstm.setInt(6, c.getC_id());

            resultado = pstm.executeUpdate();
            System.out.println("resultado = " + resultado);

        } catch (SQLException e) {
            System.out.println(e+ " p4");
        }
        return resultado;
    }

    public int borrarCita(Cita c) {
        int resultado = 0;
        try {
            PreparedStatement pstm = cn.getConexion().prepareStatement("delete from citas "
                                                                        + "where c_id = ?");
            pstm.setInt(1, c.getC_id());

            resultado = pstm.executeUpdate();

        } catch (SQLException e) {
            System.out.println(e+ " p5");
        }

        return resultado;
    }

}
