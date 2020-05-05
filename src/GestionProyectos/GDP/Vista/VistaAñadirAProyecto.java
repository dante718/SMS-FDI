package GestionProyectos.GDP.Vista;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

import GestionProyectos.GDP.Controlador.Controlador;

public class VistaA�adirAProyecto extends VistaProyectos{
	private static VistaProyectos instancia=null;
    private JButton a�adir, cancelar;
	private VistaA�adirAProyecto() {
		initVista();
		initGUI();
	}
	public static VistaProyectos getInstancia() {
		if(instancia==null) {
			instancia= new VistaA�adirAProyecto();
		}
		return instancia;
	}
	private void initGUI() {
		JPanel SouthPanel = new JPanel();
		SouthPanel.setLayout(new FlowLayout());
		a�adir=new JButton("A�adir");
		cancelar= new JButton("Cancelar");	
		a�adir.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				if(getTabla().getSelectedRow()==-1) {
					JOptionPane.showMessageDialog(null, "No has seleccionado ning�n proyecto.");
				}
				else {
					String NombreProy= (String) getTabla().getValueAt(getTabla().getSelectedRow(), 0);
					Controlador.getInstancia().a�adiraproyecto(getDNISeleccionado(), NombreProy);
					JOptionPane.showMessageDialog(null, "Investigador a�adido a "+NombreProy);
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
		
		SouthPanel.add(a�adir);
		SouthPanel.add(cancelar);
		getPanel().add(SouthPanel, BorderLayout.PAGE_END);
		getContentPane().add(getPanel());	
		
	}
	
}
