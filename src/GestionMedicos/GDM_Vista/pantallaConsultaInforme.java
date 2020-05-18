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

public class pantallaConsultaInforme extends PantallaSeleccion {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JTextArea plantilla,id,resultado;
	private etiqueta etiquetaplantilla,etiquetaIdentificador;
	public pantallaConsultaInforme(String titulo, ControladorMed control) {
		super(titulo, control);
		// TODO Auto-generated constructor stub
	}
	@Override
	public void init() {
		Descripcion=new etiqueta("Rellena los campos para consular un informe o pon TODOS  ",Color.BLACK,20); 
		panelOpciones=new JPanel();
		panelDescripcion =new JPanel();
		panelConfirmacion=new JPanel(new FlowLayout());
		
	
	//	plantilla=new JTextArea(1,10);
		id=new JTextArea(1,10);
		resultado=new JTextArea(3,13);
	
		
		//etiquetaplantilla=new etiqueta("Plantilla:",Color.BLACK,20);
		etiquetaIdentificador=new etiqueta("Identificador:",Color.BLACK,20);
		
		panelOpciones.add(Box.createRigidArea(new Dimension(70,10)));
		panelOpciones.add(etiquetaIdentificador);
		panelOpciones.add(id);
		panelOpciones.add(Box.createRigidArea(new Dimension(20,10)));
		panelOpciones.add(resultado);
		
		
		panelDescripcion.add(Descripcion);
		panelDescripcion.add(Box.createRigidArea(new Dimension(0,20)));
		
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		if(e.getSource()==(JButton)this.botonContinuar) {
			if(id.getText().equals("")||id.getText().equals(" ")) {
				resultado.setText("Argumento no valido");
			}
			else {

				resultado.setText(this.Controlador.consultarInfome(id.getText()));
				if(!resultado.getText().equals("no se ha encontrado pedido")) {

					exit("No","hacer otra consulta");
					
				}
						
			}
		}
		else if(e.getSource()==(JButton)this.botonAtras) {
			
			dispose();
		}
	}

	

}
