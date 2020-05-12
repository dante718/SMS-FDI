package GestionMedicos.GDM_Vista;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

import GestionMedicos.Complementos.button;
import GestionMedicos.Complementos.etiqueta;
import GestionMedicos.GDM.Controlador.ControladorMed;

public class PantallaPrincipal extends JFrame implements ActionListener {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	JPanel PanelPrincipal,PanelTitulo,PanelBotonesAcciones,PanelInferior;
	button botonPedido,botonHacerEstudio,botonInforme;
	ControladorMed controller;
	public	PantallaPrincipal(String nombre,ControladorMed ctrl){
		super(nombre);
		this.controller=ctrl;
		mostrarGUI();
	}
	private void mostrarGUI() {
		this.setLayout(new BorderLayout());
		this.setVisible(true);
		
		this.setPreferredSize(new Dimension(900,800));
		this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		this.getContentPane().setBackground(Color.yellow);
		//encabezado
		
		PanelPrincipal=new JPanel();
		PanelPrincipal.setBackground(Color.yellow);
		PanelPrincipal.setLayout(new BoxLayout(PanelPrincipal,BoxLayout.Y_AXIS));
		//-------------------------------------------------
		PanelTitulo=new JPanel();
		PanelTitulo.setPreferredSize(new Dimension (300,200));
		PanelTitulo.setBackground(Color.yellow);
		etiqueta titulo=new etiqueta("Hospital ",Color.blue,100);
		titulo.setIcon(new ImageIcon("cruz.png"));
		PanelTitulo.add(Box.createRigidArea(new Dimension(10,0)));
		PanelTitulo.add(Box.createHorizontalGlue());
		PanelTitulo.add(titulo);
		//----------------------------------------------------------	
		PanelBotonesAcciones=new JPanel();
		PanelBotonesAcciones.setLayout(new BoxLayout(PanelBotonesAcciones,BoxLayout.Y_AXIS));
		PanelBotonesAcciones.setBackground(Color.yellow);
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
		JLabel etiquetaContinuar = new etiqueta("Continuar",Color.black,15);
		button botonSalir =new button(" ",15);
		button botonContinuar =new button(" ",15);
		botonSalir.setIcon(new ImageIcon("salir.jpg"));
		botonContinuar.setIcon(new ImageIcon("continuar.png"));
		PanelEtiquetasOpciones.add(Box.createRigidArea(new Dimension(20,0)));
		PanelEtiquetasOpciones.add(etiquetaSalir);
		PanelEtiquetasOpciones.add(Box.createRigidArea(new Dimension(20,0)));
		PanelEtiquetasOpciones.add(etiquetaContinuar,FlowLayout.LEFT);
		PanelOpcionesBotones.add(botonSalir);
		PanelOpcionesBotones.add(botonContinuar,FlowLayout.LEFT);
		PanelOpciones.add(PanelOpcionesBotones,BorderLayout.NORTH);
		PanelOpciones.add(PanelEtiquetasOpciones,BorderLayout.SOUTH);
	//_--------------------------------------------------------------------
			
		PanelInferior=new JPanel(new BorderLayout());
		PanelInferior.setBackground(Color.yellow);
		PanelInferior.add(PanelOpciones,BorderLayout.EAST);
		//_----------------------------------------------------------------
		PanelPrincipal.add(PanelTitulo);
		PanelPrincipal.add(PanelBotonesAcciones);
		this.add(PanelPrincipal,BorderLayout.NORTH);
		this.add(PanelInferior,BorderLayout.PAGE_END);
		botonHacerEstudio.addActionListener(this);
		this.pack();
		
		
	}
	


@Override
public void actionPerformed(ActionEvent e) {
	// TODO Auto-generated method stub
	if(e.getSource()==this.botonHacerEstudio) {	
		this.controller.crearPantallaSeleccion();
		
	}
	
}

	
	
	
}
