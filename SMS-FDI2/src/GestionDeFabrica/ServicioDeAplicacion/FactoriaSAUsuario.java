package GestionDeFabrica.ServicioDeAplicacion;

public abstract class FactoriaSAUsuario {

	private static FactoriaSAUsuario factoria;
	
	public static FactoriaSAUsuario dameInstancia() {
		
		if (factoria == null) {
			
			factoria = new FactoriaSAUsuarioImp();
		}
		
		return factoria;
	}
	
	public abstract SAUsuarios generaSAUsuario();
}
