package GestionProyectos.GDP.Vista;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

import GestionProyectos.GDP.Controlador.Controlador;

public class VistaAñadirAProyecto extends VistaProyectos{
    private JButton añadir, cancelar;
	public VistaAñadirAProyecto(Controlador controlador) {
		super(controlador);
		initVista();
		initGUI();
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
					String NombreProy= (String) getTabla().getValueAt(getTabla().getSelectedRow(), 0);
					getControlador().añadiraproyecto(getDNISeleccionado(), NombreProy);
					JOptionPane.showMessageDialog(null, "Investigador añadido a "+NombreProy);
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
