package GestionMedicos.GDM_Vista;

import General.FactoriaAbstractaPantallas;
import GestionMedicos.GDM.Controlador.ControladorMed;

public class FabricaPlantilla implements FactoriaAbstractaPantallas {

	

	@Override
	public Plantilla crearPlantilla(String s,ControladorMed control) {
		// TODO Auto-generated method stub
		return new Plantilla(s, control);
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
	public PantallaSeleccion crearPantallaSeleccion(String s, ControladorMed control) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public PantallaSeleccion CrearPantallaSeleccionPedido(String s, ControladorMed control) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public PantallaSeleccion CrearPantallaInformacionPedido(String s, ControladorMed control) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public PantallaSeleccion CrearPantallaSeleccionCreacionInforme(String s, ControladorMed control) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public PantallaSeleccion CrearPantallaConsultaInforme(String s, ControladorMed control) {
		// TODO Auto-generated method stub
		return null;
	}




	

}
