package co.edu.udistrital.agenda.graficos;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import co.edu.udistrital.agenda.datos.*;
import co.edu.udistrital.agenda.logica.*;
import javax.swing.table.DefaultTableModel;

public class FormAgenda implements ActionListener{
    
    JFrame frame;
    JPanel panel;
    JMenuBar menuBar;
    JMenu menu, subMenu;
    JMenuItem menuItem;
    JScrollPane scrollPanel;
    DefaultTableModel modeloTabla;
    JTable tablaContactos;
    JTabbedPane pestana;
    Container panelInformacion,panelCitas;
    JLabel labelId, labelNombre, labelApellido, labelTelefonoDomicilio,
    labelTelefonoOficina, labelDireccionDomicilio, labelDireccionOficina,
    labelCelular, labelCorreo, labelCid, labelHora, labelFecha, labelLugar, labelAsunto;
    JTextField textId, textNombre, textApellido, textTelefonoDomicilio, textTelefonoOficina,
    textDireccionDomicilio, textDireccionOficina, textCelular, textCorreo,
    textCid, textHora, textFecha, textLugar, textAsunto;
    JButton botonNuevoContacto, botonGuardarContacto, botonEditarContacto,
    botonBorrarContacto, botonGuardarCita, botonBorrarCita, botonNuevaCita, botonEditarCita;
    
    DBContactos dbco = new DBContactos();
    DBCitas dbci = new DBCitas();
    Contacto[] contactos;
    Cita[] citas;
    int estado = 0;
    int estado1 = 0;
    int fila;

    public FormAgenda() {
        initComponents();
    }
    
    public void initComponents(){

        frame = new JFrame("Agenda de Contactos");
        menuBar = new JMenuBar();
        frame.setJMenuBar(menuBar);
        menu = new JMenu("Opciones");
        menuBar.add(menu);
        menuItem = new JMenuItem("Acerca de ...");
        menuItem.addActionListener(this);
        menu.add(menuItem);
        menuItem = new JMenuItem("Salir");
        menuItem.addActionListener(this);
        menu.add(menuItem);
        panelInformacion = new JPanel(null);
        panelInformacion.setLayout(null);
        panelCitas = new JPanel(null);
        panelCitas.setLayout(null);
        pestana = new JTabbedPane();
        
        pestana.addTab("Información de contacto", panelInformacion);
        pestana.addTab("Citas",panelCitas);
        
        //CITAS
        
        int a = 10;
        int b = 5;
        int AbelAncho = 150;
        int AbelAlto = 20;
        int textoAncho = 150;
        int textoAlto = 20;
        
        labelCid = new JLabel("Id de Cita");
        labelCid.setBounds(a,b,100,20);
        panelCitas.add(labelCid);
        textCid = new JTextField();
        textCid.setBounds(a+80,b,50,20);
        panelCitas.add(textCid);
        b+=30;
        
        labelHora = new JLabel("Hora de Cita");
        labelHora.setBounds(a+188,b,AbelAncho,AbelAlto);
        panelCitas.add(labelHora);
        textHora = new JTextField();
        textHora.setBounds(a+288,b,textoAncho,textoAlto);
        panelCitas.add(textHora);
        b+=30;
        
        labelFecha = new JLabel("Fecha de Cita");
        labelFecha.setBounds(a+180,b,AbelAncho,AbelAlto);
        panelCitas.add(labelFecha);
        textFecha = new JTextField();
        textFecha.setBounds(a+288,b,textoAncho,textoAlto);
        panelCitas.add(textFecha);
        b+=30;
        AbelAncho+=100;
        
        labelLugar = new JLabel("Lugar de Cita");
        labelLugar.setBounds(a+180,b,AbelAncho,AbelAlto);
        panelCitas.add(labelLugar);
        textLugar = new JTextField();
        textLugar.setBounds(a+288,b,AbelAncho,AbelAlto);
        panelCitas.add(textLugar);
        b+=30;
        AbelAncho+=100;

        labelAsunto = new JLabel("Asunto de Cita");
        labelAsunto.setBounds(a+170,b,AbelAncho,AbelAlto);
        panelCitas.add(labelAsunto);
        textAsunto = new JTextField();
        textAsunto.setBounds(a+288,b,AbelAncho,AbelAlto);
        panelCitas.add(textAsunto);

        b+=60;
        AbelAncho-=200;
        
        botonNuevaCita = new JButton("Nueva Cita");
        botonNuevaCita.setBounds(a,b,AbelAncho,50);
        panelCitas.add(botonNuevaCita);
        botonNuevaCita.addActionListener(this);
        botonGuardarCita = new JButton("Guardar Cita");
        botonGuardarCita.setBounds(a+200,b,AbelAncho,50);
        panelCitas.add(botonGuardarCita);
        botonGuardarCita.addActionListener(this);
        botonEditarCita = new JButton("Editar Cita");
        botonEditarCita.setBounds(a+400,b,AbelAncho,50);
        panelCitas.add(botonEditarCita);
        botonEditarCita.addActionListener(this);
        botonBorrarCita = new JButton("Borrar Cita");
        botonBorrarCita.setBounds(a+600,b,AbelAncho,50);
        panelCitas.add(botonBorrarCita);
        botonBorrarCita.addActionListener(this);
        citas = dbci.getCitas();
        
        //CONTACTOS
        
        int y = 5;
        int x = 10;
        int labelAncho = 150;
        int labelAlto = 20;
        int textAncho = 200;
        int textAlto = 20;
        
        labelId = new JLabel("Id");
        labelId.setBounds(x,y,20,20);
        panelInformacion.add(labelId);
        textId = new JTextField();
        textId.setBounds(x+30,y,50,20);
        panelInformacion.add(textId);
        y+=30;
        
        labelNombre = new JLabel("Nombre",SwingConstants.RIGHT);
        labelNombre.setBounds(x,y,labelAncho,labelAlto);
        panelInformacion.add(labelNombre);
        textNombre = new JTextField();
        textNombre.setBounds(x+160,y,textAncho,textAlto);
        panelInformacion.add(textNombre);
        
        labelApellido = new JLabel("Apellido",SwingConstants.RIGHT);
        labelApellido.setBounds(x+350,y,labelAncho,labelAlto);
        panelInformacion.add(labelApellido);
        textApellido = new JTextField();
        textApellido.setBounds(x+510,y,textAncho,textAlto);
        panelInformacion.add(textApellido);
        y+=30;
        
        labelTelefonoDomicilio = new JLabel("Telefono Domicilio",SwingConstants.RIGHT);
        labelTelefonoDomicilio.setBounds(x,y,labelAncho,labelAlto);
        panelCitas.add(labelTelefonoDomicilio);
        panelInformacion.add(labelTelefonoDomicilio);
        textTelefonoDomicilio = new JTextField();
        textTelefonoDomicilio.setBounds(x+160,y,textAncho,textAlto);
        panelInformacion.add(textTelefonoDomicilio);
        
        labelTelefonoOficina = new JLabel("Telefono Oficina",SwingConstants.RIGHT);
        labelTelefonoOficina.setBounds(x+350,y,labelAncho,labelAlto);
        panelInformacion.add(labelTelefonoOficina);
        textTelefonoOficina = new JTextField();
        textTelefonoOficina.setBounds(x+510,y,textAncho,textAlto);
        panelInformacion.add(textTelefonoOficina);
        y+=30;
        
        labelDireccionDomicilio = new JLabel("Dirreción Domicilio",SwingConstants.RIGHT);
        labelDireccionDomicilio.setBounds(x,y,labelAncho,labelAlto);
        panelInformacion.add(labelDireccionDomicilio);
        textDireccionDomicilio = new JTextField();
        textDireccionDomicilio.setBounds(x+160,y,textAncho,textAlto);
        panelInformacion.add(textDireccionDomicilio);
        
        labelDireccionOficina = new JLabel("Dirección Oficina",SwingConstants.RIGHT);
        labelDireccionOficina.setBounds(x+350,y,labelAncho,labelAlto);
        panelInformacion.add(labelDireccionOficina);
        textDireccionOficina = new JTextField();
        textDireccionOficina.setBounds(x+510,y,textAncho,textAlto);
        panelInformacion.add(textDireccionOficina);
        y+=30;
        
        labelCelular = new JLabel("Celular",SwingConstants.RIGHT);
        labelCelular.setBounds(x,y,labelAncho,labelAlto);
        panelInformacion.add(labelCelular);
        textCelular = new JTextField();
        textCelular.setBounds(x+160,y,textAncho,textAlto);
        panelInformacion.add(textCelular);
        
        labelCorreo = new JLabel("Correo",SwingConstants.RIGHT);
        labelCorreo.setBounds(x+350,y,labelAncho,labelAlto);
        panelInformacion.add(labelCorreo);
        textCorreo = new JTextField();
        textCorreo.setBounds(x+510,y,textAncho,textAlto);
        panelInformacion.add(textCorreo);
        y+=60;
        
        botonNuevoContacto = new JButton("Nuevo Contacto");
        botonNuevoContacto.setBounds(x,y,labelAncho,50);
        panelInformacion.add(botonNuevoContacto);
        botonNuevoContacto.addActionListener(this);
        botonGuardarContacto = new JButton("Guardar Contacto");
        botonGuardarContacto.setBounds(x+200,y,labelAncho,50);
        panelInformacion.add(botonGuardarContacto);
        botonGuardarContacto.addActionListener(this);
        botonEditarContacto = new JButton("Editar Contacto");
        botonEditarContacto.setBounds(x+400,y,labelAncho,50);
        panelInformacion.add(botonEditarContacto);
        botonEditarContacto.addActionListener(this);
        botonBorrarContacto = new JButton("Borrar Contacto");
        botonBorrarContacto.setBounds(x+600,y,labelAncho,50);
        panelInformacion.add(botonBorrarContacto);
        botonBorrarContacto.addActionListener(this);
        contactos = dbco.getContactos();
        
        Object[][] data = new Object[contactos.length][5];
        for (int c=0;c<contactos.length;c++){
            data[c][0]=contactos[c].getId();
            data[c][1]=contactos[c].getNombre();
            data[c][2]=contactos[c].getApellido();
            data[c][3]=contactos[c].getCelular();
            data[c][4]=contactos[c].getCorreo();
            System.out.println("prueba");
        }
        
        String[] columNames = {"id","nombres","apellidos","celular","correo"};
        modeloTabla= new DefaultTableModel(data, columNames);
        tablaContactos = new JTable(modeloTabla);
        tablaContactos.setPreferredScrollableViewportSize(new Dimension(500, 150));
        scrollPanel = new JScrollPane(tablaContactos);
        tablaContactos.addMouseListener(new MouseAdapter(){

            public void mouseClicked(MouseEvent e){

                fila = tablaContactos.rowAtPoint(e.getPoint());
                int columna = tablaContactos.columnAtPoint(e.getPoint());
                if ((fila > -1) && (columna > -1)){
                    boolean p = true;
                    estado1 = 0;
                    textId.setText(String.valueOf(tablaContactos.getValueAt(fila,0)));
                    for(int i=0;i<contactos.length;i++){
                        
                        if(String.valueOf(contactos[i].getId()).equals(
                            String.valueOf(tablaContactos.getValueAt(fila, 0)))){
                                
                                textNombre.setText(contactos[i].getNombre());
                                textApellido.setText(contactos[i].getApellido());
                                textTelefonoDomicilio.setText(contactos[i].getTelefono());
                                textTelefonoOficina.setText(contactos[i].getTelefonoOficina());
                                textDireccionDomicilio.setText(contactos[i].getDireccion());
                                textDireccionOficina.setText(contactos[i].getDireccionTrabajo());
                                textCelular.setText(contactos[i].getCelular());
                                textCorreo.setText(contactos[i].getCorreo());
                        }
                    }
                    for(int j=0;j<citas.length;j++){
                       
                        System.out.println(String.valueOf(tablaContactos.getValueAt(fila,0)) + " " + (citas[j].getContacto().getId()));
                        if(String.valueOf(tablaContactos.getValueAt(fila,0)).equals(
                            String.valueOf(citas[j].getContacto().getId()))){
                                
                                textCid.setText(String.valueOf(citas[j].getC_id()));
                                textHora.setText(citas[j].getHora());
                                textFecha.setText(citas[j].getFecha());
                                textAsunto.setText(citas[j].getAsunto());
                                textLugar.setText(citas[j].getLugar());
                                System.out.println("citasText");
                                p = false;
                        }
                        else if(p){
                            limpiarCamposC();
                        }
                    }
                    if(!p){
                        estado1 = 2;
                    }
                    estado = 2;
                    alterarEstado();
                    alterarEstadoC();
                }
            }
        });    
        frame.getContentPane().add(scrollPanel,BorderLayout.NORTH);
        frame.getContentPane().add(pestana,BorderLayout.CENTER);
        frame.pack();
        frame.setSize(800, 500);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setResizable(false);
        JFrame.setDefaultLookAndFeelDecorated(true);
        
        frame.setVisible(true);
    
        alterarEstado();
        alterarEstadoC();
    }
    
    public void alterarEstado(){
        
        switch(this.estado){
        
            case 0://estado por defecto
                botonNuevoContacto.setEnabled(true);
                botonBorrarContacto.setEnabled(false);
                botonEditarContacto.setEnabled(false);
                botonGuardarContacto.setEnabled(false);
                
                textId.setEditable(false);
                textNombre.setEditable(false);
                textApellido.setEditable(false);
                textTelefonoDomicilio.setEditable(false);
                textTelefonoOficina.setEditable(false);
                textDireccionDomicilio.setEditable(false);
                textDireccionOficina.setEditable(false);
                textCorreo.setEditable(false);
                textCelular.setEditable(false);
                break;
            
            case 1://estado para un nuevo contacto
                botonNuevoContacto.setEnabled(false);
                botonBorrarContacto.setEnabled(false);
                botonEditarContacto.setEnabled(false);
                botonGuardarContacto.setEnabled(true);
                
                textId.setEditable(false);
                textNombre.setEditable(true);
                textApellido.setEditable(true);
                textTelefonoDomicilio.setEditable(true);
                textTelefonoOficina.setEditable(true);
                textDireccionDomicilio.setEditable(true);
                textDireccionOficina.setEditable(true);
                textCorreo.setEditable(true);
                textCelular.setEditable(true);
                break;
            
            case 2://estado de carga de un contacto
                botonNuevoContacto.setEnabled(false);
                botonBorrarContacto.setEnabled(true);
                botonEditarContacto.setEnabled(true);
                botonGuardarContacto.setEnabled(false);
                
                textId.setEditable(false);
                textNombre.setEditable(false);
                textApellido.setEditable(false);
                textTelefonoDomicilio.setEditable(false);
                textTelefonoOficina.setEditable(false);
                textDireccionDomicilio.setEditable(false);
                textDireccionOficina.setEditable(false);
                textCorreo.setEditable(false);
                textCelular.setEditable(false);
                break;
            
            case 3://estado para editar un contacto
                botonNuevoContacto.setEnabled(false);
                botonBorrarContacto.setEnabled(false);
                botonEditarContacto.setEnabled(false);
                botonGuardarContacto.setEnabled(true);
                
                textId.setEditable(false);
                textNombre.setEditable(true);
                textApellido.setEditable(true);
                textTelefonoDomicilio.setEditable(true);
                textTelefonoOficina.setEditable(true);
                textDireccionDomicilio.setEditable(true);
                textDireccionOficina.setEditable(true);
                textCorreo.setEditable(true);
                textCelular.setEditable(true);
                break;
        }    
    }
    
    public void alterarEstadoC(){
        
        switch(this.estado1){
        
            case 0://estado por defecto
                botonNuevaCita.setEnabled(true);
                botonBorrarCita.setEnabled(false);
                botonEditarCita.setEnabled(false);
                botonGuardarCita.setEnabled(false);
                
                textCid.setEditable(false);
                textHora.setEditable(false);
                textFecha.setEditable(false);
                textAsunto.setEditable(false);
                textLugar.setEditable(false);
                break;
            
            case 1://estado para un nuevo contacto
                botonNuevaCita.setEnabled(false);
                botonBorrarCita.setEnabled(false);
                botonEditarCita.setEnabled(false);
                botonGuardarCita.setEnabled(true);
                
                textCid.setEditable(false);
                textHora.setEditable(true);
                textFecha.setEditable(true);
                textAsunto.setEditable(true);
                textLugar.setEditable(true);
                break;
            
            case 2://estado de carga de un contacto
                botonNuevaCita.setEnabled(false);
                botonBorrarCita.setEnabled(true);
                botonEditarCita.setEnabled(true);
                botonGuardarCita.setEnabled(false);
                
                textCid.setEditable(false);
                textHora.setEditable(false);
                textFecha.setEditable(false);
                textAsunto.setEditable(false);
                textLugar.setEditable(false);
                break;
            
            case 3://estado para editar un contacto
                botonNuevaCita.setEnabled(false);
                botonBorrarCita.setEnabled(false);
                botonEditarCita.setEnabled(false);
                botonGuardarCita.setEnabled(true);
                
                textCid.setEditable(false);
                textHora.setEditable(true);
                textFecha.setEditable(true);
                textAsunto.setEditable(true);
                textLugar.setEditable(true);
                break;
        }    
    }
    
    public void limpiarCampos(){
    
        textId.setText("");
        textNombre.setText("");
        textApellido.setText("");
        textTelefonoDomicilio.setText("");
        textTelefonoOficina.setText("");
        textDireccionDomicilio.setText("");
        textDireccionOficina.setText("");
        textCorreo.setText("");
        textCelular.setText("");
    }
    
    public void limpiarCamposC(){
    
        textCid.setText("");
        textHora.setText("");
        textFecha.setText("");
        textAsunto.setText("");
        textLugar.setText("");
    }
    
    public void actionPerformed(ActionEvent e) {
        String accion = e.getActionCommand();
        System.out.println(accion);
        if(accion.equals("Salir")){
            System.exit(-1);
        }
        if(accion.equals("Acerca de ...")){
            Dialogo a = new Dialogo(null,false);
            a.setVisible(true);
        }
    
        if(accion.equals("Nuevo Contacto")){
            limpiarCampos();
            this.estado=1;
        }
        
        if(accion.equals("Editar Contacto")){
            this.estado=3;
        }
        if(accion.equals("Guardar Contacto")){
            if(this.estado==1){
                
                Contacto c = new Contacto();
                c.setNombre(textNombre.getText());
                c.setApellido(textApellido.getText());
                c.setTelefono(textTelefonoDomicilio.getText());
                c.setTelefonoOficina(textTelefonoOficina.getText());
                c.setDireccion(textDireccionDomicilio.getText());
                c.setDireccionTrabajo(textDireccionOficina.getText());
                c.setCorreo(textCorreo.getText());
                c.setCelular(textCelular.getText());
                int r = dbco.insertarContacto(c);
                
                if(r>0){
                
                    Object[] newRow={r,c.getNombre(),c.getApellido(),c.getCelular(),c.getCorreo()};
                    modeloTabla.addRow(newRow);
                    JOptionPane.showMessageDialog(null, "Contacto agregado");
                }
            }else if(this.estado==3){
                
                Contacto c = new Contacto();
                c.setId(Integer.parseInt(textId.getText(),10));
                c.setNombre(textNombre.getText());
                c.setApellido(textApellido.getText());
                c.setTelefono(textTelefonoDomicilio.getText());
                c.setTelefonoOficina(textTelefonoOficina.getText());
                c.setDireccion(textDireccionDomicilio.getText());
                c.setDireccionTrabajo(textDireccionOficina.getText());
                c.setCorreo(textCorreo.getText());
                c.setCelular(textCelular.getText());
                int r = dbco.actualizarContacto(c);
                
                if(r>0){
                
                    modeloTabla.setValueAt(c.getNombre(), fila, 1);
                    modeloTabla.setValueAt(c.getApellido(), fila, 2);
                    modeloTabla.setValueAt(c.getCelular(), fila, 3);
                    modeloTabla.setValueAt(c.getCorreo(), fila, 4);
                    JOptionPane.showMessageDialog(null, "Contacto actualizado");
                }
            }
            
            contactos = dbco.getContactos();
            limpiarCampos();
            this.estado=0;
        }
        if(accion.equals("Borrar Contacto")){
            
            Contacto c = new Contacto();
            c.setId(Integer.parseInt(textId.getText(),10));
            int r = dbco.borrarContacto(c);
            
            if(r>0){
                
                modeloTabla.removeRow(fila);
                JOptionPane.showMessageDialog(null, "Contacto borrado");
                limpiarCampos();
            }
            contactos = dbco.getContactos();
            this.estado=0;
        }
        alterarEstado();
        
        //CITAS
        
        if(accion.equals("Nueva Cita")){
            limpiarCampos();
            this.estado1=1;
        }
        
        if(accion.equals("Editar Cita")){
            this.estado1=3;
        }
        if(accion.equals("Guardar Cita")){
            if(this.estado1==1){
                
                Cita c = new Cita();
                
                c.setHora(textHora.getText());
                c.setFecha(textFecha.getText());
                c.setAsunto(textAsunto.getText());
                c.setLugar(textLugar.getText());
                int r = dbci.insertarCita(c);
                
                if(r>0){
                
                    /*Object[] newRow={r,c.getNombre(),c.getApellido(),c.getCelular(),c.getCorreo()};
                    modeloTabla.addRow(newRow);*/
                    JOptionPane.showMessageDialog(null, "Cita agregada");
                }
            }else if(this.estado==3){
                
                Cita c = new Cita();
                c.setC_id(Integer.parseInt(textCid.getText(),10));
                c.setHora(textNombre.getText());
                c.setFecha(textApellido.getText());
                c.setAsunto(textTelefonoDomicilio.getText());
                c.setLugar(textTelefonoOficina.getText());
                int r = dbci.actualizarCita(c);
                
                if(r>0){
                
                    /*modeloTabla.setValueAt(c.getNombre(), fila, 1);
                    modeloTabla.setValueAt(c.getApellido(), fila, 2);
                    modeloTabla.setValueAt(c.getCelular(), fila, 3);
                    modeloTabla.setValueAt(c.getCorreo(), fila, 4);*/
                    JOptionPane.showMessageDialog(null, "Cita actualizada");
                }
            }
            
            citas = dbci.getCitas();
            limpiarCamposC();
            this.estado1=0;
        }
        if(accion.equals("Borrar Cita")){
            
            Cita c = new Cita();
            c.setC_id(Integer.parseInt(textId.getText(),10));
            int r = dbci.borrarCita(c);
            
            if(r>0){
                
                //modeloTabla.removeRow(fila);
                JOptionPane.showMessageDialog(null, "Cita borrada");
                limpiarCamposC();
            }
            citas = dbci.getCitas();
            this.estado1=0;
        }
        alterarEstadoC();
    }
}