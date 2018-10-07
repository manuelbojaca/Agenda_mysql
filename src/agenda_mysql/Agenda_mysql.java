package agenda_mysql;

import co.edu.udistrital.pryagenda.datos.*;
import co.edu.udistrital.pryagenda.logica.*;

public class Agenda_mysql {

    public static void main(String[] args) {

        Contacto[] contactos;
        DBConexion conn = new DBConexion();
        DBContactos con = new DBContactos();
        con.getContactos();
        contactos = con.getContactos();
        Object[][] data = new Object[contactos.length][5];
        for (int c=0;c<contactos.length;c++){
            data[c][0]=contactos[c].getId();
            data[c][1]=contactos[c].getNombre();
            data[c][2]=contactos[c].getApellido();
            data[c][3]=contactos[c].getCelular();
            data[c][4]=contactos[c].getCorreo(); 
        }
        for (int i=0; i<5; i++){
            for (int j=0; j<5; j++){
                System.out.println(data[i][j]);
            }
        }
    }
    
}
