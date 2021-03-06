package GestionProyectos.GDP.Presentacion;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

public class VistaNuevaVersionDeProyecto extends VistaProyectos implements IVista{
    private JButton nuevaversion, cancelar;
    private static VistaProyectos instancia=null;
	private VistaNuevaVersionDeProyecto() {
		super.initVista();
		this.initVista();
	}
	public static VistaProyectos getInstancia() {
		if(instancia==null) {
			instancia= new VistaNuevaVersionDeProyecto();
		}
		return instancia;
	}
	protected void initVista() {
		setTitle("Nueva Version de Proyecto");
		JPanel SouthPanel = new JPanel();
		SouthPanel.setLayout(new FlowLayout());
		nuevaversion=new JButton("Generar Nueva Version");
		cancelar= new JButton("Cancelar");
		cancelar.setForeground(Color.WHITE);
		cancelar.setBackground(Color.RED);
		nuevaversion.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				if(getTabla().getSelectedRow()==-1) {
					JOptionPane.showMessageDialog(null, "No has seleccionado ning�n proyecto.");
				}
				else {
				if(Controlador.getInstancia().compararfechas((String) getTabla().getValueAt(getTabla().getSelectedRow(), 4))) {
					    Controlador.getInstancia().GenerarNuevaVersion(getModelo().getProyecto(getTabla().getSelectedRow()));
						JOptionPane.showMessageDialog(null, "Nueva Versi�n Generada Correctamente. ");
						dispose();
					}
					else {
						JOptionPane.showMessageDialog(null, "Deben pasar al menos un dia para que los estad�sticos concluyan sus estudios. Y generar as� una nueva versi�n. ");
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
		
		SouthPanel.add(nuevaversion);
		SouthPanel.add(cancelar);
		getPanel().add(SouthPanel, BorderLayout.PAGE_END);
		getContentPane().add(getPanel());
	}
	@Override
	public void Visibilizar() {
		super.Visibilizar();	
	}
}
