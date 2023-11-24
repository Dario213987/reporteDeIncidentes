
package Pantallas.Formularios;

import Entidades.Cliente;
import Entidades.Incidente;
import Entidades.Servicio;
import Entidades.Tecnico;
import Logica.DAOGenericoHibernate;
import Pantallas.pantallaPrincipal;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.time.Duration;
import java.util.Calendar;

public class FormularioIncidencia extends javax.swing.JDialog {
    DAOGenericoHibernate<Incidente> incidentes;
    DAOGenericoHibernate<Cliente> clientes;
    DAOGenericoHibernate<Servicio> servicios;
    DAOGenericoHibernate<Tecnico> tecnicos;
    public FormularioIncidencia(java.awt.Frame parent, boolean modal,DAOGenericoHibernate<Incidente> incidentes, DAOGenericoHibernate<Cliente> clientes, DAOGenericoHibernate<Servicio> servicios, DAOGenericoHibernate<Tecnico> tecnicos) {
        super(parent, modal);
        this.incidentes = incidentes;
        this.clientes = clientes;
        this.servicios = servicios;
        this.tecnicos = tecnicos;
        initComponents();
    }
    private void initComponents() {
        setResizable(false);
        setTitle("Nueva Incidencia");

        fechaIncidencia = new com.toedter.calendar.JDateChooser();
        comboboxClientes = new javax.swing.JComboBox<>();
        comboboxServicios = new javax.swing.JComboBox<>();
        comboboxTecnicos = new javax.swing.JComboBox<>();
        botonGuardar = new javax.swing.JButton();
        horasEstimadas = new javax.swing.JSpinner();
        jLabel1 = new javax.swing.JLabel();
        minutosEstimados = new javax.swing.JSpinner();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        cajaDeObservaciones = new javax.swing.JTextPane();
        jLabel8 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        fechaIncidencia.setDateFormatString("dd/MM/yyyy");
        fechaIncidencia.setDate(Calendar.getInstance().getTime());

        comboboxClientes.setModel(new javax.swing.DefaultComboBoxModel<>(clientes.getAll().toArray(new Cliente[0])));
        comboboxClientes.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                if(comboboxClientes.getSelectedItem() != null){
                    comboboxServicios.setModel(new DefaultComboBoxModel<>(
                            clientes.getByID(((Cliente)comboboxClientes.getSelectedItem()).getIdCliente()).getServiciosContratados().toArray(new Servicio[0])));
                            comboboxServicios.setEnabled(true);
                            comboboxTecnicos.setModel(new DefaultComboBoxModel<>());
                            comboboxTecnicos.setEnabled(false);
                }
            }
        });
        comboboxServicios.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                if(comboboxServicios.getSelectedItem() != null){
                    comboboxTecnicos.setModel(new DefaultComboBoxModel<>(
                            servicios.getByID(((Servicio)comboboxServicios.getSelectedItem()).getIdServicio()).getTecnicosCapacitados().toArray(new Tecnico[0])));
                    comboboxTecnicos.setEnabled(true);
                }
            }
        });

        comboboxServicios.setEnabled(false);
        comboboxTecnicos.setEnabled(false);
        botonGuardar.setText("Guardar");
        botonGuardar.addActionListener(this::guardarIncidencia);

        jLabel1.setText(":");

        jLabel2.setText("hs.");

        jLabel3.setText("Tiempo estimado (opcional):");

        jLabel4.setText("Fecha:");

        jLabel5.setText("Cliente:");

        jLabel6.setText("Servicio:");

        jLabel7.setText("Técnico:");

        jScrollPane1.setViewportView(cajaDeObservaciones);

        jLabel8.setText("Observaciones:");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(botonGuardar))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(6, 6, 6)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel3)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(horasEstimadas, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jLabel1)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(minutosEstimados, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jLabel2))
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                .addComponent(comboboxTecnicos, javax.swing.GroupLayout.Alignment.LEADING, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(comboboxServicios, javax.swing.GroupLayout.Alignment.LEADING, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(comboboxClientes, javax.swing.GroupLayout.Alignment.LEADING, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jLabel4, javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(fechaIncidencia, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 199, Short.MAX_VALUE)
                                .addComponent(jLabel5, javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(jLabel6, javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(jLabel7, javax.swing.GroupLayout.Alignment.LEADING)))
                        .addGap(32, 32, 32)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jScrollPane1)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel8)
                                .addGap(0, 474, Short.MAX_VALUE)))))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(22, 22, 22)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(jLabel8))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(fechaIncidencia, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jLabel5)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(comboboxClientes, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jLabel6)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(comboboxServicios, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jLabel7)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(comboboxTecnicos, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jLabel3)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(horasEstimadas, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel1)
                            .addComponent(minutosEstimados, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel2)))
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 405, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(botonGuardar)
                .addContainerGap())
        );

        pack();
    }
    public void guardarIncidencia(ActionEvent actionEvent){
        if(comboboxServicios.getSelectedItem() == null){
            JOptionPane.showMessageDialog(this,"Seleccionar un Servicio","Error",JOptionPane.ERROR_MESSAGE);
            return;
        }
        if(comboboxTecnicos.getSelectedItem() == null){
            JOptionPane.showMessageDialog(this,"Asignar un técnico","Error",JOptionPane.ERROR_MESSAGE);
            return;
        }
        if(cajaDeObservaciones.getText().isEmpty()){
            JOptionPane.showMessageDialog(this,"Llenar la caja de observaciones con ua descripción de problema","Error",JOptionPane.ERROR_MESSAGE);
            return;
        }
        Incidente nuevoIncidente = new Incidente();
        nuevoIncidente.setCliente((Cliente) comboboxClientes.getSelectedItem());
        nuevoIncidente.setServicio((Servicio) comboboxServicios.getSelectedItem());
        nuevoIncidente.setTecnicoAsignado((Tecnico) comboboxTecnicos.getSelectedItem());
        nuevoIncidente.setEstado(false);
        nuevoIncidente.setObservaciones(cajaDeObservaciones.getText());
        nuevoIncidente.setTiempoEstimado(Duration.ofHours(Math.abs((Integer) horasEstimadas.getValue())).toMillis()+ Duration.ofMinutes(Math.abs((Integer) minutosEstimados.getValue())).toMillis());
        nuevoIncidente.setFecha(fechaIncidencia.getDate());
        ((Cliente) comboboxClientes.getSelectedItem()).addIncidente(nuevoIncidente);
        System.out.println("Estoy guardando Flaco");
        incidentes.save(nuevoIncidente);
        ((pantallaPrincipal)getParent()).getTablaIncidencias().agregarIncidente(nuevoIncidente);
        this.dispose();
    }


    private javax.swing.JButton botonGuardar;
    private javax.swing.JTextPane cajaDeObservaciones;
    private javax.swing.JComboBox<Cliente> comboboxClientes;
    private javax.swing.JComboBox<Servicio> comboboxServicios;
    private javax.swing.JComboBox<Tecnico> comboboxTecnicos;
    private com.toedter.calendar.JDateChooser fechaIncidencia;
    private javax.swing.JSpinner horasEstimadas;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JSpinner minutosEstimados;
}
