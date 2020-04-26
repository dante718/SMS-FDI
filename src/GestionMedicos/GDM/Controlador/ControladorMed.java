package GestionMedicos.GDM.Controlador;




import General.FactoriaSApp;
import GestionMedicos.FactoriaServAplicacion.FactoriaServAppMed_Imp;
import GestionMedicos.FactoriaServAplicacion.TransPlantilla;


public class ControladorMed extends FactoriaControladorMed {
	static FactoriaServAppMed_Imp plantilla;
	public ControladorMed(String estudio, String pastilla, String etapa){
		BuscarPlantilla( estudio,  pastilla,  etapa);
		
	}
	public  ControladorMed() {};
	
	public  void BuscarPlantilla(String estudio, String pastilla, String etapa) {
		
		//realizo la comprobacion de los datos :
		//comprobacionDatos(estudio, pastilla, etapa);
		
		//si son validos:
		plantilla= (FactoriaServAppMed_Imp) FactoriaSApp.getInstancia_Med(estudio, pastilla, etapa);
		//plantilla.mostrarDatosPlantilla();		<-cambiarlo
	}
	//va a ser interpretado como un objeto con una serie de datos 
	public  void agregarDatos(String id,String sexo,int edad,int cantidad,String fecha) {
		plantilla.introducirDatos(id, sexo, edad, cantidad, fecha);
		
	}
	
	public  void GuardarDatos() {
		plantilla.GuardarEnPlantilla();
	} 
	

}
