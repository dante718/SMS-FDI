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
	
	public FactoriaServAppMed_Imp() {
	}
	public ArrayList<String>primeraLectura(String ruta){
		
		return FactoriaDAO.getInstancia_Med().primeraCarga().leerPrimeravez(ruta);
	}
	public void setValores(String estudio, String pastilla, String etapa,String ruta){
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
		
		
		return FactoriaDAO.getInstancia_Med().CrearTablaDatosClinicos(this.Ruta,this.Plantilla).getDatosClinicos();
	}
	
	
	public void introducirDatos(String id,String sexo,int edad,String fecha,int cantidad) {
		try {
			//pasar a un String los datos
			FactoriaDAO.getInstancia_Med().CrearTablaDatosClinicos(this.Ruta,this.Plantilla).crearDatos(id+" "+sexo+" "+ edad+" "+fecha+" "+cantidad);//CrearDatos(id, sexo, edad, fecha,cantidad);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	public boolean eliminarDato(String id) {
		boolean respuesta=false;
		try {
			respuesta= FactoriaDAO.getInstancia_Med().CrearTablaDatosClinicos(Ruta,this.Plantilla).eliminarDatoTabla(id);
				
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			System.out.println("fallo al borrar");
			e.printStackTrace();
		}
		return respuesta;
	}
	
	public void modificarDatos(String  datos,int i) {
		try {
			FactoriaDAO.getInstancia_Med().CrearTablaDatosClinicos(Ruta,this.Plantilla).modificarDatos(datos,i);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			System.out.println("Imposible modificar datos");
			e.printStackTrace();
		}
	}
	public void realizarPedido(String pedido) {
		FactoriaDAO.getInstancia_Med().CrearPedidoMedicos().realizarPedido(pedido);
	}	
	public String consultarPedido(String id, String nombre) {
		return FactoriaDAO.getInstancia_Med().CrearPedidoMedicos().consultarPedido(id,nombre);
	}	
	 public boolean  crearInforme(String informe) {
		 return FactoriaDAO.getInstancia_Med().CrearInformesMedicos().crearInforme(informe);
	 }
	 public String consultarInforme(boolean todos,String id) {
			return FactoriaDAO.getInstancia_Med().CrearInformesMedicos().consultarInforme (todos,id);
		}
	 
}
