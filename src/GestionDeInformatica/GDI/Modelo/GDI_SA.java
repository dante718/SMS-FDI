package GestionDeInformatica.GDI.Modelo;

import java.util.ArrayList;

import General.FactoriaDAO;
import General.FactoriaSApp;

public class GDI_SA extends FactoriaSApp {

	
	
	public ArrayList<TransferEmpleados> leerListaEmpleados(ArrayList<TransferEmpleados>arrayPersonas) {

		FactoriaDAO.getInstancia_Inf().crearDAOEmpleados().leerListaEmpleados(arrayPersonas);
		return arrayPersonas;
	}
	
	public void anadirEmpleado(TransferEmpleados persona) {

		FactoriaDAO.getInstancia_Inf().crearDAOEmpleados().anadirEmpleado(persona);
	}

	public void eliminarEmpleado(ArrayList<TransferEmpleados> arrayPersonas,int fila) {
		
		FactoriaDAO.getInstancia_Inf().crearDAOEmpleados().eliminarEmpleado(arrayPersonas, fila);
	}
	
	
	
	
	public ArrayList<TransferPlantilla> leerListaEstudios(ArrayList<TransferPlantilla> arrayEstudios) {

		FactoriaDAO.getInstancia_Inf().crearDAOPlantillas().leerListaEstudios(arrayEstudios);
		return arrayEstudios;
	}
	
	
	
	public void eliminarEstudio(ArrayList<TransferPlantilla> arrayEstudios,int fila) {

		FactoriaDAO.getInstancia_Inf().crearDAOPlantillas().eliminarEstudio(arrayEstudios, fila);
		
	}
	
	public void anadirEstudio(TransferPlantilla estudio) {

		FactoriaDAO.getInstancia_Inf().crearDAOPlantillas().anadirEstudio(estudio);

		
	}
	
	public void anadirPlantilla(String id, String nombre, String etapa, ArrayList<String> variables) {

		FactoriaDAO.getInstancia_Inf().crearDAOPlantillas().anadirPlantilla(id, nombre, etapa, variables);
		
	}
	
	public ArrayList<String> leerPlantilla(String id, String nombre, String etapa,ArrayList<String> variables) {

		FactoriaDAO.getInstancia_Inf().crearDAOPlantillas().leerPlantilla(id, nombre, etapa, variables);
		return variables;
	}
	
	
	public ArrayList<TransferError> leerListaErrores(ArrayList<TransferError> arrayErrores) {

		FactoriaDAO.getInstancia_Inf().crearDAOErrores().leerListaErrores(arrayErrores);
		return arrayErrores;
	}
	public void eliminarError(ArrayList<TransferError> estudios, int fila) {
		FactoriaDAO.getInstancia_Inf().crearDAOErrores().eliminarError(estudios, fila);
	}

	public static GDI_SA getInstacia() {
		// TODO Auto-generated method stub
		return null;
	}


	
}

