package GestionProyectos.GDP.Presentacion;
import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;


import GestionProyectos.GDP.Integracion.ModeloTablaProyectos;

public abstract class VistaProyectos extends JFrame{
		private JTable tabla;
		private String DNISeleccionado;
		private ModeloTablaProyectos modelo= new ModeloTablaProyectos();
		private JLabel etiqueta;
		private JPanel panel= new JPanel();
        public void setDNI(String DNI) {
         	this.DNISeleccionado=DNI;
         }
		public void initVista() {
			setSize(500,350);
			panel.setLayout(new BorderLayout());
			etiqueta= new JLabel("Proyectos:");
			panel.add(etiqueta,BorderLayout.PAGE_START);
			modelo=Controlador.getInstancia().crearTablaProyectos();			
		    tabla= new JTable(modelo);
			panel.add(new JScrollPane(tabla), BorderLayout.CENTER);
			setLocationRelativeTo(null);
			setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		}
        public JPanel getPanel() {
        	return panel;
        }
        public JTable getTabla() {
        	return tabla;
        }
        public String getDNISeleccionado() {
        	return DNISeleccionado;
        }
        public ModeloTablaProyectos getModelo() {
        	return modelo;
        }
       
}
