package GestionMedicos.GDM.Controlador;



import GestionMedicos.FactoriaServAplicacion.FactoriaServAppPlantilla_Med;
import GestionMedicos.FactoriaServAplicacion.ServAppMed;
import GestionMedicos.FactoriaServAplicacion.TransPlantilla;


public class ControladorMed extends FactoriaControladorMed {
	static ServAppMed plantilla;
	public ControladorMed(){
		
	}
	
	
	public static void BuscarPlantilla(String estudio, String pastilla, String etapa) {
		
		//realizo la comprobacion de los datos :
		//comprobacionDatos(estudio, pastilla, etapa);
		
		//si son validos:
		plantilla=FactoriaServAppPlantilla_Med.getInstancia(estudio, pastilla, etapa);
		//plantilla.mostrarDatosPlantilla();		<-cambiarlo
	}
	//va a ser interpretado como un objeto con una serie de datos 
	public static void agregarDatos(String id,String sexo,int edad,int cantidad,String fecha) {
		plantilla.introducirDatos(id, sexo, edad, cantidad, fecha);
		
	}
	
	public static void GuardarDatos() {
		plantilla.GuardarEnPlantilla();
	} 
	

}
