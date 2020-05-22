package GestionMedicos.GDM_Vista;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;

import javax.swing.Box;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextArea;

import GestionMedicos.Complementos.button;
import GestionMedicos.Complementos.etiqueta;
import GestionMedicos.GDM.Controlador.ControladorMed;

public class PantallaSeleccionPedido extends PantallaSeleccion {
/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JTextArea descripcion,cantidad,nombre,id,fallo;
	private etiqueta etiquetaDescripcion,etiquetaCantidad,etiquetaNombre,etiquetaIdentificador;
	private  final String  ids="ID";
	private static int cont=0;
public PantallaSeleccionPedido(String titulo ) {
	super(titulo);
}

@Override
public void init() {
	Descripcion=new etiqueta("Introduzca la informacion para realizar el pedido ",Color.BLACK,20);
	panelOpciones=new JPanel();
	panelDescripcion =new JPanel();
	panelConfirmacion=new JPanel(new FlowLayout());
	
	descripcion=new JTextArea(1,20);
	cantidad=new JTextArea(1,10);
	nombre=new JTextArea(1,10);
	id=new JTextArea(1,10);
	id.setText(ids+cont);
	cont++;
	id.setEditable(false);
	fallo=new JTextArea(1,10);
	fallo.setEditable(false);
	fallo.setVisible(false);
	etiquetaDescripcion=new etiqueta("Motivo:",Color.BLACK,20);
	etiquetaCantidad=new etiqueta("Cantidad:",Color.BLACK,20);
	etiquetaNombre=new etiqueta("Nombre:",Color.BLACK,20);
	etiquetaIdentificador=new etiqueta("Identificador:",Color.BLACK,20);	
	panelOpciones.add(Box.createRigidArea(new Dimension(70,10)));
	panelOpciones.add(etiquetaIdentificador);
	panelOpciones.add(id);
	panelOpciones.add(Box.createRigidArea(new Dimension(20,10)));
	panelOpciones.add(etiquetaNombre);
	panelOpciones.add(nombre);
	panelOpciones.add(Box.createRigidArea(new Dimension(90,10)));
	panelOpciones.add(etiquetaDescripcion);
	panelOpciones.add(descripcion);
	panelOpciones.add(Box.createRigidArea(new Dimension(20,10)));
	panelOpciones.add(etiquetaCantidad);
	panelOpciones.add(cantidad);
	panelOpciones.add(Box.createRigidArea(new Dimension(20,10)));
	panelOpciones.add(fallo);
	

	
	panelDescripcion.add(Descripcion);
	panelDescripcion.add(Box.createRigidArea(new Dimension(0,20)));
	
	
	
}

@Override
public void actionPerformed(ActionEvent e) {
	
			if(e.getSource()==(JButton)this.botonContinuar) {
				String pedido=this.id.getText()+" "+this.nombre.getText()+" "+
								this.cantidad.getText()+" "+this.descripcion.getText();
				
				if(this.nombre.getText().equals("") ||
						this.nombre.getText().equals(" ")) {
					
					fallo.setText("IDENTIFICADOR NO VALIDO");
					fallo.setVisible(true);
			
				}
				else{
					this.Controlador.realizarPedido(pedido);
					fallo.setVisible(false);
					exit("salir","Realizar otro pedido");
					id.setText(ids+cont);
				}
			}
			else if(e.getSource()==(JButton)this.botonAtras) {
				
				dispose();
			}
	
}


}
