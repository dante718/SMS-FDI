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
import GestionProyectos.GDP.Negocio.TPersona;

public class VistaProyectos extends JFrame implements IVista{
		private JTable tabla;
		private TPersona PersonaSeleccionada;
		private ModeloTablaProyectos modelo= new ModeloTablaProyectos();
		private JLabel etiqueta;
		private JPanel panel= new JPanel();
        public void setPersona(TPersona Persona) {
         	this.PersonaSeleccionada=Persona;
         }
		protected void initVista() {
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
        public TPersona getPersonaSeleccionada() {
        	return PersonaSeleccionada;
        }
        public ModeloTablaProyectos getModelo() {
        	return modelo;
        }
		@Override
		public void Visibilizar() {
			setVisible(true);			
		} 
}
