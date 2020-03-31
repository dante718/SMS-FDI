package GestionMedicos.FactoriaServAplicacion;

import GestionMedicos.FactoriaDAO.FactoriaDAO_Med;

public class ServAppMed {
	private TransDatosClinicos plantillaDatosClinicos;
	private TransPlantilla Plantilla;
	public ServAppMed(String estudio, String pastilla, String etapa){
		//esto esta bien si lo hago aqui? o sería mejor hacerlo en el modulo del controlador
		Plantilla=buscarPlantilla(estudio, pastilla,  etapa);  
		//ya hemos consulado através del DAODatosClinicos el almacen
		plantillaDatosClinicos=null;
		
	}
	public TransPlantilla getPlantillaCargada() {
		return this.Plantilla;
	}
	
	private TransPlantilla buscarPlantilla(String estudio, String pastilla, String etapa) {
		//ServApp ->DAODatosPlantilla
		TransPlantilla PlantillaBuscada=null;
		PlantillaBuscada=FactoriaDAO_Med.getInstancia().crearDAOPlantilla().cargarPlantilla(estudio, pastilla, etapa);
			
		return PlantillaBuscada;
	}
	public TransDatosClinicos introducirDatos(String id,String sexo,int edad,int cantidad,String fecha) {
		plantillaDatosClinicos=FactoriaDAO_Med.getInstancia().CrearTablaDatosClinicos().CrearDatos(id, sexo, edad, cantidad, fecha);
		return plantillaDatosClinicos;
	}


	public void mostrarDatosPlantilla() {
		//Aqui debe mostrar la plantilla
	 System.out.print(this.Plantilla);
		
	}
	public void GuardarEnPlantilla() {
		FactoriaDAO_Med.getInstancia().CrearTablaDatosClinicos().guardarDatosEnAlmacén(Plantilla, plantillaDatosClinicos);
		
	}


}
