package General;

import java.io.IOException;

import GestionDeInformatica.GDI.Modelo.DaoEmpleados;
import GestionDeInformatica.GDI.Modelo.DaoErrores;
import GestionDeInformatica.GDI.Modelo.DaoPlantillas;
import GestionDeInformatica.GDI.Modelo.GDI_FactoriaDAO_Inf_imp;
import GestionLaboratorio.integracion_Laboratorio.DAOPedido_Lab;
import GestionLaboratorio.integracion_Laboratorio.DAOProducto_Lab;
import GestionLaboratorio.integracion_Laboratorio.FactoriaDAO_Lab_imp;
import GestionMedicos.CapaDeIntegracion.DAODatosClinicos;
import GestionMedicos.CapaDeIntegracion.DAODatosPlantilla;
import GestionMedicos.CapaDeIntegracion.DAOIncidencias;
import GestionMedicos.CapaDeIntegracion.DAOPedidosMedicos;
import GestionMedicos.CapaDeIntegracion.DAOPrimeraLectura;
import GestionMedicos.CapaDeIntegracion.FactoriaDAO_Med_imp;
import GestionMedicos.CapaDeNegocio.TransPlantilla;
import GestionAlmacen.Integracion.DAOPedido;
import GestionAlmacen.Integracion.DAOProducto;
import GestionAlmacen.Integracion.DAOProveedor;
import GestionAlmacen.Integracion.FactoriaDAO_Almacen;


//Autor Mingyang Chen, GestionLaboratorio


public abstract class FactoriaAbstractaDAO {


	private static FactoriaAbstractaDAO instanciaLab=null;
	
	static public FactoriaAbstractaDAO getInstancia_Lab()
	{
		if (instanciaLab == null) instanciaLab= new FactoriaDAO_Lab_imp();
	
		return instanciaLab;
	}
	public abstract DAOProducto_Lab crearDAOProducto();
	
	public abstract DAOPedido_Lab crearDAOPedido();
	
	
	
	
	
	private static FactoriaAbstractaDAO instanciaMed=null;
	
	static public FactoriaAbstractaDAO getInstancia_Med(){
		
		if (instanciaMed == null) instanciaMed= new FactoriaDAO_Med_imp();
	
		return instanciaMed;
	}
	
	public abstract DAODatosPlantilla crearDAOPlantilla();
	public abstract DAODatosClinicos CrearTablaDatosClinicos(String ruta,TransPlantilla p) throws IOException;
	public	abstract DAOPedidosMedicos CrearPedidoMedicos();
	public abstract DAOIncidencias CrearInformesMedicos();
	public abstract DAOPrimeraLectura primeraCarga();
	
	
private static FactoriaAbstractaDAO instanciaInf=null;
	
	static public FactoriaAbstractaDAO getInstancia_Inf(){
		
		if (instanciaInf == null) instanciaInf= new GDI_FactoriaDAO_Inf_imp();
	
		return instanciaInf;
	}
	public abstract DaoEmpleados crearDAOEmpleados();
	public abstract DaoPlantillas crearDAOPlantillas();
	public abstract DaoErrores crearDAOErrores();
	
	private static FactoriaAbstractaDAO instanciaAlmacen = null;
	
	static public FactoriaAbstractaDAO getInstancia_Almacen() {
		if(instanciaAlmacen == null) instanciaAlmacen = new FactoriaDAO_Almacen();
		return instanciaAlmacen;
	}
	
	public abstract DAOProducto crearDAOProductoAlmacen();
	public abstract DAOPedido crearDAOPedidoAlmacen();
	public abstract DAOProveedor crearDAOProveedor();
	
}


