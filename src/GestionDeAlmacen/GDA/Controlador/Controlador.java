package GestionDeAlmacen.GDA.Controlador;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import GestionDeAlmacen.GDA.Modelo.ModeloGestionProducto;
import GestionDeAlmacen.GDA.Vista.InterfazVista;

public class Controlador implements ActionListener{
	
	private InterfazVista _vista;
	private ModeloGestionProducto _modelo;
	
	public Controlador(InterfazVista vista, ModeloGestionProducto modelo){
		_vista = vista;
		_modelo = modelo;
	}

	@Override
	public void actionPerformed(ActionEvent evento) {
		// TODO Auto-generated method stub
		if(evento.getActionCommand().equals(InterfazVista.I)){
			System.out.println("Has pulsado " + InterfazVista.I);
			_vista.ventanaInventario();
		}else if(evento.getActionCommand().equals(InterfazVista.AP)){
			System.out.println("Has pulsado " + InterfazVista.AP);
			_vista.ventanaAddProducto();
		}else if(evento.getActionCommand().equals(InterfazVista.LP)){
			System.out.println("Has pulsado " + InterfazVista.LP);
			_vista.ventanaListaPedidos();
		}else if(evento.getActionCommand().equals(InterfazVista.P)){
			System.out.println("Has pulsado " + InterfazVista.P);
		}
		else{
			System.out.println("ERROR");
		}
	}
}
