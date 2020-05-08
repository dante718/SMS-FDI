package GestionMedicos.GDM.Controlador;




import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

import General.FactoriaSApp;
import GestionMedicos.FactoriaServAplicacion.FactoriaServAppMed_Imp;
import GestionMedicos.FactoriaServAplicacion.TransDatosClinicos;
import GestionMedicos.FactoriaServAplicacion.TransPlantilla;


public class ControladorMed extends FactoriaControladorMed {
	static FactoriaServAppMed_Imp ServicioApp;
	static String rutaestudios="src/BaseDatos/estudios.txt";
	static String rutafarmacos="src/BaseDatos/farmacos.txt";
	static String rutaetapas="src/BaseDatos/etapas.txt";

	private ArrayList<String> ListaEstudios;
	private ArrayList<String> ListaEtapas;
	private ArrayList<String> ListaFarmacos;
	private ArrayList<String> ParametrosPlantilla;
	private ArrayList<TransDatosClinicos> personas;

	
	public ControladorMed() {
		ListaEstudios= null;
		ListaFarmacos=null;
		ListaEtapas=null;
		ParametrosPlantilla=null;
		personas=null;
		//BuscarPlantilla( estudio,  pastilla,  etapa);
		
	try {
		CargarDatos();
	} catch (IOException e) {
	
		e.printStackTrace();
	}
	
	
	}

	public void CargarDatos() throws IOException {
			this.ListaEstudios=lectura(rutaestudios);
			this.ListaFarmacos=lectura(rutafarmacos);
			this.ListaEtapas=lectura(rutaetapas);
			//this.ParametrosPlantilla=lectura(rutaParametrosPlantilla);
			//si hay que agregar un nuevo dao tendria que meter un nuevo sistema de app 
	}

	private ArrayList<String> lectura(String ruta) throws IOException{
		ArrayList<String>lista=new ArrayList<String>();
		BufferedReader buffer=new BufferedReader(new InputStreamReader(new FileInputStream(ruta)));
		String cadena=" ";
		while((cadena=buffer.readLine())!=null) {
			lista.add(cadena);
			
		}
		buffer.close();
	return lista;
}
	public ArrayList<String> getListaEstudios() {
		return this.ListaEstudios;
	}
	public ArrayList<String>getListaFarmacos(){
		
		return this.ListaFarmacos;
	}
	public ArrayList<String>getListaEtapas(){
		return this.ListaEtapas;
		
	}
	public ArrayList<String>getParametrosPlantilla(){
		return this.ParametrosPlantilla;
	}
	public ArrayList<TransDatosClinicos>getListaPersonas(){
		return this.personas;
	}
	
	public  void BuscarPlantilla(String estudio, String pastilla, String etapa) {
		
		//realizo la comprobacion de los datos :
		//comprobacionDatos(estudio, pastilla, etapa);
		
		//si son validos:
		ArrayList <String> aux;
		try {
			this.ParametrosPlantilla=lectura("src/BaseDatos/parametros_"+estudio+"_"+pastilla+"_"+etapa+".txt");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		ServicioApp= (FactoriaServAppMed_Imp) FactoriaSApp.getInstancia_Med(estudio, pastilla, etapa);
		try {
			aux=ServicioApp.CargaDatos("src/BaseDatos/"+estudio+"_"+pastilla+"_"+etapa+".txt");
			this.personas=generarListaPersonas(aux);
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			System.out.println("fallo al cargar datos");
		}
		
		//plantilla.mostrarDatosPlantilla();		<-cambiarlo
	}
	
	private ArrayList<TransDatosClinicos>  generarListaPersonas(ArrayList<String> lista) {
		ArrayList<TransDatosClinicos> personas=new ArrayList<>();
		TransDatosClinicos p;
		String[] cadena;
		for(String e:lista) {
			 cadena=e.split(" ");
			
		p=new TransDatosClinicos(cadena[0],cadena[1],Integer.parseInt(cadena[2]),cadena[3],
							 Integer.parseInt(cadena[4]));			
			 	
		personas.add(p);
			 
		}
		return personas;
	}
	
	
	
	
	//va a ser interpretado como un objeto con una serie de datos 
	public  void agregarDatos(String id,String sexo,int edad,int cantidad,String fecha) {
		//ServicioApp.introducirDatos(id, sexo,edad,fecha);
		
	}
	
	public  void GuardarDatos() {
		//ServicioApp.GuardarEnPlantilla();
	} 
	

}
