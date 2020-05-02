package GestionProyectos.GDP.Vista;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.AbstractTableModel;
import javax.swing.table.TableModel;

import GestionProyectos.GDP.Controlador.Controlador;
import GestionProyectos.GDP.Modelo.ModeloTablaPersona;



@SuppressWarnings("serial")
public class VistaModEstadoInvest extends JFrame{
		private Controlador	controlador;
		private JTable tabla;
		private ModeloTablaPersona modelo= new ModeloTablaPersona();
		private JLabel etiqueta;
		private VistaProyectos vp;
		private JButton liberar, cambiarproyecto, addinvestigador;
		private JPanel panel= new JPanel();
         public VistaModEstadoInvest(Controlador controlador) {
        	  this.controlador= controlador;
        	  initVista();
         }

		private void initVista() {
			setSize(500, 350);
			panel.setLayout(new BorderLayout());
			etiqueta= new JLabel("Personal de proyecto:");
			panel.add(etiqueta,BorderLayout.NORTH);
			modelo=controlador.creartablaPersonas("investigador");			
		    tabla= new JTable(modelo);
			panel.add(new JScrollPane(tabla), BorderLayout.CENTER);
			JPanel downPanel= new JPanel();		
			liberar= new JButton("Borrar de Proyecto");
			liberar.addActionListener(new ActionListener() {

				@Override
				public void actionPerformed(ActionEvent e) {
					
					if(tabla.getSelectedRow()==-1) {
						JOptionPane.showMessageDialog(null, "No has seleccionado ningun investigador.");
					}
					else {
						String estado= (String) tabla.getValueAt(tabla.getSelectedRow(), 5);
						if(estado.toLowerCase().equals("disponible")) {
							JOptionPane.showMessageDialog(null, "Selecciona un investigador que est� en proyecto.");
						}
						else if(tabla.getSelectedRow()!=-1) {
							if(controlador.liberar((String) tabla.getValueAt(tabla.getSelectedRow(), 0))) {
								modelo.actualizar();
							}
							else {
								JOptionPane.showMessageDialog(null, "No puedes liberar a este trabajador, un proyecto debe tener al menos uno.");
							}
						}
					}
					
				}
				
			});
			
			cambiarproyecto= new JButton("Cambiar de Proyecto");
			cambiarproyecto.addActionListener(new ActionListener() {

				@Override
				public void actionPerformed(ActionEvent e) {
					if(tabla.getSelectedRow()==-1) {
						JOptionPane.showMessageDialog(null, "No has seleccionado ningun investigador.");
					}
					else {
						String estado= (String) tabla.getValueAt(tabla.getSelectedRow(), 5);
						if(estado.toLowerCase().equals("no disponible")) {
							vp= new VistaCambiarProyecto(controlador);
							vp.setDNI((String) tabla.getValueAt(tabla.getSelectedRow(), 0));
							vp.setVisible(true);
						}
						else {
							JOptionPane.showMessageDialog(null, "Selecciona un investigador que ya est� en un proyecto");
						}
					}					
				}
				
			});
			
			
			addinvestigador= new JButton("A�adir a Proyecto");
			
			addinvestigador.addActionListener(new ActionListener() {

				@Override
				public void actionPerformed(ActionEvent e) {
					if(tabla.getSelectedRow()==-1) {
						JOptionPane.showMessageDialog(null, "No has seleccionado ningun investigador.");
					}
					else {
						String estado= (String) tabla.getValueAt(tabla.getSelectedRow(), 5);
						if(estado.toLowerCase().equals("disponible")) {
							vp= new VistaA�adirAProyecto(controlador);
							vp.setDNI((String) tabla.getValueAt(tabla.getSelectedRow(), 0));
							vp.setVisible(true);
						}
						else {
							JOptionPane.showMessageDialog(null, "Selecciona un investigador que est� libre.");
						}		
					}
					
				}
				
			});
			downPanel.add(liberar);
			downPanel.add(cambiarproyecto);
			downPanel.add(addinvestigador);
			panel.add(downPanel, BorderLayout.SOUTH);
			this.getContentPane().add(panel);
			setVisible(true);
			setLocationRelativeTo(null);
			setDefaultCloseOperation(EXIT_ON_CLOSE);
		}
}