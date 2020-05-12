package General;

import java.awt.BorderLayout;

import GestionMedicos.GDM.Controlador.ControladorMed;
import GestionMedicos.GDM_Vista.PantallaPrincipal;
import GestionMedicos.GDM_Vista.PantallaSeleccion;
import GestionMedicos.GDM_Vista.Plantilla;



public interface FactoriaAbstractaPantallas {
	public PantallaSeleccion crearPantallaSeleccion(String string,ControladorMed control);
	 public Plantilla crearPlantilla(String s,ControladorMed control);
	 public PantallaPrincipal crearPantallaPrincipal(String s,ControladorMed control);
}
