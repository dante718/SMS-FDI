package GestionProyectos.GDP.Vista;

import javax.swing.JFrame;
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
		private JPanel panel= new JPanel();
         public GDP_VistaModEstadoInvest() {
        	  initVista();
         }

		private void initVista() {
			setSize(700, 700);
			TableModel modelo= new GDP_ModeloTabla();
			modelo=controlador.iniciarBasedeDatos("investigador");			
		    tabla= new JTable(modelo);
			panel.add(new JScrollPane(tabla)); 
			this.getContentPane().add(panel);
			setVisible(true);
			setLocationRelativeTo(null);
			setDefaultCloseOperation(EXIT_ON_CLOSE);
		}
}
