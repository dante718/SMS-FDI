package GestionMedicos.FactoriaDAO;

import java.io.IOException;
import java.util.ArrayList;

import General.FactoriaDAO;
import GestionLaboratorio.integracion_Laboratorio.DAOPedido_Lab;
import GestionLaboratorio.integracion_Laboratorio.DAOProducto_Lab;
import GestionMedicos.FactoriaServAplicacion.TransPlantilla;

public  class FactoriaDAO_Med_imp extends FactoriaDAO{
	
	
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
	
	//preguntar si es necesario, si es necesario debemos crear un nuevo dao?
	
	/*public DAOParametros CrearParametros() {
		return new  DAOParametros();
	}*/
///////////////////////////////////
	/*public ArrayList<String>leerDatos(){//leer los datos previos a la carga 
		
		
		return null;
		
	}
	public void  agregarDato(String ruta,String datos) {
		
		
	}
	public abstract crearDato(String dato);
	
	
	*/
	
	
	
	
	
	
	
	
	
///////////////////////////////////////////////	
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

