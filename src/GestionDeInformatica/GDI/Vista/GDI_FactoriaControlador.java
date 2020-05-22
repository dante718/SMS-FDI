package GestionDeInformatica.GDI.Vista;

public abstract class GDI_FactoriaControlador {
	
	private static GDI_Controlador instancia=null;   //Asegurar de que no hay 2 instancias de Controladore
	static public GDI_Controlador getInstancia() {
		if (instancia == null) instancia= new GDI_Controlador();
		
		return instancia;
	}
}
