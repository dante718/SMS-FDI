package GestionDeInformatica.GDI.Modelo;

import java.io.IOException;

import General.FactoriaAbstractaDAO;
import GestionLaboratorio.integracion_Laboratorio.DAOPedido_Lab;
import GestionLaboratorio.integracion_Laboratorio.DAOProducto_Lab;
import GestionMedicos.FactoriaDAO.DAODatosClinicos;
import GestionMedicos.FactoriaDAO.DAODatosPlantilla;
import GestionMedicos.FactoriaDAO.DAOIncidencias;
import GestionMedicos.FactoriaDAO.DAOPedidosMedicos;
import GestionMedicos.FactoriaDAO.DAOPrimeraLectura;
import GestionMedicos.FactoriaServAplicacion.TransPlantilla;

public class GDI_FactoriaDAO_Inf_imp  extends FactoriaAbstractaDAO {

	
	public DaoEmpleados crearDAOEmpleados() {
		return new DaoEmpleados();
		
	}
	public DaoPlantillas crearDAOPlantillas() {
		return new DaoPlantillas();
		
	}
	public DaoErrores crearDAOErrores() {
		return new DaoErrores();
		
	}
	
	
	
	
	
	
	// 
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

	@Override
	public DAODatosPlantilla crearDAOPlantilla() {
		// TODO Auto-generated method stub
		return null;
	}
	@Override
	public DAODatosClinicos CrearTablaDatosClinicos(String ruta) throws IOException {
		// TODO Auto-generated method stub
		return null;
	}
	

	
	
	
	
}
