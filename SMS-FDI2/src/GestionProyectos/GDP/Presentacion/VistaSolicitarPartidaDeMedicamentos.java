package GestionProyectos.GDP.Presentacion;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JOptionPane;
import javax.swing.JPanel;


public class VistaSolicitarPartidaDeMedicamentos extends VistaProyectos{
    private JButton solicitar, cancelar;
    private static VistaProyectos instancia=null;
	private VistaSolicitarPartidaDeMedicamentos() {
		super.initVista();
		this.initVista();
	}
	public static VistaProyectos getInstancia() {
		if(instancia==null) {
			instancia= new VistaSolicitarPartidaDeMedicamentos();
		}
		return instancia;
	}
	protected void initVista() {
		setTitle("Solcitar Partida de Medicamentos");
		JPanel SouthPanel = new JPanel();
		SouthPanel.setLayout(new FlowLayout());
		solicitar=new JButton("Solicitar Partida");
		cancelar= new JButton("Cancelar");	
		cancelar.setForeground(Color.WHITE);
		cancelar.setBackground(Color.RED);
		solicitar.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				if(getTabla().getSelectedRow()==-1) {
					JOptionPane.showMessageDialog(null, "No has seleccionado ning�n proyecto.");
				}
				else if(getTabla().getValueAt(getTabla().getSelectedRow(), 5).equals("SI")) {
					FactoriaVistas.getInstancia().CrearObjetoVista("A�adirPedido").Visibilizar();
				}
				else {
					JOptionPane.showMessageDialog(null, "Solo pueden solicitar partida de medicamentos proyectos en fabricacion. ");
				}
			}
			
		});
		
		cancelar.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				dispose();
			}
			
		});
		
		SouthPanel.add(solicitar);
		SouthPanel.add(cancelar);
		getPanel().add(SouthPanel, BorderLayout.PAGE_END);
		getContentPane().add(getPanel());
		setVisible(true);
		
	}

}
