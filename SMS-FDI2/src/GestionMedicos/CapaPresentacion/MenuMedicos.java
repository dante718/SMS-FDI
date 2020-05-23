package GestionMedicos.CapaPresentacion;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;

import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

import GestionMedicos.Complementos.button;
import GestionMedicos.Complementos.etiqueta;

public class MenuMedicos extends PantallaPrincipal {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	button botonPedido,botonHacerEstudio,botonInforme, botonSalir;
	
	public MenuMedicos(String s) {
		super(s,"Hospital ","cruz.png");
		
	}
	@Override
	public void mostrarGUI() {
		
			
		botonPedido =new button("REALIZAR PEDIDO    ",30);
		botonHacerEstudio =new button("REALIZAR ESTUDIO  ",30);
		botonInforme =new button("INFORME DE ERROR",30);
		PanelBotonesAcciones.add(Box.createVerticalStrut(100));
		PanelBotonesAcciones.add(botonPedido);
		PanelBotonesAcciones.add(Box.createVerticalStrut(40));
		PanelBotonesAcciones.add(botonHacerEstudio);
		PanelBotonesAcciones.add(Box.createVerticalStrut(40));
		PanelBotonesAcciones.add(botonInforme);	
		//----------------------------------------------------
		JPanel PanelOpciones=new JPanel(new BorderLayout());
		PanelOpciones.setBackground(Color.yellow);
		JPanel PanelEtiquetasOpciones=new JPanel(new FlowLayout());
		PanelEtiquetasOpciones.setBackground(Color.yellow);
		JPanel PanelOpcionesBotones=new JPanel(new FlowLayout());
		PanelOpcionesBotones.setBackground(Color.yellow);
		JLabel etiquetaSalir = new etiqueta("Salir",Color.black,15);
		//JLabel etiquetaContinuar = new etiqueta("Continuar",Color.black,15);
		botonSalir =new button(" ",15);
		button botonContinuar =new button(" ",15);
		botonSalir.setIcon(new ImageIcon("salir.jpg"));
		botonContinuar.setIcon(new ImageIcon("continuar.png"));
		PanelEtiquetasOpciones.add(Box.createRigidArea(new Dimension(20,0)));
		PanelEtiquetasOpciones.add(etiquetaSalir);
		//PanelEtiquetasOpciones.add(Box.createRigidArea(new Dimension(20,0)));
	//	PanelEtiquetasOpciones.add(etiquetaContinuar,FlowLayout.LEFT);
		PanelOpcionesBotones.add(botonSalir);
		//PanelOpcionesBotones.add(botonContinuar,FlowLayout.LEFT);
		PanelOpciones.add(PanelOpcionesBotones,BorderLayout.NORTH);
		PanelOpciones.add(PanelEtiquetasOpciones,BorderLayout.SOUTH);
	//_--------------------------------------------------------------------
			
		PanelInferior=new JPanel(new BorderLayout());
		PanelInferior.setBackground(Color.yellow);
		PanelInferior.add(PanelOpciones,BorderLayout.EAST);
		//----------------------------------------------------------------
		
		
		this.add(PanelInferior,BorderLayout.PAGE_END);
		botonHacerEstudio.addActionListener(this);
		botonPedido.addActionListener(this);
		botonInforme.addActionListener(this);
		botonSalir.addActionListener(this);
			
		
	}
	
	private void exit() {
		String[] options = { "Si", "No" };
		int n = JOptionPane.showOptionDialog(this, "Va a salir de tu sesion", "Exit",
				JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE, null, options, options[1]);

		if (n == JOptionPane.YES_OPTION)
			System.exit(0);
	}


@Override
public void actionPerformed(ActionEvent e) {
	// TODO Auto-generated method stub
	if(e.getSource()==this.botonHacerEstudio) {	
		this.controller.crearPantallaSeleccionPlantilla();
		
	}
	if(e.getSource()==this.botonPedido) {	
		this.controller.crearPantallaPedido();
		
	}
	if(e.getSource()==this.botonInforme) {	
		this.controller.crearIncidencia();
		
	}
	
	if(e.getSource()==this.botonSalir) {
		exit();
	}
	
	
}

	
}
