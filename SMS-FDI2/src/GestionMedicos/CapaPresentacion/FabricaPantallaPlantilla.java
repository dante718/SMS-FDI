package GestionMedicos.CapaPresentacion;

import General.FactoriaAbstractaPantallas;

public class FabricaPantallaPlantilla implements FactoriaAbstractaPantallas {

	

	@Override
	public Plantilla crearPlantilla(String s) {
		// TODO Auto-generated method stub
		return new Plantilla(s);
	}

	@Override
	public PantallaPrincipal crearPantallaMenuMedicos(String s) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public PantallaPrincipal crearPantallaPedidos(String s) {
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
