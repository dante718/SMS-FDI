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

import GestionProyectos.GDP.Controlador.GDP_Controlador;
import GestionProyectos.GDP.Modelo.GDP_ModeloTabla;
import GestionProyectos.GDP.Modelo.GDP_TableModel;

@SuppressWarnings("serial")
public class GDP_VistaModEstadoInvest extends JFrame{
		private GDP_Controlador	controlador= new GDP_Controlador();
		private JTable tabla;
		private JLabel etiqueta;
		private JButton liberar, cambiarproyecto;
		private JPanel panel= new JPanel();
         public GDP_VistaModEstadoInvest() {
        	  initVista();
         }

		private void initVista() {
			setSize(500, 350);
			panel.setLayout(new BorderLayout());
			etiqueta= new JLabel("Investigadores:");
			panel.add(etiqueta,BorderLayout.NORTH);
			TableModel modelo= new GDP_ModeloTabla();
			modelo=controlador.creartabla("investigador");			
		    tabla= new JTable(modelo);
			panel.add(new JScrollPane(tabla), BorderLayout.CENTER);
			JPanel downPanel= new JPanel();		
			liberar= new JButton("Liberar");
			liberar.addActionListener(new ActionListener() {

				@Override
				public void actionPerformed(ActionEvent e) {
					if(tabla.getSelectedRow()!=-1) {
						controlador.liberar((String) tabla.getValueAt(tabla.getSelectedRow(), 0));
					}
					else {
						JOptionPane.showMessageDialog(null, "No has seleccionado ningun investigador");
					}
				}
				
			});
			cambiarproyecto= new JButton("Cambiar de Proyecto");
			downPanel.add(liberar);
			downPanel.add(cambiarproyecto);
			panel.add(downPanel, BorderLayout.SOUTH);
			this.getContentPane().add(panel);
			setVisible(true);
			setLocationRelativeTo(null);
			setDefaultCloseOperation(EXIT_ON_CLOSE);
		}
}
