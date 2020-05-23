package GestionProyectos.GDP.Presentacion;

import java.awt.BorderLayout;
import java.awt.Color;
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
		super.initVista();
		this.initVista();
	}
	public static VistaProyectos getInstancia() {
		if(instancia==null) {
			instancia= new VistaCambiarProyecto();
		}
		return instancia;
	}	 
	protected void initVista() {
		setTitle("Cambiar de Proyecto");
		JPanel SouthPanel = new JPanel();
		SouthPanel.setLayout(new FlowLayout());
		cambiar=new JButton("Cambiar");
		cancelar= new JButton("Cancelar");
		cancelar.setForeground(Color.WHITE);
		cancelar.setBackground(Color.RED);
		cambiar.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				if(getTabla().getSelectedRow()==-1) {
					JOptionPane.showMessageDialog(null, "No has seleccionado ningún proyecto.");
				}
				else {
					String NombreProy= (String) getTabla().getValueAt(getTabla().getSelectedRow(), 0);
					if(Controlador.getInstancia().cambiarproyecto(getPersonaSeleccionada(), getModelo().getProyecto(getTabla().getSelectedRow()))) {
						JOptionPane.showMessageDialog(null, "Investigador cambiado de proyecto.");
						dispose();
					}
					else {
						if(Controlador.getInstancia().proyectocontamaño1(getPersonaSeleccionada())) {
							JOptionPane.showMessageDialog(null, "No se ha podido cambiar de proyecto, mínimo debe haber una persona trabajando en un proyecto");
						}
						else {
							JOptionPane.showMessageDialog(null, "No se ha podido cambair de proyecto, la persona seleccionada ya trabaja en este proyecto");
						}
						
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
