package GestionMedicos.CapaPresentacion;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.event.ActionEvent;

import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.ImageIcon;
import javax.swing.JPanel;

import GestionMedicos.Complementos.button;
import GestionMedicos.Complementos.etiqueta;

public class pantallaInforme extends PantallaPrincipal {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	button crearInforme,verMisInformes,atras;
	public pantallaInforme(String nombre) {
		super(nombre, " Informes ","informe.png");
		
	}

	@Override
	public void mostrarGUI() {
		this.setResizable(false);
		crearInforme=new button("CREAR INFORME",30);
		verMisInformes=new button(" VER INFORMES ",30);
		atras =new button("atras",15);
		PanelBotonesAcciones.add(Box.createVerticalStrut(100));
		PanelBotonesAcciones.add(crearInforme);
		PanelBotonesAcciones.add(Box.createVerticalStrut(50));
		PanelBotonesAcciones.add(verMisInformes);
		PanelBotonesAcciones.add(Box.createVerticalStrut(50));
		crearInforme.addActionListener(this);
		verMisInformes.addActionListener(this);
		atras.addActionListener(this);
		this.PanelInferior=new JPanel();
		PanelInferior.setBackground(Color.yellow);

		PanelInferior.add(atras);
		PanelPrincipal.add(PanelInferior,BorderLayout.PAGE_END);
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource()==crearInforme) {
			this.controller.crearPantallaSeleccionCreacionInforme();
		}
		if(e.getSource()==verMisInformes){
			this.controller.crearPantallaConsultaInforme();
		}
		if(e.getSource()==this.atras) {
			dispose();
		}
		
	}


}
