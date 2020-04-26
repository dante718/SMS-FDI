package General;

import GestionLaboratorio.integracion_Laboratorio.DAOPedido_Lab;
import GestionLaboratorio.integracion_Laboratorio.DAOProducto_Lab;
import GestionLaboratorio.integracion_Laboratorio.FactoriaDAO_Lab_imp;
import GestionMedicos.FactoriaDAO.DAODatosClinicos;
import GestionMedicos.FactoriaDAO.DAODatosPlantilla;

import GestionMedicos.FactoriaDAO.FactoriaDAO_Med_imp;


//Autor Mingyang Chen, GestionLaboratorio


public abstract class FactoriaDAO {


	private static FactoriaDAO instanciaLab=null;
	
	static public FactoriaDAO getInstancia_Lab()
	{
		if (instanciaLab == null) instanciaLab= new FactoriaDAO_Lab_imp();
	
		return instanciaLab;
	}
	public abstract DAOProducto_Lab crearDAOProducto();
	
	public abstract DAOPedido_Lab crearDAOPedido();
	
	
	
	
	
	private static FactoriaDAO instanciaMed=null;
	
	static public FactoriaDAO getInstancia_Med(){
		
		if (instanciaMed == null) instanciaMed= new FactoriaDAO_Med_imp();
	
		return instanciaMed;
	}
	
	public abstract DAODatosPlantilla crearDAOPlantilla();
	
	public abstract DAODatosClinicos CrearTablaDatosClinicos();
	
	
	
}
