package GestionMedicos.FactoriaDAO;

import General.FactoriaDAO;
import GestionLaboratorio.integracion_Laboratorio.DAOPedido_Lab;
import GestionLaboratorio.integracion_Laboratorio.DAOProducto_Lab;

public class FactoriaDAO_Med_imp extends FactoriaDAO{
	
	
	public DAODatosPlantilla crearDAOPlantilla() {
		return new DAODatosPlantilla();
		
	}
	public DAODatosClinicos  CrearTablaDatosClinicos() {
		return new DAODatosClinicos();
	}
	@Override
	public DAOProducto_Lab crearDAOProducto() {
		// TODO Auto-generated method stub
		return null;
	}
	@Override
	public DAOPedido_Lab crearDAOPedido() {
		// TODO Auto-generated method stub
		return null;
	}
	
}

