package GestionMedicos.GDM_Vista;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.util.Scanner;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import java.awt.event.ActionListener;

import GestionMedicos.Complementos.button;
import GestionMedicos.Complementos.etiqueta;
import GestionMedicos.FactoriaServAplicacion.TransPlantilla;
import GestionMedicos.GDM.Controlador.ControladorMed;

public class Plantilla extends JFrame {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	ControladorMed Controlador;
	public Plantilla(ControladorMed controlador) {
		super("Plantilla:");
		this.Controlador=controlador;
		this.setLayout(null);
		this.setVisible(true);
		this.setSize(0,0);
		this.setBounds(0,0,700,600);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.getContentPane().setBackground(Color.LIGHT_GRAY);
		button boton=new button("Boton",20,0,0, 400, 80);
		
		etiqueta id=new etiqueta("Id",Color.black,20,10,100,100,30);
		etiqueta pastilla=new etiqueta("Pastilla",Color.black,20,100,100,100,30);
		etiqueta sexo=new etiqueta("Sexo",Color.black,20,200,100,100,30);
		etiqueta dato1=new etiqueta("Dato1",Color.black,20,300,100,100,30);
		button botonEditar =new button(" "  ,15,500,150,95, 35);
		button botonCancelar =new button(" ",15,600,150, 95, 35);
		button botonEliminar =new button(" ",15,700,150, 95, 35);
		button botonGuardar=new button("GUARDAR",15,800,150, 150, 35);
		botonEditar.setIcon(new ImageIcon("editar.png"));
		botonCancelar.setIcon(new ImageIcon("cancel.png"));
		botonEliminar.setIcon(new ImageIcon("borrar.png"));
		
		this.add(id);
		this.add(pastilla);
		this.add(sexo);
		this.add(dato1);
		this.add(botonEditar);
		this.add(botonCancelar);
		this.add(botonEliminar);
		this.add(botonGuardar);
		botonEditar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				agregarDatos();
				
			}
			
		}); 
		botonGuardar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			GuardarDatosIntroducidos();
				
			}
			
		});
		
	}
	
	public void agregarDatos() {
		String id,sexo,fecha;
		int edad, cantidad ;
		Scanner teclado =new Scanner (System.in);
		System.out.println("introduce el identificador");
		id=teclado.nextLine();
		System.out.println("el sexo");
		sexo=teclado.nextLine();
		 System.out.println("la edad");
		edad=Integer.parseInt(teclado.nextLine());
		 System.out.println("la cantidad");
		cantidad=Integer.parseInt(teclado.nextLine());
		System.out.println(" la fecha");		
		fecha=teclado.nextLine();
		System.out.println("PULSA GUARDAR");
	
		
		Controlador.agregarDatos(id, sexo, edad, cantidad, fecha);
		
	}
	public void GuardarDatosIntroducidos() {
		Controlador.GuardarDatos();
		
	}

	
}
