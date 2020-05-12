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
	private String Ruta;
	public FactoriaServAppMed_Imp(String estudio, String pastilla, String etapa,String ruta){
		//esto esta bien si lo hago aqui? o ser�a mejor hacerlo en el modulo del controlador
		this.Ruta=ruta;
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
	
	
	public ArrayList<String> CargaDatos() throws IOException {
		
		
		return FactoriaDAO.getInstancia_Med().CrearTablaDatosClinicos(this.Ruta).getDatosClinicos();
	}
	
	
	public void introducirDatos(String id,String sexo,int edad,String fecha,int cantidad) {
		try {
			FactoriaDAO.getInstancia_Med().CrearTablaDatosClinicos(this.Ruta).CrearDatos(id, sexo, edad, fecha,cantidad,Plantilla);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	public void eliminarDato(String id) {
		try {
			FactoriaDAO.getInstancia_Med().CrearTablaDatosClinicos(Ruta).eliminarDatoTabla(id,Plantilla);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			System.out.println("fallo al borrar");
			e.printStackTrace();
		}
	}
//}
	/*


	public void mostrarDatosPlantilla() {
		//Aqui debe mostrar la plantilla
	 System.out.print(this.Plantilla);
		
	}
	public void GuardarEnPlantilla() {
		FactoriaDAO.getInstancia_Med().CrearTablaDatosClinicos().guardarDatosEnAlmacen(Plantilla, plantillaDatosClinicos);
		
	}*/
	

}
