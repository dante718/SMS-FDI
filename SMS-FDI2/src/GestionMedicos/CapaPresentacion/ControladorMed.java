package GestionMedicos.CapaPresentacion;




import java.io.IOException;

import java.util.ArrayList;


import General.FactoriaSApp;
import GestionMedicos.CapaDeNegocio.FactoriaServAppMed_Imp;
import GestionMedicos.CapaDeNegocio.TransDatosClinicos;



public class ControladorMed extends FactoriaControladorMed {
	
	static String rutaestudios="src/BaseDatos/estudios.txt";
	static String rutafarmacos="src/BaseDatos/farmacos.txt";
	static String rutaetapas="src/BaseDatos/etapas.txt";
	private FactoriaServAppMed_Imp ServicioApp;
	private ArrayList<String> ListaEstudios;
	private ArrayList<String> ListaEtapas;
	private ArrayList<String> ListaFarmacos;
	private ArrayList<String> ParametrosPlantilla;
	private ArrayList<TransDatosClinicos> personas;
	private String ruta;
	private String estudio,  pastilla, etapa;
	private FabricaPantallasPrincipales FPrincipales;
	private  FabricaPantallaSeleccion FPSeleccion;
	private FabricaPantallaPlantilla FPpantallaPlantilla;
	public ControladorMed() {
		ListaEstudios= null;
		ListaFarmacos=null;
		ListaEtapas=null;
		ParametrosPlantilla=null;
		personas=null;
		FPSeleccion= new FabricaPantallaSeleccion();
		FPrincipales=new FabricaPantallasPrincipales();
		FPpantallaPlantilla=new FabricaPantallaPlantilla();
		this.ServicioApp=(FactoriaServAppMed_Imp) FactoriaSApp.getInstancia_Med();
	
		
	try {
		CargarDatos();
	} catch (IOException e) {
	
		e.printStackTrace();
	}
	
	
	}
	
///fabricas Pantallas//
public void CrearPantallaPrincipal() {
	
	FPrincipales.crearPantallaMenuMedicos("subsitema Medicos");
	
}
public void crearIncidencia() {
	
	FPrincipales.crearPantallaIncidencia("Crear Incidencia");
}
public void crearPantallaPedido() {
	
	FPrincipales.crearPantallaPedidos("Realizar Pedido");
}

public void crearPantallaSeleccionPlantilla() {
	
	FPSeleccion.crearPantallaSeleccion("pantalla de seleccion formulario");
	
}
public void crearPantallaSeleccionPedido() {

	FPSeleccion.CrearPantallaSeleccionPedido("Pedido a realizar");
}

public void crearPantallaInformacionPedido() {
	FPSeleccion.CrearPantallaInformacionPedido("Informacion pedido");
}
public void crearPantallaSeleccionCreacionInforme() {
	FPSeleccion.CrearPantallaSeleccionCreacionInforme("Informe");
}
public void crearPantallaConsultaInforme() {
	FPSeleccion.CrearPantallaConsultaInforme("Mis Informes");
}


public void crearPantallaPlantilla() {
	BuscarPlantilla();
	
	FPpantallaPlantilla.crearPlantilla("Plantilla: ");
}




//////////////////////Caso de uso más complejo////////	
	
	
public void setParametros(	String estudio2, String pastilla, String etapa2) {
this.estudio=estudio2;	
 this.etapa=etapa2;
 this.pastilla=pastilla;
	
}
	public void CargarDatos() throws IOException {
		
		this.ListaEstudios=this.ServicioApp.primeraLectura(rutaestudios);
		this.ListaEtapas=this.ServicioApp.primeraLectura(rutaetapas);
		this.ListaFarmacos=this.ServicioApp.primeraLectura(rutafarmacos);
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
	
	private  void BuscarPlantilla() {
		
		
		ArrayList <String> aux;
		
		this.ParametrosPlantilla=this.ServicioApp.primeraLectura("src/BaseDatos/parametros_"+estudio+"_"+pastilla+"_"+etapa+".txt");
		this.ruta="src/BaseDatos/"+estudio+"_"+pastilla+"_"+etapa+".txt";
	
		 this.ServicioApp.setValores(estudio, pastilla, etapa,ruta);
		try {
			aux=ServicioApp.CargaDatos();
			this.personas=generarListaPersonas(aux);
			
		} catch (IOException e) {
			
			System.out.println("fallo al cargar datos");
		}
		
	
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
	
	
	public ArrayList<TransDatosClinicos> recargarDatos() {
		ArrayList <String> aux;
		
		try {
			aux=ServicioApp.CargaDatos();
			this.personas=generarListaPersonas(aux);
			
		} catch (IOException e) {
			System.out.println("fallo al cargar datos");
		}
		return this.personas;
	}
	
	 
	public  void agregarDatos(String id,String sexo,int edad,String fecha,int cantidad) {
		ServicioApp.introducirDatos(id, sexo,edad,fecha,cantidad);
		
	}
	public String eliminarElemento(String id) {
		if(ServicioApp.eliminarDato(id)) {
			return " Se ha eliminado correctamente ";
		}
		else{
			return " No existe el dato ";
		}
		
	}
	
	public String modificarDatos(String [] aux) {
		boolean encontrado=false;
		String resultado="";
		int i=0;
		
		while(!encontrado && i<this.personas.size()) {
			//this.personas.get(i);
			if(aux[0].equals(this.personas.get(i).getId())){
				encontrado=true;
			}
			else {
				i++;
			}
			
		}
		if(encontrado) {
			if(aux[1].equals(this.ParametrosPlantilla.get(1))) {
				this.personas.get(i).setSexo(aux[2]);
			}
			if(aux[1].equals(this.ParametrosPlantilla.get(2))){
				this.personas.get(i).setEdad(Integer.parseInt(aux[2]));
			}
			if(aux[1].equals(this.ParametrosPlantilla.get(3))){
				this.personas.get(i).setFecha(aux[2]);
			}
			if(aux[1].equals( this.ParametrosPlantilla.get(4))) {
				this.personas.get(i).setCantidad(Integer.parseInt(aux[2]));
			}
			ServicioApp.modificarDatos(this.personas.get(i).toString(),i);
			resultado=" Modificacion realizada ";
		}
		else {
			resultado =" No se ha podido realizar la Modificacion ";
		}
		return resultado;
	
		
		
		
	}
	
/////////////////////////PEDIDO//////////////////////
	
	public void realizarPedido(String pedido) {
		
		ServicioApp.realizarPedido(pedido);
		
	}
	public String consultarPedido(String info) {
		String [] s=info.split(" ");
		String [] estado=this.ServicioApp.consultarPedido(s[0],s[1]).split(" ");
		if(!estado[0].equals("no")) {
			//imprimo el estado
			return estado[2]+" "+ estado[3];
		}
		else{
			//pedido no encontradox[]
			return "no se ha encontrado pedido";
		}
		
	}
	
//////////////INFORME/////////////////////////
	public boolean realizarInforme(String informe) {
		return ServicioApp.crearInforme(informe);
	}
	public String consultarInfome(String info) {
		String [] s=info.split(" ");
		if(s[0].equals("todos")) {
			return this.ServicioApp.consultarInforme(true,s[0]);//.split(" ");
		}
		else {

			String  estado=this.ServicioApp.consultarInforme(false,s[0]);
			if(!estado.equals("")) {
				//imprimo el estado
				return estado;
			}
			else{
				//pedido no encontradox[]
				return "no se ha encontrado pedido";
			}	
		}
		
	}
	

}
