package GestionMedicos.GDM_Vista;

import General.FactoriaAbstractaPantallas;
import GestionMedicos.GDM.Controlador.ControladorMed;

public class FabricaPantallasPrincipales implements FactoriaAbstractaPantallas {

	@Override
	public PantallaPrincipal crearPantallaPrincipal(String s, ControladorMed control) {
		// TODO Auto-generated method stub
		return new PantallaPrincipal(s,control);
	}
	



	@Override
	public PantallaSeleccion crearPantallaSeleccion(String string, ControladorMed control) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Plantilla crearPlantilla(String s, ControladorMed control) {
		// TODO Auto-generated method stub
		return null;
	}


}
