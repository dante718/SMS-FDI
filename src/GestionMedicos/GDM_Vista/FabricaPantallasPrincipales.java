package GestionMedicos.GDM_Vista;

import General.FactoriaAbstractaPantallas;

public class FabricaPantallasPrincipales implements FactoriaAbstractaPantallas {

	@Override
	public PantallaPrincipal crearPantallaMenuMedicos(String s) {
		// TODO Auto-generated method stub
		 return new MenuMedicos(s);
	}

	@Override
	public PantallaPrincipal crearPantallaPedidos(String s) {
		// TODO Auto-generated method stub
		return new pantallaPedido(s);
	}
	public PantallaPrincipal crearPantallaIncidencia(String s) {
		// TODO Auto-generated method stub
		return new pantallaInforme(s);
	}
	@Override
	public Plantilla crearPlantilla(String s) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public PantallaSeleccion crearPantallaSeleccion(String s) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public PantallaSeleccion CrearPantallaSeleccionPedido(String s) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public PantallaSeleccion CrearPantallaInformacionPedido(String s) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public PantallaSeleccion CrearPantallaSeleccionCreacionInforme(String s) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public PantallaSeleccion CrearPantallaConsultaInforme(String s) {
		// TODO Auto-generated method stub
		return null;
	}
}
