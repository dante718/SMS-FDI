package GestionLaboratorio.integracion_Laboratorio;

import General.FactoriaDAO;
import GestionMedicos.FactoriaDAO.DAODatosClinicos;
import GestionMedicos.FactoriaDAO.DAODatosPlantilla;

public class FactoriaDAO_Lab_imp extends FactoriaDAO{
	
	public DAOProducto_Lab crearDAOProducto() {
		return new DAOProducto_Lab();
	}
	public DAOPedido_Lab crearDAOPedido() {
		return new DAOPedido_Lab();
	}
	@Override
	public DAODatosPlantilla crearDAOPlantilla() {
		// TODO Auto-generated method stub
		return null;
	}
	@Override
	public DAODatosClinicos CrearTablaDatosClinicos(String ruta) {
		// TODO Auto-generated method stub
		return null;
	}
	
}
