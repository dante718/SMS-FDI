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
		private Controlador	controlador= new Controlador();
		private JTable tabla;
		private ModeloTablaPersona modelo= new ModeloTablaPersona();
		private JLabel etiqueta;
		private VistaProyectos vp;
		private JButton liberar, cambiarproyecto, addinvestigador;
		private JPanel panel= new JPanel();
         public VistaModEstadoInvest() {
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
			liberar= new JButton("Liberar");
			liberar.addActionListener(new ActionListener() {

				@Override
				public void actionPerformed(ActionEvent e) {
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
					else {
						JOptionPane.showMessageDialog(null, "No has seleccionado ningun investigador.");
					}
				}
				
			});
			vp= new VistaProyectos(controlador);
			cambiarproyecto= new JButton("Asignar otro Proyecto");
			cambiarproyecto.addActionListener(new ActionListener() {

				@Override
				public void actionPerformed(ActionEvent e) {
					String estado= (String) tabla.getValueAt(tabla.getSelectedRow(), 5);
					if(estado.toLowerCase().equals("no disponible")) {
						vp.setVisible(true);
					}
					else {
						JOptionPane.showMessageDialog(null, "Selecciona un investigador que ya est� en un proyecto");
					}
				}
				
			});
			
			addinvestigador= new JButton("A�adir Investigador");
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
