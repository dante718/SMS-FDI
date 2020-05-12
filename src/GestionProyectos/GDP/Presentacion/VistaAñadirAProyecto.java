package GestionProyectos.GDP.Presentacion;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JOptionPane;
import javax.swing.JPanel;



public class VistaAñadirAProyecto extends VistaProyectos{
	private static VistaProyectos instancia=null;
    private JButton añadir, cancelar;
	private VistaAñadirAProyecto() {
		initVista();
		initGUI();
	}
	public static VistaProyectos getInstancia() {
		if(instancia==null) {
			instancia= new VistaAñadirAProyecto();
		}
		return instancia;
	}
	private void initGUI() {
		JPanel SouthPanel = new JPanel();
		SouthPanel.setLayout(new FlowLayout());
		añadir=new JButton("Añadir");
		cancelar= new JButton("Cancelar");	
		añadir.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				if(getTabla().getSelectedRow()==-1) {
					JOptionPane.showMessageDialog(null, "No has seleccionado ningún proyecto.");
				}
				else {
					Controlador.getInstancia().añadiraproyecto(getPersonaSeleccionada(), getModelo().getProyecto(getTabla().getSelectedRow()));
					JOptionPane.showMessageDialog(null, "Investigador añadido a "+getModelo().getProyecto(getTabla().getSelectedRow()).getNombre());
					dispose();
				}
								
			}
			
		});
		
		cancelar.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				dispose();
			}
			
		});
		
		SouthPanel.add(añadir);
		SouthPanel.add(cancelar);
		getPanel().add(SouthPanel, BorderLayout.PAGE_END);
		getContentPane().add(getPanel());	
		
	}
	
}
