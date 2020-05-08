package GestionProyectos.GDP.Presentacion;

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

import GestionProyectos.GDP.Integracion.ModeloTablaPersona;



@SuppressWarnings("serial")
public class VistaModEstadoInvest extends JFrame{
	    private static VistaModEstadoInvest instancia=null;
		private JTable tabla;
		private ModeloTablaPersona modelo= new ModeloTablaPersona();
		private JLabel etiqueta;
		private JButton liberar, cambiarproyecto, addinvestigador;
		private JPanel panel= new JPanel();
        private VistaModEstadoInvest() {
        	  initVista();
        }
        public static VistaModEstadoInvest getInstancia() {
        	if(instancia==null) {
        		instancia= new VistaModEstadoInvest();
        	}
        	return instancia;
        }
		private void initVista() {
			setSize(500, 350);
			panel.setLayout(new BorderLayout());
			etiqueta= new JLabel("Personal de proyecto:");
			panel.add(etiqueta,BorderLayout.NORTH);
			modelo=Controlador.getInstancia().creartablaPersonas("Investigador");			
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
							JOptionPane.showMessageDialog(null, "Selecciona un investigador que esté en proyecto.");
						}
						else if(tabla.getSelectedRow()!=-1) {
							if(Controlador.getInstancia().liberar((String) tabla.getValueAt(tabla.getSelectedRow(), 0))) {
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
							VistaCambiarProyecto.getInstancia().setDNI((String) tabla.getValueAt(tabla.getSelectedRow(), 0));
							VistaCambiarProyecto.getInstancia().setVisible(true);
						}
						else {
							JOptionPane.showMessageDialog(null, "Selecciona un investigador que ya esté en un proyecto");
						}
					}					
				}
				
			});
			
			
			addinvestigador= new JButton("Añadir a Proyecto");
			
			addinvestigador.addActionListener(new ActionListener() {

				@Override
				public void actionPerformed(ActionEvent e) {
					if(tabla.getSelectedRow()==-1) {
						JOptionPane.showMessageDialog(null, "No has seleccionado ningun investigador.");
					}
					else {
						String estado= (String) tabla.getValueAt(tabla.getSelectedRow(), 5);
						if(estado.toLowerCase().equals("disponible")) {
							VistaAñadirAProyecto.getInstancia().setDNI((String) tabla.getValueAt(tabla.getSelectedRow(), 0));
							VistaAñadirAProyecto.getInstancia().setVisible(true);
						}
						else {
							JOptionPane.showMessageDialog(null, "Selecciona un investigador que esté libre.");
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
			setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		}
}
