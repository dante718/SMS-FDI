package General;

import java.awt.BorderLayout;

import GestionMedicos.CapaPresentacion.PantallaPrincipal;
import GestionMedicos.CapaPresentacion.PantallaSeleccion;
import GestionMedicos.CapaPresentacion.Plantilla;

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
