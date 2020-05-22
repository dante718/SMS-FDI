package General;

import java.awt.BorderLayout;

import GestionMedicos.GDM_Vista.PantallaPrincipal;
import GestionMedicos.GDM_Vista.PantallaSeleccion;
import GestionMedicos.GDM_Vista.Plantilla;

public interface FactoriaAbstractaPantallas {
	public PantallaSeleccion crearPantallaSeleccion(String s);
	public PantallaSeleccion CrearPantallaSeleccionPedido(String s);
	public PantallaSeleccion CrearPantallaInformacionPedido(String s);
	
	public PantallaSeleccion CrearPantallaSeleccionCreacionInforme(String s);
	public PantallaSeleccion CrearPantallaConsultaInforme(String s);
	 public Plantilla crearPlantilla(String s);
	 
	 public PantallaPrincipal crearPantallaMenuMedicos(String s);
	 public PantallaPrincipal crearPantallaPedidos(String s);
}
