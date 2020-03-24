package presentación_Laboratorio;


public abstract class FactoriaControlador_Lab {

	private static Controlador_Lab instancia=null;   //Asegurar de que no hay 2 instancias de Controladore
	static public Controlador_Lab getInstancia() {
		if (instancia == null) instancia= new Controlador_Lab();
		return instancia;
	}
}
