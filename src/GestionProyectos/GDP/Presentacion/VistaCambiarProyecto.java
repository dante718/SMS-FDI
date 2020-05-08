package GestionProyectos.GDP.Presentacion;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JOptionPane;
import javax.swing.JPanel;



public class VistaCambiarProyecto extends VistaProyectos{
    private JButton cambiar, cancelar;
    private static VistaProyectos instancia=null;
	private VistaCambiarProyecto() {
		initVista();
		initGUI();
	}
	public static VistaProyectos getInstancia() {
		if(instancia==null) {
			instancia= new VistaCambiarProyecto();
		}
		return instancia;
	}	 
	private void initGUI() {
		JPanel SouthPanel = new JPanel();
		SouthPanel.setLayout(new FlowLayout());
		cambiar=new JButton("Cambiar");
		cancelar= new JButton("Cancelar");
		
		cambiar.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				if(getTabla().getSelectedRow()==-1) {
					JOptionPane.showMessageDialog(null, "No has seleccionado ningún proyecto.");
				}
				else {
					String NombreProy= (String) getTabla().getValueAt(getTabla().getSelectedRow(), 0);
					if(Controlador.getInstancia().cambiarproyecto(getDNISeleccionado(), NombreProy)) {
						JOptionPane.showMessageDialog(null, "Investigador cambiado de proyecto.");
						dispose();
					}
					else {
						JOptionPane.showMessageDialog(null, "Este investigador ya trabaja en el"+NombreProy);
					}
				}
								
			}
			
		});
		
		cancelar.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				dispose();
			}
			
		});
		
		SouthPanel.add(cambiar);
		SouthPanel.add(cancelar);
		getPanel().add(SouthPanel, BorderLayout.PAGE_END);
		getContentPane().add(getPanel());	
	}

}
