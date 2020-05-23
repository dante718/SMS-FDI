package GestionDeInformatica.GDI.Modelo;

import java.io.IOException;

import General.FactoriaAbstractaDAO;
import GestionAlmacen.Integracion.DAOPedido;
import GestionAlmacen.Integracion.DAOProducto;
import GestionAlmacen.Integracion.DAOProveedor;
import GestionLaboratorio.integracion_Laboratorio.DAOPedido_Lab;
import GestionLaboratorio.integracion_Laboratorio.DAOProducto_Lab;
import GestionMedicos.CapaDeIntegracion.DAODatosClinicos;
import GestionMedicos.CapaDeIntegracion.DAODatosPlantilla;
import GestionMedicos.CapaDeIntegracion.DAOIncidencias;
import GestionMedicos.CapaDeIntegracion.DAOPedidosMedicos;
import GestionMedicos.CapaDeIntegracion.DAOPrimeraLectura;
import GestionMedicos.CapaDeNegocio.TransPlantilla;

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
	public DAODatosClinicos CrearTablaDatosClinicos(String ruta, TransPlantilla p) throws IOException {
		// TODO Auto-generated method stub
		return null;
	}
	@Override
	public DAOPedidosMedicos CrearPedidoMedicos() {
		// TODO Auto-generated method stub
		return null;
	}
	@Override
	public DAOIncidencias CrearInformesMedicos() {
		// TODO Auto-generated method stub
		return null;
	}
	@Override
	public DAOPrimeraLectura primeraCarga() {
		// TODO Auto-generated method stub
		return null;
	}
	@Override
	public DAOProducto crearDAOProductoAlmacen() {
		// TODO Auto-generated method stub
		return null;
	}
	@Override
	public DAOPedido crearDAOPedidoAlmacen() {
		// TODO Auto-generated method stub
		return null;
	}
	@Override
	public DAOProveedor crearDAOProveedor() {
		// TODO Auto-generated method stub
		return null;
	}
	

	
	
	
	
}
