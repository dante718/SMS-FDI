package GestionMedicos.GDM_Vista;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;

import javax.swing.Box;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JPanel;

import GestionMedicos.Complementos.button;
import GestionMedicos.Complementos.etiqueta;
import GestionMedicos.GDM.Controlador.ControladorMed;

public class PantallaSeleccionPlantilla extends PantallaSeleccion {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private  String Estudio="";
	private  String Etapa=" ";
	private  String Pastilla=" ";
	
	private JComboBox<String> estudio,farmaco,etapa;

	private etiqueta etiEstudios,etiFarmacos,etiEtapas;
	
	public PantallaSeleccionPlantilla(String titulo ,ControladorMed control) {
		super(titulo,control);
		
	}
	
	public void init() {
		
		//encabezado
		
		this.etiEstudios= new etiqueta("Estudios",Color.black,20);
		this.etiFarmacos=new etiqueta("Farmacos",Color.black,20);
		this.etiEtapas=new etiqueta("Etapas",Color.black,20);
		this.estudio=new JComboBox<String>();
		this.etapa=new JComboBox<String>();
		this.farmaco=new JComboBox<String>();
		lecturalistas();
		
		panelOpciones=new JPanel();
		
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
		
		panelConfirmacion=new JPanel(new FlowLayout());
		
		
		Descripcion=new etiqueta("Por favor seleccione los valores y pulse continuar ",Color.BLACK,20);
		panelDescripcion =new JPanel();
		panelDescripcion.add(Descripcion);
		panelDescripcion.add(Box.createRigidArea(new Dimension(0,20)));
		
			
		
		
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
			this.Controlador.setParametros(Estudio, Pastilla, Etapa);
			this.Controlador.crearPantallaPlantilla();
			
			
		}
		else if(e.getSource()==(JButton)this.botonAtras) {
			
			dispose();
		}
		
	}


}
