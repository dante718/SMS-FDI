package GestionMedicos.CapaPresentacion;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.event.ActionEvent;

import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.ImageIcon;
import javax.swing.JPanel;

import GestionMedicos.Complementos.button;
import GestionMedicos.Complementos.etiqueta;

public class pantallaPedido extends PantallaPrincipal {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	button hacerPedido,informacionPedido,atras;
	public pantallaPedido(String nombre) {
		super(nombre, "Pedidos","envios.png");
		// TODO Auto-generated constructor stub
	}
	@Override
	public void mostrarGUI(){
		
		this.setResizable(false);
		
		hacerPedido=new button("HACER PEDIDO" ,30);
		informacionPedido=new button(" INFOR PEDIDO ",30);
		atras =new button("atras",15);
		
		PanelBotonesAcciones.add(hacerPedido);
		PanelBotonesAcciones.add(Box.createVerticalStrut(50));
		PanelBotonesAcciones.add(informacionPedido);
		PanelBotonesAcciones.add(Box.createVerticalStrut(50));
		//informacionPedido.addActionListener(this);
		//hacerPedido.addActionListener(this);
		
		this.PanelInferior=new JPanel();
		PanelInferior.setBackground(Color.yellow);
		PanelInferior.add(atras);
		PanelPrincipal.add(PanelInferior,BorderLayout.PAGE_END);
		atras.addActionListener(this);
		hacerPedido.addActionListener(this);
		informacionPedido.addActionListener(this);
		

	}
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		if(e.getSource()==this.hacerPedido) {
			System.out.print("hola");
			this.controller.crearPantallaSeleccionPedido();
		}
		if(e.getSource()==this.informacionPedido) {
			
			this.controller.crearPantallaInformacionPedido();
			
		}
		if(e.getSource()==this.atras) {
			dispose();
		}
	}

}
