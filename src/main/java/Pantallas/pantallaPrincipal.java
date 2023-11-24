
package Pantallas;

import Entidades.Cliente;
import Entidades.Incidente;
import Entidades.Servicio;
import Entidades.Tecnico;
import Logica.DAOGenericoHibernate;
import Pantallas.Elementos.TablaClientes;
import Pantallas.Elementos.TablaIncidentes;
import Pantallas.Elementos.TablaServicios;
import Pantallas.Elementos.TablaTecnico;
import Pantallas.Formularios.FormularioIncidencia;
import com.formdev.flatlaf.FlatLaf;
import com.formdev.flatlaf.intellijthemes.materialthemeuilite.FlatMaterialDarkerContrastIJTheme;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;


public class pantallaPrincipal extends javax.swing.JFrame {
    DAOGenericoHibernate<Incidente> incidentes;
    DAOGenericoHibernate<Cliente> clientes;
    DAOGenericoHibernate<Servicio> servicios;
    DAOGenericoHibernate<Tecnico> tecnicos;
    public pantallaPrincipal() {
        cargarDAO();
        initComponents();
    }
    public void cargarDAO(){
        incidentes = new DAOGenericoHibernate<>(Incidente.class);
        clientes = new DAOGenericoHibernate<>(Cliente.class);
        servicios = new DAOGenericoHibernate<>(Servicio.class);
        tecnicos = new DAOGenericoHibernate<>(Tecnico.class);
    }
    private void initComponents() {
        setTitle("Gestión de incidencias");
        setPreferredSize(new Dimension(1280,720));

        TabbedPane = new javax.swing.JTabbedPane();
        TabIncidencias = new javax.swing.JLayeredPane();
        scrollTablaIncidencias = new javax.swing.JScrollPane();
        tablaIncidencias = new javax.swing.JTable();
        panelSuperiorIncidencias = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        jDateChooser1 = new com.toedter.calendar.JDateChooser();
        jLabel1 = new javax.swing.JLabel();
        jDateChooser2 = new com.toedter.calendar.JDateChooser();
        jCheckBox1 = new javax.swing.JCheckBox();
        jLayeredPane2 = new javax.swing.JLayeredPane();
        jScrollPane5 = new javax.swing.JScrollPane();
        tablaTecnicos = new javax.swing.JTable();
        jLayeredPane3 = new javax.swing.JLayeredPane();
        jScrollPane6 = new javax.swing.JScrollPane();
        tablaClientes = new javax.swing.JTable();
        jLayeredPane4 = new javax.swing.JLayeredPane();
        jScrollPane7 = new javax.swing.JScrollPane();
        tablaServicios = new javax.swing.JTable();
        JPopupMenu menuIncidencias = new JPopupMenu();
        JMenuItem nuevaIncidencia = new JMenuItem();

        tablaIncidencias.setFocusable(false);
        tablaClientes.setFocusable(false);
        tablaServicios.setFocusable(false);
        tablaTecnicos.setFocusable(false);

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        TabIncidencias.setLayout(new java.awt.BorderLayout());

        tablaIncidencias.setModel(new TablaIncidentes(incidentes.getAll()));

        nuevaIncidencia.setText("Nueva Incidencia");
        var ventana = this;
        nuevaIncidencia.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                FormularioIncidencia formulario = new FormularioIncidencia(ventana,true,incidentes,clientes,servicios,tecnicos);
                formulario.setLocationRelativeTo(ventana);
                formulario.setVisible(true);
            }
        });
        menuIncidencias.add(nuevaIncidencia);
        tablaIncidencias.setComponentPopupMenu(menuIncidencias);

        tablaIncidencias.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                if(e.getClickCount()==2){
                    System.out.println(((TablaIncidentes)tablaIncidencias.getModel()).getIncidente(tablaIncidencias.rowAtPoint(e.getPoint())));
                }
                if(e.isPopupTrigger()){
                    menuIncidencias.show(tablaIncidencias,e.getX(),e.getY());
                }
            }
        });
        scrollTablaIncidencias.setViewportView(tablaIncidencias);

        TabIncidencias.add(scrollTablaIncidencias, java.awt.BorderLayout.CENTER);

        jLabel2.setText("Desde");
        panelSuperiorIncidencias.add(jLabel2);
        panelSuperiorIncidencias.add(jDateChooser1);

        jLabel1.setText("hasta");
        panelSuperiorIncidencias.add(jLabel1);
        panelSuperiorIncidencias.add(jDateChooser2);

        jCheckBox1.setText("Resuelta");

        panelSuperiorIncidencias.add(jCheckBox1);

        TabIncidencias.add(panelSuperiorIncidencias, java.awt.BorderLayout.PAGE_START);

        TabbedPane.addTab("Incidencias", TabIncidencias);

        jLayeredPane2.setLayout(new java.awt.BorderLayout());

        tablaTecnicos.setModel(new TablaTecnico(tecnicos.getAll()));
        tablaTecnicos.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                if(e.getClickCount()==2){
                    System.out.println(((TablaTecnico)tablaTecnicos.getModel()).getIncidente(tablaTecnicos.rowAtPoint(e.getPoint())));
                }
            }
        });
        jScrollPane5.setViewportView(tablaTecnicos);

        jLayeredPane2.add(jScrollPane5, java.awt.BorderLayout.CENTER);

        TabbedPane.addTab("Técnicos", jLayeredPane2);

        jLayeredPane3.setLayout(new java.awt.BorderLayout());

        tablaClientes.setModel(new TablaClientes(clientes.getAll()));
        tablaClientes.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                if(e.getClickCount()==2){
                    System.out.println(((TablaClientes)tablaClientes.getModel()).getIncidente(tablaClientes.rowAtPoint(e.getPoint())));
                }
            }
        });
        jScrollPane6.setViewportView(tablaClientes);

        jLayeredPane3.add(jScrollPane6, java.awt.BorderLayout.CENTER);

        TabbedPane.addTab("Clientes", jLayeredPane3);

        jLayeredPane4.setLayout(new java.awt.BorderLayout());

        tablaServicios.setModel(new TablaServicios(servicios.getAll()));
        tablaServicios.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                if(e.getClickCount()==2){
                    System.out.println(((TablaServicios)tablaServicios.getModel()).getIncidente(tablaServicios.rowAtPoint(e.getPoint())));
                }
            }
        });
        jScrollPane7.setViewportView(tablaServicios);

        jLayeredPane4.add(jScrollPane7, java.awt.BorderLayout.CENTER);

        TabbedPane.addTab("Servicios", jLayeredPane4);

        getContentPane().add(TabbedPane, java.awt.BorderLayout.CENTER);

        pack();
    }

    public TablaIncidentes getTablaIncidencias(){
        return (TablaIncidentes) tablaIncidencias.getModel();
    }

    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(pantallaPrincipal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(pantallaPrincipal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(pantallaPrincipal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(pantallaPrincipal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                FlatLaf.setup(new FlatMaterialDarkerContrastIJTheme());
                UIManager.put( "Button.arc", 17 );
                UIManager.put( "Component.arc", 17 );
                UIManager.put( "TextComponent.arc", 17 );
                UIManager.put( "Component.focusWidth", 1 );
                UIManager.put( "ScrollBar.thumbArc", 999 );
                UIManager.put( "ScrollBar.thumbInsets", new Insets( 2, 2, 2, 2 ) );
                var pantalla = new pantallaPrincipal();
                pantalla.setLocationRelativeTo(null);
                pantalla.setVisible(true);
            }
        });
    }
    private javax.swing.JCheckBox jCheckBox1;
    private com.toedter.calendar.JDateChooser jDateChooser1;
    private com.toedter.calendar.JDateChooser jDateChooser2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLayeredPane TabIncidencias;
    private javax.swing.JLayeredPane jLayeredPane2;
    private javax.swing.JLayeredPane jLayeredPane3;
    private javax.swing.JLayeredPane jLayeredPane4;
    private javax.swing.JPanel panelSuperiorIncidencias;
    private javax.swing.JScrollPane scrollTablaIncidencias;
    private javax.swing.JScrollPane jScrollPane5;
    private javax.swing.JScrollPane jScrollPane6;
    private javax.swing.JScrollPane jScrollPane7;
    private javax.swing.JTabbedPane TabbedPane;
    private javax.swing.JTable tablaClientes;
    private javax.swing.JTable tablaIncidencias;
    private javax.swing.JTable tablaServicios;
    private javax.swing.JTable tablaTecnicos;
}
