package GestionMedicos.CapaPresentacion;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;

import javax.swing.Box;
import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JTextArea;

import GestionMedicos.Complementos.etiqueta;

public class PantallaConsultaPedido extends PantallaSeleccion {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JTextArea nombre,id,resultado,fallo;
	private etiqueta etiquetaNombre,etiquetaIdentificador,etiquetaEstado;
	public PantallaConsultaPedido(String titulo) {
		super(titulo);
	
	}
	@Override
	public void init() {
		Descripcion=new etiqueta("Introduzaca el identificador del producto que quiere hacer la consulta: ", Color.black,20);
		panelOpciones=new JPanel();
		panelDescripcion=new JPanel();
		panelConfirmacion=new JPanel(new FlowLayout());
		
		nombre=new JTextArea(1,10);
		id=new JTextArea(1,10);
		resultado=new JTextArea(1,10);
		resultado.setEditable(false);
		fallo=new JTextArea(1,10);
		fallo.setVisible(false);
		
		etiquetaNombre=new etiqueta("Nombre:",Color.BLACK,20);
		etiquetaIdentificador=new etiqueta("Identificador:",Color.BLACK,20);	
		etiquetaEstado=new etiqueta("Estado:",Color.BLACK,20);
		
		panelOpciones.add(Box.createRigidArea(new Dimension(70,10)));
		panelOpciones.add(etiquetaIdentificador);
		panelOpciones.add(id);
		panelOpciones.add(Box.createRigidArea(new Dimension(20,10)));
		panelOpciones.add(etiquetaNombre);
		panelOpciones.add(nombre);
		panelOpciones.add(Box.createRigidArea(new Dimension(100,10)));
		panelOpciones.add(etiquetaEstado);
		panelOpciones.add(resultado);
		
		panelOpciones.add(Box.createRigidArea(new Dimension(20,10)));
		panelOpciones.add(fallo);
		
		
		panelDescripcion.add(Descripcion);
		panelDescripcion.add(Box.createRigidArea(new Dimension(0,20)));
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		if(e.getSource()==(JButton)this.botonContinuar) {
			String pedido= this.id.getText()+" "+this.nombre.getText();
			
			if(this.nombre.getText().equals("") ||
				this.nombre.getText().equals(" ")) {
				fallo.setText("IDENTIFICADOR NO VALIDO");
				fallo.setVisible(true);
		
			}
			else {
				resultado.setText(this.Controlador.consultarPedido(pedido));
				fallo.setVisible(false);
				exit("Continuar","Realizar otra consulta");
			
				
			}
		}
		else if(e.getSource()==(JButton)this.botonAtras) {
			
			dispose();
		}

	}


}
