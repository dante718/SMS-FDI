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

public abstract class PantallaPrincipal extends JFrame implements ActionListener {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	JPanel PanelPrincipal,PanelTitulo,PanelBotonesAcciones,PanelInferior;
	etiqueta titulo;
	ControladorMed controller;
	public	PantallaPrincipal(String nombre,String T,String I){
		super(nombre);
		this.controller=ControladorMed.getInstancia();
		this.setLayout(new BorderLayout());
		this.setVisible(true);
		this.setPreferredSize(new Dimension(900,900));
		this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		this.getContentPane().setBackground(Color.yellow);
		/////////////////////ENCABEZADO////////////////////////////////
		PanelPrincipal=new JPanel();
		PanelPrincipal.setBackground(Color.yellow);
		PanelPrincipal.setLayout(new BoxLayout(PanelPrincipal,BoxLayout.Y_AXIS));
		//-------------------------------------------------
		PanelTitulo=new JPanel();
		//PanelTitulo.setPreferredSize(new Dimension (300,200));
		PanelTitulo.setBackground(Color.yellow);
		etiqueta titulo=new etiqueta(T,Color.blue,100);
		titulo.setIcon(new ImageIcon(I));
		PanelTitulo.add(Box.createRigidArea(new Dimension(10,0)));
		PanelTitulo.add(Box.createHorizontalGlue());
		PanelTitulo.add(titulo);
		PanelPrincipal.add(PanelTitulo);
		this.add(PanelPrincipal,BorderLayout.NORTH);
		////////////////////PANELBOTONES///////////////////////////////	
		PanelBotonesAcciones=new JPanel();
		PanelBotonesAcciones.setLayout(new BoxLayout(PanelBotonesAcciones,BoxLayout.Y_AXIS));
		PanelBotonesAcciones.setBackground(Color.yellow);
		PanelPrincipal.add(PanelBotonesAcciones);
		//////////////////////////////////////////////////////////////
				
		mostrarGUI();
		this.pack();
	}
	public abstract void mostrarGUI();
	
	
}
