package GestionMedicos.GDM.Controlador;




import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

import javax.swing.JComboBox;

import General.FactoriaSApp;
import GestionMedicos.FactoriaServAplicacion.FactoriaServAppMed_Imp;
import GestionMedicos.FactoriaServAplicacion.TransDatosClinicos;
import GestionMedicos.FactoriaServAplicacion.TransPlantilla;
import GestionMedicos.GDM_Vista.FabricaPantallaSeleccion;
import GestionMedicos.GDM_Vista.FabricaPantallasPrincipales;
import GestionMedicos.GDM_Vista.FabricaPlantilla;
import GestionMedicos.GDM_Vista.PantallaPrincipal;
import GestionMedicos.GDM_Vista.PantallaSeleccion;
import GestionMedicos.GDM_Vista.Plantilla;


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
	String estudio,  pastilla, etapa;
	FabricaPantallasPrincipales FPrincipales;
	 FabricaPantallaSeleccion FPSeleccion;
	public ControladorMed() {
		ListaEstudios= null;
		ListaFarmacos=null;
		ListaEtapas=null;
		ParametrosPlantilla=null;
		personas=null;
		FPSeleccion= new FabricaPantallaSeleccion();
		this.ServicioApp=(FactoriaServAppMed_Imp) FactoriaSApp.getInstancia_Med();
	
		
	try {
		CargarDatos();
	} catch (IOException e) {
	
		e.printStackTrace();
	}
	
	
	}
	
///fabricas Pantallas//
public void CrearPantallaPrincipal() {
	FPrincipales=new FabricaPantallasPrincipales();
	FPrincipales.crearPantallaMenuMedicos("subsitema Medicos",this);
	
}
public void crearIncidencia() {
	
	FPrincipales.crearPantallaIncidencia("Crear Incidencia",this);
}
public void crearPantallaPedido() {
	
	FPrincipales.crearPantallaPedidos("Realizar Pedido",this);
}

public void crearPantallaSeleccion() {
	
	FPSeleccion.crearPantallaSeleccion("pantalla de seleccion formulario",this);
	
}
public void crearPantallaSeleccionPedido() {

	FPSeleccion.CrearPantallaSeleccionPedido("Pedido a realizar",this);
}

public void crearPantallaInformacionPedido() {
	FPSeleccion.CrearPantallaInformacionPedido("Informacion pedido", this);
}
public void crearPantallaSeleccionCreacionInforme() {
	FPSeleccion.CrearPantallaSeleccionCreacionInforme("Informe", this);
}
public void crearPantallaConsultaInforme() {
	FPSeleccion.CrearPantallaConsultaInforme("Mis Informes", this);
}


public void crearPantallaPlantilla() {
	BuscarPlantilla();
	FabricaPlantilla f=new FabricaPlantilla();
	Plantilla p=f.crearPlantilla("Plantilla: ",this);
}




//////////////////////	
	
	
public void setParametros(	String estudio2, String pastilla, String etapa2) {
this.estudio=estudio2;	
 this.etapa=etapa2;
 this.pastilla=pastilla;
	
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
	
	public  void BuscarPlantilla() {
		
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
		this.ruta="src/BaseDatos/"+estudio+"_"+pastilla+"_"+etapa+".txt";
		//ServicioApp= (FactoriaServAppMed_Imp) FactoriaSApp.getInstancia_Med(estudio, pastilla, etapa,ruta);
		 this.ServicioApp.setValores(estudio, pastilla, etapa,ruta);
		try {
			aux=ServicioApp.CargaDatos();
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
	
	
	public ArrayList<TransDatosClinicos> recargarDatos() {
		ArrayList <String> aux;
		
		try {
			aux=ServicioApp.CargaDatos();
			this.personas=generarListaPersonas(aux);
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			System.out.println("fallo al cargar datos");
		}
		return this.personas;
	}
	
	//va a ser interpretado como un objeto con una serie de datos 
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
		String id;
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
