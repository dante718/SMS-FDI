package GestionMedicos.CapaDeIntegracion;

import java.io.IOException;


import General.FactoriaAbstractaDAO;
import GestionAlmacen.Integracion.DAOPedido;
import GestionAlmacen.Integracion.DAOProducto;
import GestionAlmacen.Integracion.DAOProveedor;
import GestionDeInformatica.GDI.Modelo.DaoEmpleados;
import GestionDeInformatica.GDI.Modelo.DaoErrores;
import GestionDeInformatica.GDI.Modelo.DaoPlantillas;
import GestionLaboratorio.integracion_Laboratorio.DAOPedido_Lab;
import GestionLaboratorio.integracion_Laboratorio.DAOProducto_Lab;
import GestionMedicos.CapaDeNegocio.TransPlantilla;

public  class FactoriaDAO_Med_imp extends FactoriaAbstractaDAO{
	
	
	public DAODatosPlantilla crearDAOPlantilla() {
		return new DAODatosPlantilla();
		
	}
	public DAODatosClinicos  CrearTablaDatosClinicos(String ruta,TransPlantilla p) throws IOException {
		return new DAODatosClinicos(ruta,p);
	}
	@Override
	public DAOPedidosMedicos CrearPedidoMedicos() {
		return new  DAOPedidosMedicos();
	}
	@Override
	public DAOIncidencias CrearInformesMedicos() {
		// TODO Auto-generated method stub
		return new DAOIncidencias();
	}
	@Override
	public DAOPrimeraLectura primeraCarga() {
		// TODO Auto-generated method stub
		return new DAOPrimeraLectura();
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

