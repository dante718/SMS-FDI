package GestionProyectos.GDP.Vista;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.swing.JButton;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

import GestionProyectos.GDP.Controlador.Controlador;

public class VistaNuevaVersionDeProyecto extends VistaProyectos{
    private JButton nuevaversion, cancelar;
	public VistaNuevaVersionDeProyecto(Controlador controlador) {
		super(controlador);
		initVista();
		initGUI();
	}

	private void initGUI() {
		JPanel SouthPanel = new JPanel();
		SouthPanel.setLayout(new FlowLayout());
		nuevaversion=new JButton("Generar Nueva Version");
		cancelar= new JButton("Cancelar");	
		nuevaversion.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				if(getTabla().getSelectedRow()==-1) {
					JOptionPane.showMessageDialog(null, "No has seleccionado ningún proyecto.");
				}
				else {
				//	if(getControlador().compararfechas((String) getTabla().getValueAt(getTabla().getSelectedRow(), 4))) {
						getControlador().GenerarNuevaVersion((String) getTabla().getValueAt(getTabla().getSelectedRow(), 0));
						dispose();
				//	}
					//else {
						JOptionPane.showMessageDialog(null, "Deben pasar al menos dos semanas para que los estadísticos concluyan sus estudios. Y generar así una nueva versión. ");
					//}			
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
		
		SouthPanel.add(nuevaversion);
		SouthPanel.add(cancelar);
		getPanel().add(SouthPanel, BorderLayout.PAGE_END);
		getContentPane().add(getPanel());
		setVisible(true);
		
	}

}
