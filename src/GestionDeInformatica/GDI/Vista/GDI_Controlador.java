package GestionDeInformatica.GDI.Vista;

import java.util.ArrayList;

import GestionDeInformatica.GDI.Negocio.GDI_SA;
import GestionDeInformatica.GDI.Negocio.TransferEmpleados;
import GestionDeInformatica.GDI.Negocio.TransferError;
import GestionDeInformatica.GDI.Negocio.TransferPlantilla;
import GestionDeInformatica.GDI.Vista.GDI_FactoriaControlador;




public class GDI_Controlador {

	
	
	GDI_SA SA = new GDI_SA();
	public ArrayList<TransferEmpleados> leerListaEmpleados(ArrayList<TransferEmpleados>arrayPersonas) {
		//SA.getInstacia().leerListaEmpleados(arrayPersonas);
		//GDI_SA.getInstacia().leerListaEmpleados(arrayPersonas);
		SA.leerListaEmpleados(arrayPersonas);
		return arrayPersonas;
	}
	
	public void anadirEmpleado(TransferEmpleados persona) {
		SA.anadirEmpleado(persona);
	}

	public void eliminarEmpleado(ArrayList<TransferEmpleados> arrayPersonas,int fila) {
		
		SA.eliminarEmpleado(arrayPersonas, fila);
	}
	
	
	
	
	public ArrayList<TransferPlantilla> leerListaEstudios(ArrayList<TransferPlantilla> arrayEstudios) {
		SA.leerListaEstudios (arrayEstudios);
		return arrayEstudios;
	}
	
	
	
	public void eliminarEstudio(ArrayList<TransferPlantilla> arrayEstudios,int fila) {
		SA.eliminarEstudio(arrayEstudios, fila);
		
	}
	
	public void anadirEstudio(TransferPlantilla estudio) {
		SA.anadirEstudio(estudio);
		
	}
	
	public void anadirPlantilla(String id, String nombre, String etapa, ArrayList<String> variables) {
		SA.anadirPlantilla(id,nombre,etapa, variables);
		
	}
	
	public ArrayList<String> leerPlantilla(String id, String nombre, String etapa,ArrayList<String> variables) {
		SA.leerPlantilla(id, nombre, etapa,variables);
		return variables;
	}
	
	
	public ArrayList<TransferError> leerListaErrores(ArrayList<TransferError> arrayErrores) {
		SA.leerListaErrores(arrayErrores);
		return arrayErrores;
	}
	public void eliminarError(ArrayList<TransferError> estudios, int fila) {
		SA.eliminarError(estudios, fila);
	}
	
	

	
	public void pantalla1(){
		GDI_VistaPrincipal Principal = new GDI_VistaPrincipal();
		Principal.setVisible(true);
	}
	
	public void pantalla2(){
		GDI_VistaListaEstudios ListaEstudios = new GDI_VistaListaEstudios();
		ListaEstudios.setVisible(true);
	}
	
	public void pantalla3(){
		GDI_VistaListaPersonal ListaPersonal = new GDI_VistaListaPersonal();
		ListaPersonal.setVisible(true);
	}
	
	public void pantalla4(){
		GDI_VistaListaErrores ListaErrores = new GDI_VistaListaErrores();
		ListaErrores.setVisible(true);
	}
	
	public void pantalla5(boolean mod,TransferPlantilla plan,int j,ArrayList<TransferPlantilla> arrayPlantillas){
		GDI_VistaNuevoEstudio NuevoEstudio = new GDI_VistaNuevoEstudio(mod, plan,j,arrayPlantillas);
		NuevoEstudio.setVisible(true);
	}
	
	public void pantalla6(String id){
		GDI_VistaMedicos ListaMedicos = new GDI_VistaMedicos(id);
		ListaMedicos.setVisible(true);
	}
	
	public void pantalla7(){
		GDI_VistaNuevoEmpleado NuevoEmpleado = new GDI_VistaNuevoEmpleado();
		NuevoEmpleado.setVisible(true);
	}
	
	private static GDI_Controlador instancia=null;   //Asegurar de que no hay 2 instancias de Controladore
	static public GDI_Controlador getInstancia() {
		if (instancia == null) instancia= new GDI_Controlador();
		
		return instancia;
	}

}
	
	

