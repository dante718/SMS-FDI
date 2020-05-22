package GestionLaboratorio.integracion_Laboratorio;

import java.io.IOException;


import General.FactoriaAbstractaDAO;
import GestionDeInformatica.GDI.Modelo.DaoEmpleados;
import GestionDeInformatica.GDI.Modelo.DaoErrores;
import GestionDeInformatica.GDI.Modelo.DaoPlantillas;
import GestionMedicos.FactoriaDAO.DAODatosClinicos;
import GestionMedicos.FactoriaDAO.DAODatosPlantilla;
import GestionMedicos.FactoriaDAO.DAOIncidencias;
import GestionMedicos.FactoriaDAO.DAOPedidosMedicos;
import GestionMedicos.FactoriaServAplicacion.TransPlantilla;

public class FactoriaDAO_Lab_imp extends FactoriaAbstractaDAO{
	
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
	
	public DAODatosClinicos CrearTablaDatosClinicos(String ruta, TransPlantilla p) throws IOException {
		// TODO Auto-generated method stub
		return null;
	}
	@Override
	public DAODatosClinicos CrearTablaDatosClinicos(String ruta) throws IOException {
		// TODO Auto-generated method stub
		return null;
	}
	@Override
	public DaoEmpleados crearDAOEmpleados() {
		// TODO Auto-generated method stub
		return null;
	}
	@Override
	public DaoPlantillas crearDAOPlantillas() {
		// TODO Auto-generated method stub
		return null;
	}
	@Override
	public DaoErrores crearDAOErrores() {
		// TODO Auto-generated method stub
		return null;
	}

	
}
