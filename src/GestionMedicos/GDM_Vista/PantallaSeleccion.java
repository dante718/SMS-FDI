package GestionMedicos.GDM_Vista;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.Map;

import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.ComboBoxModel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JComponent;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JSpinner;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.SpinnerNumberModel;

import GestionMedicos.Complementos.button;
import GestionMedicos.Complementos.etiqueta;
import GestionMedicos.FactoriaServAplicacion.TransPlantilla;
import GestionMedicos.GDM.Controlador.ControladorMed;

public abstract class PantallaSeleccion extends JFrame implements ActionListener{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	ControladorMed Controlador;
	button botonAtras , botonContinuar;
	JPanel panelOpciones, panelDescripcion,panelConfirmacion;
	etiqueta Descripcion;
public PantallaSeleccion(String titulo){
	super(titulo);
	Controlador=ControladorMed.getInstancia();
	this.setLayout(new BorderLayout());
	this.setVisible(true);
	this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
	this.getContentPane().setBackground(Color.yellow);
	this.setPreferredSize(new Dimension(700,200));
	this.setResizable(false);
	botonAtras =new button("atras",15);
	botonContinuar =new button("Continuar",15);
	botonAtras.addActionListener(this);
	botonContinuar.addActionListener(this);
	init();
	panelConfirmacion.add(Box.createRigidArea(new Dimension(0,50)));
	panelConfirmacion.add(botonContinuar);
	panelConfirmacion.add(Box.createRigidArea(new Dimension(0,10)));
	panelConfirmacion.add(botonAtras,FlowLayout.LEFT);
	this.add(panelDescripcion,BorderLayout.PAGE_START);	
	this.add(panelOpciones,BorderLayout.CENTER);
	this.add(panelConfirmacion,BorderLayout.PAGE_END);
	this.pack();
}
public void exit(String op1, String op2) {
	String[] options = { op1,"SI" };
	int n = JOptionPane.showOptionDialog(this, op2, " AVISO ",
			JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE, null, options, options[0]);

	if (n == JOptionPane.YES_OPTION)
	dispose();
}
public abstract void init();

}