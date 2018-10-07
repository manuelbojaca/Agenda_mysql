package agenda_mysql;

import javax.swing.JTable;
import javax.swing.JScrollPane;
import javax.swing.JFrame;
import java.awt.*;
import java.awt.event.*;
import co.edu.udistrital.agenda.datos.DBConexion;
import co.edu.udistrital.agenda.datos.DBContactos;
import co.edu.udistrital.agenda.logica.Contacto;


public class Tabla extends JFrame {

    public Tabla() {

        super("Citas");

        Contacto[] contactos;
        DBConexion conn = new DBConexion();
        DBContactos con = new DBContactos();
        contactos = con.getContactos();
        Object[][] data = new Object[contactos.length][5];

        for (int c=0;c<contactos.length;c++){

            data[c][0]=contactos[c].getNombre();
            data[c][1]=contactos[c].getApellido();
            data[c][2]=contactos[c].getCelular();
            data[c][3]=contactos[c].getTelefono();
            data[c][4]=contactos[c].getCorreo();
        }

        String[] columnNames = {"Nombre", "Apellido", "telefono", "celular", "correo"};

        final JTable table = new JTable(data, columnNames);
        table.setPreferredScrollableViewportSize(new Dimension(500, 80));

        JScrollPane scrollpane = new JScrollPane(table);

        getContentPane().add(scrollpane, BorderLayout.CENTER);

        //manejamos la salida
        addWindowListener(new WindowAdapter() {

            public void windowClosing(WindowEvent e) {
                System.exit(0);
            }
        });
    }

    public static void main(String ar[]) {
            Tabla frame = new Tabla();
            frame.pack();
            frame.setVisible(true);
        }
}