package GestionMedicos.CapaPresentacion;

import General.FactoriaAbstractaPantallas;

public class FabricaPantallaSeleccion implements FactoriaAbstractaPantallas {


	@Override
	public Plantilla crearPlantilla(String s) {
		// TODO Auto-generated method stub
		return null;
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
		return new PantallaSeleccionPlantilla(s);
	}

	@Override
	public PantallaSeleccion CrearPantallaSeleccionPedido(String s) {
		// TODO Auto-generated method stub
		return new PantallaSeleccionPedido(s);
	}
	@Override
	public PantallaSeleccion CrearPantallaInformacionPedido(String s) {
		// TODO Auto-generated method stub
		return new PantallaConsultaPedido(s);
	}

	@Override
	public PantallaSeleccion CrearPantallaSeleccionCreacionInforme(String s) {
		// TODO Auto-generated method stub
		return new PantallaSeleccionCreacionInforme(s);
	}

	@Override
	public PantallaSeleccion CrearPantallaConsultaInforme(String s) {
		// TODO Auto-generated method stub
		return new pantallaConsultaInforme(s);
	}

}



