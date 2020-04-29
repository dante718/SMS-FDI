package GestionProyectos.GDP.Vista;

import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;

import GestionProyectos.GDP.Controlador.Controlador;
import GestionProyectos.GDP.Modelo.ModeloTablaProyectos;

public class VistaProyectos extends JFrame{
		private Controlador controlador;
		private JTable tabla;
		private ModeloTablaProyectos modelo= new ModeloTablaProyectos();
		private JLabel etiqueta;
		private VistaProyectos vp;
		private JButton añadir, cancelar;
		private JPanel panel= new JPanel();
        public VistaProyectos(Controlador controlador) {
        	this.controlador=controlador;
        	initVista();
        }

		private void initVista() {
			setSize(500,350);
			panel.setLayout(new BorderLayout());
			etiqueta= new JLabel("Proyectos:");
			panel.add(etiqueta,BorderLayout.PAGE_START);
			modelo=controlador.crearTablaProyectos();			
		    tabla= new JTable(modelo);
			panel.add(new JScrollPane(tabla), BorderLayout.CENTER);
			JPanel SouthPanel = new JPanel();
			SouthPanel.setLayout(new FlowLayout());
			añadir=new JButton("Añadir");
			cancelar= new JButton("Cancelar");
			SouthPanel.add(añadir);
			SouthPanel.add(cancelar);
			panel.add(SouthPanel, BorderLayout.PAGE_END);
			getContentPane().add(panel);
			setLocationRelativeTo(null);
			setDefaultCloseOperation(EXIT_ON_CLOSE);
		}
}
