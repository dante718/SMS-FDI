package GestionMedicos.FactoriaServAplicacion;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

import General.FactoriaDAO;
import General.FactoriaSApp;

public class FactoriaServAppMed_Imp extends FactoriaSApp {
	private ArrayList<String> plantillaDatosClinicos;
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
	
	
	public ArrayList<String> CargaDatos(String ruta) throws IOException {
		/*ArrayList<String>lista=new ArrayList<String>();
		BufferedReader buffer=new BufferedReader(new InputStreamReader(new FileInputStream(ruta)));
		String cadena=" ";
		while((cadena=buffer.readLine())!=null) {
			lista.add(cadena);
			
		}
		buffer.close();
		
		return lista;*/
		
		return FactoriaDAO.getInstancia_Med().CrearTablaDatosClinicos(ruta).getDatosClinicos();
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	/*public TransDatosClinicos introducirDatos(String id,String sexo,int edad,String fecha) {
		plantillaDatosClinicos=FactoriaDAO.getInstancia_Med().CrearTablaDatosClinicos().CrearDatos(id, sexo, edad, fecha);
		return plantillaDatosClinicos;
	}


	public void mostrarDatosPlantilla() {
		//Aqui debe mostrar la plantilla
	 System.out.print(this.Plantilla);
		
	}
	public void GuardarEnPlantilla() {
		FactoriaDAO.getInstancia_Med().CrearTablaDatosClinicos().guardarDatosEnAlmacen(Plantilla, plantillaDatosClinicos);
		
	}*/
	

}
