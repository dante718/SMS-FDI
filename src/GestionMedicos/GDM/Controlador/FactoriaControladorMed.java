package GestionMedicos.GDM.Controlador;

public abstract class FactoriaControladorMed {
	
	private static ControladorMed instancia=null;   //Asegurar de que no hay 2 instancias de Controladore
	static public ControladorMed getInstancia() {
		if (instancia == null) instancia= new ControladorMed();
		
		return instancia;
	}
}
