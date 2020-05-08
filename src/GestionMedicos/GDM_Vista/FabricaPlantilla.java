package GestionMedicos.GDM_Vista;

import General.FactoriaAbstractaPantallas;
import GestionMedicos.GDM.Controlador.ControladorMed;

public class FabricaPlantilla implements FactoriaAbstractaPantallas {

	@Override
	public PantallaSeleccion crearPantallaSeleccion(String string, ControladorMed control) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Plantilla crearPlantilla(String s,ControladorMed control) {
		// TODO Auto-generated method stub
		return new Plantilla(s, control);
	}

	@Override
	public PantallaPrincipal crearPantallaPrincipal(String s) {
		// TODO Auto-generated method stub
		return null;
	}

}
