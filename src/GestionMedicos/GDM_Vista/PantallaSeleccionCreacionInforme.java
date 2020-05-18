package GestionMedicos.GDM_Vista;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;

import javax.swing.Box;
import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JTextArea;

import GestionMedicos.Complementos.etiqueta;
import GestionMedicos.GDM.Controlador.ControladorMed;

public class PantallaSeleccionCreacionInforme extends PantallaSeleccion {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JTextArea motivo,fecha,plantilla,id,fallo;
	private etiqueta etiquetaMotivo,etiquetafecha,etiquetaplantilla,etiquetaIdentificador;
	private  final String  ids="ID";
	private static int cont=0;
	public PantallaSeleccionCreacionInforme(String titulo, ControladorMed control) {
		super(titulo, control);
		// TODO Auto-generated constructor stub
	}
	@Override
	public void init() {
		Descripcion=new etiqueta("Introduzca la informacion para realizar el pedido ",Color.BLACK,20);
		panelOpciones=new JPanel();
		panelDescripcion =new JPanel();
		panelConfirmacion=new JPanel(new FlowLayout());
		
		motivo=new JTextArea(1,10);
		fecha=new JTextArea(1,10);
		plantilla=new JTextArea(1,10);
		id=new JTextArea(1,10);
		id.setText(ids+cont);
		cont++;
		id.setEditable(false);
		fallo=new JTextArea(1,10);
		fallo.setEditable(false);
		fallo.setVisible(false);
		etiquetaMotivo=new etiqueta("Motivo:",Color.BLACK,20);
		etiquetafecha=new etiqueta("Fecha:",Color.BLACK,20);
		etiquetaplantilla=new etiqueta("Plantilla:",Color.BLACK,20);
		etiquetaIdentificador=new etiqueta("Identificador:",Color.BLACK,20);
		
		panelOpciones.add(Box.createRigidArea(new Dimension(70,10)));
		panelOpciones.add(etiquetaIdentificador);
		panelOpciones.add(id);
		panelOpciones.add(Box.createRigidArea(new Dimension(20,10)));
		panelOpciones.add(etiquetaplantilla);
		panelOpciones.add(plantilla);
		panelOpciones.add(Box.createRigidArea(new Dimension(90,10)));
		panelOpciones.add(etiquetaMotivo);
		panelOpciones.add(motivo);
		panelOpciones.add(Box.createRigidArea(new Dimension(20,10)));
		panelOpciones.add(etiquetafecha);
		panelOpciones.add(fecha);
		panelOpciones.add(fallo);
		
		panelDescripcion.add(Descripcion);
		panelDescripcion.add(Box.createRigidArea(new Dimension(0,20)));
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource()==(JButton)this.botonContinuar) {
			String informe=id.getText()+" "+motivo.getText()+" "+
					plantilla.getText()+" "+fecha.getText();
			if(plantilla.getText().equals("") || plantilla.getText().equals("")) {
				fallo.setText(" Datos de consulta no validos ");
				fallo.setVisible(true);
				
			}
			else {

				if(this.Controlador.realizarInforme(informe) && informe.split(" ").length==4) {
					exit("No","Realizar otro informe");
					id.setText(ids+cont);
					fallo.setVisible(false);
				}
				else {
					fallo.setText(" Fallo al registrar el pedido ");
					fallo.setVisible(true);
				}
				
			}
			
			
		}
		else if(e.getSource()==(JButton)this.botonAtras) {
			
			dispose();
		}
		motivo.setText("");
		fecha.setText("");
		plantilla.setText("");
	}

	

}
