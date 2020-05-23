package GestionProyectos.GDP.Presentacion;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JOptionPane;
import javax.swing.JPanel;



public class VistaAnnadirAProyecto extends VistaProyectos{
	private static VistaProyectos instancia=null;
    private JButton a�adir, cancelar;
	private VistaAnnadirAProyecto() {
		super.initVista();
		this.initVista();
	}
	public static VistaProyectos getInstancia() {
		if(instancia==null) {
			instancia= new VistaAnnadirAProyecto();
		}
		return instancia;
	}
	protected void initVista() {
		setTitle("A�adir Investigador A Proyecto");
		JPanel SouthPanel = new JPanel();
		SouthPanel.setLayout(new FlowLayout());
		a�adir=new JButton("A�adir");
		a�adir.setForeground(Color.WHITE);
		a�adir.setBackground(Color.GREEN);
		cancelar= new JButton("Cancelar");	
		cancelar.setForeground(Color.WHITE);
		cancelar.setBackground(Color.RED);
		a�adir.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				if(getTabla().getSelectedRow()==-1) {
					JOptionPane.showMessageDialog(null, "No has seleccionado ning�n proyecto.");
				}
				else {
					Controlador.getInstancia().annadiraproyecto(getPersonaSeleccionada(), getModelo().getProyecto(getTabla().getSelectedRow()));
					JOptionPane.showMessageDialog(null, "Investigador a�adido a "+getModelo().getProyecto(getTabla().getSelectedRow()).leerNombre());
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
