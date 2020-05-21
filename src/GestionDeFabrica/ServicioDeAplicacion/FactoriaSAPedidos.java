package GestionDeFabrica.ServicioDeAplicacion;

public abstract class FactoriaSAPedidos {

	private static FactoriaSAPedidos factoria;
	
	public static FactoriaSAPedidos dameInstancia() {
		
		if (factoria == null) {
			
			factoria = new FactoriaSAPedidosImp();
		}
		
		return factoria;
	}
	
	public abstract SAPedido generaSAPedidos();
}
