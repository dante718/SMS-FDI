package GestionMedicos.GDM_Vista;

import General.FactoriaAbstractaPantallas;
import GestionMedicos.GDM.Controlador.ControladorMed;

public class FabricaPantallaSeleccion implements FactoriaAbstractaPantallas {


	


	@Override
	public Plantilla crearPlantilla(String s, ControladorMed control) {
		// TODO Auto-generated method stub
		return null;
	}




	@Override
	public PantallaPrincipal crearPantallaMenuMedicos(String s, ControladorMed control) {
		// TODO Auto-generated method stub
		return null;
	}




	@Override
	public PantallaPrincipal crearPantallaPedidos(String s, ControladorMed control) {
		// TODO Auto-generated method stub
		return null;
	}




	@Override
	public PantallaSeleccion crearPantallaSeleccion(String s, ControladorMed c) {
		// TODO Auto-generated method stub
		return new PantallaSeleccionPlantilla(s,c);
	}




	@Override
	public PantallaSeleccion CrearPantallaSeleccionPedido(String s, ControladorMed c) {
		// TODO Auto-generated method stub
		return new PantallaSeleccionPedido(s,c);
	}




	@Override
	public PantallaSeleccion CrearPantallaInformacionPedido(String s, ControladorMed control) {
		// TODO Auto-generated method stub
		return new PantallaConsultaPedido(s,control);
	}




	@Override
	public PantallaSeleccion CrearPantallaSeleccionCreacionInforme(String s, ControladorMed control) {
		// TODO Auto-generated method stub
		return new PantallaSeleccionCreacionInforme(s,control);
	}




	@Override
	public PantallaSeleccion CrearPantallaConsultaInforme(String s, ControladorMed control) {
		// TODO Auto-generated method stub
		return new pantallaConsultaInforme(s,control);
	}




	
}



