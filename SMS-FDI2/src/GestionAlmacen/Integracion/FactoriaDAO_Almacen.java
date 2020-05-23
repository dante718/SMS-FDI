package GestionAlmacen.Integracion;

import java.io.IOException;

import General.FactoriaAbstractaDAO;
import GestionDeInformatica.GDI.Modelo.DaoEmpleados;
import GestionDeInformatica.GDI.Modelo.DaoErrores;
import GestionDeInformatica.GDI.Modelo.DaoPlantillas;
import GestionLaboratorio.integracion_Laboratorio.DAOPedido_Lab;
import GestionLaboratorio.integracion_Laboratorio.DAOProducto_Lab;
import GestionMedicos.CapaDeIntegracion.DAODatosClinicos;
import GestionMedicos.CapaDeIntegracion.DAODatosPlantilla;
import GestionMedicos.CapaDeIntegracion.DAOIncidencias;
import GestionMedicos.CapaDeIntegracion.DAOPedidosMedicos;
import GestionMedicos.CapaDeIntegracion.DAOPrimeraLectura;
import GestionMedicos.CapaDeNegocio.TransPlantilla;

public class FactoriaDAO_Almacen extends FactoriaAbstractaDAO{
	
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

	@Override
	public DAOProducto crearDAOProductoAlmacen() {
		// TODO Auto-generated method stub
		return new DAOProducto();
	}

	@Override
	public DAOPedido crearDAOPedidoAlmacen() {
		// TODO Auto-generated method stub
		return new DAOPedido();
	}
	
	@Override
	public DAOProveedor crearDAOProveedor() {
		// TODO Auto-generated method stub
		return new DAOProveedor();
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
