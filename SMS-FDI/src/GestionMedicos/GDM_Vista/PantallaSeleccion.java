package GestionMedicos.GDM_Vista;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;

import GestionMedicos.Complementos.button;
import GestionMedicos.Complementos.etiqueta;
import GestionMedicos.FactoriaServAplicacion.TransPlantilla;
import GestionMedicos.GDM.Controlador.ControladorMed;

public class PantallaSeleccion  extends JFrame implements ActionListener{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private static String Estudio ="";
	private static String Etapa=" ";
	private static String Pastilla=" ";
	//private ControladorMed Controlador;
public PantallaSeleccion(ControladorMed contrl){
	super("seleccione opcion");
	//Controlador=contrl;
	this.setLayout(null);
	this.setVisible(true);
	this.setSize(100,100);
	this.setBounds(2000,0,700,600);
	this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
	this.getContentPane().setBackground(Color.orange);
	//encabezado
	etiqueta etiEstudios= new etiqueta("Estudios",Color.black,20,100,100,100,30);
	etiqueta etiFarmacos=new etiqueta("Fármacos",Color.black,20,300,100,100,30);
	etiqueta etiEtapas=new etiqueta("Etapas",Color.black,20,500,100,100,30);
	//BOTONES DE ETAPA
	button estudio1 =new button("Estudio_1",15,100,200, 100, 30);
	button estudio2 =new button("Estudio_2",15,100,300, 100, 30);
	button estudio3 =new button("Estudio_3",15,100,400, 100, 30);
//BOTONES FARMACOS
	button Catarro =new button("P.contra el catarro",15,250,200, 200, 30);
	button Alergia =new button("P.contra la alergia",15,250,300, 200, 30);
	button Suenio =new button("P.para el sueño"     ,15,250,400, 200, 30);
	
//BOTONES DE SELECCION DE ETAPA
	button etapa1 =new button("Etapa_1",15,500,200, 100, 30);
	button etapa2 =new button("Etapa_2",15,500,300, 100, 30);
	button etapa3 =new button("Etapa_3",15,500,400, 100, 30);
//Continuar
	button botonContinuar =new button("Continuar",15,550,500, 100, 30);
	
	this.add(etiEstudios);
	this.add(etiFarmacos);
	this.add(etiEtapas);
	this.add(estudio1);
	this.add(estudio2);
	this.add(estudio3);
	this.add(Catarro);
	this.add(Alergia);
	this.add(Suenio);
	this.add(etapa1);
	this.add(etapa2);
	this.add(etapa3); 
	this.add(botonContinuar);
	
	//seleccion se puede meter en una lista
	this.ComproacionMedicamento(Catarro, Alergia, Suenio);
	this.ComprobacionEstudios(estudio1,estudio2,estudio3);
	this.ComprobacionEtapa(etapa1, etapa2, etapa3);
	
	/*una vez hecho la comprobacion   paso los parametros al controlador para que este
	 haga :
	*/
	botonContinuar.addActionListener(new ActionListener() {

		@Override
		public void actionPerformed(ActionEvent e) {
			//System.out.println("datos: "+Estudio+Pastilla+Etapa);
			//aqui debo generar una llamada al transfer y al mismo tiempo  debo llamar 
			//al controlador ->SerApp->DaoDatos->Almacen
			
			ControladorMed.BuscarPlantilla(Estudio,Pastilla,Etapa);
			Plantilla PlantillaDatos=new Plantilla();
			
		
			
		}
	});
	

}
private void ComprobacionEstudios(button b1,button b2, button b3) {
	
	b1.addActionListener(new ActionListener() {

		@Override
		public void actionPerformed(ActionEvent e) {
			
			JButton obj = (JButton)e.getSource();
            String nombre = obj.getText();
 			
			PantallaSeleccion.Estudio=nombre;
		
			
		}
	});
	b2.addActionListener(new ActionListener() {

		@Override
		public void actionPerformed(ActionEvent e) {
			JButton obj = (JButton)e.getSource();
            String nombre = obj.getText();
 			
			PantallaSeleccion.Estudio=nombre;
		
		
		}
	});
	b3.addActionListener(new ActionListener() {

		@Override
		public void actionPerformed(ActionEvent e) {
			JButton obj = (JButton)e.getSource();
            String nombre = obj.getText();
 			
			PantallaSeleccion.Estudio=nombre;
		
		}
	});

	
}

private void ComproacionMedicamento(button b1,button b2, button b3) {
	b1.addActionListener(new ActionListener() {

		@Override
		public void actionPerformed(ActionEvent e) {
			PantallaSeleccion.Pastilla="Pastilla_contra_el_catarro";
			
		}
	});
	b2.addActionListener(new ActionListener() {

		@Override
		public void actionPerformed(ActionEvent e) {
			PantallaSeleccion.Pastilla="Pastilla_contra_la_alergia";
		}
	});
	b3.addActionListener(new ActionListener() {

		@Override
		public void actionPerformed(ActionEvent e) {
			PantallaSeleccion.Pastilla="Pastilla_para_el_sueño";	
		}
	});
	
}
private void ComprobacionEtapa(button b1,button b2, button b3) {
	b1.addActionListener(new ActionListener() {

		@Override
		public void actionPerformed(ActionEvent e) {
			JButton obj = (JButton)e.getSource();
            String nombre = obj.getText();
 			
			PantallaSeleccion.Etapa=nombre;
		
			
		}
	});
	b2.addActionListener(new ActionListener() {

		@Override
		public void actionPerformed(ActionEvent e) {
			JButton obj = (JButton)e.getSource();
            String nombre = obj.getText();
 			
			PantallaSeleccion.Etapa=nombre;
		
			
		}
	});
	b3.addActionListener(new ActionListener() {

		@Override
		public void actionPerformed(ActionEvent e) {
			JButton obj = (JButton)e.getSource();
            String nombre = obj.getText();
 			
			PantallaSeleccion.Etapa=nombre;
		
				
		}
	});
	
}



@Override
public void actionPerformed(ActionEvent e) {
	// TODO Auto-generated method stub
	
}
	
	

}
