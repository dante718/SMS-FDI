package GestionProyectos.GDP.Vista;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;

import GestionProyectos.GDP.Controlador.Controlador;
import GestionProyectos.GDP.Modelo.ModeloTablaPersona;

public class VistaAñadirFabricacion extends VistaProyectos{
	private JButton fabricacion, cancelar;
	public VistaAñadirFabricacion(Controlador controlador) {
		super(controlador);
		initVista();
		initGUI();
	}

	private void initGUI() {
		JPanel SouthPanel = new JPanel();
		SouthPanel.setLayout(new FlowLayout());
		fabricacion=new JButton("Pasar a modo Fabricacion");
		cancelar= new JButton("Cancelar");	
		fabricacion.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				if(getTabla().getSelectedRow()==-1) {
					JOptionPane.showMessageDialog(null, "No has seleccionado ningún proyecto.");
				}
				else if(getTabla().getValueAt(getTabla().getSelectedRow(), 5).equals("SI")) {
					JOptionPane.showMessageDialog(null, "Selecciona un proyecto que no esté ya en fabricacion. ");
				}
				else {
				   if(getControlador().pasarafabricacion((String) getTabla().getValueAt(getTabla().getSelectedRow(), 0))) {
					   crearTablaTrabajadores((String) getTabla().getValueAt(getTabla().getSelectedRow(), 0));
				   }
				   else {
					   JOptionPane.showMessageDialog(null, "El proyecto debe estar al menos en version 3 para pasar a modo de fabricacion.");
				   }
					dispose();
				}
								
			}

			private void crearTablaTrabajadores(String NombreProy) {
				JDialog dialog= new JDialog();
				dialog.setSize(500,350);
				setLayout(new BorderLayout());
				JLabel etiqueta= new JLabel("Participantes del proyecto: ");
				JPanel PANEL= new JPanel();
				PANEL.setLayout(new BorderLayout());
				PANEL.add(etiqueta, BorderLayout.PAGE_START);
				ModeloTablaPersona modelo= getControlador().tablapersonaldeproyecto(NombreProy);
				JTable tabla= new JTable(modelo);
				
				
				PANEL.add(new JScrollPane(tabla), BorderLayout.CENTER);
				
				
				JPanel surpanel= new JPanel();
				
				JButton  continuar= new JButton("Continuar en el proyecto");
				
				continuar.addActionListener(new ActionListener() {

					@Override
					public void actionPerformed(ActionEvent e) {
						if(tabla.getSelectedRow()==-1) {
							JOptionPane.showMessageDialog(null, "No has seleccionado ningún participante del proyecto.");
						}
						else {
							modelo.getPersonas().remove(tabla.getSelectedRow());
							modelo.actualizar();
							if(modelo.getPersonas().size()==0) {
								getControlador().ponerenfabricacion(NombreProy);
								dialog.dispose();
							}
						}
					}
					
									
				});
				
				JButton acabar = new JButton("Quitar de proyecto");
				
				acabar.addActionListener(new ActionListener() {

					@Override
					public void actionPerformed(ActionEvent e) {
						if(tabla.getSelectedRow()==-1) {
							JOptionPane.showMessageDialog(null, "No has seleccionado ningún participante del proyecto.");
						}
						else {
							getControlador().liberar((String) tabla.getValueAt(tabla.getSelectedRow(), 0));
							modelo.getPersonas().remove(tabla.getSelectedRow());
							modelo.actualizar();
							if(modelo.getPersonas().size()==0) {
								dialog.dispose();
							}
						}
						
					}
							
				});
				surpanel.add(continuar);
				surpanel.add(acabar);				
				PANEL.add(surpanel, BorderLayout.PAGE_END);				
				dialog.getContentPane().add(PANEL);
				dialog.setVisible(true);
				dialog.setLocationRelativeTo(null);
				dialog.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
			}
			
		});
		
		cancelar.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				dispose();
			}
			
		});
		
		SouthPanel.add(fabricacion);
		SouthPanel.add(cancelar);
		getPanel().add(SouthPanel, BorderLayout.PAGE_END);
		getContentPane().add(getPanel());
		setVisible(true);
		
	}

}
