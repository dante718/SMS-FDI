package GestionMedicos.FactoriaServAplicacion;

import General.FactoriaDAO;
import General.FactoriaSApp;

public class FactoriaServAppMed_Imp extends FactoriaSApp {
	private TransDatosClinicos plantillaDatosClinicos;
	private TransPlantilla Plantilla;
	public FactoriaServAppMed_Imp(String estudio, String pastilla, String etapa){
		//esto esta bien si lo hago aqui? o ser�a mejor hacerlo en el modulo del controlador
		Plantilla=buscarPlantilla(estudio, pastilla,  etapa);  
		//ya hemos consulado atrav�s del DAODatosClinicos el almacen
		plantillaDatosClinicos=null;
		
	}
	public TransPlantilla getPlantillaCargada() {
		return this.Plantilla;
	}
	
	private TransPlantilla buscarPlantilla(String estudio, String pastilla, String etapa) {
		//ServApp ->DAODatosPlantilla
		TransPlantilla PlantillaBuscada=null;
		PlantillaBuscada=FactoriaDAO.getInstancia_Med().crearDAOPlantilla().cargarPlantilla(estudio, pastilla, etapa);
			
		return PlantillaBuscada;
	}
	public TransDatosClinicos introducirDatos(String id,String sexo,int edad,int cantidad,String fecha) {
		plantillaDatosClinicos=FactoriaDAO.getInstancia_Med().CrearTablaDatosClinicos().CrearDatos(id, sexo, edad, cantidad, fecha);
		return plantillaDatosClinicos;
	}


	public void mostrarDatosPlantilla() {
		//Aqui debe mostrar la plantilla
	 System.out.print(this.Plantilla);
		
	}
	public void GuardarEnPlantilla() {
		FactoriaDAO.getInstancia_Med().CrearTablaDatosClinicos().guardarDatosEnAlmacen(Plantilla, plantillaDatosClinicos);
		
	}


}
