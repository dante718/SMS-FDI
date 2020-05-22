package GestionDeInformatica.GDI.Controlador;

import java.util.ArrayList;

import GestionDeInformatica.GDI.Modelo.GDI_FactoriaSA_Inf_imp;
import GestionDeInformatica.GDI.Modelo.TransferEmpleados;
import GestionDeInformatica.GDI.Modelo.TransferError;
import GestionDeInformatica.GDI.Modelo.TransferPlantilla;
import GestionDeInformatica.GDI.Vista.GDI_VistaListaErrores;
import GestionDeInformatica.GDI.Vista.GDI_VistaListaEstudios;
import GestionDeInformatica.GDI.Vista.GDI_VistaListaPersonal;
import GestionDeInformatica.GDI.Vista.GDI_VistaMedicos;
import GestionDeInformatica.GDI.Vista.GDI_VistaNuevoEmpleado;
import GestionDeInformatica.GDI.Vista.GDI_VistaNuevoEstudio;
import GestionDeInformatica.GDI.Vista.GDI_VistaPrincipal;




public class GDI_Controlador extends FactoriaControlador {

	
	
	public ArrayList<TransferEmpleados> leerListaEmpleados(ArrayList<TransferEmpleados>arrayPersonas) {
		//SA.getInstacia().leerListaEmpleados(arrayPersonas);
		//GDI_SA.getInstacia().leerListaEmpleados(arrayPersonas);
		//SA.leerListaEmpleados(arrayPersonas);
		GDI_FactoriaSA_Inf_imp.getInstancia_Inf().leerListaEmpleados(arrayPersonas);
		return arrayPersonas;
	}
	
	public void anadirEmpleado(TransferEmpleados persona) {
		GDI_FactoriaSA_Inf_imp.getInstancia_Inf().anadirEmpleado(persona);
	}

	public void eliminarEmpleado(ArrayList<TransferEmpleados> arrayPersonas,int fila) {
		
		GDI_FactoriaSA_Inf_imp.getInstancia_Inf().eliminarEmpleado(arrayPersonas, fila);
	}
	
	
	
	
	public ArrayList<TransferPlantilla> leerListaEstudios(ArrayList<TransferPlantilla> arrayEstudios) {
		GDI_FactoriaSA_Inf_imp.getInstancia_Inf().leerListaEstudios (arrayEstudios);
		return arrayEstudios;
	}
	
	
	
	public void eliminarEstudio(ArrayList<TransferPlantilla> arrayEstudios,int fila) {
		GDI_FactoriaSA_Inf_imp.getInstancia_Inf().eliminarEstudio(arrayEstudios, fila);
		
	}
	
	public void anadirEstudio(TransferPlantilla estudio) {
		GDI_FactoriaSA_Inf_imp.getInstancia_Inf().anadirEstudio(estudio);
		
	}
	
	public void anadirPlantilla(String id, String nombre, String etapa, ArrayList<String> variables) {
		GDI_FactoriaSA_Inf_imp.getInstancia_Inf().anadirPlantilla(id,nombre,etapa, variables);
		
	}
	
	public ArrayList<String> leerPlantilla(String id, String nombre, String etapa,ArrayList<String> variables) {
		GDI_FactoriaSA_Inf_imp.getInstancia_Inf().leerPlantilla(id, nombre, etapa,variables);
		return variables;
	}
	
	
	public ArrayList<TransferError> leerListaErrores(ArrayList<TransferError> arrayErrores) {
		GDI_FactoriaSA_Inf_imp.getInstancia_Inf().leerListaErrores(arrayErrores);
		return arrayErrores;
	}
	public void eliminarError(ArrayList<TransferError> estudios, int fila) {
		GDI_FactoriaSA_Inf_imp.getInstancia_Inf().eliminarError(estudios, fila);
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
	
	

}
	
	

