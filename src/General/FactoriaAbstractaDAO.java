package General;

import java.io.IOException;

import GestionDeInformatica.GDI.Modelo.DaoEmpleados;
import GestionDeInformatica.GDI.Modelo.DaoErrores;
import GestionDeInformatica.GDI.Modelo.DaoPlantillas;
import GestionDeInformatica.GDI.Modelo.GDI_FactoriaDAO_Inf_imp;
import GestionLaboratorio.integracion_Laboratorio.DAOPedido_Lab;
import GestionLaboratorio.integracion_Laboratorio.DAOProducto_Lab;
import GestionLaboratorio.integracion_Laboratorio.FactoriaDAO_Lab_imp;
import GestionMedicos.FactoriaDAO.DAODatosClinicos;
import GestionMedicos.FactoriaDAO.DAODatosPlantilla;
import GestionMedicos.FactoriaDAO.DAOIncidencias;
import GestionMedicos.FactoriaDAO.DAOPedidosMedicos;
import GestionMedicos.FactoriaDAO.DAOPrimeraLectura;
import GestionMedicos.FactoriaDAO.FactoriaDAO_Med_imp;


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
	
	public abstract DAODatosClinicos CrearTablaDatosClinicos(String ruta) throws IOException;
	
	
private static FactoriaAbstractaDAO instanciaInf=null;
	
	static public FactoriaAbstractaDAO getInstancia_Inf(){
		
		if (instanciaInf == null) instanciaInf= new GDI_FactoriaDAO_Inf_imp();
	
		return instanciaInf;
	}
	public abstract DaoEmpleados crearDAOEmpleados();
	public abstract DaoPlantillas crearDAOPlantillas();
	public abstract DaoErrores crearDAOErrores();
	public DAOPrimeraLectura primeraCarga() {
		// TODO Auto-generated method stub
		return null;
	}
	public DAOIncidencias CrearInformesMedicos() {
		// TODO Auto-generated method stub
		return null;
	}
	public DAOPedidosMedicos CrearPedidoMedicos() {
		// TODO Auto-generated method stub
		return null;
	}
	
}


