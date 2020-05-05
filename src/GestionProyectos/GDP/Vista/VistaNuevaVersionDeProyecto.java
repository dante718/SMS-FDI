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
	public VistaNuevaVersionDeProyecto() {
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
					JOptionPane.showMessageDialog(null, "No has seleccionado ning�n proyecto.");
				}
				else {
				if(Controlador.getInstancia().compararfechas((String) getTabla().getValueAt(getTabla().getSelectedRow(), 4))) {
					    Controlador.getInstancia().GenerarNuevaVersion((String) getTabla().getValueAt(getTabla().getSelectedRow(), 0));
						JOptionPane.showMessageDialog(null, "Nueva Versi�n Generada Correctamente. ");
						dispose();
					}
					else {
						JOptionPane.showMessageDialog(null, "Deben pasar al menos un dia para que los estad�sticos concluyan sus estudios. Y generar as� una nueva versi�n. ");
					}			
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
