package GDA.Main;

import GDA.Controlador.Controlador;
import GDA.Modelo.ModeloGestionProducto;
import GDA.Vista.InterfazVista;
import GDA.Vista.VentanaGDA;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//Modelo
		ModeloGestionProducto m = new ModeloGestionProducto("prueba.txt");
		
		//Vista
		InterfazVista v = new VentanaGDA();
		
		//Controlador
		Controlador c = new Controlador(v, m);
		
		//Configura la vista
		v.setControlador(c);
		
		//Arranca la interfaz
		v.arranca();
	}

}
