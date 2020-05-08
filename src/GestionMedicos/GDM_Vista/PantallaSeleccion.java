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
import javax.swing.JPanel;
import javax.swing.JSpinner;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.SpinnerNumberModel;

import GestionMedicos.Complementos.button;
import GestionMedicos.Complementos.etiqueta;
import GestionMedicos.FactoriaServAplicacion.TransPlantilla;
import GestionMedicos.GDM.Controlador.ControladorMed;

public class PantallaSeleccion extends JFrame implements ActionListener{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private  String Estudio="";
	private  String Etapa=" ";
	private  String Pastilla=" ";
	private ControladorMed Controlador;
	private JComboBox<String> estudio,farmaco,etapa;
	private button botonAtras , botonContinuar;
	private etiqueta etiEstudios,etiFarmacos,etiEtapas;
public PantallaSeleccion(String titulo ,ControladorMed control){
	super(titulo);
	Controlador=control;
	init();
}
private void init() {
	this.setLayout(new BorderLayout());
	this.setVisible(true);
	this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
	this.getContentPane().setBackground(Color.yellow);
	this.setPreferredSize(new Dimension(700,200));
	this.setResizable(false);
	//encabezado
	
	this.etiEstudios= new etiqueta("Estudios",Color.black,20);
	this.etiFarmacos=new etiqueta("Farmacos",Color.black,20);
	this.etiEtapas=new etiqueta("Etapas",Color.black,20);
	
	this.estudio=new JComboBox<String>();
	this.etapa=new JComboBox<String>();
	this.farmaco=new JComboBox<String>();
	lecturalistas();
	
	JPanel panelOpciones=new JPanel();
	
	panelOpciones.add(Box.createRigidArea(new Dimension(0,50)));
	panelOpciones.add(etiEstudios);
	panelOpciones.add(estudio);
	panelOpciones.add(Box.createRigidArea(new Dimension(10,20)));
	panelOpciones.add(etiEtapas);
	panelOpciones.add(etapa);
	panelOpciones.add(Box.createRigidArea(new Dimension(10,20)));
	panelOpciones.add(etiFarmacos);
	panelOpciones.add(Box.createRigidArea(new Dimension(10,20)));
	panelOpciones.add(farmaco);
	//Continuar
	botonAtras =new button("atras",15);
	botonContinuar =new button("Continuar",15);
	botonAtras.addActionListener(this);
	botonContinuar.addActionListener(this);
	
	JPanel panelConfirmacion=new JPanel(new FlowLayout());
	panelConfirmacion.add(Box.createRigidArea(new Dimension(0,50)));
	panelConfirmacion.add(botonContinuar);
	panelConfirmacion.add(Box.createRigidArea(new Dimension(0,10)));
	panelConfirmacion.add(botonAtras,FlowLayout.LEFT);
	etiqueta Descripcion=new etiqueta("Por favor seleccione los valores y pulse continuar ",Color.BLACK,20);
	JPanel panelDescripcion =new JPanel();
	panelDescripcion.add(Descripcion);
	panelDescripcion.add(Box.createRigidArea(new Dimension(0,20)));
	this.add(panelDescripcion,BorderLayout.PAGE_START);
	this.add(panelOpciones,BorderLayout.CENTER);
	this.add(panelConfirmacion,BorderLayout.PAGE_END);
	
	this.pack();
	
}
private void lecturalistas() {
	for(String e:Controlador.getListaEstudios()) {

		 estudio.addItem(e);
		 	
	}
	for(String e:Controlador.getListaFarmacos()) {

		farmaco.addItem(e);
			
	}
	for(String e:this.Controlador.getListaEtapas()) {

		etapa.addItem(e);	
	}
	
}
private void ExtraccionValores(JComboBox<String> estudio, JComboBox<String> Farmaco, JComboBox<String> etapa) {
	this.Estudio= (String) estudio.getSelectedItem();
	this.Pastilla=(String)Farmaco.getSelectedItem();
	this.Etapa=(String)etapa.getSelectedItem();
}


@Override
public void actionPerformed(ActionEvent e) {
	// TODO Auto-generated method stub
	if(e.getSource()==(JButton)this.botonContinuar) {
		ExtraccionValores(estudio,farmaco, etapa);
		this.Controlador.BuscarPlantilla(Estudio,Pastilla,Etapa);
		FabricaPlantilla f=new FabricaPlantilla();
		Plantilla p=f.crearPlantilla("Plantilla: ", Controlador);
		//Plantilla PlantillaDatos=new Plantilla(Controlador);
		
	}
	else if(e.getSource()==(JButton)this.botonAtras) {
		
		dispose();
	}
	
}


}